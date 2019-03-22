package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.manerger.sys.common.idgenerator.redis.RedisIdGenerator;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.bean.GoldLogEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.common.exception.BusinessException;
import com.company.shop.sys.service.common.vo.*;
import com.company.shop.sys.service.modules.sys.entity.*;
import com.company.shop.sys.service.modules.sys.mapper.OrderMapper;
import com.company.shop.sys.service.modules.sys.service.*;
import com.company.shop.sys.service.properties.WxConfigProperties;
import com.company.shop.sys.service.utils.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {


    @Autowired
    private IShippingService shippingService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IStoreUserService storeUserService;

    //生成商品id接口
    @Autowired
    private RedisIdGenerator redisIdGenerator;
    @Autowired
    private WxConfigProperties wxConfigProperties;

    private String SUCCESS_STATUS = "SUCCESS";

    @Autowired
    private IBuyLimitService buyLimitService;

    @Autowired
    private IGoldLogService goldLogService;

    @Autowired
    private ITemplateService templateService;

    /**
     * 金币支付方式
     */

    private WxPayVo goldPay(ProductEntity product, int quantity, String shippingId, String remark) {
        WxPayVo wxPayVo = new WxPayVo();
        //fixme 进行支付
        StoreUserEntity userEntity = storeUserService.getUserInfo();
        //金币支付方式
        BigDecimal residue = BigDecimalUtils.sub(userEntity.getGold().doubleValue(), quantity * product.getGold().doubleValue());
        if (residue.doubleValue() < 0) {//金币不足
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2032.code());
            return wxPayVo;
        }

        //金币支付一天只能购买一次

        String orderId = generateOrder(product, quantity, shippingId, remark, "");
        if (TextUtils.isEmpty(orderId)) {
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2031.code());
            return wxPayVo;
        }

        updateUser(orderId, userEntity, residue, product, quantity);
        //返回数据
        wxPayVo.setSys_order(orderId);
        wxPayVo.setPayType(BusinessConstant.Home.ZERO);

        return wxPayVo;
    }

    private void updateUser(String orderId, StoreUserEntity userEntity, BigDecimal residue, ProductEntity product, int quantity) {
        sendOrderMessage(userEntity.getUsername(), product, orderId);//发送下单消息
        if (updateOrderInfo(orderId)) {
            userEntity.setGold(residue);
            userEntity.setNewuser(BusinessConstant.Home.ZERO);
            storeUserService.insertOrUpdate(userEntity);
            //
            product.setInventory(product.getInventory() - quantity);
            //product.setSales(product.getSales() + quantity);限量已取消
            productService.updateProduct(product);
            //
            updateUserDayBuy();//更新用户一天购买数量
            updateChangeLog(BigDecimalUtils.mul(product.getGold().doubleValue(), quantity), new Date());//上传用户消费日志
        }

    }

    /**
     * 下单成功
     *
     * @param
     */
    private void sendOrderMessage(String username, ProductEntity product, String orderId) {

        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(username));

        if (null == formIdVo) {
            return;
        }

        Map<String, Object> map = new HashMap();

        map.put("product_name", product.getProductName());
        map.put("order_id", orderId);


        templateService.sendNotifyTemplate(username, formIdVo, map, BusinessConstant.Message.NUMBER_3);
    }

    private boolean updateOrderInfo(String orderId) {
        OrderEntity orderEntity = this.queryOrder(orderId);
        orderEntity.setStatus(BusinessConstant.Order.ORDER_0_PAYED);//已付款
        orderEntity.setPaymentTime(new Date());
        return insertOrUpdate(orderEntity);
    }


    private void updateUserDayBuy() {
        BuyLimitEntity buyLimitEntity = buyLimitService.getBuyLimit();
        if (null == buyLimitEntity) {
            buyLimitEntity = new BuyLimitEntity();
            buyLimitEntity.setAmount(BusinessConstant.Home.ONE);
            buyLimitEntity.setUserName(PrincipalUtils.getUsername());
            buyLimitEntity.setGetDate(new Date());
        } else {
            buyLimitEntity.setAmount(BusinessConstant.Home.ONE);
            buyLimitEntity.setGetDate(new Date());
        }

        buyLimitService.insertUserBuy(buyLimitEntity);
    }

    /**
     * 微信支付方式
     *
     * @param
     * @param product
     * @param quantity
     * @param shippingId
     * @param remark
     * @param description
     * @param price
     * @return
     */
    private WxPayVo wxPay(ProductEntity product, int quantity, String shippingId, String remark, String description, String price) {
        WxPayVo wxPayVo = new WxPayVo();
        StoreUserEntity userEntity = storeUserService.getUserInfo();
        BigDecimal residue = BigDecimalUtils.sub(userEntity.getGold().doubleValue(), quantity * product.getGold().doubleValue());
        if (residue.doubleValue() < 0) {//金币不足
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2032.code());
            return wxPayVo;
        }
        try {

            Map<String, String> requestMap = new HashMap<String, String>();
            String appId = wxConfigProperties.getAppid();
            String mch_id = wxConfigProperties.getMerchantid();
            String ip = RequestUtils.getCurrentIp();
            String notify_url = wxConfigProperties.getWx_notify_url();
            String trade_type = wxConfigProperties.getTradType();
            String openId = PrincipalUtils.getUsername();
            String nonce_str = StringUtils.randomString(32);

            //fixme 系统内部订单号
            String orderId = redisIdGenerator.nextUniqueId(BusinessConstant.Order.ID_NAME, BusinessConstant.Order.KEY_NAME, BusinessConstant.Order.STEP, BusinessConstant.Order.LENGTH, true);

            requestMap.put("appid", appId);
            requestMap.put("mch_id", mch_id);
            requestMap.put("nonce_str", nonce_str);//fixme 生成随机字符串小于32位
            requestMap.put("body", description);
            requestMap.put("out_trade_no", orderId);//商户订单号
            requestMap.put("total_fee", price);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            requestMap.put("spbill_create_ip", ip);
            requestMap.put("notify_url", notify_url);//fixme 回调地址，部署阶段
            requestMap.put("trade_type", trade_type);//支付方式--小程序定值
            requestMap.put("openid", openId);//从header中取

            Log.i("微信支付下单map:" + requestMap.toString());
            //fixme MD5生成签名--下单和回调要统一使用一种签名模式
            String sign = PayUtils.sign(PayUtils.createLinkString(requestMap), wxConfigProperties.getAppsecret(), GlobalConstant.UTF8).toUpperCase();

            String xml = "<xml>" + "<appid>" + appId + "</appid>"
                    + "<body><![CDATA[" + description + "]]></body>"
                    + "<mch_id>" + mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + notify_url + "</notify_url>"
                    + "<openid>" + openId + "</openid>"
                    + "<out_trade_no>" + orderId + "</out_trade_no>"
                    + "<spbill_create_ip>" + ip + "</spbill_create_ip>"
                    + "<total_fee>" + price + "</total_fee>"
                    + "<trade_type>" + trade_type + "</trade_type>"
                    + "<sign>" + sign + "</sign>"
                    + "</xml>";
            Log.i("微信统一下单接口xml:" + xml);

            //fixme 发起请求


            String response = RequestUtils.httpRequest(wxConfigProperties.getWx_pay_url(), GlobalConstant.POST, xml);

            Log.i("微信下单response:" + response);
            Map resultMap = PayUtils.doXMLParse(response);
            Log.i("编译微信下单map:" + resultMap.toString());

            String return_code = (String) resultMap.get("return_code");

            Log.i("微信下单返回码:" + return_code);

            if (!return_code.equals(SUCCESS_STATUS)) {//下单失败

                wxPayVo.setErrorCode(ErrorCodeEnum.PAY2002.code());
                return wxPayVo;

            }

            //fixme 生成系统内部订单号--支付成功应保存到数据库--订单信息表--微信平台无返回微信订单号，考虑使用nonce_str
            String order = generateOrder(product, quantity, shippingId, remark, nonce_str);


            //更新用户信息
            userEntity.setGold(residue);
            userEntity.setNewuser(BusinessConstant.Home.ZERO);
            storeUserService.insertOrUpdate(userEntity);
            //更新商品信息
            product.setInventory(product.getInventory() - quantity);
            productService.updateProduct(product);
            //上传用户消费日志
            updateChangeLog(BigDecimalUtils.mul(product.getGold().doubleValue(), quantity), new Date());//上传用户消费日志
            String prePayId = (String) resultMap.get("prepay_id");
            Long timeStamp = System.currentTimeMillis() / 1000;


            wxPayVo.setNonce_str(nonce_str);//返回随机字符串
            wxPayVo.setPrepay_id("prepay_id=" + prePayId);
            wxPayVo.setTimeStamp(timeStamp + "");//返回小程序支付时需求的时间戳
            wxPayVo.setSignType("MD5");
            wxPayVo.setApp_id(appId);

            //fixme 需要进行二次签名再返回前端对应的签名串
            String signStr = "appId=" + appId + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prePayId + "&signType=MD5&timeStamp=" + timeStamp;


            //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
            String paySign = PayUtils.sign(signStr, wxConfigProperties.getAppsecret(), GlobalConstant.UTF8).toUpperCase();

            wxPayVo.setSign(paySign);

        } catch (Exception e) {
            wxPayVo.setErrorCode(ErrorCodeEnum.PAY2001.code());

            e.printStackTrace();
        }
        return wxPayVo;
    }

    /**
     * 检查当前的时间间隔
     */
    private boolean isRepetition(Date lastDate, Date nowDate) {

        if (DateUtils.daysBetween(lastDate, nowDate) > 0) {
            Log.i("大于1天，返回false");
            return false;
        }
        return true;
    }

    /**
     * 上传用户兑换日志表
     */
    private void updateChangeLog(BigDecimal gold, Date date) {
        GoldLogEntity goldLogEntity = new GoldLogEntity();
        goldLogEntity.setGold(gold);
        goldLogEntity.setStep(BusinessConstant.Home.ZERO);
        goldLogEntity.setEvent(GoldLogEnum.GoldStatusEnum.EVENT_GOLD.getValue());//步数兑换金币
        goldLogEntity.setGoldType(GoldLogEnum.GoldStatusEnum.DECREASE.getValue());//获得
        goldLogEntity.setUserName(PrincipalUtils.getUsername());
        goldLogEntity.setGoldDate(date);
        goldLogService.insertLog(goldLogEntity);

    }

    /**
     * 购买了一次商品后不再是新人--生成订单后--有现金支付
     *
     * @param json
     * @return
     */
    @Override
    public WxPayVo createOrder(JSONObject json) {
        Date date = new Date();
        WxPayVo wxPayVo = new WxPayVo();
        String shippingId = json.getString("shippingId");//收货地址
        String remark = json.getString("remark");//卖家备注
        int quantity = json.getIntValue("quantity");//购买数量
        String productId = json.getString("productId");//商品id
        String description = json.getString("description");
        String detail = json.getString("detail");

        BuyLimitEntity buyLimitEntity = buyLimitService.getBuyLimit();
        if (null != buyLimitEntity) {
            if (isRepetition(buyLimitEntity.getGetDate(), date) && buyLimitEntity.getAmount() == BusinessConstant.Home.ONE) {//fixme 时间间隔在一天内
                wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2033.code());
                return wxPayVo;
            }
        }

        if (TextUtils.isEmpty(shippingId)) {//需要物流地址
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2027.code());
            return wxPayVo;
        } else if (quantity == BusinessConstant.Home.ZERO) {//购买商品数量不为0
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2028.code());
            return wxPayVo;
        } else if (TextUtils.isEmpty(productId)) {
            wxPayVo.setErrorCode(ErrorCodeEnum.PRODUCT3008.code());
            return wxPayVo;
        }

        //fixme 首先根据前端出入的productId查询当前商品是否还有库存

        ProductEntity product = productService.getProduct(productId);
        if (null == product) {
            wxPayVo.setErrorCode(ErrorCodeEnum.PRODUCT3008.code());
            return wxPayVo;
        } else if (quantity > product.getInventory()) {//库存数量不足
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2029.code());
            return wxPayVo;
        } else if (product.getStatus() != BusinessConstant.Home.ONE) {//商品已下架
            wxPayVo.setErrorCode(ErrorCodeEnum.ORDER2030.code());
            return wxPayVo;
        }

        if (null == product.getPrice() || product.getPrice().intValue() == BusinessConstant.Home.ZERO || product.getPinkagePrice().intValue() == BusinessConstant.Home.ZERO) {//金币支付
            return goldPay(product, quantity, shippingId, remark);
        } else {//金钱支付或金钱与金币支付
            return wxPay(product, quantity, shippingId, remark, description, String.valueOf(product.getPrice()));
        }


    }


    /**
     * 生成订单
     */
    private String generateOrder(ProductEntity product, int quantity, String shippingId, String remark, String wxOrder) {

        //fixme 计算金币和金钱

        BigDecimal gold = BigDecimalUtils.mul(quantity, product.getGold().doubleValue());
        BigDecimal price = BigDecimalUtils.mul(quantity, product.getPrice().doubleValue());

        OrderEntity order = new OrderEntity();
        //fixme 实例化订单对象
        String orderId = null;
        try {
            orderId = redisIdGenerator.nextUniqueId(BusinessConstant.Order.ID_NAME, BusinessConstant.Order.KEY_NAME, BusinessConstant.Order.STEP, BusinessConstant.Order.LENGTH, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("orderId:" + orderId);
        order.setOrderId(orderId);
        order.setTotalGold(gold);
        order.setTotalPrice(price);
        order.setCreateDate(new Date());
        order.setProductId(product.getId());
        order.setShippingId(shippingId);
        order.setRemarks(remark);
        order.setUserName(PrincipalUtils.getUsername());
        order.setPrice(product.getPrice());
        order.setGold(product.getGold());
        order.setQuantity(quantity);
        order.setPaymentType(BusinessConstant.Order.PAY_ONLINE);//在线支付
        order.setPostage(product.getPinkagePrice());
        order.setStatus(BusinessConstant.Order.ORDER_4_NOT_PAY);
        order.setWx_order_no(wxOrder);
        return insertOrUpdate(order) ? orderId : "";
    }

    /**
     * 删除订单--已完成，已取消的订单才可以删除
     *
     * @param orderId
     * @return
     */
    @Override
    public int deleteOrder(String orderId) {
        return baseMapper.deleteOrder(PrincipalUtils.getUsername(), orderId, BusinessConstant.Order.ORDER_3_CANCEL, BusinessConstant.Order.ORDER_2_SUCCESSED);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @Override
    public int cancelOrder(String orderId) {
        OrderEntity orderEntity = this.queryOrder(orderId);
        orderEntity.setStatus(BusinessConstant.Order.ORDER_3_CANCEL);
        return insertOrUpdate(orderEntity) ? 1 : 0;
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderVo queryOrderDetails(String orderId) {
        OrderVo orderVo = new OrderVo();
        //1.根据orderId查询到对应的订单信息
        OrderEntity orderEntity = this.queryOrder(orderId);

        if (null == orderEntity) {
            throw new BusinessException(ErrorCodeEnum.ORDER2024.code(), ErrorCodeEnum.ORDER2024.msg());
        }
        orderVo.setOrder(orderEntity);
        //2.根据订单获取的物流id查询到对应的物流信息
        ShippingEntity shipping = shippingService.getUserShipById(orderEntity.getShippingId());
        if (null != shipping) {
            orderVo.setShip(shipping);
        }
        //3.根据订单中的商品id查询到对应的商品信息

        ProductEntity product = productService.getProductDetails(orderEntity.getProductId());

        if (null != product) {
            orderVo.setProduct(product);
        }
        return orderVo;
    }

    /**
     * 查询订单信息--取消订单在使用
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderEntity queryOrder(String orderId) {
        return baseMapper.getOrder(PrincipalUtils.getUsername(), orderId);
    }

    /**
     * 查询用户的所有订单信息,订单与商品关系关联,因为有切数据源，不能使用表连接查询
     *
     * @return
     */
    @Override
    public Page<OrderVo> queryAllOrder(Page<OrderVo> page) {

        List orderList = baseMapper.getAllOrder(page, PrincipalUtils.getUsername());

        return getOrderList(page, orderList);
    }

    private Page<OrderVo> getOrderList(Page<OrderVo> page, List<OrderEntity> orderList) {
        List<OrderVo> list = new ArrayList<>();
        for (OrderEntity order : orderList) {
            OrderVo orderVo = new OrderVo();
            ProductEntity product = productService.getProduct(order.getProductId());
            orderVo.setOrder(order);
            orderVo.setProduct(product);
            list.add(orderVo);
        }
        return page.setRecords(list);
    }

    /**
     * 根据用户的类别查询订单
     *
     * @param type
     * @return
     */
    @Override
    public Page<OrderVo> queryAllOrderByType(Page<OrderVo> page, int type) {

        List<OrderEntity> orderList = baseMapper.getAllOrderByType(page, PrincipalUtils.getUsername(), type);

        return getOrderList(page, orderList);
    }

    @Override
    public Page getProductRecord(Page page, String productId) {

        List orderList = baseMapper.getProductRecord(page, productId);

        return page.setRecords(orderList);
    }

    /**
     * 确认收货接口
     *
     * @param orderId
     * @return
     */
    @Override
    public int comfirmOrder(String orderId) {
        OrderEntity orderEntity = queryOrder(orderId);
        if (orderEntity.getStatus() == BusinessConstant.Order.ORDER_4_NOT_PAY) {
            return BusinessConstant.Order.ORDER_4_NOT_PAY;
        }
        return baseMapper.comfirmOrder(PrincipalUtils.getUsername(), orderId, BusinessConstant.Order.ORDER_2_SUCCESSED);
    }


    /**
     * 支付回调接口--需要修改回调的订单状态
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public synchronized String wxPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Log.i("微信支付回调通知");
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        Log.i("接收到微信回调报文:" + notityXml);

        Map resultMap = PayUtils.doXMLParse(notityXml);

        String returnCode = (String) resultMap.get("return_code");
        Log.i("回调返回code:" + returnCode);
        if (SUCCESS_STATUS.equals(returnCode)) {
            Log.i("微信回调支付成功");
            //验证签名是否正确
            Map<String, String> validParams = PayUtils.paraFilter(resultMap);  //回调验签时需要去除sign和空值参数
            String sign = PayUtils.sign(PayUtils.createLinkString(validParams), wxConfigProperties.getAppsecret(), GlobalConstant.UTF8).toUpperCase();//拼装生成服务器端验证的签名
            //fixme 需要验证微信返回的签名与订单金额信息
            if (sign.equals(resultMap.get("sign"))) {
                /**此处添加自己的业务逻辑代码--如确认支付逻辑信息等start**/

                String openid = (String) resultMap.get("openid");
                String orderId = (String) resultMap.get("out_trade_no");
                //更新订单状态
                OrderEntity orderEntity = this.queryOrder(orderId);
                orderEntity.setStatus(BusinessConstant.Order.ORDER_0_PAYED);
                orderEntity.setPaymentTime(new Date());
                insertOrUpdate(orderEntity);
                updateUserDayBuy();//更新用户今日购买数量表
                //
                StoreUserEntity userEntity = storeUserService.getUserInfo();
                /*//更新用户信息
                userEntity.setGold(residue);
                userEntity.setNewuser(BusinessConstant.Home.ZERO);
                storeUserService.insertOrUpdate(userEntity);
                //更新商品信息
                product.setSales(product.getSales() + quantity);
                product.setInventory(product.getInventory() - quantity);
                productService.updateProduct(product);*/
                /**此处添加自己的业务逻辑代码end**/
                //fixme 商户处理成功信息后需要回调通知微信服务端--固定格式
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {//fixme 回调失败
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        Log.i("微信支付回调结束，xml:" + resXml);


        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
        return resXml;
    }

    @Override
    public List<OrderEntity> getOrderList(int type) {
        return baseMapper.getOrderList(type);
    }

    @Override
    public boolean updateOrder(OrderEntity orderEntity) {

        return insertOrUpdate(orderEntity);
    }

}
