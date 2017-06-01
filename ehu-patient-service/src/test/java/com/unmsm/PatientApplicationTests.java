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

import com.unmsm.patient.PatientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PatientApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class PatientApplicationTests {
	
	private Logger log = LoggerFactory.getLogger(PatientApplicationTests.class);
	
	@Autowired
	PatientRepository patientRepository;
	
	@Test
	@Ignore
	public void findPatientDetailByCodeTest(){
		log.info(patientRepository.findPatientByCode(12400221).toString());
	}
	
	@Test
	public void savePatient(){
	
	}
	
	@Test
	public void findPatientSummaryByCodeTest(){
		log.info(patientRepository.findPatientSummaryByCode(12200221).toString());
	}
}
