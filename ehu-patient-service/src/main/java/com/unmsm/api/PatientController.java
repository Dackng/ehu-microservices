package com.unmsm.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.patient.Patient;

@RestController
@RequestMapping(path = "/api")
public class PatientController {
	
	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService){
		this.patientService = patientService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) throws Exception{
		Assert.notNull(patient);
		return Optional.ofNullable(patientService.registerPatient(patient))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save patient"));
	}
	
	@RequestMapping(path = "/find-detail/{code}", method = RequestMethod.GET, name = "findPatientDetailByCode")
	public ResponseEntity<Patient> findPatientDetailByCode(@PathVariable("code") Integer code){
		return Optional.ofNullable(patientService.findPatientDetailByCode(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/find-summary/{code}", method = RequestMethod.GET, name = "findPatientSummaryByCode")
	public ResponseEntity<Patient> findPatientSummaryByCode(@PathVariable("code") Integer code){
		return Optional.ofNullable(patientService.findPatientSummaryByCode(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
