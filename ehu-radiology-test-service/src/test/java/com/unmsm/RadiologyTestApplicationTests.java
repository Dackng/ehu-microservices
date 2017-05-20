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

import com.unmsm.radiology.RadiologyTest;
import com.unmsm.radiology.RadiologyTestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RadiologyTestApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class RadiologyTestApplicationTests {

	private Logger log = LoggerFactory.getLogger(RadiologyTestApplicationTests.class);

	@Autowired
	RadiologyTestRepository radiologyTestRepository;

	@Test
	@Ignore
	public void registerRadiologyTestTest() {
		RadiologyTest radiologyTest = new RadiologyTest();
		radiologyTest.setEmrPacientCode(12200221);
		radiologyTest.setEmrHealthPlanId(1);
		assert radiologyTestRepository.save(radiologyTest) != null;
		log.info("success");
	}

	@Test
	public void findRadiologyTestByEmrHealthPlanIdAndEmrPacientCodeTest() {
		RadiologyTest radiologyTest = radiologyTestRepository.findRadiologyTestByEmrHealthPlanIdAndEmrPacientCode(1,
				12200221);
		assert radiologyTest != null;
		log.info(radiologyTest.toString());
		log.info("success");
	}
}
