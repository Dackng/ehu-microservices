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
import org.springframework.util.Assert;

import com.unmsm.psychological.PsychologicalTest;
import com.unmsm.psychological.PsychologicalTestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PsychologicalTestApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class PsychologicalTestApplicationTests {

	private Logger log = LoggerFactory.getLogger(PsychologicalTestApplicationTests.class);
	
	@Autowired
	PsychologicalTestRepository psychologicalTestRepository;
	
	@Test
	@Ignore
	public void registerPsychologicalTestTest() {
		PsychologicalTest psychologicalTest = new PsychologicalTest();
		psychologicalTest.setEmrPatientCode(12200221);
		psychologicalTest.setEmrHealthPlanId(1);
		Assert.notNull(psychologicalTestRepository.save(psychologicalTest));
		log.info("success");
	}

	@Test
	public void findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCodeTest() {
		PsychologicalTest psychologicalTest = psychologicalTestRepository.findPsychologicalTestByEmrHealthPlanIdAndEmrPatientCode(1,
				12200221);
		Assert.notNull(psychologicalTest);
		log.info(psychologicalTest.toString());
		log.info("success");
	}
}
