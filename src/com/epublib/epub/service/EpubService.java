package com.epublib.epub.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.baoyi.common.page.PageResult;

public interface EpubService {

	public abstract List find(String where, int size);

	public abstract double getCount(String sql);

	public abstract PageResult getPageResult(String sql, int pageSize);

	public abstract PageResult getPageResult(String sql, String currentPage, int pageSize);

	public abstract PageResult getPageResult(String where, String currentPage,
			String pagerMethod, int pageSize);

	public abstract Session openSession();

	public abstract List find(String where);

	public abstract Object findById(Class cla, Serializable id);

	public abstract void saveOrUpdate(Object object);

	public abstract void update(Object object);

	public abstract void delete(String sql);

	public abstract void delete(Object object);

	public abstract Object save(Object object);

	public abstract Object getColumnMaxValue(String hql);

	public abstract Long getCountRecord(String hql);

	public abstract List getPageList(String hql, int page, int countOfPage);

	public abstract List getList(String hql);

	public abstract int getPageCount(int countOfPage, long record);

	public abstract PageResult getMyPageResult(String hql, String currentPage,
			int pageSize);

	public abstract Object getById(String clazz, Serializable id);

	public abstract void saveOrUpdateAll(Collection collection);

	public abstract void deleteAll(Collection collection);

	public abstract Object getOneObject(String hql);

	public abstract void add(Object obj);

}
