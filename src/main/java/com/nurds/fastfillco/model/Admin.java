package com.nurds.fastfillco.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nurds.fastfillco.ResponseObject;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "admin")
public class Admin extends ResponseObject implements Serializable {

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
  private String firstName;
  
  private String lastName;
  
  private String mobileNumber;
  
  @NotNull
  private String username;
  
  @NotNull
  private String password;
  
  private String city;
  
  private boolean superadmin;
  
  private boolean status;
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(boolean superadmin) {
		this.superadmin = superadmin;
	}
	

public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

@Override
public String toString() {
	return "Admin [username=" + username + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", password=" + password
			+ ", mobileNumber=" + mobileNumber + ", city=" + city + ", superadmin=" + superadmin + "]";
	}
  
} // class User
