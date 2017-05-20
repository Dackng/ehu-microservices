package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public RadiologyTest findRadiologyTestByEmrHealthPlanIdAndEmrPacientCode(Integer emrHealthPlanId, Integer emrPacientCode){
		return radiologyTestRepository.findRadiologyTestByEmrHealthPlanIdAndEmrPacientCode(emrHealthPlanId, emrPacientCode);
	}
}
