package com.unmsm.pacient;

import org.springframework.data.repository.CrudRepository;

public interface PacientRepository extends CrudRepository<Pacient, Long> {

	Pacient findPacientByCode(Long code);
}
