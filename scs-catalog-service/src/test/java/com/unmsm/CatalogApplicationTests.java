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
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.CatalogRepository;
import com.unmsm.catalog.NamesField;
import com.unmsm.catalog.PrimaryGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CatalogApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class CatalogApplicationTests {
	
	private Logger log = LoggerFactory.getLogger(CatalogApplicationTests.class);
	
	@Autowired
	CatalogRepository catalogRepository;
	
	@Test
	public void findElementByIdPrimaryAndIdSecondary(){
		log.info(catalogRepository.findElementByIdPrimaryAndIdSecondary(PrimaryGroup.CIVIL_STATUS.getValue(), 1L).toString());
	}
	
	@Test
	public void findElementsListByIdPrimary(){
		List<Catalog> lista = catalogRepository.findElementsListByIdPrimary(PrimaryGroup.EAP.getValue());
		if(lista.isEmpty()){
			fail("Elements not found");
		}else{
			for (Catalog catalog : lista) {
				log.info(catalog.toString());
			}
		}
	}
	
	@Test
	public void findTop1ByIdPrimary(){
		log.info(catalogRepository.findTop1ByIdPrimary(PrimaryGroup.MEDICAL_STATUS.getValue(), 
				new Sort(Sort.Direction.ASC, NamesField.ID_SECONDARY.getValue())).toString());
	}
}
