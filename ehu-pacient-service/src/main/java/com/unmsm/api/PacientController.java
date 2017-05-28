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

import com.unmsm.pacient.Pacient;

@RestController
@RequestMapping(path = "/api")
public class PacientController {
	
	private PacientService pacientService;
	
	@Autowired
	public PacientController(PacientService pacientService){
		this.pacientService = pacientService;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Pacient> registerPacient(@RequestBody Pacient pacient) throws Exception{
		assert pacient != null;
		return Optional.ofNullable(pacientService.registerPacient(pacient))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save pacient"));
	}
	
	@RequestMapping(path = "/find-detail/{code}", method = RequestMethod.GET, name = "findPacientDetailByCode")
	public ResponseEntity<Pacient> findPacientDetailByCode(@PathVariable("code") Integer code){
		return Optional.ofNullable(pacientService.findPacientDetailByCode(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/find-summary/{code}", method = RequestMethod.GET, name = "findPacientSummaryByCode")
	public ResponseEntity<Pacient> findPacientSummaryByCode(@PathVariable("code") Integer code){
		return Optional.ofNullable(pacientService.findPacientSummaryByCode(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
