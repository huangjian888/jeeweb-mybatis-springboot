package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.exception.BusinessException;
import com.company.shop.sys.service.modules.sys.entity.ShippingEntity;
import com.company.shop.sys.service.modules.sys.mapper.ShippingMapper;
import com.company.shop.sys.service.modules.sys.service.IShippingService;
import com.company.shop.sys.service.utils.Log;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("shippingService")
public class ShippingServiceImpl extends ServiceImpl<ShippingMapper, ShippingEntity> implements IShippingService {


    /**
     * 添加收货地址--设置添加物流地址限制
     *
     * @param
     * @return
     */
    @Override
    public int addAddress(JSONObject json) {
        //限制每个用户的物流地址数量为6
        List<ShippingEntity> list = this.getUserAddress();//获取用户的物流地址
        if (null != list && list.size() > BusinessConstant.Home.ZERO) {//用户已有收货地址
            for (ShippingEntity shippingEntity : list) {
                shippingEntity.setDefaultAddress(BusinessConstant.Home.ZERO);
                insertOrUpdate(shippingEntity);
            }
        }
        ShippingEntity shippingEntity = new ShippingEntity();
        if (this.countAddress() >= BusinessConstant.Shipping.LIMIT_ADDRESS) {
            return BusinessConstant.Shipping.LIMIT_ADDRESS;

        }
        shippingEntity.setUsername(PrincipalUtils.getUsername());
        shippingEntity.setRealName(json.getString("realName"));
        shippingEntity.setPhone(json.getString("phone"));
        shippingEntity.setProvince(json.getString("province"));
        shippingEntity.setCity(json.getString("city"));
        shippingEntity.setZone(json.getString("zone"));
        shippingEntity.setStreet(json.getString("street"));
        shippingEntity.setDetailAddress(json.getString("detailAddress"));
        shippingEntity.setDefaultAddress(json.getIntValue("defaultAddress"));


        return addOrUpdateAddress(shippingEntity);
    }

    /**
     * 删除收货地址
     *
     * @param shippingId
     * @return
     */
    @Override
    public int removeAddress(String shippingId) {
        return baseMapper.removeAddress(PrincipalUtils.getUsername(), shippingId);
    }

    /**
     * 修改收货地址
     *
     * @param JSONObject
     * @return
     */
    @Override
    public int updateAddress(JSONObject json) {
        String shippingId = json.getString("id");
        if (TextUtils.isEmpty(shippingId)) {
            return BusinessConstant.Home.ZERO;
        }
        ShippingEntity shippingEntity = this.getUserShipById(shippingId);
        shippingEntity.setRealName(json.getString("realName"));
        shippingEntity.setPhone(json.getString("phone"));
        shippingEntity.setProvince(json.getString("province"));
        shippingEntity.setCity(json.getString("city"));
        shippingEntity.setZone(json.getString("zone"));
        shippingEntity.setStreet(json.getString("street"));
        shippingEntity.setDetailAddress(json.getString("detailAddress"));
        shippingEntity.setDefaultAddress(json.getIntValue("defaultAddress"));

        return addOrUpdateAddress(shippingEntity);
    }

    /**
     * 设置默认的收货地址--只能有一个默认收货地址
     * 1.查找当前的默认收货地址
     * 2.判断需要设置的默认地址与当前的默认收货地址是否相同
     * 3.相同的不处理，不同则需要更新到用户需求的默认地址
     *
     * @param shippingId
     * @return
     */
    @Override
    public int defaultAddress(String shippingId) {
        ShippingEntity shippingInfo = baseMapper.getCurrentDefaultAddress(PrincipalUtils.getUsername());

        if (null == shippingInfo) {//无默认收货地址--设置当前id为默认地址
            return baseMapper.setDefaultAddress(PrincipalUtils.getUsername(), shippingId);
        }
        //如有默认的收货地址,且相等--不做操作
        if (shippingId.equalsIgnoreCase(shippingInfo.getId())) {
            return 1;
        }
        //3.设置当前shippingId为默认收货地址，之前的shippingId置为非默认
        setDeauflt(shippingId, BusinessConstant.Shipping.DEFAULT);
        setDeauflt(shippingInfo.getId(), BusinessConstant.Shipping.NOT_DEFAULT);
        return 1;
    }

    @Override
    public ShippingEntity getDefaultAddress() {
        return baseMapper.getDefaultAddress(PrincipalUtils.getUsername());
    }

    /**
     * 获取用户的所有收货地址
     *
     * @return
     */
    @Override
    public List<ShippingEntity> getUserAddress() {


        return baseMapper.getAllAdress(PrincipalUtils.getUsername());
    }

    /**
     * 根据物流id查询对应的物流信息
     *
     * @param shippingId
     * @return
     */
    @Override
    public ShippingEntity getUserShipById(String shippingId) {

        return baseMapper.getShipById(PrincipalUtils.getUsername(), shippingId);
    }

    /**
     * 获取用户的物流地址数量
     *
     * @return
     */
    @Override
    public int countAddress() {
        return baseMapper.countAddress(PrincipalUtils.getUsername());
    }


    private int addOrUpdateAddress(ShippingEntity shippingInfo) {

        //id为空则创建收货表信息，不为空则更新收货地址表


        return insertOrUpdate(shippingInfo) ? 1 : 0;

    }

    /**
     * @param shippingId
     * @param isDeauflt
     */
    private void setDeauflt(String shippingId, int isDeauflt) {

        ShippingEntity shippingInfo = new ShippingEntity();
        shippingInfo.setId(shippingId);
        shippingInfo.setDefaultAddress(isDeauflt);

        shippingInfo.setUsername(PrincipalUtils.getUsername());

        boolean result = insertOrUpdate(shippingInfo);

        if (!result) {
            Log.i("insert address error");
            throw new BusinessException(ErrorCodeEnum.AUTH500.code(), ErrorCodeEnum.AUTH500.msg());//设置默认地址异常
        }
    }

}
