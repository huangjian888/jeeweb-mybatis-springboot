package com.company.manerger.sys.common.base.mvc.entity.tree;

public interface TreeNode<ID> {

	ID getId();// 主键

	void setId(ID name);// 设置主键

	/**
	 * 是否是根节点
	 *
	 * @return
	 */
	boolean isRoot();

	String getName();// 节点名称

	void setName(String name);// 设置节点名称

	Long getLevel();// 节点的级别，默认最高级为0

	Boolean isLeaf();// 是否为叶节点，为true时表示该节点下面没有子节点了

	/**
	 * 获取 parentIds 之间的分隔符
	 *
	 * @return
	 */
	String getSeparator();

	/**
	 * 把自己构造出新的父节点路径
	 *
	 * @return
	 */
	String makeSelfAsNewParentIds();

	/**
	 * 父路径
	 *
	 * @return
	 */
	ID getParentId();

	void setParentId(ID parentId);

	/**
	 * 所有父路径 如1,2,3,
	 *
	 * @return 父亲节点
	 */
	String getParentIds();

	void setParentIds(String parentIds);

	Boolean getExpanded();// 是否默认展开状态

	void setExpanded(Boolean expanded);// 是否默认展开状态

	void setLoaded(Boolean loaded);// 是否已经加载过子节点（为false时点击节点会自动加载子节点）

	Boolean getLoaded();// 是否已经加载过子节点（为false时点击节点会自动加载子节点）

	/**
	 * 构造TAGS
	 *
	 * @return
	 */
	String[] makeTags();
}
