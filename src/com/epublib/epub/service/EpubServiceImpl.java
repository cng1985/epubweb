package com.epublib.epub.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.baoyi.common.page.PageResult;
import com.epublib.epub.dao.EpubDao;

public class EpubServiceImpl implements EpubService {

	private EpubDao epubDao;

	@Override
	public void add(Object obj) {
		epubDao.add(obj);
	}

	@Override
	public Object getOneObject(String hql) {
		return epubDao.getOneObject(hql);
	}

	@Override
	public void deleteAll(Collection collection) {
		epubDao.deleteAll(collection);
	}

	@Override
	public void saveOrUpdateAll(Collection collection) {
		epubDao.saveOrUpdateAll(collection);
	}

	@Override
	public Object getById(String clazz, Serializable id) {
		return epubDao.getById(clazz, id);
	}

	@Override
	public PageResult getMyPageResult(String hql, String currentPage,
			int pageSize) {
		return epubDao.getMyPageResult(hql, currentPage, pageSize);
	}

	@Override
	public int getPageCount(int countOfPage, long record) {
		return epubDao.getPageCount(countOfPage, record);
	}

	@Override
	public List getList(String hql) {
		return epubDao.getList(hql);
	}

	@Override
	public List getPageList(String hql, int page, int countOfPage) {
		return epubDao.getPageList(hql, page, countOfPage);
	}

	@Override
	public Long getCountRecord(String hql) {
		return epubDao.getCountRecord(hql);
	}

	@Override
	public Object getColumnMaxValue(String hql) {
		return epubDao.getColumnMaxValue(hql);
	}

	@Override
	public Object save(Object object) {
		return epubDao.save(object);
	}

	@Override
	public void delete(Object object) {
		epubDao.delete(object);
	}

	@Override
	public void delete(String sql) {
		epubDao.delete(sql);
	}

	@Override
	public void update(Object object) {
		epubDao.update(object);
	}

	@Override
	public void saveOrUpdate(Object object) {
		epubDao.saveOrUpdate(object);
	}

	@Override
	public Object findById(Class cla, Serializable id) {
		return epubDao.findById(cla, id);
	}

	@Override
	public List find(String where) {
		return epubDao.find(where);
	}

	@Override
	public Session openSession() {
		return epubDao.openSession();
	}

	@Override
	public PageResult getPageResult(String where, String currentPage,
			String pagerMethod, int pageSize) {
		return epubDao.getPageResult(where, currentPage, pagerMethod, pageSize);
	}

	@Override
	public PageResult getPageResult(String sql, String currentPage, int pageSize) {
		return epubDao.getPageResult(sql, currentPage, pageSize);
	}

	@Override
	public PageResult getPageResult(String sql, int pageSize) {
		return epubDao.getPageResult(sql, pageSize);
	}

	@Override
	public double getCount(String sql) {
		return epubDao.getCount(sql);
	}

	@Override
	public List find(String where, int size) {
		return epubDao.find(where, size);
	}

	public EpubDao getEpubDao() {
		return epubDao;
	}

	public void setEpubDao(EpubDao epubDao) {
		this.epubDao = epubDao;
	}
}
