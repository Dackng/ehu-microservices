package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.unmsm.patient.Patient;
import com.unmsm.patient.PatientRepository;
import com.unmsm.ubigeo.Ubigeo;

@Service
public class PatientService {

	private PatientRepository patientRepository;
	private RestTemplate restTemplate;

	@Autowired
	public PatientService(PatientRepository patientRepository, RestTemplate normalRestTemplate) {
		this.patientRepository = patientRepository;
		this.restTemplate = normalRestTemplate;
	}

	public Patient registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@HystrixCommand
	public Patient findPatientDetailByCode(Integer code) {
		Patient patient = patientRepository.findPatientByCode(code);
		if(patient != null){
			Ubigeo ubigeo = restTemplate.getForObject(
					"http://ehu-ubigeo-service/api/element/ubigeo/" +
					patient.getUbigeo().getUbigeoCode(), Ubigeo.class);
			patient.setUbigeo(ubigeo);
		}
		return patient;
	}
	
	public Patient findPatientSummaryByCode(Integer code) {
		return patientRepository.findPatientSummaryByCode(code);
	}
}
