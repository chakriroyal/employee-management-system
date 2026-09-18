package com.qsp.employee_management_system.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private HibernateUtil() {
		
	}

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() { 
		
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		else {
			return sessionFactory;
		}
	}
}
