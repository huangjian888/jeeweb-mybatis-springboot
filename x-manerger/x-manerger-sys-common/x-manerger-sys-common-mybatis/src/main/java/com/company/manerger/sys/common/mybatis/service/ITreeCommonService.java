package com.company.manerger.sys.common.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.company.manerger.sys.common.base.mvc.entity.tree.TreeNode;
import com.company.manerger.sys.common.query.data.Queryable;

import java.io.Serializable;
import java.util.List;

public interface ITreeCommonService<T extends Serializable & TreeNode<ID>, ID extends Serializable>
		extends ICommonService<T> {
	public List<T> selectTreeList(Wrapper<T> wrapper);
	public List<T> selectTreeList(Queryable queryable, Wrapper<T> wrapper);
}