package com.baoyi.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.baoyi.common.page.PageResult;

/**
 * @Class BaseDAO.java
 * @Author ada
 * @Email
 * @Time 2012.04.21
 * @Version 1.0
 */
@SuppressWarnings("unchecked")
public interface BaseDAO {

	public abstract void add(Object obj);
	public Object getOneObject(String hql);
	public abstract void deleteAll(Collection collection);

	public abstract void saveOrUpdateAll(Collection collection);

	public abstract Object getById(String clazz, Serializable id);

	// 获取分页对象和结�?
	public PageResult getMyPageResult(String hql, String currentPage,
			int pageSize);

	public abstract int getPageCount(int countOfPage, long record);

	public abstract List getList(String hql);

	public abstract List getPageList(String hql, int page, int countOfPage);

	public abstract Long getCountRecord(String hql);

	public Object getColumnMaxValue(String hql);

	// 根据给定的持久化对象,添加记录
	public Object save(Object object);

	// 根据给定的持久化对象,删除记录
	public void delete(Object object);

	public void delete(String sql);

	// 根据给定的持久化对象,更新记录
	public void update(Object object);

	// 根据给定的对象,保存或更新对象
	public void saveOrUpdate(Object object);

	// 通过主键ID返回一个数据对象
	public Object findById(Class cla, Serializable id);

	// 执行HQL查询,返回查询的结果
	public List find(String where);

	// 获得Hibernate中的一个session
	public Session openSession();

	// 获取分页对象和结果
	public PageResult getPageResult(String where, String currentPage,
			String pagerMethod, int pageSize);

	// 获取分页对象和结果
	public PageResult getPageResult(String sql, String currentPage, int pageSize);

	// 获取分页对象和结果
	public PageResult getPageResult(String sql, int pageSize);

	// 得到总数
	public double getCount(String sql);
	public List find(String where, int size);

}
