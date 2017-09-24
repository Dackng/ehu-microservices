package com.unmsm;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

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

import com.unmsm.api.EmrService;
import com.unmsm.emr.Emr;
import com.unmsm.emr.EmrRepository;
import com.unmsm.medicaltest.MedicalTest;
import com.unmsm.medicaltest.MedicalTestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EmrApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class EmrApplicationTests {


	private Logger log = LoggerFactory.getLogger(EmrApplicationTests.class);
	
	@Autowired
	EmrRepository emrRepository;
	@Autowired
	MedicalTestRepository medicalTestRepository;
	@Autowired
	EmrService emrService;
	
	@Test
	@Ignore
	public void registerEmrTest(){
		Emr emr = new Emr();
		emr.setPatientCode(22221555);
		emr.setStateId(1);
		emr.setHealthPlanId(1);
		Assert.notNull(emrService.registerEmr(emr));
		log.info("success");
	}
	
	@Test
	@Ignore
	public void validateEmrStateUpdatedTest(){
		Emr emr = new Emr();
		emr.setId(1);
		emr.setCreatedAt(new Date());
		emr.setPatientCode(22221555);
		emr.setStateId(2);
		emr.setHealthPlanId(1);
		emr = emrService.validateEmrStateUpdated(emr, 4);
		log.info("success:"+emr);
	}
	
	@Test
	@Ignore
	public void findEmrByPatientCodeAndHealthPlanIdTest(){
		Emr emr = emrRepository.findEmrByHealthPlanIdAndPatientCode(1,12200221);
		Assert.notNull(emr);
		log.info("success");
		log.info(emr.toString());
	}
	
	@Test
	@Ignore
	public void findEmrByPatientCodeTest(){
		List<Emr> list = emrRepository.findEmrByPatientCode(12200221);
		log.info("Emr List:", list);
	}
	
	@Test
	@Ignore
	public void findMedicalTestsByMedicalTypeTest(){
		List<MedicalTest> list = emrService.findMedicalTestsByType(1, 22221555, 1);
		if (list.isEmpty()) {
			fail("Elements not found");
		}else{
			log.info("success");
			for(MedicalTest item: list) log.info(item.toString());
		}
	}
	
}
