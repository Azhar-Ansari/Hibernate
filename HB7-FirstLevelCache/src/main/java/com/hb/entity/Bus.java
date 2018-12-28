package com.hb.entity;

import java.io.Serializable;

public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	private int busNo;
	private String serviceNo;
	private int seatingCapacity;
	private String fuelType;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", serviceNo=" + serviceNo + ", seatingCapacity=" + seatingCapacity
				+ ", fuelType=" + fuelType + "]";
	}
}
