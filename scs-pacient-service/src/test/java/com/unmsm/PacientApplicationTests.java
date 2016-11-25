package com.unmsm;

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
	public void findPacientByCode(){
		log.info(pacientRepository.findPacientByCode(12400200L).toString());
	}
	
	@Test
	public void savePacient(){
	
	}
}
