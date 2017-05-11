package com.nurds.fastfillco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nurds.fastfillco.ResponseObject;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "medicine")
public class DoctorMedicine extends ResponseObject implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

  private String medicineName;
  
   
  private String expiryDate;
  
  private String mClass;
  
  private String subClass;
  
  private String medicineInsurance;
  
  private String dosage;
  
  private String numPillPerBox;
  
  private String numOfBoxes;
  
  private String lotNumber;
  
  private String locationSample;
  
  private String numVoucher;
  
  private String voucherInsurance;
  
  private String voucherExpiryDate;
  
  private String medicineLength;
  
  private String medicinePrice;
  
  @JsonIgnore
  @ManyToOne (fetch = FetchType.LAZY)
  private MedicalRep mr;
  
  private String couponsExpiryDate;
  
  private String numCoupons;
  
  private String couponLength;
  
  private String couponPrice;
  
  private String couponInsurance;
  
  
  
  public String getCouponInsurance() {
	return couponInsurance;
}

public void setCouponInsurance(String couponInsurance) {
	this.couponInsurance = couponInsurance;
}

@JsonIgnore
  @ManyToOne(fetch=FetchType.LAZY)
  private Doctor doctor;

@JsonIgnore
@ManyToOne(fetch=FetchType.LAZY)
private Location location;



  public String getMedicineLength() {
	return medicineLength;
}

public void setMedicineLength(String medicineLength) {
	this.medicineLength = medicineLength;
}

public String getMedicinePrice() {
	return medicinePrice;
}

public void setMedicinePrice(String medicinePrice) {
	this.medicinePrice = medicinePrice;
}

public Location getLocation() {
	return location;
}

public void setLocation(Location location) {
	this.location = location;
}

public String getMedicineName() {
	return medicineName;
  }

public String getMedicineInsurance() {
	return medicineInsurance;
}





public String getDosage() {
	return dosage;
}

public void setDosage(String dosage) {
	this.dosage = dosage;
}

public String getVoucherLength() {
	return medicineLength;
}

public void setVoucherLength(String voucherLength) {
	this.medicineLength = voucherLength;
}

public String getVoucherPrice() {
	return medicinePrice;
}

public void setVoucherPrice(String voucherPrice) {
	this.medicinePrice = voucherPrice;
}

public MedicalRep getMr() {
	return mr;
}

public void setMr(MedicalRep mr) {
	this.mr = mr;
}

public String getCouponLength() {
	return couponLength;
}

public void setCouponLength(String couponLength) {
	this.couponLength = couponLength;
}

public String getCouponPrice() {
	return couponPrice;
}

public void setCouponPrice(String couponPrice) {
	this.couponPrice = couponPrice;
}

public String getStrengthDoses() {
	return dosage;
}

public void setStrengthDoses(String strengthDoses) {
	this.dosage = strengthDoses;
}

public void setMedicineInsurance(String medicineInsurance) {
	this.medicineInsurance = medicineInsurance;
}

public String getNumCoupons() {
	return numCoupons;
}

public void setNumCoupons(String numCoupons) {
	this.numCoupons = numCoupons;
}

public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}

public String getExpiryDate() {
	return expiryDate;
}

public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}

public String getmClass() {
	return mClass;
}

public void setmClass(String mClass) {
	this.mClass = mClass;
}

public String getSubClass() {
	return subClass;
}

public void setSubClass(String subClass) {
	this.subClass = subClass;
}

public String getNumPillPerBox() {
	return numPillPerBox;
}

public void setNumPillPerBox(String numPillPerBox) {
	this.numPillPerBox = numPillPerBox;
}

public String getNumOfBoxes() {
	return numOfBoxes;
}

public void setNumOfBoxes(String numOfBoxes) {
	this.numOfBoxes = numOfBoxes;
}

public String getLotNumber() {
	return lotNumber;
}

public void setLotNumber(String lotNumber) {
	this.lotNumber = lotNumber;
}

public String getLocationSample() {
	return locationSample;
}

public void setLocationSample(String locationSample) {
	this.locationSample = locationSample;
}

public String getNumVoucher() {
	return numVoucher;
}

public void setNumVoucher(String numVoucher) {
	this.numVoucher = numVoucher;
}

public String getVoucherInsurance() {
	return voucherInsurance;
}

public void setVoucherInsurance(String voucherInsurance) {
	this.voucherInsurance = voucherInsurance;
}

public String getVoucherExpiryDate() {
	return voucherExpiryDate;
}

public void setVoucherExpiryDate(String voucherExpiryDate) {
	this.voucherExpiryDate = voucherExpiryDate;
}

public String getCouponsExpiryDate() {
	return couponsExpiryDate;
}

public void setCouponsExpiryDate(String couponsExpiryDate) {
	this.couponsExpiryDate = couponsExpiryDate;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Doctor getDoctor() {
	return doctor;
}

public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

@Override
public String toString() {
	return "DoctorMedicine [id=" + id + ", medicineName=" + medicineName
			+ ", expiryDate=" + expiryDate + ", mClass=" + mClass
			+ ", subClass=" + subClass + ", numPillPerBox=" + numPillPerBox
			+ ", numOfBoxes=" + numOfBoxes + ", lotNumber=" + lotNumber
			+ ", locationSample=" + locationSample + ", numVoucher="
			+ numVoucher + ", voucherInsurance=" + voucherInsurance
			+ ", voucherExpiryDate=" + voucherExpiryDate
			+ ", couponsExpiryDate=" + couponsExpiryDate + ", doctor=" + doctor
			+ "]";
}


  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  
  
} // class User
