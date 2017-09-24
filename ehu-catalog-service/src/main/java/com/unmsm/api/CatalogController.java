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
import com.unmsm.catalog.ItemIndex;
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
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByItemIndex(PrimaryGroup.EMR_STATE
				, ItemIndex.FIRST_ITEM.getValue()))
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
	
	@RequestMapping(path = "/list/hemoglobin-state", method = RequestMethod.GET, name = "getHemoglobinStateList")
	public ResponseEntity<List<Catalog>> getHemoglobinStateList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.HEMOGLOBIN_STATE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/depression-state", method = RequestMethod.GET, name = "getDepressionStateList")
	public ResponseEntity<List<Catalog>> getDepressionStateList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.DEPRESSION_STATE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/anxiety-state", method = RequestMethod.GET, name = "getAnxietyStateList")
	public ResponseEntity<List<Catalog>> getAnxietyStateList(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.ANXIETY_STATE))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/medical-test/new-patient", method = RequestMethod.GET, name = "getMedicalTestListForNewPatient")
	public ResponseEntity<List<Catalog>> getMedicalTestListForNewPatient(){
		return Optional.ofNullable(catalogService.getElementsListByPrimaryId(PrimaryGroup.MEDICAL_TEST))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	/**
	 * SECOND_ITEM and THIRD_ITEM are index of Laboratory and Radiology respectively
	 * @return
	 */
	@RequestMapping(path = "/list/medical-test/old-patient", method = RequestMethod.GET, name = "getMedicalTestListForOldPatient")
	public ResponseEntity<List<Catalog>> getMedicalTestListForOldPatient(){
		return Optional.ofNullable(catalogService.getElementsOfPrimaryGroupByfirstIndexAndSecondIndex(PrimaryGroup.MEDICAL_TEST
				,ItemIndex.SECOND_ITEM.getValue(), ItemIndex.THIRD_ITEM.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/medical-test/general-medicine", method = RequestMethod.GET, name = "getMedicalTestListForNewPatient")
	public ResponseEntity<Catalog> findGeneralMedicineTest(){
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByItemIndex
				(PrimaryGroup.MEDICAL_TEST, ItemIndex.FIRST_ITEM.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/medical-test/laboratory", method = RequestMethod.GET, name = "findLaboratoryTest")
	public ResponseEntity<Catalog> findLaboratoryTest(){
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByItemIndex
				(PrimaryGroup.MEDICAL_TEST, ItemIndex.SECOND_ITEM.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/medical-test/radiology", method = RequestMethod.GET, name = "findRadiologyTest")
	public ResponseEntity<Catalog> findRadiologyTest(){
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByItemIndex
				(PrimaryGroup.MEDICAL_TEST, ItemIndex.THIRD_ITEM.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@RequestMapping(path = "/element/medical-test/psychological", method = RequestMethod.GET, name = "findPsychologicalTest")
	public ResponseEntity<Catalog> findPsychologicalTest(){
		return Optional.ofNullable(catalogService.getElementOfPrimaryGroupByItemIndex
				(PrimaryGroup.MEDICAL_TEST, ItemIndex.FOURTH_ITEM.getValue()))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
