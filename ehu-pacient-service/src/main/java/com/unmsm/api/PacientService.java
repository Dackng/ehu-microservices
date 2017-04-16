package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.unmsm.catalog.Catalog;
import com.unmsm.pacient.Pacient;
import com.unmsm.pacient.PacientRepository;
import com.unmsm.ubigeo.Ubigeo;

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
					"http://ehu-catalog-service/api/element/medical-status/" + pacient.getMedicalStatusId(),Catalog.class);
			pacient.setMedicalStatusName(catalog.getName());
			catalog = restTemplate.getForObject(
					"http://ehu-catalog-service/api/element/civil-status/" + pacient.getCivilStatusId(),Catalog.class);
			pacient.setCivilStatusName(catalog.getName());
			catalog = restTemplate.getForObject(
					"http://ehu-catalog-service/api/element/eap/" + pacient.getEapId(),Catalog.class);
			pacient.setEapName(catalog.getName());
			Ubigeo ubigeo = restTemplate.getForObject("http://ehu-ubigeo-service/api/element/ubigeo/" + 
					pacient.getUbigeo().getUbigeoCode(), Ubigeo.class);
			pacient.setUbigeo(ubigeo);
		}
		return pacient;
	}
}
