package com.baoyi.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectFactory {
	private static BeanFactory factory;
	public static BeanFactory getInstance() {
		if (factory == null) {
			factory = new ClassPathXmlApplicationContext("spring.xml");
		}
		return factory;
	}
}
