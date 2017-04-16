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
	
	@RequestMapping(path = "/element/civil-status/{secondaryId}", method = RequestMethod.GET, name = "findCivilStatusBySecondaryId")
	public ResponseEntity<Catalog> findCivilStatusBySecondaryId(
			@PathVariable("secondaryId") Long secondaryId){
		return Optional.ofNullable(catalogService.findElementByPrimaryIdAndSecondaryId(PrimaryGroup.CIVIL_STATUS, secondaryId))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/civil-status", method = RequestMethod.GET, name = "getCivilStatusList")
	public ResponseEntity<List<Catalog>> getCivilStatusList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.CIVIL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/medical-status/{secondaryId}", method = RequestMethod.GET, name = "findMedicaltatusBySecondaryId")
	public ResponseEntity<Catalog> findMedicaltatusBySecondaryId(
			@PathVariable("secondaryId") Long secondaryId){
		return Optional.ofNullable(catalogService.findElementByPrimaryIdAndSecondaryId(PrimaryGroup.MEDICAL_STATUS, secondaryId))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/first-medical-status", method = RequestMethod.GET, name = "getFirstMedicalStatus")
	public ResponseEntity<Catalog> getFirstMedicalStatus(){
		return Optional.ofNullable(catalogService.getFirstElementOfPrimaryGroup(PrimaryGroup.MEDICAL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@RequestMapping(path = "/list/medical-status", method = RequestMethod.GET, name = "getMedicalStatusList")
	public ResponseEntity<List<Catalog>> getMedicalStatusList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.MEDICAL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/eap/{secondaryId}", method = RequestMethod.GET, name = "findEapBySecondaryId")
	public ResponseEntity<Catalog> findEapBySecondaryId(
			@PathVariable("secondaryId") Long secondaryId){
		return Optional.ofNullable(catalogService.findElementByPrimaryIdAndSecondaryId(PrimaryGroup.EAP, secondaryId))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/eap", method = RequestMethod.GET, name = "getEapList")
	public ResponseEntity<List<Catalog>> getEapList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.EAP))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/gender", method = RequestMethod.GET, name = "getGenderList")
	public ResponseEntity<List<Catalog>> getGenderList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.GENDER))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
