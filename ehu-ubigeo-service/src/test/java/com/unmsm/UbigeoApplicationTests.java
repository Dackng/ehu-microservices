package com.unmsm;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unmsm.ubigeo.Ubigeo;
import com.unmsm.ubigeo.UbigeoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(UbigeoApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class UbigeoApplicationTests {
	
	private Logger log = LoggerFactory.getLogger(UbigeoApplicationTests.class);
	
	@Autowired
	UbigeoRepository ubigeoRepository;
	
	@Test
	public void findUbigeoByCode(){
		log.info(ubigeoRepository.findUbigeoByCode("10101").toString());
	}
	
	@Test
	public void findDepartments(){
		List<Ubigeo> lista = ubigeoRepository.findDepartments();
		if(lista.isEmpty()){
			fail("Elements not found");
		}else{
			for (Ubigeo ubigeo : lista) {
				log.info(ubigeo.toString());
			}
		}
	}
	
	@Test
	public void findProvincesByDepartmentCode(){
		List<Ubigeo> lista = ubigeoRepository.findProvincesByDepartmentCode("1");
		if(lista.isEmpty()){
			fail("Elements not found");
		}else{
			for (Ubigeo ubigeo : lista) {
				log.info(ubigeo.toString());
			}
		}
	}
	
	@Test
	public void findDistrictsByProvinceCode(){
		List<Ubigeo> lista = ubigeoRepository.findDistrictsByProvinceCode("1");
		if(lista.isEmpty()){
			fail("Elements not found");
		}else{
			for (Ubigeo ubigeo : lista) {
				log.info(ubigeo.toString());
			}
		}
	}
}
