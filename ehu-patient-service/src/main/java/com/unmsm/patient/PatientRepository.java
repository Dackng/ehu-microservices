package com.unmsm.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	Patient findPatientByCode(Integer code);
	
	@Query("select new Patient(p.code, p.names, p.paternalSurname, p.maternalSurname "
			+ ", p.birthDate, p.gender) from Patient p where p.code = ?1")
	Patient findPatientSummaryByCode(Integer code);
}
