package cn.jeeweb.core.query.data;

/**
 * 查询接口
 * 
 * @author Administrator
 *
 */
public interface Queryable {
	/**
	 * 获得分页
	 * 
	 * @return
	 */
	public Pageable getPageable();

	public void setPageable(Pageable pageable);

	/**
	 * 获得排序
	 * 
	 * @return
	 */
	public Sort getSort();

	public void addSort(Sort sort);

	/**
	 * 获得查询条件
	 * 
	 * @return
	 */
	public Condition getCondition();

	public void setCondition(Condition condition);

	/**
	 * 通过字段获得值，方便自定义查询
	 * 
	 * @return
	 */
	public Object getValue(String property);

	/**
	 * 添加条件
	 * 
	 * @param operator
	 * @param property
	 * @param value
	 * @return
	 */
	public Queryable addCondition(final String property, final Object value);

	/**
	 * 移出条件，方便自定义条件
	 * 
	 * @param property
	 */
	public void removeCondition(String property);

	public boolean isConverted();

}
