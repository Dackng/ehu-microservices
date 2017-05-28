package com.unmsm.pacient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PacientRepository extends CrudRepository<Pacient, Integer> {

	Pacient findPacientByCode(Integer code);
	
	@Query("select new Pacient(p.code, p.names, p.paternalSurname, p.maternalSurname) from Pacient p where p.code = ?1")
	Pacient findPacientSummaryByCode(Integer code);
}
