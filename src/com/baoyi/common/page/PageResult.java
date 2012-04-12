package com.baoyi.common.page;
import java.util.List;
/**
 * 分页结果类

 * @author 翟昆

 * 2010-4-29 
 * Email:zhaikun1234@sina.com
 */
@SuppressWarnings("unchecked")
public class PageResult
{
	/**
	 * 分页结果
	 */
	private List resultList;
	/**
	 * 分页信息
	 */
	private PageBean pageBean;
	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}	
}
