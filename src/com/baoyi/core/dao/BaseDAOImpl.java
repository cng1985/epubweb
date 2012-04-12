package com.baoyi.core.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import com.baoyi.common.page.PageBean;
import com.baoyi.common.page.PageResult;
import com.baoyi.utils.NumberTools;

/**
 * @Class BaseDAOImpl.java
 * @Author 翟昆
 * @Email zhaikun1234@sina.com
 * @Time 2010-4-29
 * @Version 1.0
 */

@SuppressWarnings("unchecked")
public class BaseDAOImpl implements BaseDAO {

	protected static final Log log = LogFactory.getLog(BaseDAOImpl.class);
	public SessionFactory sessionFactory;

	public PageResult getMyPageResult(String hql, String currentPage,
			int pageSize) {
		// 定义pager对象，用于传到页�?
		int totalRows = 0;
		List resultList = null;
		PageBean pager = null;
		Session session = this.openSession();
		Query query = session.createSQLQuery(hql);
		totalRows = (query.list()).size(); // 取得总计录数
		pager = new PageBean(totalRows, pageSize);
		if ((Integer.parseInt(currentPage)) <= pager.getTotalPages()) {
			// 从当前页记录数开�?
			query.setFirstResult((Integer.parseInt(currentPage) - 1) * pageSize);
			// 取出pageSize个记�?
			query.setMaxResults(pager.getPageSize());
			if (query.list().size() > 0) {
				resultList = query.list();
			}
		}
		// 把分页查询的结果和对象放入PagerResult�?
		PageResult pagerResult = new PageResult();
		pagerResult.setPageBean(pager);
		pagerResult.setResultList(resultList);
		return pagerResult;
	}

	public void saveOrUpdateAll(Collection collection) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(collection);
	}

	public void add(Object obj) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
	}

	public void deleteAll(Collection collection) {
		Session session = sessionFactory.openSession();
		session.delete(collection);
	}

	public Object getById(String clazz, Serializable id) {
		Session session = sessionFactory.openSession();
		Object o = session.byId(clazz).getReference(id);
		return o;
	}

	public Long getCountRecord(final String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		return (Long) query.uniqueResult();
	}

	public List getList(final String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	public int getPageCount(int countOfPage, long record) {

		long count = 0;

		long _count = record % countOfPage;

		if (_count > 0) {
			if (record < countOfPage) {
				count = 1;
			} else {
				count = record / countOfPage + 1;
			}
		} else {
			count = record / countOfPage;
		}
		return NumberTools.toInteger(new Long(count)).intValue();
	}

	public List getPageList(final String hql, final int page,
			final int countOfPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(countOfPage);
		query.setFirstResult(page);
		return query.list();
	}

	public Object getColumnMaxValue(String hql) {
			return null;
	}

	// 根据给定的持久化对象,添加记录
	public Object save(Object object) {
		Session session = sessionFactory.openSession();
		return session.save(object);
	}

	// 根据给定的持久化对象,删除记录
	public void delete(Object object) {
		Session session = sessionFactory.openSession();
		session.delete(object);
	}

	// 根据给定的持久化对象,删除记录
	public void delete(String hsql) {
		Session session = this.openSession();

		try {
			session.createQuery(hsql).executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
	}

	// 根据给定的持久化对象,更新记录
	public void update(Object object) {
		Session session = this.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(object);
			session.setFlushMode(FlushMode.AUTO);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 执行HQL查询,返回查询的结果

	public List find(String where) {
		Session session = sessionFactory.openSession();
	
		return 	session.createQuery(where).list();
	}

	public List find(String where, int size) {
		Session session = this.openSession();
		Query query = session.createQuery(where);
		query.setMaxResults(size);
		return query.list();
	}

	// 通过主键ID返回一个数据对象
	public Object findById(Class cla, Serializable id) {
		Session session = sessionFactory.openSession();
		Object o = session.byId(cla).getReference(id);
		return o;
	}

	// 根据给定的对象,保存或更新对象
	public void saveOrUpdate(Object object) {
		Session session = this.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(object);
			session.setFlushMode(FlushMode.AUTO);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 获得Hibernate中的一个session
	public Session openSession() {
		return 		sessionFactory.openSession();
	}

	// 获取分页对象
	public PageResult getPageResult(String where, String currentPage,
			String pagerMethod, int pageSize) {
		// 定义pager对象，用于传到页面
		int totalRows = 0;
		List resultList = null;
		PageBean pager = null;
		Session session = this.openSession();
		Query query = session.createQuery(where);
		totalRows = (query.list()).size(); // 取得总计录数

		pager = new PageBean(totalRows, pageSize);
		// 如果当前页号为空，表示为首次查询该页
		// 如果不为空，则刷新pager对象，输入当前页号等信息
		if (currentPage != null) {
			pager.refresh(Integer.parseInt(currentPage));
		} else {
			// pager.select();
		}
		// 获取当前执行的方法，首页，前一页，后一页，尾页。
		if (pagerMethod != null) {
			if (pagerMethod.equals("first")) {
				pager.first();
			} else if (pagerMethod.equals("previous")) {
				pager.previous();
			} else if (pagerMethod.equals("next")) {
				pager.next();
			} else if (pagerMethod.equals("last")) {
				pager.last();
			} else if (pagerMethod.equals("selectd")) {
				pager.selectd();
			}
		}
		pager.select();
		// 从当前页记录数开始
		query.setFirstResult(pager.getStartRow());
		// 取出pageSize个记录
		query.setMaxResults(pager.getPageSize());
		if (query.list().size() > 0) {
			resultList = query.list();
		}
		// 把分页查询的结果和对象放入PagerResult中
		PageResult pagerResult = new PageResult();
		pagerResult.setPageBean(pager);
		pagerResult.setResultList(resultList);
		return pagerResult;
	}

	// 获取分页对象
	public PageResult getPageResult(String where, String currentPage,
			int pageSize) {
		// 定义pager对象，用于传到页面

		int totalRows = 0;
		List resultList = null;
		PageBean pager = null;
		Session session = this.openSession();
		Query query = session.createQuery(where);
		totalRows = (query.list()).size(); // 取得总计录数

		pager = new PageBean(totalRows, pageSize);

		if (Integer.parseInt(currentPage) <= pager.getTotalPages()) {

			// 从当前页记录数开始
			query.setFirstResult((Integer.parseInt(currentPage) - 1) * pageSize);
			// 取出pageSize个记录
			query.setMaxResults(pager.getPageSize());
			if (query.list().size() > 0) {
				resultList = query.list();
			}
		}

		// 把分页查询的结果和对象放入PagerResult中
		PageResult pagerResult = new PageResult();
		pagerResult.setPageBean(pager);
		pagerResult.setResultList(resultList);
		return pagerResult;
	}

	// 获取分页对象
	public PageResult getPageResult(String hsql, int pageSize) {
		// 定义pager对象，用于传到页面

		int totalRows = 0;
		List resultList = null;
		PageBean pager = null;
		Session session = this.openSession();
		Query query = session.createQuery(hsql);
		totalRows = (query.list()).size(); // 取得总计录数

		pager = new PageBean(totalRows, pageSize);
		resultList = query.list();

		// 把分页查询的结果和对象放入PagerResult中
		PageResult pagerResult = new PageResult();
		pagerResult.setPageBean(pager);
		pagerResult.setResultList(resultList);
		return pagerResult;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public double getCount(String hql) {
		Session session = sessionFactory.openSession();
			return 0.0f;
	}

	public Object getOneObject(String hql) {
			return null;
	}

}
