package com.hb.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Bus;

public class DevSessionFactory {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		Properties configProperties = new Properties();
		configProperties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/dev");
		configProperties.put("hibernate.connection.username", "root");
		configProperties.put("hibernate.connection.password", "password");
		configProperties.put("hibernate.show_sql", "true");
		configProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		configuration.addProperties(configProperties);
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
