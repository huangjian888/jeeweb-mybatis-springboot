package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.InviteConfigEntity;

public interface IInviteConfigService {
    InviteConfigEntity getInviteEntity();
    boolean updateInviteConfig(JSONObject json);
}
