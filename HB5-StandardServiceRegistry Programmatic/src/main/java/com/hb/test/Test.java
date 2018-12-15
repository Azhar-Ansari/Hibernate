package com.hb.test;

import com.hb.dao.BusDao;
import com.hb.entity.Bus;
import com.hb.util.DevSessionFactory;

public class Test {

	public static void main(String[] args) {
		BusDao busDao = new BusDao();

		Bus bus = new Bus();
		bus.setBusNo(5);
		bus.setServiceNo("24");
		bus.setSeatingCapacity(20);
		bus.setFuelType("Petrol");
		busDao.addBus(bus);

		busDao.getBus(5);
		DevSessionFactory.close();
	}
}
