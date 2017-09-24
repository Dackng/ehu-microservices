package com.unmsm.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.generalmedicine.GeneralMedicineTest;
import com.unmsm.generalmedicine.GeneralMedicineTestRepository;
import com.unmsm.symptom.Symptom;

@Service
public class GeneralMedicineTestService {

	GeneralMedicineTestRepository generalMedicineTestRepository;

	@Autowired
	public GeneralMedicineTestService(GeneralMedicineTestRepository generalMedicineTestRepository) {
		this.generalMedicineTestRepository = generalMedicineTestRepository;
	}

	public GeneralMedicineTest registerGeneralMedicineTest(GeneralMedicineTest generalMedicineTest) {
		Set<Symptom> symptoms = new HashSet<Symptom>(){
			private static final long serialVersionUID = 1L;
		{
			for(Symptom tmp : generalMedicineTest.getSymptoms()){
				Symptom symptom = new Symptom(tmp.getTypeId(), tmp.getCieId(), 
						tmp.getAppointment(), tmp.getObservation(), generalMedicineTest);
				add(symptom);
			}
		}};
		generalMedicineTest.setSymptoms(symptoms);
		generalMedicineTestRepository.save(new HashSet<GeneralMedicineTest>(){
			private static final long serialVersionUID = 1L;
		{
			add(generalMedicineTest);
		}});
		return generalMedicineTestRepository.
				findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode
				(generalMedicineTest.getEmrHealthPlanId(), generalMedicineTest.getEmrPatientCode());
	}

	public GeneralMedicineTest findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode) {
		return generalMedicineTestRepository.findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId,
				emrPatientCode);
	}
}
