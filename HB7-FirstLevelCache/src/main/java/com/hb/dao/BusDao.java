package com.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.Bus;
import com.hb.util.DevSessionFactory;

public class BusDao {

	public void addBus(Bus bus) {
		Session session = getSession();
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

	public Bus getBus(Session session, int busNo) {
		return (Bus) session.get(Bus.class, busNo);
	}

	public void getBusTwice(int busNo) {
		Session session = getSession();

		Bus bus1 = (Bus) session.get(Bus.class, busNo);
		Bus bus2 = (Bus) session.get(Bus.class, busNo);
		System.out.println(bus1 == bus2);
	}

	public Session getSession() {
		SessionFactory sessionFactory = DevSessionFactory.getSessionFactory();
		return sessionFactory.openSession();
	}
}
