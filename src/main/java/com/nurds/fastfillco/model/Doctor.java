package com.nurds.fastfillco.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nurds.fastfillco.ResponseObject;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "doctor")
public class Doctor extends ResponseObject implements Serializable {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
  @Id
  @NotNull
  private String username;
  
  @NotNull
  private String firstName;
  
  private String lastName;
  
  @NotNull
  private String password;
  
  private String mobileNumber;
  
  private String speciality;
  
  private String clinicName;
  
  @OneToMany
  private List<DoctorMedicine> medicines;
  
  @OneToMany
  private List<Location> locations;
  
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doctors")
  private List<MedicalRep> medicalReps;
  
  
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  	
  
  
  public List<Location> getLocations() {
	return locations;
}

public void setLocations(List<Location> locations) {
	this.locations = locations;
}

public List<DoctorMedicine> getMedicines() {
	return medicines;
}

public List<MedicalRep> getMedicalReps() {
	return medicalReps;
}

public void setMedicalReps(List<MedicalRep> medicalReps) {
	this.medicalReps = medicalReps;
}

public void setMedicines(List<DoctorMedicine> medicines) {
	this.medicines = medicines;
}

public Doctor() { }

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

public String getSpeciality() {
	return speciality;
}

public void setSpeciality(String speciality) {
	this.speciality = speciality;
}

public String getClinicName() {
	return clinicName;
}

public void setClinicName(String clinicName) {
	this.clinicName = clinicName;
}

@Override
public String toString() {
	return "Doctor [username=" + username + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", password=" + password
			+ ", mobileNumber=" + mobileNumber + ", speciality=" + speciality
			+ ", clinicName=" + clinicName + ", medicines=" + medicines + "]";
}

   




  
} // class User
