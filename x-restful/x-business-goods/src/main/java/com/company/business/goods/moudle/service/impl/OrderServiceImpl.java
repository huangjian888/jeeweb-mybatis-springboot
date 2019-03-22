package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.properties.PddProperties;
import com.company.business.goods.common.vo.FormIdVo;
import com.company.business.goods.common.vo.InviteVo;
import com.company.business.goods.moudle.entity.*;
import com.company.business.goods.moudle.mapper.OrderMapper;
import com.company.business.goods.moudle.service.*;
import com.company.business.goods.security.user.ITomatoUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("orderService")
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {

    @Autowired
    private PddProperties pddProperties;

    @Autowired
    private ITomatoUserService tomatoUserService;
    @Autowired
    private ITomatoCouponUserService tomatoCouponUserService;
    @Autowired
    private IPropertyService propertyService;
    @Autowired
    private IPropertyLogService propertyLogService;
    @Autowired
    private ITemplateService templateService;

    @Autowired
    private IPacketUserBuyService packetUserBuyService;//用户的购买表情况

    /**
     * 以下为配置项
     */
    @Autowired
    private IPageIConService pageIConService;//fixme 用户首次购买返现的判断

    @Autowired
    private IPacketSaleService packetSaleService;//用户自买的配置情况

    @Autowired
    private IPacketCommissionService packetCommissionService;//邀请者佣金比例动态表
    @Autowired
    private IRateService rateService;

    @Autowired
    private IPropertyInviterLogService propertyInviterLogService;//邀请者的佣金获得情况

    @Override
    public boolean insertOrder(JSONObject json) {

        if (!TextUtils.isEmpty(json.getString("error_response"))) {
            Log.i("error_response");
            return true;
        }

        //fixme 获取配置项
        RateEntity rateEntity = rateService.getRateEntity();
        PageIConEntity pageIConEntity = pageIConService.getPageIConEntity(TomatoConstant.Front.extance_red);//fixme 获取首页返现配置状态
        List<PacketCommissionEntity> commissionList = packetCommissionService.getPacketCommissionList();//用户下单数量配置

        List<PacketSaleEntity> saleList = packetSaleService.getPacketSaleList();
        //fixme 获取配置结束

        JSONObject jsonObject = json.getJSONObject(pddProperties.getOrder_list_get_response());
        int total = jsonObject.getIntValue(pddProperties.getTotal_count());
        JSONArray jsonArray = jsonObject.getJSONArray(pddProperties.getOrder_list());
        if (total == TomatoConstant.Common.NUMBER_0) {//fixme 当前时间点内无订单，直接返回
            return true;
        }

        for (int i = 0; i < jsonArray.size(); i++) {
            Log.i("parse order information,total:" + total);

            JSONObject itemObject = jsonArray.getJSONObject(i);

            String orderSn = itemObject.getString("order_sn");
            String username = itemObject.getString("custom_parameters");
            String pId = itemObject.getString("p_id");

            if (!pId.equals("8285337_50538028")) {//fixme 获取的订单是当前推广位订单--不匹配跳出本次循环
                Log.i("current is not same pid,not insert mysql");
                continue;
            }

            Log.i("username:" + username);

            //fixme 查询当前的订单号是否已经存在
            OrderEntity orderEntity = this.getOrderById(orderSn);
            if (null == orderEntity) {

                orderEntity = new OrderEntity();
                orderEntity.setOrder_sn(orderSn);
            }


            try {
                long goodsId = itemObject.getLongValue("goods_id");
                String goodsName = itemObject.getString("goods_name");
                String goodsThumbnailUrl = itemObject.getString("goods_thumbnail_url");
                long goodsQuantity = itemObject.getLongValue("goods_quantity");

                long goodsPrice = itemObject.getLongValue("goods_price");

                long orderAmount = itemObject.getLongValue("order_amount");

                long orderCreateTime = itemObject.getLongValue("order_create_time");

                long orderVerifyTime = itemObject.getLongValue("order_verify_time");//审核时间，每个月20号结算当月15号前审核通过的订单
                long promotionRate = itemObject.getLongValue("promotion_rate");
                long orderPayTime = itemObject.getLongValue("order_pay_time");
                long promotionAmount = itemObject.getLongValue("promotion_amount");

                long orderGroupSuccessTime = itemObject.getLongValue("order_group_success_time");
                long orderModifyAt = itemObject.getLongValue("order_modify_at");
                int orderStatus = itemObject.getIntValue("order_status");
                String orderStatusDesc = itemObject.getString("order_status_desc");


                orderEntity.setGoods_id(goodsId);
                orderEntity.setGoods_name(goodsName);
                orderEntity.setGoods_thumbnail_url(goodsThumbnailUrl);
                orderEntity.setGoods_quantity(goodsQuantity);
                orderEntity.setUser_name(username);

                //价格以及提成比是bigdecimal
                orderEntity.setGoods_price(BigDecimalUtils.div(goodsPrice, pddProperties.getScala()));
                orderEntity.setOrder_amount(BigDecimalUtils.div(orderAmount, pddProperties.getScala()));
                orderEntity.setPromotion_amount(BigDecimalUtils.div(promotionAmount, pddProperties.getScala()));
                orderEntity.setPromotion_rate(BigDecimalUtils.div(promotionRate, pddProperties.getScala()));


                orderEntity.setOrder_create_date(orderCreateTime);
                orderEntity.setOrder_verify_time(orderVerifyTime);

                orderEntity.setOrder_payment_time(orderPayTime);


                orderEntity.setOrder_group_success_time(orderGroupSuccessTime);
                orderEntity.setOrder_modify_at(orderModifyAt);

                orderEntity.setOrder_status(orderStatus);
                orderEntity.setOrder_status_desc(orderStatusDesc);
                orderEntity.setP_id(pId);

                insertOrUpdate(orderEntity);
                if (!TextUtils.isEmpty(username)) {
                    //fixme 处理佣金规则--根据username处理
                    userComfirmProduct(orderEntity, rateEntity, pageIConEntity, saleList);
                    userCheckSuc(orderEntity);
                    //
                    inViteComfirmProduct(orderEntity, commissionList);
                    inviteCheckSuc(orderEntity);
                    sendMessage(orderEntity);
                    //
                    userSalesReturn(orderEntity);
                    inviteSalesReturn(orderEntity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return true;
    }


    /**
     * 将当前订单号记录到收益日志中1--收货 0--退货
     *
     * @param order_no
     * @param username
     * @param bigDecimal
     */
    private void insertUserPropertyLog(String order_no, String username, BigDecimal bigDecimal, int pdd) {

        PropertyLogEntity propertyLogEntity = new PropertyLogEntity();
        propertyLogEntity.setOrder_no(order_no);
        propertyLogEntity.setCommission_date(new Date());
        propertyLogEntity.setUser_name(username);
        propertyLogEntity.setCommission_money(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
        propertyLogEntity.setType(TomatoConstant.Common.NUMBER_1);
        propertyLogEntity.setStatus(pdd);
        propertyLogService.insertPropertyLog(propertyLogEntity);
    }

    /**
     * 邀请者的佣金收益表
     *
     * @param order_no
     * @param
     * @param bigDecimal
     */
    private void insertInviterPropertyLog(String order_no, String inviter, String invited_user, BigDecimal bigDecimal, int pdd) {

        PropertyInviterLogEntity propertyInviterLogEntity = new PropertyInviterLogEntity();

        propertyInviterLogEntity.setOrder_no(order_no);
        propertyInviterLogEntity.setCommission_date(new Date());
        propertyInviterLogEntity.setUser_name(invited_user);
        propertyInviterLogEntity.setInviter_user(inviter);
        propertyInviterLogEntity.setCommission_money(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
        propertyInviterLogEntity.setType(TomatoConstant.Common.NUMBER_1);
        propertyInviterLogEntity.setStatus(pdd);
        propertyInviterLogService.insertPropertyLog(propertyInviterLogEntity);
    }

    /**
     * 用户或是粉丝退货，需要更新当前订单的状态
     *
     * @param
     */
    private void updateInviterPropertyLog(PropertyInviterLogEntity propertyInviterLogEntity, int type, int pdd) {

        propertyInviterLogEntity.setCommission_date(new Date());
        propertyInviterLogEntity.setStatus(pdd);
        propertyInviterLogEntity.setType(type);//已被退货
        propertyInviterLogService.insertPropertyLog(propertyInviterLogEntity);
    }

    /**
     * 用户或是粉丝退货，需要更新当前订单的状态
     *
     * @param
     */
    private void updateUserPropertyLog(PropertyLogEntity propertyLogEntity, int type, int pdd) {

        propertyLogEntity.setCommission_date(new Date());
        propertyLogEntity.setStatus(pdd);
        propertyLogEntity.setType(type);//已被退货
        propertyLogService.insertPropertyLog(propertyLogEntity);
    }

    /**
     * 设置或更新用户的购买情况表
     */
    private boolean insertUserBuyTable(OrderEntity orderEntity) {

        try {
            PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(orderEntity.getUser_name());
            if (null == packetUserBuyEntity) {
                packetUserBuyEntity = new PacketUserBuyEntity();

                packetUserBuyEntity.setBuy_amounts(orderEntity.getOrder_amount());//设置用户的订单总额
                packetUserBuyEntity.setFirst_date(new Date());
                packetUserBuyEntity.setRecent_date(new Date());
                packetUserBuyEntity.setBuy_times(TomatoConstant.Common.NUMBER_1);
                packetUserBuyEntity.setUser_name(orderEntity.getUser_name());
                return packetUserBuyService.insertUpdatePacketUserBuy(packetUserBuyEntity);
            } else {
                packetUserBuyEntity.setBuy_times(packetUserBuyEntity.getBuy_times() + TomatoConstant.Common.NUMBER_1);
                packetUserBuyEntity.setBuy_amounts(BigDecimalUtils.addBig(orderEntity.getOrder_amount(), packetUserBuyEntity.getBuy_amounts()));
                packetUserBuyEntity.setRecent_date(new Date());
                return packetUserBuyService.insertUpdatePacketUserBuy(packetUserBuyEntity);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 当用户退货时需要更新用户的购买表情况
     *
     * @param orderEntity
     * @return
     */
    private boolean updateUserBuy(OrderEntity orderEntity) {

        PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(orderEntity.getUser_name());
        if (null == packetUserBuyEntity) {
            return false;
        }
        packetUserBuyEntity.setBuy_times(packetUserBuyEntity.getBuy_times() - TomatoConstant.Common.NUMBER_1);
        packetUserBuyEntity.setBuy_amounts(BigDecimalUtils.subBig(packetUserBuyEntity.getBuy_amounts(), orderEntity.getOrder_amount()));
        return packetUserBuyService.insertUpdatePacketUserBuy(packetUserBuyEntity);
    }


    /**
     * @param
     * @param
     * @return
     */
    private double getFirstBuyMoney(OrderEntity orderEntity, List<PacketSaleEntity> saleList) {


        for (PacketSaleEntity packetSaleEntity : saleList) {
            BigDecimal bigDecimal1 = packetSaleEntity.getLower_limit_amounts();
            BigDecimal bigDecimal2 = packetSaleEntity.getUpper_limit_amounts();


            if (BigDecimalUtils.subBig(orderEntity.getOrder_amount(), bigDecimal1).doubleValue() > TomatoConstant.Common.NUMBER_0 && BigDecimalUtils.subBig(orderEntity.getOrder_amount(), bigDecimal2).doubleValue() <= TomatoConstant.Common.NUMBER_0) {

                return BigDecimalUtils.mul(packetSaleEntity.getRate().doubleValue() / TomatoConstant.Common.NUMBER_100, orderEntity.getPromotion_amount().doubleValue()).doubleValue();
            } else if (TomatoConstant.Common.NUMBER_0 == bigDecimal2.doubleValue()) {//fixme 最后一个,最后一个为null，构造为0
                if (BigDecimalUtils.subBig(orderEntity.getOrder_amount(), bigDecimal1).doubleValue() > TomatoConstant.Common.NUMBER_0) {

                    return BigDecimalUtils.mul(packetSaleEntity.getRate().doubleValue() / TomatoConstant.Common.NUMBER_100, orderEntity.getPromotion_amount().doubleValue()).doubleValue();
                }
            }


        }

        return TomatoConstant.Common.NUMBER_0;

    }


    /**
     * 用户的第一单--产生佣金金额
     *
     * @return
     */
    private double getUserFirstBuyMoney(OrderEntity orderEntity, String username, List<PacketSaleEntity> saleList) {
        PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(username);
        if (null == packetUserBuyEntity) {//fixme 用户的第一单,判断用户的第一单的购买金额
            return getFirstBuyMoney(orderEntity, saleList);
        } else if (packetUserBuyEntity.getBuy_times() == TomatoConstant.Common.NUMBER_0) {//用户曾经购买过，但是退货后购买次数就会变为0
            return getFirstBuyMoney(orderEntity, saleList);
        }
        //fixme 已经购买过的用户则不再享受此活动
        return TomatoConstant.Common.NUMBER_0;
    }

    /**
     * 发送用户的自买佣金信息
     */
    private void sendSelfBuyMessage(String username, double money) {

        if (money == TomatoConstant.Common.NUMBER_0) {
            return;
        }
        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(username));

        if (null == formIdVo) {
            Log.e("formId invalid");
            return;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("price", money);
        templateService.sendNotifyTemplate(username, formIdVo, map, TomatoConstant.Common.NUMBER_3);

    }


    private InviteVo getUserInviteVo(OrderEntity orderEntity, RateEntity rateEntity, PageIConEntity pageIConEntity, List<PacketSaleEntity> saleList) {

        double money = 0;
        if (null != pageIConEntity && saleList.size() > TomatoConstant.Common.NUMBER_0) {
            if (pageIConEntity.getStatus() == TomatoConstant.Common.NUMBER_1) {//fixme 后端的用户首次购买返现能使用
                //fixme 用户自己购买的第一单--首次购买返现
                double firstBuyMoney = getUserFirstBuyMoney(orderEntity, orderEntity.getUser_name(), saleList);
                sendSelfBuyMessage(orderEntity.getUser_name(), firstBuyMoney);//发送自买佣金
                money += firstBuyMoney;
            }
        }

        if (null != rateEntity) {
            List<TomatoUserEntity> userEntityList = tomatoCouponUserService.getUserFansList(orderEntity.getUser_name());
            if (userEntityList.size() < rateEntity.getInvite_user_return()) {
                if (money == TomatoConstant.Common.NUMBER_0) {
                    return null;

                } else {
                    InviteVo inviteVo = new InviteVo();
                    inviteVo.setBigDecimal(new BigDecimal(String.valueOf(money)));
                    inviteVo.setUsername(orderEntity.getUser_name());
                    return inviteVo;
                }
            } else if (userEntityList.size() >= rateEntity.getInvite_user_return()) {


                //fixme 用户邀请了10个用户后，自己购买也能拿到百分之5的佣金

                money += BigDecimalUtils.mulBig(orderEntity.getPromotion_amount(), BigDecimalUtils.div(rateEntity.getNormal_buy_rate().doubleValue(), TomatoConstant.Common.NUMBER_100)).doubleValue();

            }
        }


        InviteVo inviteVo = new InviteVo();
        inviteVo.setBigDecimal(new BigDecimal(String.valueOf(money)));
        inviteVo.setUsername(orderEntity.getUser_name());
        return inviteVo;
    }


    /**
     * 确认收货
     *
     * @param
     */
    private void userCheckSuc(OrderEntity orderEntity) {


        if (orderEntity.getOrder_status() == TomatoConstant.Order.CHECK_SUC) {

            //审核成功，从日志表中查询该条订单
            PropertyLogEntity propertyLogEntity = propertyLogService.getPropertyLog(orderEntity.getUser_name(), orderEntity.getOrder_sn());
            if (null == propertyLogEntity) {
                return;
            }

            PropertyEntity propertyEntity = propertyService.getProperEntity(orderEntity.getUser_name());
            if (null == propertyEntity) {
                return;
            }

            BigDecimal commissionAble;
            if (propertyEntity.getCommission_money_able().doubleValue() == TomatoConstant.Common.NUMBER_0) {

                commissionAble = propertyLogEntity.getCommission_money();

            } else {

                commissionAble = BigDecimalUtils.addBig(propertyEntity.getCommission_money_able(), propertyLogEntity.getCommission_money());

            }

            BigDecimal commissionBack = BigDecimalUtils.subBig(propertyEntity.getCommission_money_back(), commissionAble);
            updateUserPropertyLog(propertyLogEntity, TomatoConstant.Common.NUMBER_1, TomatoConstant.Order.CHECK_SUC);
            propertyService.updateProperty(orderEntity.getUser_name(), commissionAble, commissionBack);
        }


    }


    /**
     * 当前用户的粉丝数量达到10个后，自己购买也能获取对应佣金
     *
     * @param
     */
    private boolean userComfirmProduct(OrderEntity orderEntity, RateEntity rateEntity, PageIConEntity pageIConEntity, List<PacketSaleEntity> saleList) {


        if (orderEntity.getOrder_status() == TomatoConstant.Order.HAS_GROUP) {

            InviteVo inviteVo = getUserInviteVo(orderEntity, rateEntity, pageIConEntity, saleList);
            if (null == inviteVo) {
                return insertUserBuyTable(orderEntity);//fixme设置当前用户的购买情况

            }


            PropertyEntity propertyEntity = propertyService.getProperEntity(inviteVo.getUsername());

            if (null == propertyEntity) {
                propertyEntity = new PropertyEntity();
                propertyEntity.setUser_name(orderEntity.getUser_name());

                propertyEntity.setCommission_money_able(new BigDecimal("0.00"));

                propertyEntity.setCommission_money_back(inviteVo.getBigDecimal());
                propertyService.insertProperty(propertyEntity);

            } else {
                BigDecimal commissionBack = BigDecimalUtils.addBig(propertyEntity.getCommission_money_back(), inviteVo.getBigDecimal());
                propertyService.updateProperty(orderEntity.getUser_name(), null, commissionBack);

            }
            //fixme 设置用户自己的佣金获得情况
            insertUserPropertyLog(orderEntity.getOrder_sn(), orderEntity.getUser_name(), inviteVo.getBigDecimal(), TomatoConstant.Order.HAS_GROUP);

            insertUserBuyTable(orderEntity);//fixme设置当前用户的购买情况
        }

        return true;
    }

    /**
     * 邀请者待体现的金额,确认收货即为待体现的金额，15天后转为可提现金额--确认收货
     */
    private void inViteComfirmProduct(OrderEntity orderEntity, List<PacketCommissionEntity> commissionList) {

        if (orderEntity.getOrder_status() == TomatoConstant.Order.HAS_GROUP) {//1


            InviteVo inviteVo = getInviteVo(orderEntity, commissionList);
            if (null == inviteVo) {
                Log.i("inviteVo is null");
                return;
            }

            String inviteUser = inviteVo.getInviteUser();
            BigDecimal bigDecimal = inviteVo.getBigDecimal();

            PropertyEntity propertyEntity = propertyService.getProperEntity(inviteUser);//查询邀请者的资产情况

            if (null == propertyEntity) {
                propertyEntity = new PropertyEntity();
                propertyEntity.setUser_name(inviteUser);
                propertyEntity.setCommission_money_able(new BigDecimal("0.00"));
                propertyEntity.setCommission_money_back(bigDecimal);
                propertyService.insertProperty(propertyEntity);
            } else {
                //待返现金额跌加-可提现金额不变
                BigDecimal commissionBack = BigDecimalUtils.addBig(propertyEntity.getCommission_money_back(), bigDecimal);

                propertyService.updateProperty(inviteUser, null, commissionBack);
            }
            //fixme 插入到邀请者的佣金日志表中
            insertUserPropertyLog(orderEntity.getOrder_sn(), inviteUser, inviteVo.getBigDecimal(), TomatoConstant.Order.HAS_GROUP);//插入到用户收益日志表
            insertInviterPropertyLog(orderEntity.getOrder_sn(), inviteUser, orderEntity.getUser_name(), inviteVo.getBigDecimal(), TomatoConstant.Order.HAS_GROUP);

        }

    }


    /**
     * 当用户确认收货，如15天内没有退货退款，会审核成功，如此间有退货退款则审核失败
     */
    private void inviteSalesReturn(OrderEntity orderEntity) {

        if (orderEntity.getOrder_status() == TomatoConstant.Order.CHECK_FAILED) {

            //审核失败，从日志表中查询该条订单
            PropertyInviterLogEntity propertyInviterLogEntity = propertyInviterLogService.getPropertyInviterLog(orderEntity.getOrder_sn());
            if (null == propertyInviterLogEntity) {
                return;
            }
            String inviteUser = propertyInviterLogEntity.getInviter_user();//获取到当前用户的邀请者

            PropertyEntity propertyEntity = propertyService.getProperEntity(inviteUser);//查询邀请者的资产情况
            if (null == propertyEntity) {
                return;
            }

            //fixme 减去退货的佣金
            BigDecimal commissionBack = BigDecimalUtils.subBig(propertyEntity.getCommission_money_back(), propertyInviterLogEntity.getCommission_money());

            propertyService.updateProperty(inviteUser, null, commissionBack);

            updateInviterPropertyLog(propertyInviterLogEntity, TomatoConstant.Common.NUMBER_0, TomatoConstant.Order.CHECK_FAILED);

            //审核失败，从日志表中查询该条订单
            PropertyLogEntity propertyLogEntity = propertyLogService.getPropertyLog(inviteUser, orderEntity.getOrder_sn());
            if (null == propertyLogEntity) {
                return;
            }

            updateUserPropertyLog(propertyLogEntity, TomatoConstant.Common.NUMBER_0, TomatoConstant.Order.CHECK_FAILED);//更新用户表

        }


    }

    //用户自己退货--需要更新财产
    private void userSalesReturn(OrderEntity orderEntity) {

        if (orderEntity.getOrder_status() == TomatoConstant.Order.CHECK_FAILED) {

            //审核失败，从日志表中查询该条订单
            PropertyLogEntity propertyLogEntity = propertyLogService.getPropertyLog(orderEntity.getUser_name(), orderEntity.getOrder_sn());
            if (null == propertyLogEntity) {
                return;
            }

            PropertyEntity propertyEntity = propertyService.getProperEntity(orderEntity.getUser_name());
            if (null == propertyEntity) {
                return;
            }

            //待提现金额减少
            BigDecimal commissionBack = BigDecimalUtils.subBig(propertyEntity.getCommission_money_back(), propertyLogEntity.getCommission_money());

            propertyService.updateProperty(orderEntity.getUser_name(), null, commissionBack);

            updateUserPropertyLog(propertyLogEntity, TomatoConstant.Common.NUMBER_0, TomatoConstant.Order.CHECK_FAILED);
            updateUserBuy(orderEntity);//fixme设置当前用户的购买情况
        }
    }


    private double getRate(List<TomatoUserEntity> inviteList, List<PacketCommissionEntity> commissionList) {
        int sum = 0;//邀请者B的被邀请A的总下单数量

        for (TomatoUserEntity user : inviteList) {
            PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(user.getUsername());
            if (null == packetUserBuyEntity) {
                continue;
            } else if (packetUserBuyEntity.getBuy_times() > TomatoConstant.Common.NUMBER_0) {

                sum += packetUserBuyEntity.getBuy_times();
            }
        }

        //邀请者邀请粉丝佣金比例配置
        for (PacketCommissionEntity packet : commissionList) {

            if (sum > packet.getLower_fans() && sum <= packet.getUpper_fans()) {
                return packet.getRate().doubleValue() / TomatoConstant.Common.NUMBER_100;
            } else if (sum > packet.getLower_fans() && TomatoConstant.Common.NUMBER_0 == packet.getUpper_fans()) {//最后一个,upper为null，构造为0
                return packet.getRate().doubleValue() / TomatoConstant.Common.NUMBER_100;
            }
        }

        return TomatoConstant.Common.NUMBER_0;
    }


    private String getInviter(OrderEntity orderEntity) {

        TomatoUserEntity tomatoUserEntity = tomatoUserService.findUserByUsername(orderEntity.getUser_name());

        if (null == tomatoUserEntity) {
            Log.e("tomatoUserEntity is null");
            return null;
        }

        //fixme 获取当前用户的邀请者信息
        return tomatoUserEntity.getInviteUser();
    }

    /**
     * 三期中策划去除了：邀请者B邀请了20个人以后的用户A的首单比例提升为15%
     *
     * @param orderEntity
     * @return
     */
    private InviteVo getInviteVo(OrderEntity orderEntity, List<PacketCommissionEntity> commissionList) {

        String inviteUser = getInviter(orderEntity);
        if (inviteUserEmpty(inviteUser)) {

            return null;
        }


        //fixme 获取邀请者的被邀请者列表
        List<TomatoUserEntity> inviteList = tomatoCouponUserService.getUserFansList(inviteUser);

        if (inviteList.size() == TomatoConstant.Common.NUMBER_0) {

            return null;
        }

        double rate = getRate(inviteList, commissionList);

        if (rate == TomatoConstant.Common.NUMBER_0) {//未配置粉丝下单佣金比例、或是获取失败

            return null;
        }

        InviteVo inviteVo = new InviteVo();
        inviteVo.setInviteUser(inviteUser);

        inviteVo.setBigDecimal(BigDecimalUtils.mul(rate, orderEntity.getPromotion_amount().doubleValue()));

        return inviteVo;

    }

    private boolean inviteUserEmpty(String inviteUser) {
        if (null == inviteUser) {

            return true;
        } else if (TextUtils.isEmpty(inviteUser)) {

            return true;
        }
        return false;
    }

    /**
     * 用户支付成功，向邀请者推送消息模板
     *
     * @param orderEntity
     */
    private void sendMessage(OrderEntity orderEntity) {
        if (orderEntity.getOrder_status() == TomatoConstant.Order.HAS_GROUP) {//订单已支付，向邀请者发送信息--已成团为已支付

            String inviteUser = getInviter(orderEntity);
            if (inviteUserEmpty(inviteUser)) {
                return;
            }

            //确认成功即会向数据库中插入数据
            PropertyInviterLogEntity propertyInviterLogEntity = propertyInviterLogService.getPropertyInviterLog(orderEntity.getOrder_sn());
            if (null == propertyInviterLogEntity) {
                return;
            }

            if (propertyInviterLogEntity.getCommission_money().doubleValue() <= TomatoConstant.Common.NUMBER_0) {//佣金==0不发送信息
                return;
            }
            FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(inviteUser));

            if (null == formIdVo) {
                Log.e("formId invalid");
                return;
            }

            Map<String, Object> map = new HashMap<>();
            map.put("price", propertyInviterLogEntity.getCommission_money());
            templateService.sendNotifyTemplate(inviteUser, formIdVo, map, TomatoConstant.Common.NUMBER_2);


        }
    }

    /**
     * 设置当前username的邀请者佣金--审核成功
     *
     * @param orderEntity
     * @param
     */
    private void inviteCheckSuc(OrderEntity orderEntity) {


        //fixme 用户已经确认收货
        if (orderEntity.getOrder_status() == TomatoConstant.Order.CHECK_SUC) {//fixme 拼多多回复审核时间向前推15天即为确认收货时间

            String inviteUser = getInviter(orderEntity);

            if (inviteUserEmpty(inviteUser)) {
                return;
            }

            //审核成功，从日志表中查询该条订单
            PropertyInviterLogEntity propertyInviterLogEntity = propertyInviterLogService.getPropertyInviterLog(orderEntity.getOrder_sn());
            if (null == propertyInviterLogEntity) {
                return;
            }

            PropertyEntity propertyEntity = propertyService.getProperEntity(inviteUser);//查询邀请者的资产情况

            if (null == propertyEntity) {
                return;
            }
            //fixme 可提现金增加，待体现金额减少
            BigDecimal commissionAble = null;

            if (propertyEntity.getCommission_money_able().doubleValue() == TomatoConstant.Common.NUMBER_0) {//可提现金额
                commissionAble = propertyInviterLogEntity.getCommission_money();

            } else {
                //可提现金额增加
                commissionAble = BigDecimalUtils.addBig(propertyEntity.getCommission_money_able(), propertyInviterLogEntity.getCommission_money());
            }
            //待返现金额减少
            BigDecimal commissionBack = BigDecimalUtils.subBig(propertyEntity.getCommission_money_back(), propertyInviterLogEntity.getCommission_money());

            updateInviterPropertyLog(propertyInviterLogEntity, TomatoConstant.Common.NUMBER_1, TomatoConstant.Order.CHECK_SUC);
            //审核失败，从日志表中查询该条订单
            PropertyLogEntity propertyLogEntity = propertyLogService.getPropertyLog(inviteUser, orderEntity.getOrder_sn());
            if (null == propertyLogEntity) {
                return;
            }

            updateUserPropertyLog(propertyLogEntity, TomatoConstant.Common.NUMBER_1, TomatoConstant.Order.CHECK_SUC);//更新用户表
            propertyService.updateProperty(inviteUser, commissionAble, commissionBack);

        }

    }

    /**
     * 根据订单号查询订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderEntity getOrderById(String orderId) {

        return baseMapper.getOrderById(orderId);
    }


    @Override
    public List<OrderEntity> getOrderByUserName(String username) {
        return baseMapper.getOrderListByName(username);
    }

    /**
     * 确认收货的商品
     *
     * @param username
     * @return
     */
    @Override
    public List<OrderEntity> getOrderComplete(String username) {
        return baseMapper.getOrderComplete(username, TomatoConstant.Order.HAS_PAY, TomatoConstant.Order.CHECK_SUC);//fixme 用户购买商品后即为收益
    }
}
