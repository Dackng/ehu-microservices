package com.unmsm.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.psychological.PsychologicalTest;

@RestController
@RequestMapping(path = "/api")
public class PsychologicalTestController {

	private PsychologicalTestService psychologicalTestService;
	
	@Autowired
	public PsychologicalTestController(PsychologicalTestService psychologicalTestService){
		this.psychologicalTestService = psychologicalTestService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<PsychologicalTest> registerPsychologicalTest
		(@RequestBody PsychologicalTest psychologicalTest)throws Exception{
		assert psychologicalTest != null;
		return Optional.ofNullable(psychologicalTestService.registerPsychologicalTest(psychologicalTest))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save psychological test"));
	}
	
	@RequestMapping(path = "/find/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<PsychologicalTest> findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode(@PathVariable("emrHealthPlanId") Integer emrHealthPlanId, @PathVariable("emrPatientCode") Integer emrPatientCode){
		return Optional.ofNullable(psychologicalTestService.findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/get-state/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "getTestStateByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<Boolean> getTestStateByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPatientCode") Integer emrPatientCode) {
		return Optional
				.ofNullable(psychologicalTestService
						.getTestStateByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
