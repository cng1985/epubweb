package com.ada.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		long time=System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			try {
				Connection con=		od.getConnection();
				String sql="SELECT `name`, `id`, `key`, LEFT(`contents`, 256) FROM `epubweb`.`app` LIMIT 0, 1000;";
				PreparedStatement s=		con.prepareStatement(sql);
				ResultSet set=	s.executeQuery();
				while (set.next()) {
					
				}
				set.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  time=System.currentTimeMillis()-time;
	  System.out.println(time);
		System.out.println(od.getClass());
		
		
	}

}
