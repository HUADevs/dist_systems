package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.HashMap;

public class Service implements Serializable {

	private String ServiceName;
	private int ServiceId;

	public String getServiceName() {
		return this.ServiceName;
	}

	public void setServiceName(String ServiceName) {
		this.ServiceName = ServiceName;
	}

	public int getServiceId() {
		return ServiceId;
	}

	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}

}
