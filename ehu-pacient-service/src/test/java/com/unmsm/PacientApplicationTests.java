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

import com.unmsm.pacient.PacientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PacientApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class PacientApplicationTests {
	
	private Logger log = LoggerFactory.getLogger(PacientApplicationTests.class);
	
	@Autowired
	PacientRepository pacientRepository;
	
	@Test
	@Ignore
	public void findPacientDetailByCodeTest(){
		log.info(pacientRepository.findPacientByCode(12400221).toString());
	}
	
	@Test
	public void savePacient(){
	
	}
	
	@Test
	public void findPacientSummaryByCodeTest(){
		log.info(pacientRepository.findPacientSummaryByCode(12200221).toString());
	}
}
