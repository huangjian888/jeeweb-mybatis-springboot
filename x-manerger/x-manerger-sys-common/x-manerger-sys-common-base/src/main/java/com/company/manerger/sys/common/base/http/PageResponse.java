package com.company.manerger.sys.common.base.http;

import com.company.manerger.sys.common.query.data.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 页面展示分页
 * @param <T>
 */
public class PageResponse<T> extends Response implements Serializable {
	private static final long serialVersionUID = 1L;
	private long page = 1;// 当前页
	private long rows = 10;// 每页显示记录数
	private long total; // 总数
	private long totalPages; // 总页数
	private List<T> results; // 结果

	public PageResponse() {

	}

	public PageResponse(List<T> results) {
		this(0, Long.MAX_VALUE, Long.MAX_VALUE, results);
	}

	public PageResponse(Page<T> page) {
		this(page.getNumber(), page.getSize(), page.getTotalElements(), page.getContent());
	}

	public PageResponse(long page, long rows, long total, List<T> results) {
		this.page = page;
		this.rows = rows;
		this.total = total;
		this.results = results;
		this.totalPages = getRows() == 0 ? 1 : (int) Math.ceil((double) total / (double) getRows());
		// 设置配置
		put("page",this.page);
		put("rows",this.rows);
		put("total",this.total);
		put("results",this.results);
		put("totalPages",this.totalPages);
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getRows() {
		return rows;
	}

	public void setRows(long rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}
