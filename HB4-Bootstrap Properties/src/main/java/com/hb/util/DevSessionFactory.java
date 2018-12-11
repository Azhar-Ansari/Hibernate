package com.hb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Bus;

public class DevSessionFactory {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addClass(Bus.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
