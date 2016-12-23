package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "History")
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510918284566998522L;

	@Id
	@Column(name = "incident_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incId;

	
	@ManyToOne
	@JoinColumn(name = "personal_id", nullable = false, referencedColumnName = "personal_id")
	private Customer personalId;

	@Column(name = "incident", nullable = true)
	private String incident;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public int getIncId() {
		return incId;
	}

	public void setIncId(int incId) {
		this.incId = incId;
	}

	public Customer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Customer personalId) {
		this.personalId = personalId;
	}

	public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}

}
