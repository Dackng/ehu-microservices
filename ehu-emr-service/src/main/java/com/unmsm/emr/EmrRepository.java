package com.unmsm.emr;

import org.springframework.data.repository.CrudRepository;

public interface EmrRepository extends CrudRepository<Emr, Integer>{
	
	Emr findEmrByPacientCodeAndHealthPlanId(Integer pacientCode, Integer healthPlanId);
}
