package com.unmsm.emr;

import org.springframework.data.repository.CrudRepository;

public interface EmrRepository extends CrudRepository<Emr, Integer>{
	
	Emr findEmrByHealthPlanIdAndPacientCode(Integer healthPlanId, Integer pacientCode);
}
