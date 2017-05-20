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

import com.unmsm.generalmedicine.GeneralMedicineTest;

@RestController
@RequestMapping(path = "/api")
public class GeneralMedicineTestController {

	private GeneralMedicineTestService generalMedicineTestService;

	@Autowired
	public GeneralMedicineTestController(GeneralMedicineTestService generalMedicineTestService) {
		this.generalMedicineTestService = generalMedicineTestService;
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<GeneralMedicineTest> registerGeneralMedicineTest(
			@RequestBody GeneralMedicineTest generalMedicineTest) throws Exception {
		assert generalMedicineTest != null;
		return Optional.ofNullable(generalMedicineTestService.registerGeneralMedicineTest(generalMedicineTest))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElseThrow(() -> new Exception("Could not save general medicine test"));
	}

	@RequestMapping(path = "/find/{emrHealthPlanId}/{emrPacientCode}", method = RequestMethod.GET, name = "findGeneralMedicineTestByEmrHealthPlanIdAndEmrPacientCode")
	public ResponseEntity<GeneralMedicineTest> findGeneralMedicineTestByEmrHealthPlanIdAndEmrPacientCode(
			@PathVariable("emrHealthPlanId") Integer emrHealthPlanId,
			@PathVariable("emrPacientCode") Integer emrPacientCode) {
		return Optional
				.ofNullable(generalMedicineTestService
						.findGeneralMedicineTestByEmrHealthPlanIdAndEmrPacientCode(emrHealthPlanId, emrPacientCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
