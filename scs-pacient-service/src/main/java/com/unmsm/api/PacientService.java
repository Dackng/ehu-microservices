package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.unmsm.catalog.Catalog;
import com.unmsm.pacient.Pacient;
import com.unmsm.pacient.PacientRepository;

@Service
public class PacientService {

	private PacientRepository pacientRepository;
	private RestTemplate restTemplate;

	@Autowired
	public PacientService(PacientRepository pacientRepository, RestTemplate normalRestTemplate) {
		this.pacientRepository = pacientRepository;
		this.restTemplate = normalRestTemplate;
	}

	public Pacient savePacient(Pacient pacient) {
		return pacientRepository.save(pacient);
	}

	@HystrixCommand
	public Pacient findPacientByCode(Long code) {
		Pacient pacient = pacientRepository.findPacientByCode(code);
		if(pacient != null){
			Catalog catalog = restTemplate.getForObject(
					"http://scs-catalog-service/api/element/medical-status/" + pacient.getIdMedicalStatus(),Catalog.class);
			pacient.setNameMedicalStatus(catalog.getName());
			catalog = restTemplate.getForObject(
					"http://scs-catalog-service/api/element/civil-status/" + pacient.getIdCivilStatus(),Catalog.class);
			pacient.setNameCivilStatus(catalog.getName());
			catalog = restTemplate.getForObject(
					"http://scs-catalog-service/api/element/eap/" + pacient.getIdEap(),Catalog.class);
			pacient.setNameEap(catalog.getName());
		}
		return pacient;
	}
}
