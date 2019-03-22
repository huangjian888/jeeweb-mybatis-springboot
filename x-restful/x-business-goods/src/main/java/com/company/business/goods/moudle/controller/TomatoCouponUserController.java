package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.UserFansVo;
import com.company.business.goods.moudle.service.ITomatoCouponUserService;
import com.company.business.goods.security.user.ITomatoUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.Log;
import com.company.business.goods.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TomatoCouponUserController {
    @Autowired
    private ITomatoCouponUserService tomatoCouponUserService;

    @Autowired
    private ITomatoUserService tomatoUserService;

    @PostMapping(value = "/authentication/admin/login")
    public String login(@RequestBody JSONObject json) {//username,passwod
        String username = json.getString("username");
        String password = json.getString("password");
        return tomatoUserService.login(username, password);
    }


    @PostMapping(value = "/authentication/admin/register")
    public String register(@RequestBody JSONObject json) {

        String username = json.getString("username");
        String password = json.getString("password");
        Log.i("username:" + username + ",password:" + password);
        TomatoUserEntity storeUser = new TomatoUserEntity();
        storeUser.setUsername(username);
        storeUser.setPassword(password);
        return tomatoUserService.register(storeUser);
    }

    @GetMapping(value = "/exit")
    public Response exitApp() {
        int result = tomatoCouponUserService.updateExitTime();
        if (result == 0) {

            return Response.error(ErrorCodeEnum.COUPON2006.code(), ErrorCodeEnum.COUPON2006.msg());
        }

        return Response.ok();
    }

    /**
     * 上传用户数据
     *
     * @return
     */
    @PostMapping("/user")
    public Response updateUserInfo(@RequestBody JSONObject json) {

        return tomatoCouponUserService.updateUserInfo(json) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2010.code(), ErrorCodeEnum.COUPON2010.msg());
    }

    /**
     * 邀请的好友数据
     *
     * @return
     */
    @GetMapping("/user/friends")
    public Response getUserFansSize() {
        return Response.ok().putObject(tomatoCouponUserService.getFriendsVo());
    }

    @GetMapping("/user/fans")
    public Response getUserFansList(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");


        Page pageEntity = new Page<UserFansVo>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<UserFansVo> pageList = tomatoCouponUserService.getUserFansList(pageEntity);

        List<UserFansVo> list = pageList.getRecords();
        if (null == list) {
            return Response.error(ErrorCodeEnum.COUPON2024.code(), ErrorCodeEnum.COUPON2024.msg());
        }

        return Response.ok().putList(TomatoConstant.Common.RESPONSE, list);
    }

}
