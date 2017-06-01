package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.generalmedicine.GeneralMedicineTest;
import com.unmsm.generalmedicine.GeneralMedicineTestRepository;

@Service
public class GeneralMedicineTestService {

	GeneralMedicineTestRepository generalMedicineTestRepository;

	@Autowired
	public GeneralMedicineTestService(GeneralMedicineTestRepository generalMedicineTestRepository) {
		this.generalMedicineTestRepository = generalMedicineTestRepository;
	}

	public GeneralMedicineTest registerGeneralMedicineTest(GeneralMedicineTest generalMedicineTest) {
		return generalMedicineTestRepository.save(generalMedicineTest);
	}

	public GeneralMedicineTest findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode) {
		return generalMedicineTestRepository.findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId,
				emrPatientCode);
	}
}
