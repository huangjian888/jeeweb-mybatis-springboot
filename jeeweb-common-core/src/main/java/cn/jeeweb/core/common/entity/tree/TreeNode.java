package cn.jeeweb.core.common.entity.tree;

public interface TreeNode<ID> {
	public ID getId();// 主键

	public void setId(ID name);// 设置主键

	/**
	 * 是否是根节点
	 *
	 * @return
	 */
	public boolean isRoot();

	public String getName();// 节点名称

	public void setName(String name);// 设置节点名称

	public Long getLevel();// 节点的级别，默认最高级为0

	public Boolean isLeaf();// 是否为叶节点，为true时表示该节点下面没有子节点了

	/**
	 * 获取 parentIds 之间的分隔符
	 *
	 * @return
	 */
	public String getSeparator();

	/**
	 * 把自己构造出新的父节点路径
	 *
	 * @return
	 */
	public String makeSelfAsNewParentIds();

	/**
	 * 父路径
	 *
	 * @return
	 */
	public ID getParentId();

	public void setParentId(ID parentId);

	/**
	 * 所有父路径 如1,2,3,
	 *
	 * @return
	 */
	public String getParentIds();

	public void setParentIds(String parentIds);

	public Boolean getExpanded();// 是否默认展开状态

	public void setExpanded(Boolean expanded);// 是否默认展开状态

	public void setLoaded(Boolean loaded);// 是否已经加载过子节点（为false时点击节点会自动加载子节点）

	public Boolean getLoaded();// 是否已经加载过子节点（为false时点击节点会自动加载子节点）
	public String[] makeTags();
}
