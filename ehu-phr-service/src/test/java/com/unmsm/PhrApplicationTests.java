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

import com.unmsm.api.PhrService;
import com.unmsm.phr.EmrSummary;
import com.unmsm.phr.PatientSummary;
import com.unmsm.phr.Phr;
import com.unmsm.phr.PhrRepository;
import com.unmsm.phr.Ubigeo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PhrApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class PhrApplicationTests {

	private Logger log = LoggerFactory.getLogger(PhrApplicationTests.class);
	
	@Autowired
	PhrRepository phrRepository;
	
	@Autowired
	PhrService phrService;
	
	@Test
	@Ignore
	public void registerPhrTest() {
		Phr phr = new Phr();
		Ubigeo ubigeo = new Ubigeo("LIMA", "LIMA", "LOS OLIVOS");
		PatientSummary patientSummary = new PatientSummary(12345678, "DIEGO", "CAYO", "ALCOS","SOLTERO"
				, "prueba@mail.com", "ING. SOFTWARE", new Date(), 5504444, "MASCULINO"
				, "AV. ALFA", ubigeo);
		phr.setPatientSummary(patientSummary);
		EmrSummary emrSummary = new EmrSummary("2017-001", "FINALIZADO", new Date(), new Date()
				, "PLAN 2017-I", "OBSERVADO", "NEGATIVO", "NO REACTIVO", "A Rh(+)");
		phr.getEmrSummaryList().add(emrSummary);
		log.info("Registering: "+ phr);
		phrRepository.save(phr);
		log.info("success");
	}
	
	@Test
	@Ignore
	public void findPhrByPatientCodeTest(){
		log.info("Getting: " + phrRepository.findByPatientCode(12345678));
	}
	
	@Test
	public void registerEmrSummaryTest(){
		EmrSummary emrSummary = new EmrSummary("2017-230", "FINALIZADO", new Date(), new Date()
				, "PLAN 2017-II", "NORMAL", "POSITIVO", "REACTIVO", "B Rh(+)");
		log.info("Registering EMR SUMMARY: " + emrSummary);
		Phr phr = phrService.registerEmrSummary(12345678, emrSummary);
		log.info("success: "+phr);
	}
}
