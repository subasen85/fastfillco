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

@Entity
@Table(name = "mrmedicine")
public class MrMedicine extends ResponseObject implements Serializable {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

private String medicineName;

 
private String expiryDate;

private String mClass;

private String subClass;

private String dosage;

private String numPillPerBox;





private String voucherInsurance;

private String voucherExpiryDate;

private String medicineLength;

private String medicinePrice;

private int voucherPrice;

private int couponPrice;



public int getCouponPrice() {
	return couponPrice;
}

public void setCouponPrice(int couponPrice) {
	this.couponPrice = couponPrice;
}

public void setVoucherPrice(int voucherPrice) {
	this.voucherPrice = voucherPrice;
}

@JsonIgnore
@ManyToOne (fetch = FetchType.LAZY)
private MedicalRep mr;

private String couponsExpiryDate;




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

public String getMedicineName() {
	return medicineName;
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


public String getStrengthDoses() {
	return dosage;
}

public void setStrengthDoses(String strengthDoses) {
	this.dosage = strengthDoses;
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
			+ ", numOfBoxes=" + "" + ", lotNumber=" + ""
			+ ", voucherExpiryDate=" + voucherExpiryDate
			+ ", couponsExpiryDate=" + couponsExpiryDate + ", doctor=" + doctor
			+ "]";
}



// ------------------------
// PUBLIC METHODS
// ------------------------


}
