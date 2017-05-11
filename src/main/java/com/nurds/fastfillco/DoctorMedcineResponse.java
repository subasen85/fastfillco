package com.nurds.fastfillco;

import java.util.List;

import com.nurds.fastfillco.model.DoctorMedicine;

public class DoctorMedcineResponse extends ResponseObject{

	private List<DoctorMedicine> medicines;

	public List<DoctorMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<DoctorMedicine> medicines) {
		this.medicines = medicines;
	} 
	
	
}
