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
		psychologicalTest.setEmrPacientCode(12200221);
		psychologicalTest.setEmrHealthPlanId(1);
		assert psychologicalTestRepository.save(psychologicalTest) != null;
		log.info("success");
	}

	@Test
	public void findPsychologicalTestByEmrHealthPlanIdAndEmrPacientCodeTest() {
		PsychologicalTest psychologicalTest = psychologicalTestRepository.findPsychologicalTestByEmrHealthPlanIdAndEmrPacientCode(1,
				12200221);
		assert psychologicalTest != null;
		log.info(psychologicalTest.toString());
		log.info("success");
	}

}
