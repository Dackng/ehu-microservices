package com.unmsm.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.PrimaryGroup;

@RestController
@RequestMapping(path = "/api")
public class CatalogController {
	
	private CatalogService catalogService;
	
	@Autowired	
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService; 
	}
	
	@RequestMapping(path = "/element/civil-status/{idSecondary}", method = RequestMethod.GET, name = "findCivilStatusByIdSecondary")
	public ResponseEntity<Catalog> findCivilStatusByIdSecondary(
			@PathVariable("idSecondary") Long idSecondary){
		return Optional.ofNullable(catalogService.findElementByIdPrimaryAndIdSecondary(PrimaryGroup.CIVIL_STATUS, idSecondary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/civil-status", method = RequestMethod.GET, name = "getCivilStatusList")
	public ResponseEntity<List<Catalog>> getCivilStatusList(){
		return Optional.ofNullable(catalogService.findElementsListByIdPrimary(PrimaryGroup.CIVIL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/medical-status/{idSecondary}", method = RequestMethod.GET, name = "findMedicaltatusByIdSecondary")
	public ResponseEntity<Catalog> findMedicaltatusByIdSecondary(
			@PathVariable("idSecondary") Long idSecondary){
		return Optional.ofNullable(catalogService.findElementByIdPrimaryAndIdSecondary(PrimaryGroup.MEDICAL_STATUS, idSecondary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/first-medical-status", method = RequestMethod.GET, name = "getFirstMedicalStatus")
	public ResponseEntity<List<Catalog>> getFirstMedicalStatus(){
		return Optional.ofNullable(catalogService.findFirstElementOfPrimaryGroup(PrimaryGroup.MEDICAL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@RequestMapping(path = "/list/medical-status", method = RequestMethod.GET, name = "getMedicalStatusList")
	public ResponseEntity<List<Catalog>> getMedicalStatusList(){
		return Optional.ofNullable(catalogService.findElementsListByIdPrimary(PrimaryGroup.MEDICAL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/eap/{idSecondary}", method = RequestMethod.GET, name = "findEapByIdSecondary")
	public ResponseEntity<Catalog> findEapByIdSecondary(
			@PathVariable("idSecondary") Long idSecondary){
		return Optional.ofNullable(catalogService.findElementByIdPrimaryAndIdSecondary(PrimaryGroup.EAP, idSecondary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/eap", method = RequestMethod.GET, name = "getEapList")
	public ResponseEntity<List<Catalog>> getEapList(){
		return Optional.ofNullable(catalogService.findElementsListByIdPrimary(PrimaryGroup.EAP))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
