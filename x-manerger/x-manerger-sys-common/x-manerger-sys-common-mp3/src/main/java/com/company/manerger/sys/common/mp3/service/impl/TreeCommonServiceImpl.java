package com.company.manerger.sys.common.mp3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.manerger.sys.common.base.mvc.entity.tree.TreeNode;
import com.company.manerger.sys.common.mp3.mapper.BaseTreeMapper;
import com.company.manerger.sys.common.mp3.parse.QueryToWrapper;
import com.company.manerger.sys.common.mp3.service.ITreeCommonService;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.utils.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class TreeCommonServiceImpl<M extends BaseTreeMapper<T>, T extends Serializable & TreeNode<ID>, ID extends Serializable> extends CommonServiceImpl<M, T> implements ITreeCommonService<T, ID> {

	@Override
	public T getById(Serializable id) {
		return baseMapper.selectByTreeId(id);
	}

	@Override
	public List<T> selectTreeList(Queryable queryable, QueryWrapper<T> wrapper) {
		// 保证有where字句
		QueryToWrapper<T> queryToWrapper = new QueryToWrapper<T>();
		wrapper.eq(true,"1", "1");
		queryToWrapper.parseCondition(wrapper, queryable);
		// 排序问题
		queryToWrapper.parseSort(wrapper, queryable);
		List<T> content = baseMapper.selectTreeList(wrapper);
		return content;
	}

	@Override
	public List<T> selectTreeList(QueryWrapper<T> wrapper) {
		// 保证有where字句
		wrapper.eq(true,"1", "1");
		List<T> content = baseMapper.selectTreeList(wrapper);
		return content;
	}

	@Override
	public boolean save(T entity) {
		if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
			T parent = getById(entity.getParentId());
			entity.setParentId(parent.getId());
			entity.setParentIds(parent.makeSelfAsNewParentIds());
		} else {
			entity.setParentId(null);
		}
		return super.save(entity);
	}

	@Override
	public boolean saveOrUpdate(T entity) {
		if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
			T parent = getById(entity.getParentId());
			updateSelftAndChild(entity, parent.getId(), parent.makeSelfAsNewParentIds());
		} else {
			entity.setParentId(null);
			updateSelftAndChild(entity, null, null);
		}
		return true;
	}

	private void updateSelftAndChild(T entity, ID newParentId, String newParentIds) {
		T oldEntity = getById(entity.getId());
		String oldChildrenParentIds = oldEntity.makeSelfAsNewParentIds();
		entity.setParentId(newParentId);
		entity.setParentIds(newParentIds);
		super.saveOrUpdate(entity);
		String newChildrenParentIds = entity.makeSelfAsNewParentIds();
		baseMapper.updateSunTreeParentIds(newChildrenParentIds, oldChildrenParentIds);
	}

}