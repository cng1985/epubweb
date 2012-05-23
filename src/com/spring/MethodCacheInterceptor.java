package com.spring;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class MethodCacheInterceptor implements MethodInterceptor,
		InitializingBean {
	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	/*
	 * (non-Javadoc) 检测cache对象是否为空
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "cache is null,please set a new cache");
	}
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		String cacheKey = getCacheKey(targetName, methodName, arguments);
		Element element = cache.get(cacheKey);
		if (element == null) {
			result = invocation.proceed();
			element = new Element(cacheKey, (Serializable) result);
			cache.put(element);
		}
		return element.getValue();
	}

	/**
	 * 获得 cache key 的方法，cache key 是 Cache 中一个 Element 的唯一标识 cache key
	 * 包括　包名+类名+方法名，如 com.co.cache.service.UserServiceImpl.getAllUser
	 * 
	 * @param targetName
	 * @param methodName
	 * @param arguments
	 * @return
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer key = new StringBuffer();
		key.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				key.append(".").append(arguments[i]);
			}
		}
		return key.toString();
	}
}
