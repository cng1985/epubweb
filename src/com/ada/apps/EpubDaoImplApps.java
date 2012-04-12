package com.ada.apps;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baoyi.dao.EpubDaoImpl;
import com.epublib.domain.Epub;

public class EpubDaoImplApps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//add();
//		List<Epub> es=		dao.findAll();
//		System.out.println(es);
//		EntityManager em =EntityManagerHelper.getEntityManager();
//		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
//		try {
//			fullTextEntityManager.createIndexer().startAndWait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	private static void delete() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		long time = System.currentTimeMillis();
		int size = 1;
		EpubDaoImpl dao = context.getBean(EpubDaoImpl.class);
		Epub epub = new Epub();
		epub.setId(5169);
		epub.setDescription(UUID.randomUUID().toString());
		dao.delete(epub);
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		System.out.println(size / time);
	}
	private static void update() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		long time = System.currentTimeMillis();
		int size = 1;
		EpubDaoImpl dao = context.getBean(EpubDaoImpl.class);
		Epub epub = new Epub();
		epub.setId(5169);
		epub.setDescription(UUID.randomUUID().toString());
		dao.update(epub);

		time = System.currentTimeMillis() - time;
		System.out.println(time);
		System.out.println(size / time);
	}

	private static void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		long time = System.currentTimeMillis();
		int size = 10;
		for (int i = 0; i < size; i++) {
			EpubDaoImpl dao = context.getBean(EpubDaoImpl.class);
			Epub epub = new Epub();
			epub.setDescription(UUID.randomUUID().toString());
			epub.setName(UUID.randomUUID().toString());
			epub.setSourtnum(i);
			dao.add(epub);

		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		System.out.println(size / time);
	}

}
