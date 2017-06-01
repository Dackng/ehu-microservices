package com.unmsm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unmsm.generalmedicine.GeneralMedicineTest;
import com.unmsm.generalmedicine.GeneralMedicineTestRepository;
import com.unmsm.symptom.Symptom;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GeneralMedicineTestApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class GeneralMedicineTestApplicationTests {

	private Logger log = LoggerFactory.getLogger(GeneralMedicineTestApplicationTests.class);

	@Autowired
	GeneralMedicineTestRepository generalMedicineTestRepository;
	
	@Test
	@Ignore
	public void registerGeneralMedicineTestTest() {
		GeneralMedicineTest generalMedicineTest = new GeneralMedicineTest();
		generalMedicineTest.setEmrHealthPlanId(1);
		generalMedicineTest.setEmrPatientCode(12200221);
		Set<Symptom> symptoms = new HashSet<Symptom>(){{
			Symptom symptom = new Symptom(generalMedicineTest);
			symptom.setCieId(1);
			symptom.setAppointment(new Date());
			symptom.setTypeId(1);			
			add(symptom);
		}};
		generalMedicineTest.setSymptoms(symptoms);
		assert generalMedicineTestRepository.save(new HashSet<GeneralMedicineTest>(){{
			add(generalMedicineTest);
		}}) != null;
		log.info("success");
		
	}

	@Test
	public void findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCodeTest() {
		GeneralMedicineTest generalMedicineTest = generalMedicineTestRepository
				.findGeneralMedicineTestByEmrHealthPlanIdAndEmrPatientCode(1, 12200221);
		assert generalMedicineTest != null;
		log.info(generalMedicineTest.toString());
		log.info("success");
	}
}
