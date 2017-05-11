package com.nurds.fastfillco;

public class LocationRequest {
	
private String label;
	
	private String city;
	
	private String state;
	
	private String pinCode;
	
	private String addressline1;
	
	private String addressline2;
	
	private String userName;
	
	

	@Override
	public String toString() {
		return "LocationRequest [label=" + label + ", city=" + city
				+ ", state=" + state + ", pinCode=" + pinCode
				+ ", addressline1=" + addressline1 + ", addressline2="
				+ addressline2 + ", userName=" + userName + "]";
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
