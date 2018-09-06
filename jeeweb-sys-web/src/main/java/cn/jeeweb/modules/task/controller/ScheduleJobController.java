package cn.jeeweb.modules.task.controller;


import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.MyBeanUtils;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.modules.task.entity.ScheduleJob;
import cn.jeeweb.modules.task.service.IScheduleJobService;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: 任务
 * @Description: 任务
 * @author jeeweb
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/task/schedulejob")
@RequiresPathPermission("task:schedulejob")
public class ScheduleJobController extends BaseCRUDController<ScheduleJob, String> {

	@Resource
	private IScheduleJobService scheduleJobService;

	@RequestMapping(value = "/changeJobStatus", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson changeJobStatus(ScheduleJob scheduleJob, HttpServletRequest request,
                                    HttpServletResponse response) {
		String cmd = request.getParameter("cmd");
		AjaxJson ajaxJson = new AjaxJson();
		String label = "停止";
		if (cmd.equals("start")) {
			label = "启动";
		} else {
			label = "停止";
		}
		ajaxJson.success("任务" + label + "成功");
		try {
			scheduleJobService.changeStatus(scheduleJob.getId(), cmd);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("任务" + label + "失败" + e.getMessage());
		}
		return ajaxJson;
	}

	@RequestMapping(value = "/updateCron", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateCron(ScheduleJob scheduleJob, HttpServletRequest request,
                               HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("任务更新成功");
		try {
			scheduleJobService.updateCron(scheduleJob.getId());
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("任务更新失败" + e.getMessage());
		}
		return ajaxJson;
	}
	
	@RequestMapping(value = "/saveScheduleJob", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveScheduleJob(ScheduleJob scheduleJob, HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("保存成功");
		if (!CronExpression.isValidExpression(scheduleJob.getCronExpression())) {
			ajaxJson.fail("cron表达式格式不对");
	    	return ajaxJson;
		}
		try {
			 if (ObjectUtils.isNullOrEmpty(scheduleJob.getId())) {
				commonService.insert(scheduleJob);
			} else {
				// FORM NULL不更新
				ScheduleJob oldEntity = commonService.selectById(scheduleJob.getId());
				MyBeanUtils.copyBeanNotNull2Bean(scheduleJob, oldEntity);
				commonService.insertOrUpdate(oldEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("保存失败"+e.getMessage());
		}
		return ajaxJson;
	}
 
}
