package com.nurds.fastfillco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "doctorlocation")
public class DoctorLocation {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String location;
  
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  	
  
  public DoctorLocation() { }




public String getLocation() {
	return location;
}



public void setLocation(String location) {
	this.location = location;
}



public DoctorLocation(long id) { 
    this.id = id;
  }
  
  

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  
} // class User
