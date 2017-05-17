package com.unmsm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GeneralMedicineTestApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class GeneralMedicineTestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
