package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.modules.sys.data.SysDatabaseEnum;
import cn.jeeweb.modules.sys.entity.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 数据源
 * @Description: 数据源
 * @author jeeweb
 * @date 2017-05-10 12:01:57
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/datasource")
@RequiresPathPermission("sys:datasource")
public class DataSourceController extends BaseCRUDController<DataSource, String> {

	@RequestMapping(value = "dataSourceParameter")
	@ResponseBody
	public AjaxJson dataSourceParameter(@RequestParam String dbType) {
		AjaxJson j = new AjaxJson();
		SysDatabaseEnum sysDatabaseEnum = SysDatabaseEnum.toEnum(dbType);

		if (sysDatabaseEnum != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("driverClass", sysDatabaseEnum.getDriverClass());
			map.put("url", sysDatabaseEnum.getUrl());
			map.put("dbtype", sysDatabaseEnum.getDbtype());
			j.setData(map);
		} else {
			j.setData(null);
		}
		return j;
	}
}
