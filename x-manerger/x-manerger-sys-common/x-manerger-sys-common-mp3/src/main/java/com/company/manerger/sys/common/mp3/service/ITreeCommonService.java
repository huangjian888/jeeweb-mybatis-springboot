package com.company.manerger.sys.common.mp3.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.manerger.sys.common.base.mvc.entity.tree.TreeNode;
import com.company.manerger.sys.common.query.data.Queryable;

import java.io.Serializable;
import java.util.List;

public interface ITreeCommonService<T extends Serializable & TreeNode<ID>, ID extends Serializable> extends ICommonService<T> {
	public List<T> selectTreeList(QueryWrapper<T> wrapper);
	public List<T> selectTreeList(Queryable queryable, QueryWrapper<T> wrapper);
}