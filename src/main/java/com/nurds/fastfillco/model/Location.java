package com.nurds.fastfillco.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nurds.fastfillco.ResponseObject;

@Entity
@Table(name = "location")
public class Location extends ResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String label;
	
	private String city;
	
	private String state;
	
	private String pinCode;
	
	private String addressline1;
	
	private String addressline2;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Doctor doctor;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	private List<DoctorMedicine> medicine;
	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<DoctorMedicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<DoctorMedicine> medicine) {
		this.medicine = medicine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", label=" + label + ", city=" + city
				+ ", state=" + state + ", pinCode=" + pinCode
				+ ", addressline1=" + addressline1 + ", addressline2="
				+ addressline2 + ", doctor=" + doctor + ", medicine="
				+ medicine + "]";
	}

	
	

}
