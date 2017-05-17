package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.unmsm.catalog.Catalog;
import com.unmsm.emr.Emr;
import com.unmsm.emr.EmrRepository;

@Service
public class EmrService{

	private EmrRepository emrRepository;
	private RestTemplate restTemplate;

	@Autowired
	public EmrService(EmrRepository emrRepository, RestTemplate normalRestTempalte){
		this.emrRepository = emrRepository;
		this.restTemplate = normalRestTempalte;
	}
	
	@HystrixCommand
	public Emr findEmrByPacientCodeAndHealthPlanId(Integer pacientCode, Integer healthPlanId){
		Emr emr = emrRepository.findEmrByPacientCodeAndHealthPlanId(pacientCode, healthPlanId); 
		assert emr != null;
		Catalog catalog = restTemplate.getForObject(
					"http://ehu-catalog-service/api/element/emr-state/" + emr.getStateId(), Catalog.class);
			emr.setStateName(catalog.getName());
		return emr; 
	}
	
	public Emr registerEmr(Emr emr){
		return emrRepository.save(emr);
	}
}
