package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{

	private String RoleName;
	private List<Services> Competences;

	public String getRoleName() {
		return this.RoleName;
	}

	
	public void setRoleName(String RoleName) {
		this.RoleName = RoleName;
	}

	public List<Services> getCompetences() {
		return this.Competences;
	}

	
	public void setCompetences(List<Services> Competences) {
		this.Competences = Competences;
	}
}
