package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Boolean getTestStateByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode) {
		if(laboratoryTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode)){
			return laboratoryTestRepository.validateTestFinished(emrHealthPlanId,
					emrPatientCode, FieldValue.FINISHED.getValue());
		}
		return null;
	}
}
