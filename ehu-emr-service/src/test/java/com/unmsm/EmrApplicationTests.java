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

import com.unmsm.emr.Emr;
import com.unmsm.emr.EmrRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EmrApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class EmrApplicationTests {


	private Logger log = LoggerFactory.getLogger(EmrApplicationTests.class);
	
	@Autowired
	EmrRepository emrRepository;
	
	@Test
	@Ignore
	public void registerEmrTest(){
		Emr emr = new Emr();
		emr.setPatientCode(12200221);
		emr.setStateId(1);
		emr.setHealthPlanId(1);
		Assert.notNull(emrRepository.save(emr));
		log.info("success");
	}
	
	@Test
	public void findEmrByPatientCodeAndHealthPlanIdTest(){
		Emr emr = emrRepository.findEmrByHealthPlanIdAndPatientCode(1,12200221);
		Assert.notNull(emr);
		log.info("success");
		log.info(emr.toString());
	}
}
