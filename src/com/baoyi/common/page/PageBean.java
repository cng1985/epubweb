package com.baoyi.common.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页信息类

 * @author 翟昆

 * 2010-4-29 
 * Email:zhaikun1234@sina.com
 */
public class PageBean
{
	private int totalRows;// 记录总行数
	private int pageSize;// 设置一页显示的条数
	private int currentPage;// 当前页面
	private int totalPages;// 总页数
	private int startRow;// 当前页码开始的行数
	
	
	private List<PageSelect> pageselect;//记录选择的页数

	/**
	 * 构造函数 进行初始化
	 * @param totalRows
	 * @param pageSize
	 */
	public PageBean(int totalRows,int pageSize)
	{
		pageselect = new ArrayList();
		this.pageSize=pageSize;
		this.totalRows = totalRows;
		totalPages = totalRows / pageSize;
		if (totalRows % pageSize > 0)
		{
			totalPages++;
		}
		currentPage = 1;
		startRow = 0;
	}
	
	

	// 首页
	public void first()
	{
		currentPage = 1;
		startRow = 0;
	}

	// 上一页
	public void previous()
	{
		if (currentPage == 1)
		{
			startRow = 0;
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}

	// 下一页
	public void next()
	{
		if (currentPage < totalPages)
		{
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	// 尾页
	public void last()
	{
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}
	
	//选择页
	public void selectd(){
		startRow=(currentPage - 1) * pageSize;
	}
	
	
	//刷新page对象
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPages) {
			last();
		}
		if(currentPage<1)
		{
			first();
		}
	}
	
	
	//选择查询-总体查询
	public void select(){
		if(totalPages!=0){
				for(int i=0;i<totalPages;i++){
					PageSelect pasl = new PageSelect();
					int count = i+1;
					pasl.setAllcount(count);
					pageselect.add(pasl);
				}
			}
		}
	
	/**
	 * setter & getter methods
	 * 
	 * @return
	 */
	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}


	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getStartRow()
	{
		return startRow;
	}

	public void setStartRow(int startRow)
	{
		this.startRow = startRow;
	}

	


	public List<PageSelect> getPageselect() {
		return pageselect;
	}
	public void setPageselect(List<PageSelect> pageselect) {
		this.pageselect = pageselect;
	}
	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getTotalRows()
	{
		return totalRows;
	}

	public void setTotalRows(int totalRows)
	{
		this.totalRows = totalRows;
	}
	
}
