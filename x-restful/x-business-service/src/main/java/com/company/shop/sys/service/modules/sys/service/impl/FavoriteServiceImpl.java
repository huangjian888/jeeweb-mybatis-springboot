package com.company.shop.sys.service.modules.sys.service.impl;

import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.modules.sys.service.IFavoriteService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收藏夹
 */
@Transactional
@Service("FavoriteService")
public class FavoriteServiceImpl implements IFavoriteService {
    @Override
    public String addGoodsToFavorite(String goodsId) {
        Preconditions.checkArgument(goodsId != null, ErrorCodeEnum.PRODUCT3001.msg());//fixme 检查商品id不能为null
        return null;
    }

    @Override
    public String removeGoodsFromFavorite(String goodsId) {
        Preconditions.checkArgument(goodsId != null, ErrorCodeEnum.PRODUCT3001.msg());
        return null;
    }
}
