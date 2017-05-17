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
		assert laboratoryTest != null;
		return Optional.ofNullable(laboratoryTestService.registerLaboratoryTest(laboratoryTest))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save laboratory test"));
	}
	
	@RequestMapping(path = "/find/{emrHealthPlanId}/{emrPacientCode}", method = RequestMethod.GET, name = "findLaboratoryTestByEmrHealthPlanIdAndEmrPacientCode")
	public ResponseEntity<LaboratoryTest> findLaboratoryTestByEmrHealthPlanIdAndEmrPacientCode(@PathVariable("emrHealthPlanId") Integer emrHealthPlanId, @PathVariable("emrPacientCode") Integer emrPacientCode){
		return Optional.ofNullable(laboratoryTestService.findLaboratoryTestByEmrHealthPlanIdAndEmrPacientCode(emrHealthPlanId, emrPacientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
