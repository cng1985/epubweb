package com.epublib.category.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.baoyi.common.page.PageResult;
import com.epublib.category.dao.CategoryDao;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void add(Object obj) {
		categoryDao.add(obj);
	}

	@Override
	public Object getOneObject(String hql) {
		return categoryDao.getOneObject(hql);
	}

	@Override
	public void deleteAll(Collection collection) {
		categoryDao.deleteAll(collection);
	}

	@Override
	public void saveOrUpdateAll(Collection collection) {
		categoryDao.saveOrUpdateAll(collection);
	}

	@Override
	public Object getById(String clazz, Serializable id) {
		return categoryDao.getById(clazz, id);
	}

	@Override
	public PageResult getMyPageResult(String hql, String currentPage,
			int pageSize) {
		return categoryDao.getMyPageResult(hql, currentPage, pageSize);
	}

	@Override
	public int getPageCount(int countOfPage, long record) {
		return categoryDao.getPageCount(countOfPage, record);
	}

	@Override
	public List getList(String hql) {
		return categoryDao.getList(hql);
	}

	@Override
	public List getPageList(String hql, int page, int countOfPage) {
		return categoryDao.getPageList(hql, page, countOfPage);
	}

	@Override
	public Long getCountRecord(String hql) {
		return categoryDao.getCountRecord(hql);
	}

	@Override
	public Object getColumnMaxValue(String hql) {
		return categoryDao.getColumnMaxValue(hql);
	}

	@Override
	public Object save(Object object) {
		return categoryDao.save(object);
	}

	@Override
	public void delete(Object object) {
		categoryDao.delete(object);
	}

	@Override
	public void delete(String sql) {
		categoryDao.delete(sql);
	}

	@Override
	public void update(Object object) {
		categoryDao.update(object);
	}

	@Override
	public void saveOrUpdate(Object object) {
		categoryDao.saveOrUpdate(object);
	}

	@Override
	public Object findById(Class cla, Serializable id) {
		return categoryDao.findById(cla, id);
	}

	@Override
	public List find(String where) {
		return categoryDao.find(where);
	}

	@Override
	public Session openSession() {
		return categoryDao.openSession();
	}

	@Override
	public PageResult getPageResult(String where, String currentPage,
			String pagerMethod, int pageSize) {
		return categoryDao.getPageResult(where, currentPage, pagerMethod,
				pageSize);
	}

	@Override
	public PageResult getPageResult(String sql, String currentPage, int pageSize) {
		return categoryDao.getPageResult(sql, currentPage, pageSize);
	}

	@Override
	public PageResult getPageResult(String sql, int pageSize) {
		return categoryDao.getPageResult(sql, pageSize);
	}

	@Override
	public double getCount(String sql) {
		return categoryDao.getCount(sql);
	}

	@Override
	public List find(String where, int size) {
		return categoryDao.find(where, size);
	}
}
