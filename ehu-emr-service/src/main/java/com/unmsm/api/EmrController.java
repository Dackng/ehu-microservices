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

import com.unmsm.emr.Emr;

@RestController
@RequestMapping(path = "/api")
public class EmrController {
	
	private EmrService emrService;
	
	@Autowired
	public EmrController(EmrService emrService){
		this.emrService = emrService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Emr> registerEmr
		(@RequestBody Emr emr)throws Exception{
		Assert.notNull(emr);
		return Optional.ofNullable(emrService.registerEmr(emr))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save emr"));
	}
	
	@RequestMapping(path = "/find/{healthPlanId}/{patientCode}", method = RequestMethod.GET, name = "findEmrByHealthPlanIdAndPatientCode")
	public ResponseEntity<Emr> findEmrByHealthPlanIdAndPatientCode(@PathVariable("healthPlanId") Integer healthPlanId, @PathVariable("patientCode") Integer patientCode){
		return Optional.ofNullable(emrService.findEmrByHealthPlanIdAndPatientCode(healthPlanId, patientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/find/{healthPlanId}/{patientCode}", method = RequestMethod.PUT)
	public ResponseEntity<Emr> validateEmrStateUpdated
		(@RequestBody Emr emr, @PathVariable("healthPlanId") Integer healthPlanId
		, @PathVariable("patientCode") Integer patientCode)throws Exception{
		Assert.notNull(emr);
		return Optional.ofNullable(emrService.updateToSecondEmrState(healthPlanId, patientCode, emr))
                .map(result -> new ResponseEntity<Emr>(HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<Emr>(HttpStatus.NOT_FOUND));
	}

}
