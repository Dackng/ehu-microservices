package com.unmsm;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
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

import com.unmsm.api.CatalogService;
import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.CatalogRepository;
import com.unmsm.catalog.FieldName;
import com.unmsm.catalog.FieldValue;
import com.unmsm.catalog.ItemIndex;
import com.unmsm.catalog.PrimaryGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CatalogApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class CatalogApplicationTests {

	private Logger log = LoggerFactory.getLogger(CatalogApplicationTests.class);

	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	CatalogService catalogService;

	@Test
	@Ignore
	public void findElementByPrimaryIdAndSecondaryIdTest() {
		log.info(catalogRepository.findElementByPrimaryIdAndSecondaryId(PrimaryGroup.CIVIL_STATE.getValue(), 1)
				.toString());
	}

	@Test
	@Ignore
	public void findElementsListByPrimaryIdTest() {
		List<Catalog> list = catalogRepository.findElementsListByPrimaryId(PrimaryGroup.MEDICAL_TEST.getValue()
				, new Sort(Sort.Direction.ASC, FieldName.SECONDARY_ID.getValue()));
		if (list.isEmpty()) {
			fail("Elements not found");
		} else {
			for (Catalog catalog : list) {
				log.info(catalog.toString());
			}
		}
	}
	
	@Test
	@Ignore
	public void findCurrentHealthPlanTest() {
		log.info(catalogRepository.findElementByPrimaryIdAndState(PrimaryGroup.HEALTH_PLAN.getValue(),
				FieldValue.ACTIVE.getValue()).toString());
	}
	
	@Test
	@Ignore
	public void getElementsOfPrimaryGroupByfirstIndexAndSecondIndexTest() {
		List<Catalog> list = catalogService.getElementsOfPrimaryGroupByfirstIndexAndSecondIndex(PrimaryGroup.MEDICAL_TEST,
				ItemIndex.SECOND_ITEM.getValue(), ItemIndex.THIRD_ITEM.getValue());
		if (list.isEmpty()) {
			fail("Elements not found");
		}else{
			for(Catalog item: list) log.info(item.toString());
		}
	}
}
