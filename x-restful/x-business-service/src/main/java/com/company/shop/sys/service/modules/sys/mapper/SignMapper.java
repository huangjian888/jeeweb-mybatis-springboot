package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.SignEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SignMapper extends BaseMapper<SignEntity> {

    /**
     * 获取当前用户的签名表信息
     *
     * @return
     */
    SignEntity getSignTable(@Param("username") String username);

    List<SignEntity> getBookingSign(@Param("autoAlert") int autoAlert);
}
