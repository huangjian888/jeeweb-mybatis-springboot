package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.GoldLogVo;
import com.company.shop.sys.service.common.vo.StoreUserVo;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.controller
 * @title: 用户表控制器
 * @description: 用户表控制器
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */

@RestController
@Slf4j
public class TomatoUserController extends BaseBeanController<StoreUserEntity> {

    @Autowired
    private IStoreUserService storeUserService;


    @PostMapping(value = "/authentication/admin/login")
    public String login(@RequestBody JSONObject json) {//username,passwod

        return storeUserService.login(json.getString("username"), json.getString("password"));

    }

    @PostMapping(value = "/authentication/admin/register")
    public String register(@RequestBody JSONObject json) throws AuthenticationException {

        StoreUserEntity storeUser = new StoreUserEntity();
        storeUser.setUsername(json.getString("username"));
        storeUser.setPassword(json.getString("password"));
        return storeUserService.register(storeUser);
    }

    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization) {
        return storeUserService.refreshToken(authorization);
    }


    /**
     * 登录成功后需要前端单独调用--因微信授权可能会调用多次
     *
     * @return
     */
    @GetMapping(value = "/user/info")
    public Response getUserInfo() {
        StoreUserEntity user = storeUserService.getUserInfo();
        if (null == user) {
            return Response.error(ErrorCodeEnum.AUTH1006.code(), ErrorCodeEnum.AUTH1006.msg());
        }
        return Response.ok().putObject(user);
    }

    /**
     * 获取用户金币兑换记录
     *
     * @return
     */
    @GetMapping(value = "/user/log")
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    public Response getUserGoldLog(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<StoreUserEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));
        Page<GoldLogEntity> pageList = storeUserService.getGoldList(pageEntity);
        List<GoldLogEntity> list = pageList.getRecords();

        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.AUTH1007.code(), ErrorCodeEnum.AUTH1007.msg());
        }
        GoldLogVo goldLogVo = new GoldLogVo();
        goldLogVo.setList(list);
        goldLogVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(goldLogVo);
    }

    /**
     * 用户邀请的好友列表
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @GetMapping(value = "/user/friend")
    public Response getUserFriendList(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<StoreUserEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));
        Page<StoreUserEntity> pageList = storeUserService.getFriendList(pageEntity);
        List<StoreUserEntity> list = pageList.getRecords();


        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.AUTH1007.code(), ErrorCodeEnum.AUTH1007.msg());
        }
        StoreUserVo storeUserVo = new StoreUserVo();
        storeUserVo.setList(list);
        storeUserVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(storeUserVo);
    }

}