package com.unmsm.medicaltest;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MedicalTestRepository extends CrudRepository<MedicalTest, Integer>{
	
	@Query("select e.medicalTests from Emr e where e.healthPlanId = ?1 and e.patientCode = ?2")
	List<MedicalTest> findAllByHealthPlanIdAndPatientCode(Integer healthPlanId, Integer patientCode);
	
	@Modifying
	@Transactional
	@Query("update MedicalTest m set m.isFinished = true where m.emr.id = ?1 and m.typeId = ?2")
	int updateMedicalTestByEmrIdAndTestTypeId(Integer emrId, Integer testTypeId);
	
	@Query("select case when ( count(m) - ?2 = 0)  then true else false end from MedicalTest m "
			+ " where m.emr.id = ?1 and m.isFinished = true ")
	boolean validateMedicalTestsCompleted(Integer emrId, Long totalMedicalTest);
	
	@Query("select count(m) from MedicalTest m where m.emr.id=?1")
	Long countMedicalTestByEmrId(Integer emrId);
}
