package com.unmsm.generalmedicine;

import org.springframework.data.repository.CrudRepository;

public interface GeneralMedicineTestRepository extends CrudRepository<GeneralMedicineTest, Integer>{
	
	GeneralMedicineTest findGeneralMedicineTestByEmrHealthPlanIdAndEmrPacientCode
		(Integer emrHealthPlanId, Integer emrPacientCode);
}
