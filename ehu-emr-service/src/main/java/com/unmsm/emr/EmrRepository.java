package com.unmsm.emr;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmrRepository extends CrudRepository<Emr, Integer>{
	
	Emr findEmrByHealthPlanIdAndPatientCode(Integer healthPlanId, Integer patientCode);
	
	List<Emr> findEmrByPatientCode(Integer patientCode);
}
