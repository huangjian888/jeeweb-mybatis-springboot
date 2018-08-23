package cn.jeeweb.modules.sys.service;

import cn.jeeweb.core.common.service.ITreeCommonService;
import cn.jeeweb.modules.sys.entity.Organization;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:51
 * @version V1.0
 *
 */
public interface IOrganizationService extends ITreeCommonService<Organization, String> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Organization> findListByUserId(String userid);
}
