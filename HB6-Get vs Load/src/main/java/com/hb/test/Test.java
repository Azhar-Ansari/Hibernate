package com.hb.test;

import com.hb.dao.BusDao;
import com.hb.entity.Bus;
import com.hb.util.DevSessionFactory;

public class Test {

	public static void main(String[] args) {
		BusDao busDao = new BusDao();

		Bus bus = new Bus();

		bus = busDao.getBus(3);
		bus = busDao.loadBus(3);
		
		DevSessionFactory.close();
	}
}
