package com.unmsm.radiology;

import org.springframework.data.repository.CrudRepository;

public interface RadiologyTestRepository extends CrudRepository<RadiologyTest, Integer>{
	
	RadiologyTest findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId, Integer emrPatientCode);
}
