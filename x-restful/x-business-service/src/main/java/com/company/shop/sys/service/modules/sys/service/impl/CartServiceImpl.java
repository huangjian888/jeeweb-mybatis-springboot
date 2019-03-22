package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.RequestKeyConstant;
import com.company.shop.sys.service.common.exception.BusinessException;
import com.company.shop.sys.service.common.vo.CartVo;
import com.company.shop.sys.service.modules.sys.entity.CartInfo;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import com.company.shop.sys.service.modules.sys.mapper.CartMapper;
import com.company.shop.sys.service.modules.sys.service.ICartService;
import com.company.shop.sys.service.modules.sys.service.IProductService;
import com.company.shop.sys.service.utils.BigDecimalUtils;
import com.company.shop.sys.service.utils.PrincipalUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("cartService")
@Slf4j
public class CartServiceImpl extends ServiceImpl<CartMapper, CartInfo> implements ICartService {

    @Autowired
    private IProductService productService;

    /**
     * 获取购物车内的详细商品信息
     *
     * @return
     */
    @Override
    public CartVo getGoodsInCart() {
        List<CartInfo> cartInfoList = baseMapper.getGoodsInCart(PrincipalUtils.getUsername());
        List<ProductEntity> mallGoodsInfoList = new ArrayList<>();
        BigDecimal cartAllPrice = new BigDecimal("0");//购物车商品总价
        CartVo cartVo = null;
        if (null != cartInfoList) {
            int allCount = 0;//商品总数量

            for (CartInfo cartInfo : cartInfoList) {//获取到单个购物车表

                ProductEntity mallGoodsInfo = productService.getProduct(cartInfo.getProductId());//查询到当前商品
                if (null == mallGoodsInfo) {
                    throw new BusinessException(ErrorCodeEnum.AUTH500, mallGoodsInfo.getId());
                }

                mallGoodsInfoList.add(mallGoodsInfo);

                allCount = cartInfo.getQuantity();
                //单个商品的价格:单价*数量

                BigDecimal itemPrice = BigDecimalUtils.mul(mallGoodsInfo.getPrice().doubleValue(), cartInfo.getQuantity().doubleValue());
                //当前商品被选中将加到总价中去：计算价格
                if (cartInfo.getChecked() == BusinessConstant.Cart.CHECKED) {
                    cartAllPrice = BigDecimalUtils.add(cartAllPrice.doubleValue(), itemPrice.doubleValue());
                }

            }
            cartVo = new CartVo();
            cartVo.setCartProductList(mallGoodsInfoList);
            cartVo.setTotalPrice(cartAllPrice);
            cartVo.setAllChecked(this.getItemNoBeCheacked());
            cartVo.setCount(allCount);//商品总数量
            return cartVo;

        }
        return cartVo;

    }

    /**
     * 添加商品到购物车--判断当前想加入到购物车中的库存是否还足够
     *
     * @param json
     * @return
     */
    @Override
    public boolean addGoodsInCart(JSONObject json) {

        boolean result = false;

        //fixme 查询当前的用户id与商品id是否在购物车中存在--判断当前库存数量
        CartInfo cartInfo = this.getCartByProductId(json.getString(RequestKeyConstant.Cart.PRODUCT_ID));
        if (null == cartInfo) {
            cartInfo = new CartInfo();
            cartInfo.setChecked(BusinessConstant.Cart.CHECKED);//默认选中
            cartInfo.setProductId(json.getString(RequestKeyConstant.Cart.PRODUCT_ID));
            cartInfo.setUsername(PrincipalUtils.getUsername());
            cartInfo.setQuantity(TextUtils.isEmpty(json.getString(RequestKeyConstant.Cart.COUNT)) ? 1 : Integer.parseInt(json.getString(RequestKeyConstant.Cart.COUNT)));
            cartInfo.setUserId(json.getString(RequestKeyConstant.Cart.USER_ID));

            result = this.insert(cartInfo);
        } else {//相同则增加数量

            int count = cartInfo.getQuantity() == null ? 0 : cartInfo.getQuantity() + Integer.parseInt(json.getString(RequestKeyConstant.Cart.COUNT));
            cartInfo.setQuantity(count);
            result = this.insertOrUpdate(cartInfo);
        }

        return result;
    }

    /**
     * 更新购物车中的信息--商品数量更新
     *
     * @param json
     * @return
     */
    @Override
    public boolean updateCart(JSONObject json) {

        String productId = json.getString(RequestKeyConstant.Cart.PRODUCT_ID);
        int count = Integer.parseInt(json.getString(RequestKeyConstant.Cart.COUNT));

        if (count == 0) {//商品数量不能为0
            return false;
        }
        //查询到当前的购物车表
        CartInfo cartInfo = this.getCartByProductId(productId);
        if (null == cartInfo) {//内部异常状态
            throw new BusinessException(ErrorCodeEnum.AUTH500.code(), ErrorCodeEnum.AUTH500.msg());
        }

        cartInfo.setQuantity(count);

        return this.insertOrUpdate(cartInfo);


    }

    /***
     * 删除购物车中的商品
     * @param productId
     * @return
     */
    @Override
    public int removeGoodsFromCart(String productId) {
        return baseMapper.removeGoodsFromCart(PrincipalUtils.getUsername(), productId);
    }


    @Override
    public CartInfo getCartByProductId(String productId) {

        return baseMapper.getCartByProductId(PrincipalUtils.getUsername(), productId);
    }

    /**
     * 当前某一购物车被选择或是反选--状态保存
     *
     * @return
     */
    @Override
    public int selectCheckedStatus(JSONObject json) {


        return baseMapper.selectCheckedStatus(PrincipalUtils.getUsername(), json.getString(RequestKeyConstant.Cart.PRODUCT_ID), Integer.parseInt(json.getString(RequestKeyConstant.Cart.CHECKED_STATUS)));
    }

    /***
     * 获取当前购物车商品是否选择的状态,返回为true为全选状态
     * @return
     */

    public boolean getItemNoBeCheacked() {

        return baseMapper.getCheckedStatus(PrincipalUtils.getUsername()) == 0;
    }

}
