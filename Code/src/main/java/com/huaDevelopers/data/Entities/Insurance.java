package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "Insurance")
public class Insurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1118564151849532911L;

	@Id
    @Column(name="vehicle_id")
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="licensePlate"))
    private Long id;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Vehicle licensePlate;

	@Column(name = "date_start", nullable = false)
	private LocalDate insuranceDate;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "discount", nullable = true)
	private double discount;

	@NotEmpty(message = "***You must choose a type***")
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull @NumberFormat(style = Style.NUMBER) @Min(1) @Max(2)
	@Column(name = "duration", nullable = false)
	private int duration;

	@Column(name = "new_driver", nullable = true)
	private Boolean newDriver;

	public Insurance() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(Vehicle licensePlate) {
		this.licensePlate = licensePlate;
	}

	public LocalDate getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(LocalDate insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Boolean getNewDriver() {
		return newDriver;
	}

	public void setNewDriver(Boolean newDriver) {
		this.newDriver = newDriver;
	}

}
