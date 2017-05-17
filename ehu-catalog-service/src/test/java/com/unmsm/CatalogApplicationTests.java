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
import com.unmsm.catalog.FieldNames;
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
	public void findElementByPrimaryIdAndSecondaryId(){
		log.info(catalogRepository.findElementByPrimaryIdAndSecondaryId(PrimaryGroup.CIVIL_STATE.getValue(), 1).toString());
	}
	
	@Test
	public void findElementsListByPrimaryId(){
		List<Catalog> lista = catalogRepository.findElementsListByPrimaryId(PrimaryGroup.EAP.getValue());
		if(lista.isEmpty()){
			fail("Elements not found");
		}else{
			for (Catalog catalog : lista) {
				log.info(catalog.toString());
			}
		}
	}
	
	@Test
	public void findTop1ByPrimaryId(){
		log.info(catalogRepository.findTop1ByPrimaryId(PrimaryGroup.EMR_STATE.getValue(), 
				new Sort(Sort.Direction.ASC, FieldNames.SECONDARY_ID.getValue())).toString());
	}
}
