package com.unmsm;

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

import com.unmsm.laboratory.LaboratoryTest;
import com.unmsm.laboratory.LaboratoryTestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LaboratoryTestApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class LaboratoryTestApplicationTests {

	private Logger log = LoggerFactory.getLogger(LaboratoryTestApplicationTests.class);
	
	@Autowired
	LaboratoryTestRepository laboratoryTestRepository;
	
	@Test
	@Ignore
	public void registerLaboratoryTestTest() {
		LaboratoryTest laboratoryTest = new LaboratoryTest();
		laboratoryTest.setEmrPatientCode(12200221);
		laboratoryTest.setEmrHealthPlanId(1);
		assert laboratoryTestRepository.save(laboratoryTest)!= null;
		log.info("success");
	}
	
	@Test
	public void findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCodeTest(){
		LaboratoryTest laboratoryTest = laboratoryTestRepository.findLaboratoryTestByEmrHealthPlanIdAndEmrPatientCode
				(1, 12200221);
		assert laboratoryTest != null;
		log.info(laboratoryTest.toString());
		log.info("success");
	}

}
