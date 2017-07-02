package com.unmsm.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.generalmedicine.FieldName;
import com.unmsm.generalmedicine.FieldValue;
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
		return (GeneralMedicineTest) generalMedicineTestRepository.save(new HashSet<GeneralMedicineTest>(){
			private static final long serialVersionUID = 1L;
		{
			add(generalMedicineTest);
		}});
	}

	public GeneralMedicineTest findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode) {
		return generalMedicineTestRepository.findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId,
				emrPatientCode);
	}
	
	public Map<String, Object> getTestStateByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode){
		Map<String, Object> medicalTestItem = null;
		if(generalMedicineTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode)){
			medicalTestItem = new HashMap<>();
			boolean isFinished = generalMedicineTestRepository.validateTestFinished(emrHealthPlanId,
					emrPatientCode, FieldValue.FINISHED.getValue());
			medicalTestItem.put(FieldName.IS_FINISHED.getValue(), isFinished);
		}
		return medicalTestItem;
	}
}
