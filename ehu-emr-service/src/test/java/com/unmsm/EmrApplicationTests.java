package com.unmsm;

import java.util.Date;

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
		emr.setPacientCode(12200221);
		emr.setStateId(1);
//		emr.setCreatedAt(new Date());
		emr.setHealthPlanId(1);
		assert emrRepository.save(emr) != null;
		log.info("success");
	}
	
	@Test
	public void findEmrByPacientCodeAndHealthPlanIdTest(){
		Emr emr = emrRepository.findEmrByPacientCodeAndHealthPlanId(12200221, 1);
		assert emr != null;
		log.info("success");
		log.info(emr.toString());
	}
}
