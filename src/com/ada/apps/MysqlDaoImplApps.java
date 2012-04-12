package com.ada.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baoyi.dao.EpubDaoImpl;
import com.baoyi.dao.MysqlDaoImpl;

public class MysqlDaoImplApps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		long time = System.currentTimeMillis();
		int size = 1;
		MysqlDaoImpl dao = context.getBean(MysqlDaoImpl.class);
		System.out.println(dao.mysqlsize());
	}

}
