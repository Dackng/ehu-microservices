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

import com.unmsm.phr.EmrSummary;
import com.unmsm.phr.Phr;

@RestController
@RequestMapping(path = "/api")
public class PhrController {

	PhrService phrService;
	
	@Autowired
	public PhrController(PhrService phrService){
		this.phrService = phrService;
	}
	
	@RequestMapping(path = "/find/{patientCode}", method = RequestMethod.GET, name = "findPhrByPatientCode")
	public ResponseEntity<Phr> findPhrByPatientCode(@PathVariable("patientCode") Integer patientCode){
		return Optional.ofNullable(phrService.findPhrByPatientCode(patientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Phr> registerPhr
		(@RequestBody Phr phr)throws Exception{
		Assert.notNull(phr);
		return Optional.ofNullable(phrService.registerPhr(phr))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save phr"));
	}
	
	@RequestMapping(path = "/register/emr-summary/{patientCode}", method = RequestMethod.PUT)
	public ResponseEntity<Phr> registerEmrSummary(@PathVariable("patientCode") Integer patientCode
			, @RequestBody EmrSummary emrSummary)throws Exception{
		Assert.notNull(emrSummary);
		return Optional.ofNullable(phrService.registerEmrSummary(patientCode, emrSummary))
                .map(result -> new ResponseEntity<Phr>(HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<Phr>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/update/emr-summary/{patientCode}", method = RequestMethod.PUT)
	public ResponseEntity<Phr> updateEmrSummary(@PathVariable("patientCode") Integer patientCode
			, @RequestBody EmrSummary emrSummary)throws Exception{
		Assert.notNull(emrSummary);
		return Optional.ofNullable(phrService.updateEmrSummary(patientCode, emrSummary))
                .map(result -> new ResponseEntity<Phr>(HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<Phr>(HttpStatus.NOT_FOUND));
	}
}
