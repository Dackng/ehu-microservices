package com.unmsm.psychological;

import org.springframework.data.repository.CrudRepository;

public interface PsychologicalTestRepository extends CrudRepository<PsychologicalTest, Integer> {

	PsychologicalTest findPsychologicalTestByEmrHealthPlanIdAndEmrPacientCode(Integer emrHealthPlanId, Integer emrPacientCode);
}
