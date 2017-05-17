package com.unmsm.pacient;

import org.springframework.data.repository.CrudRepository;

public interface PacientRepository extends CrudRepository<Pacient, Integer> {

	Pacient findPacientByCode(Integer code);
}
