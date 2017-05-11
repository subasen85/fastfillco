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
@Table(name = "mastermedication")
public class MasterMedication extends ResponseObject implements Serializable {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 
  @Id
  @NotNull
  private String name;
  
  @NotNull
  private String category;
  
  private String subCategory;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getSubCategory() {
	return subCategory;
}

public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}
  
  
  


  
} // class User
