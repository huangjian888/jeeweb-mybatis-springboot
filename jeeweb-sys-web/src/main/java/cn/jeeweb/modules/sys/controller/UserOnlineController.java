package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.query.annotation.PageableDefaults;
import cn.jeeweb.core.query.data.Page;
import cn.jeeweb.core.query.data.PageImpl;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
//import cn.jeeweb.core.security.shiro.session.SessionDAO;
import cn.jeeweb.core.utils.JeewebPropertiesUtil;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.OnlineSession;
import cn.jeeweb.modules.sys.entity.UserOnline;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Title: 在线用户
 * @Description: 在线用户
 * @author jeeweb
 * @date 2017-05-15 08:18:21
 * @version V1.0
 *
 */
@Controller
@RequestMapping(value = "${admin.url.prefix}/sys/online")
@RequiresPathPermission("sys:online")
public class UserOnlineController extends BaseController {

	@Autowired
	private SessionDAO sessionDAO;

	public UserOnlineController() {
	}


	@RequiresMethodPermissions("list")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 预处理
		Collection<Session> sessionList=sessionDAO.getActiveSessions();
		List<UserOnline> onlineSessionList=new ArrayList<UserOnline>();
		for (Session session:sessionList) {
			UserOnline userOnline= UserOnline.fromOnlineSession((OnlineSession) session);
			if (!StringUtils.isEmpty(userOnline.getUserId())) {
				onlineSessionList.add(UserOnline.fromOnlineSession((OnlineSession) session));
			}
		}
		model.addAttribute("onlineSessionList",onlineSessionList);
		return display("list");
	}
	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
	@PageableDefaults(sort = "id=desc")
	private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
		// 预处理
		Collection<Session> onlineSessionList=sessionDAO.getActiveSessions();
		Page<Session> onlineSessionPage=new PageImpl<Session>((List<Session>) onlineSessionList);
		String content = JSON.toJSONString(onlineSessionPage);
		StringUtils.printJson(response, content);
	}
	@RequestMapping("/forceLogout")
	@ResponseBody
	public AjaxJson forceLogout(@RequestParam(value = "ids") String[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.setMsg("强制退出成功");
		if (JeewebPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许强制退出用户！");
			return ajaxJson;
		}
		for (String id : ids) {
			OnlineSession onlineSession = (OnlineSession) sessionDAO.readSession(id);
			if (onlineSession == null) {
				continue;
			}
			onlineSession.setStatus(OnlineSession.OnlineStatus.force_logout);
			//sessionDAO.update(onlineSession);
		}
		return ajaxJson;
	}

}
