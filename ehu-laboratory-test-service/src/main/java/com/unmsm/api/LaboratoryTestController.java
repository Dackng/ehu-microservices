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

import com.unmsm.laboratory.LaboratoryTest;

@RestController
@RequestMapping(path = "/api")
public class LaboratoryTestController {
	
	private LaboratoryTestService laboratoryTestService;
	
	@Autowired
	public LaboratoryTestController(LaboratoryTestService laboratoryTestService){
		this.laboratoryTestService = laboratoryTestService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<LaboratoryTest> registerLaboratoryTest
		(@RequestBody LaboratoryTest laboratoryTest)throws Exception{
		Assert.notNull(laboratoryTest);
		return Optional.ofNullable(laboratoryTestService.registerLaboratoryTest(laboratoryTest))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save laboratory test"));
	}
	
	@RequestMapping(path = "/find/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<LaboratoryTest> findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId, 
			@PathVariable("emrPatientCode") Integer emrPatientCode){
		return Optional.ofNullable(laboratoryTestService.findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/validate-existence/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "validateExistenceByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<Boolean> validateExistenceByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPatientCode") Integer emrPatientCode) {
		return Optional
				.ofNullable(laboratoryTestService
						.validateTestExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/get-state/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "getTestStateByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<Boolean> getTestStateByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPatientCode") Integer emrPatientCode) {
		return Optional
				.ofNullable(laboratoryTestService
						.getTestStateByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
