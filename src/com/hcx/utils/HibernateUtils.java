package com.hcx.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class HibernateUtils {
	
	private static SessionFactory sf;
	
	static{
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("虚拟机关闭，资源释放");
				sf.close();
			}
		}));
	}
	
	public static org.hibernate.Session openSession(){
		Session session = sf.openSession();
		return session;
	}
	
	public static org.hibernate.Session getCurrentSession(){
		Session session = sf.getCurrentSession();
		return session;
	}  

	public static void main(String[] args) {
		System.out.println(openSession());
	}
}
