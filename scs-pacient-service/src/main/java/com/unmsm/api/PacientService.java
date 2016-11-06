package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.pacient.Pacient;
import com.unmsm.pacient.PacientRepository;

@Service
public class PacientService {
	
	private PacientRepository pacientRepository;
	
	@Autowired
	public PacientService(PacientRepository pacientRepository) {
		this.pacientRepository = pacientRepository;
	}
	
	public Pacient savePacient(Pacient pacient){
		return pacientRepository.save(pacient);
	}
	
	public Pacient findPacientByCode(Long code){
		return pacientRepository.findPacientByCode(code);
	}
}
