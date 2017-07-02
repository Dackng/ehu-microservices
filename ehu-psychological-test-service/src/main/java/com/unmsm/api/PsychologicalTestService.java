package com.unmsm.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.psychological.FieldName;
import com.unmsm.psychological.FieldValue;
import com.unmsm.psychological.PsychologicalTest;
import com.unmsm.psychological.PsychologicalTestRepository;

@Service
public class PsychologicalTestService {

	PsychologicalTestRepository psychologicalTestRepository;
	
	@Autowired
	public PsychologicalTestService(PsychologicalTestRepository psychologicalTestRepository){
		this.psychologicalTestRepository = psychologicalTestRepository;
	}
	
	public PsychologicalTest registerPsychologicalTest(PsychologicalTest psychologicalTest){
		return psychologicalTestRepository.save(psychologicalTest);
	}
	
	public PsychologicalTest findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId, Integer emrPatientCode){
		return psychologicalTestRepository.findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode);
	}
	
	public Boolean validateTestExistenceByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode) {
		return psychologicalTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId,
				emrPatientCode);
	}
	
	public Map<String, Object> getTestStateByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode){
		Map<String, Object> medicalTestItem = null;
		if(psychologicalTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode)){
			medicalTestItem = new HashMap<>();
			boolean isFinished = psychologicalTestRepository.validateTestFinished(emrHealthPlanId,
					emrPatientCode, FieldValue.FINISHED.getValue());
			medicalTestItem.put(FieldName.IS_FINISHED.getValue(), isFinished);
		}
		return medicalTestItem;
	}
}
