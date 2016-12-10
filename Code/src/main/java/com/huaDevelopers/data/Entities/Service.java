package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Service")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8177252569658564507L;

	@Column (name="name")
	private String ServiceName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
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
