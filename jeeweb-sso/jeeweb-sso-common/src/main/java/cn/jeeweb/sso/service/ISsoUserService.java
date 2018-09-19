package cn.jeeweb.sso.service;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.sso.entity.SsoUser;

/**
 * Created by hexin on 2018/9/13.
 */
public interface ISsoUserService {
    public AjaxJson findByUsername(String username, String pwd);
    public AjaxJson findByEmail(String email,String pwd);
    public AjaxJson findByPhone(String phone,String pwd);
    public String generateToken(String user);
    public AjaxJson parseToken(String token,String clientUrl);
}
