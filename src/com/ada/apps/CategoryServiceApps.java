package com.ada.apps;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epublib.category.service.CategoryService;
import com.epublib.domain.Epub;

public class CategoryServiceApps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		CategoryService service = context.getBean("categoryService",
				CategoryService.class);
		List list = service.find("from Epub");
		Epub epub=new Epub();
		service.add(epub);
		System.out.println(list);
		//setHibernateProperties(Properties)
		//   hibernateProperties
	}

}
