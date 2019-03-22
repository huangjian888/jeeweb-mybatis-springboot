package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.modules.sys.entity.BuyLimitEntity;

public interface IBuyLimitService {
    BuyLimitEntity getBuyLimit();

    int insertUserBuy(BuyLimitEntity buyLimitEntity);
}
