package cn.jeeweb.modules.common.controller;

import cn.jeeweb.modules.common.bean.DuplicateValid;
import cn.jeeweb.modules.common.bean.ValidJson;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @Title: 重复验证
 * @Description: 重复验证
 * @author auth_team
 * @date 2017-02-23 22:27:30
 * @version V1.0
 */
@Controller
@RequestMapping("/duplicateValid")
public class DuplicateValidController {

	/**
	 * 校验数据是否在系统中是否存在
	 * 
	 * @return
	 */
	@RequestMapping(value = "validate")
	@ResponseBody
	public ValidJson doValid(DuplicateValid duplicateValid, HttpServletRequest request) {
		ValidJson validJson = new ValidJson();
		Boolean valid = Boolean.FALSE;
		String queryType = duplicateValid.getQueryType();
		if (StringUtils.isEmpty(queryType)) {
			queryType = "table";
		}
		if (queryType.equals("table")) {
			valid = validTable(duplicateValid);
		}
		if (valid) {
			validJson.setStatus("y");
			validJson.setInfo("验证通过!");
		} else {
			validJson.setStatus("n");
			validJson.setInfo("当前信息重复!");
		}
		return validJson;
	}

	@SuppressWarnings("unused")
	private Boolean validTable(DuplicateValid duplicateValid) {
		Integer num = null;
		String sql = "";
		String extendName = duplicateValid.getExtendName();
		String extendParam = duplicateValid.getExtendParam();
		if (!StringUtils.isEmpty(extendParam)) {
			// [2].编辑页面校验
			sql = "SELECT count(*) FROM " + duplicateValid.getQueryData() + " WHERE " + duplicateValid.getName() + " ='"
					+ duplicateValid.getParam() + "' and " + extendName + " != '" + extendParam + "'";
			// num = userService.countBySql(sql);
		} else {
			// [1].添加页面校验
			sql = "SELECT count(*) FROM " + duplicateValid.getQueryData() + " WHERE " + duplicateValid.getName() + " ='"
					+ duplicateValid.getParam() + "'";
			// num = userService.countBySql(sql);
		}

		if (num == null || num == 0) {
			// 该值可用
			return true;
		} else {
			// 该值不可用
			return false;
		}
	}
}
