package com.unmsm.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.laboratory.FieldName;
import com.unmsm.laboratory.FieldValue;
import com.unmsm.laboratory.LaboratoryTest;
import com.unmsm.laboratory.LaboratoryTestRepository;

@Service
public class LaboratoryTestService {

	LaboratoryTestRepository laboratoryTestRepository;
	
	@Autowired
	public LaboratoryTestService(LaboratoryTestRepository laboratoryTestRepository){
		this.laboratoryTestRepository = laboratoryTestRepository;
	}
	
	public LaboratoryTest registerLaboratoryTest(LaboratoryTest laboratoryTest){
		return laboratoryTestRepository.save(laboratoryTest);
	}
	
	public LaboratoryTest findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId, Integer emrPatientCode){
		return laboratoryTestRepository.findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode);
	}
	
	public Map<String, Object> getTestStateByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode){
		Map<String, Object> medicalTestItem = null;
		if(laboratoryTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode)){
			medicalTestItem = new HashMap<>();
			boolean isFinished = laboratoryTestRepository.validateTestFinished(emrHealthPlanId,
					emrPatientCode, FieldValue.FINISHED.getValue());
			medicalTestItem.put(FieldName.IS_FINISHED.getValue(), isFinished);
		}
		return medicalTestItem;
	}
}
