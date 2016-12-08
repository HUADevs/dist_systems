package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.HashMap;

public class Services implements Serializable{

	private String ServiceName;
	private HashMap<String, Boolean> Rights;

	public String getServiceName() {
		return this.ServiceName;
	}

	
	public void setServiceName(String ServiceName) {
		this.ServiceName = ServiceName;
	}

	public HashMap<String,Boolean> getRights() {
		return this.Rights;
	}

	
	public void setRights(HashMap<String, Boolean> Rights) {
		this.Rights = Rights;
	}

}
