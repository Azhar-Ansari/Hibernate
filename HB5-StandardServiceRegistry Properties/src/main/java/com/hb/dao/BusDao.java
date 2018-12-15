package com.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.Bus;
import com.hb.util.DevSessionFactory;

public class BusDao {

	public void addBus(Bus bus) {
		SessionFactory sessionFactory = DevSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int busNo = 0;
		boolean success = false;
		try {
			busNo = (int) session.save(bus);
			success = true;
		} finally {
			if (transaction != null) {
				if (success) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			session.close();
		}
		System.out.println("Added bus with no: " + busNo);
	}

	public Bus getBus(int busNo) {
		SessionFactory sessionFactory = DevSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Bus bus = (Bus) session.get(Bus.class, busNo);
		System.out.println("Retrieved: " + bus);
		return bus;
	}
}
