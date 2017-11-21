package com.wenming.springboot.constant;

import java.util.List;

public class Page {

	private int startIndex;
	private int pageSize = 10;
	private int total;
	@SuppressWarnings("unused")
	private int pages;
	@SuppressWarnings("rawtypes")
	private List rows;

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex > 0 ? startIndex : 0;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize > 0 ? pageSize : this.pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getPages() {
		int pages = this.total / this.pageSize;
		return this.total % this.pageSize > 0 ? pages + 1 : pages;
	}

}
