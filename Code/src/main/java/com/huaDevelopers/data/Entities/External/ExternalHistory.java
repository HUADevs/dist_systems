package com.huaDevelopers.data.Entities.External;

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
@Table(name = "HistoryInc")
public class ExternalHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510918284566998522L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incId;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private ExternalCitizen personalId;

	@Column(name = "inc_description", nullable = true)
	private String incident;

	public ExternalHistory() {
		// TODO Auto-generated constructor stub
	}

	public int getIncId() {
		return incId;
	}

	public ExternalCitizen getPersonalId() {
		return personalId;
	}

	public String getIncident() {
		return incident;
	}

}
