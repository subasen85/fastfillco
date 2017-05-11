package com.nurds.fastfillco;


public class DoctorMedicineRequest {

	private long location;
	private String medicineName;
	  
	  private String expiryDate;
	  
	  private String mClass;
	  
	  private String subClass;
	  
	  private String numPillPerBox;
	  
	  private String numOfBoxes;
	  
	  private String lotNumber;
	  
	  private String locationSample;
	  
	  private String numVoucher;
	  
	  private String numCoupons;
	  
	  private String voucherInsurance;
	  
	  private String voucherExpiryDate;
	  
	  private String couponsExpiryDate;
	  
	  private String userName;
	  
	  private String locationName;
	  
	  private String couponInsurance;
	  
	  private String dosage;
	  
	  private String voucherPrice;
	  
	  private String medicinePrice;
	  
	  

	public String getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(String medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public String getCouponInsurance() {
		return couponInsurance;
	}

	public void setCouponInsurance(String couponInsurance) {
		this.couponInsurance = couponInsurance;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getVoucherPrice() {
		return voucherPrice;
	}

	public void setVoucherPrice(String voucherPrice) {
		this.voucherPrice = voucherPrice;
	}

	public String getMedicineName() {
		return medicineName;
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
	
	

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
	
	

	public String getNumCoupons() {
		return numCoupons;
	}

	public void setNumCoupons(String numCoupons) {
		this.numCoupons = numCoupons;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getLocationSample() {
		return locationSample;
	}

	public long getLocation() {
		return location;
	}

	public void setLocation(long location) {
		this.location = location;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "DoctorMedicineRequest [medicineName=" + medicineName
				+ ", expiryDate=" + expiryDate + ", mClass=" + mClass
				+ ", subClass=" + subClass + ", numPillPerBox=" + numPillPerBox
				+ ", numOfBoxes=" + numOfBoxes + ", lotNumber=" + lotNumber
				+ ", locationSample=" + locationSample + ", numVoucher="
				+ numVoucher + ", voucherInsurance=" + voucherInsurance
				+ ", voucherExpiryDate=" + voucherExpiryDate
				+ ", couponsExpiryDate=" + couponsExpiryDate + ", userName="
				+ userName + "]";
	}
	  
	  
	
}
