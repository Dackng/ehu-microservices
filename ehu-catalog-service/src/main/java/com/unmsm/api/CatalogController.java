package com.unmsm.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.IndexOfFieldState;
import com.unmsm.catalog.PrimaryGroup;

@RestController
@RequestMapping(path = "/api")
public class CatalogController {
	
	private CatalogService catalogService;
	
	@Autowired	
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService; 
	}
	
	@RequestMapping(path = "/list/civil-state", method = RequestMethod.GET, name = "getCivilStateList")
	public ResponseEntity<List<Catalog>> getCivilStateList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.CIVIL_STATE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/first-emr-state", method = RequestMethod.GET, name = "getFirstEmrState")
	public ResponseEntity<Catalog> getFirstEmrState(){
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByStateIndex(PrimaryGroup.EMR_STATE
				, IndexOfFieldState.FIRST_STATE.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/emr-state", method = RequestMethod.GET, name = "getEmrStateList")
	public ResponseEntity<List<Catalog>> getEmrStateList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.EMR_STATE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/eap", method = RequestMethod.GET, name = "getEapList")
	public ResponseEntity<List<Catalog>> getEapList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.EAP))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/current-health-plan", method = RequestMethod.GET, name = "findCurrentHealthPlan")
	public ResponseEntity<Catalog> findCurrentHealthPlan(){
		return Optional.ofNullable(catalogService.findCurrentHealthPlan(PrimaryGroup.HEALTH_PLAN))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/gender", method = RequestMethod.GET, name = "getGenderList")
	public ResponseEntity<List<Character>> getGenderList(){
		return Optional.ofNullable(catalogService.getGenderElementsList())
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/symptom-type", method = RequestMethod.GET, name = "getSymptomTypeList")
	public ResponseEntity<List<Catalog>> getSymptomTypeList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.SYMPTOM_TYPE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/cie", method = RequestMethod.GET, name = "getCIEList")
	public ResponseEntity<List<Catalog>> getCIEList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.CIE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/serological-test", method = RequestMethod.GET, name = "getSerologicalTestList")
	public ResponseEntity<List<Catalog>> getSerologicalTestList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.SEROLOGICAL_TEST))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/blood-type", method = RequestMethod.GET, name = "getBloodTypeList")
	public ResponseEntity<List<Catalog>> getBloodTypeList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.BLOOD_TYPE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/radiology-type", method = RequestMethod.GET, name = "getRadiologyTypeList")
	public ResponseEntity<List<Catalog>> getRadiologyTypeList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.RADIOLOGY_TYPE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/psychological-diagnosis", method = RequestMethod.GET, name = "getPsychologicalDiagnosisTypeList")
	public ResponseEntity<List<Catalog>> getPsychologicalDiagnosisTypeList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.PSYCHOLOGICAL_DIAGNOSIS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
