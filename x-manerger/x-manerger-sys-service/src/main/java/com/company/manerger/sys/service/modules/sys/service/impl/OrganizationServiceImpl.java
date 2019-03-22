package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.TreeCommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.Organization;
import com.company.manerger.sys.service.modules.sys.mapper.OrganizationMapper;
import com.company.manerger.sys.service.modules.sys.service.IOrganizationService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

}
