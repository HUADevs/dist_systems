package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String FirstName;
	private String LastName;
	private String PersonalId;
	private int TRN; // TAX REGISTRATION NUMBER
	private Date LicenseAqquired;
	private ArrayList<String> HistoryInc;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPersonalId() {
		return PersonalId;
	}

	public void setPersonalId(String personalId) {
		PersonalId = personalId;
	}

	public int getTRN() {
		return TRN;
	}

	public void setTRN(int tRN) {
		TRN = tRN;
	}

	public Date getLicenseAqquired() {
		return LicenseAqquired;
	}

	public void setLicenseAqquired(Date licenseAqquired) {
		LicenseAqquired = licenseAqquired;
	}

	public ArrayList<String> getHistoryInc() {
		return HistoryInc;
	}

	public void setHistoryInc(ArrayList<String> historyInc) {
		HistoryInc = historyInc;
	}

}
