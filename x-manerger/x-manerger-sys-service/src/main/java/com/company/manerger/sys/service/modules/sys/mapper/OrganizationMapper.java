package com.company.manerger.sys.service.modules.sys.mapper;

import java.util.List;

import com.company.manerger.sys.common.mybatis.mapper.BaseTreeMapper;
import com.company.manerger.sys.service.modules.sys.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper extends BaseTreeMapper<Organization> {
	
	/**
	 * 
	 * @title: findListByUserId
	 * @description: 通过用户查找组织机构
	 * @param userId
	 * @return
	 * @return: List<Organization>
	 */
	List<Organization> findListByUserId(String userId);
}