package com.hb.test;

import org.hibernate.Session;

import com.hb.dao.BusDao;
import com.hb.entity.Bus;
import com.hb.util.DevSessionFactory;

public class Test {

	public static void main(String[] args) {
		BusDao busDao = new BusDao();
	    busDao.getBusTwice(1); //first call to get hit db, next call fetch from cache
		
		Session session = busDao.getSession();
		session.beginTransaction();
		Bus bus = busDao.getBus(session, 1);
		bus.setFuelType("Diesel");
		session.update(bus);
		bus.setSeatingCapacity(40);
		session.update(bus);
		session.flush();
		session.evict(bus);
		session.getTransaction().commit();
		
		DevSessionFactory.close();
	}
}