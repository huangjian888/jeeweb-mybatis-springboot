package com.company.shop.sys.service.modules.sys.service;

/**
 * 收藏夹--有用户状态
 */
public interface IFavoriteService {

    String addGoodsToFavorite(String goodsId);

    String removeGoodsFromFavorite(String goodsId);
}
