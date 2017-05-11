package com.nurds.fastfillco.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nurds.fastfillco.ResponseObject;


/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "medicalRep")
public class MedicalRep extends ResponseObject implements Serializable{

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String username;
  
  @NotNull
  private String firstName;
  
  private String lastName;
  
  @NotNull
  private String password;
  
  private String mobileNumber;
  
  private String companyName;
  
  @OneToMany
  private List<DoctorMedicine> docMedicine;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Doctor> doctors;
  
  
  
  public List<DoctorMedicine> getDocMedicine() {
	return docMedicine;
}



public void setDocMedicine(List<DoctorMedicine> docMedicine) {
	this.docMedicine = docMedicine;
}



public List<Doctor> getDoctors() {
	return doctors;
}



public void setDoctors(List<Doctor> doctors) {
	this.doctors = doctors;
}



public MedicalRep() { }

 

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}



public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public MedicalRep(long id) { 
    this.id = id;
  }
  
  

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  
} // class User
