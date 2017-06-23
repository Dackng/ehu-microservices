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

import com.unmsm.radiology.RadiologyTest;

@RestController
@RequestMapping(path = "/api")
public class RadiologyTestController {
	
	private RadiologyTestService radiologyTestService;
	
	@Autowired
	public RadiologyTestController(RadiologyTestService radiologyTestService){
		this.radiologyTestService = radiologyTestService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<RadiologyTest> registerRadiologyTest
		(@RequestBody RadiologyTest radiologyTest)throws Exception{
		assert radiologyTest != null;
		return Optional.ofNullable(radiologyTestService.registerRadiologyTest(radiologyTest))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save radiology test"));
	}
	
	@RequestMapping(path = "/find/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<RadiologyTest> findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode(@PathVariable("emrHealthPlanId") Integer emrHealthPlanId, @PathVariable("emrPatientCode") Integer emrPatientCode){
		return Optional.ofNullable(radiologyTestService.findRadiologyTestByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/validate-existence/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "validateExistenceByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<Boolean> validateExistenceByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPatientCode") Integer emrPatientCode) {
		return Optional
				.ofNullable(radiologyTestService
						.validateTestExistenceByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/get-state/{emrHealthPlanId}/{emrPatientCode}", method = RequestMethod.GET, name = "getTestStateByEmrHealthPlanIdAndEmrPatientCode")
	public ResponseEntity<Boolean> getTestStateByEmrHealthPlanIdAndEmrPatientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPatientCode") Integer emrPatientCode) {
		return Optional
				.ofNullable(radiologyTestService
						.getTestStateByEmrHealthPlanIdAndEmrPatientCode(emrHealthPlanId, emrPatientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
