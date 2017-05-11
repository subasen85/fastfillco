package com.nurds.fastfillco;

import java.util.List;

import com.nurds.fastfillco.model.Doctor;

public class DoctorListResponse extends ResponseObject {
	
	private List<Doctor> doctors;

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	

}
