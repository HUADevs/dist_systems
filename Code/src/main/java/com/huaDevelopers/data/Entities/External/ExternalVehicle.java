package com.huaDevelopers.data.Entities.External;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicles")
public class ExternalVehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1797310249072710177L;

	@Id
	@Column(name = "license_plate", length = 7)
	private String licensePlate;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private ExternalCitizen citizenPersonID;

	@Column(name = "release_date", nullable = false)
	private LocalDate releaseDate;

	@Column(name = "cubic", nullable = false)
	private int cubic;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "color", nullable = false)
	private String color;

	public ExternalVehicle() {
		// TODO Auto-generated constructor stub
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public ExternalCitizen getCitizenPersonID() {
		return citizenPersonID;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public int getCubic() {
		return cubic;
	}

	public String getType() {
		return type;
	}

	public String getColor() {
		return color;
	}

}
