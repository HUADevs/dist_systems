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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "History")
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510918284566998522L;

	@Id
	@Column(name = "incedent_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incId;

	@NotEmpty
	@Column(name = "personal_id", length = 8, nullable = false)
	private Customer PersonalId;

	@Column(name = "incedent", nullable = true)
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

	@ManyToOne
	@JoinColumn(name="personal_id", nullable=false)
	public Customer getPersonalId() {
		return PersonalId;
	}

	public void setPersonalId(Customer personalId) {
		PersonalId = personalId;
	}

	public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}

}
