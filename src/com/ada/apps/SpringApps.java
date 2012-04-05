package com.ada.apps;

import java.sql.SQLException;

import net.sf.ehcache.Cache;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		Cache o = context.getBean("methodCache",Cache.class);
		System.out.println(o.getClass());
		BasicDataSource od = context.getBean("dataSource",BasicDataSource.class);
		for (int i = 0; i < 18000; i++) {
			try {
				od.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(od.getClass());
	}

}
