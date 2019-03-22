package com.company.manerger.sys.service.modules.sys.service;

import java.util.List;

import com.company.manerger.sys.common.mybatis.service.ITreeCommonService;
import com.company.manerger.sys.service.modules.sys.entity.Organization;

/**
 */
public interface IOrganizationService extends ITreeCommonService<Organization, String> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Organization> findListByUserId(String userid);
}
