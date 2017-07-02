package com.unmsm.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.radiology.FieldName;
import com.unmsm.radiology.FieldValue;
import com.unmsm.radiology.RadiologyTest;
import com.unmsm.radiology.RadiologyTestRepository;

@Service
public class RadiologyTestService {

	RadiologyTestRepository radiologyTestRepository;
	
	@Autowired
	public RadiologyTestService(RadiologyTestRepository radiologyTestRepository){
		this.radiologyTestRepository = radiologyTestRepository;
	}
	
	public RadiologyTest registerRadiologyTest(RadiologyTest radiologyTest){
		return radiologyTestRepository.save(radiologyTest);
	}
	
	public RadiologyTest findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId, Integer emrPatientCode){
		return radiologyTestRepository.findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode);
	}
	
	public Map<String, Object> getTestStateByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId,
			Integer emrPatientCode){
		Map<String, Object> medicalTestItem = null;
		if(radiologyTestRepository.validateExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode)){
			medicalTestItem = new HashMap<>();
			boolean isFinished = radiologyTestRepository.validateTestFinished(emrHealthPlanId,
					emrPatientCode, FieldValue.FINISHED.getValue());
			medicalTestItem.put(FieldName.IS_FINISHED.getValue(), isFinished);
		}
		return medicalTestItem;
	}
}
