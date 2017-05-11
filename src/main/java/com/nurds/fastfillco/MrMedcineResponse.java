package com.nurds.fastfillco;

import java.util.List;

import com.nurds.fastfillco.model.MrMedicine;

public class MrMedcineResponse extends ResponseObject{

	private List<MrMedicine> medicines;

	public List<MrMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MrMedicine> medicines) {
		this.medicines = medicines;
	} 
	
	
}
