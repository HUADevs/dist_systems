package com.huaDevelopers.data.Entities;

import java.io.Serializable;

public class History implements Serializable{

	private String PersonalId;
	private String incident;
	
	public History() {
		// TODO Auto-generated constructor stub
	}

	public String getPersonalId() {
		return PersonalId;
	}

	public void setPersonalId(String personalId) {
		PersonalId = personalId;
	}

	public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}

	
}
