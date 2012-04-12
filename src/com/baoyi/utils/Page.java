package com.baoyi.utils;

public class Page {
	private int totalRows;
	private int pageSize;
	private int currentPage;
	private int totalPages;
	private int startRow;
	private static final int PAGELENGTH = 5;

	public void config() {

		totalPages = totalRows / pageSize;
		if (totalRows % pageSize > 0) {
			totalPages++;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > totalPages) {
			currentPage = totalPages+1;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		if ((startRow + pageSize) > totalRows) {
			return totalRows;
		} else {
			return startRow + pageSize;
		}

	}

	public int getStarPage() {
		if ((currentPage - PAGELENGTH) > 0) {
			return currentPage - PAGELENGTH;
		} else {
			return 1;
		}

	}

	public int getEndPage() {
		if ((currentPage + PAGELENGTH) > totalPages) {
			return totalPages;
		} else {
			return currentPage + PAGELENGTH;
		}

	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public Page() {
		currentPage = 0;
	}

}
