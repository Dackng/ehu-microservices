package com.unmsm.laboratory;

import org.springframework.data.repository.CrudRepository;

public interface LaboratoryTestRepository extends CrudRepository<LaboratoryTest, Integer>{
	
	LaboratoryTest findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode(Integer emrHealthPlanId, Integer emrPatientCode);
}
