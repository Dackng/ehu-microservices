package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.unmsm.catalog.Catalog;
import com.unmsm.emr.Emr;
import com.unmsm.emr.EmrRepository;
import com.unmsm.emr.IndexOfFieldState;

@Service
public class EmrService{

	private EmrRepository emrRepository;
	private RestTemplate restTemplate;

	@Autowired
	public EmrService(EmrRepository emrRepository, RestTemplate normalRestTempalte){
		this.emrRepository = emrRepository;
		this.restTemplate = normalRestTempalte;
	}
	
	public Emr findEmrByHealthPlanIdAndPatientCode(Integer healthPlanId, Integer patientCode){
		return emrRepository.findEmrByHealthPlanIdAndPatientCode(healthPlanId, patientCode); 
	}
	
	public Emr registerEmr(Emr emr){
		return emrRepository.save(emr);
	}
	
    public Emr updateToSecondEmrState(Integer healthPlanId, Integer patientCode, Emr emr) {
		Emr result = null;
    	Catalog[] list = restTemplate.getForObject(
				"http://ehu-catalog-service/api/list/emr-state", Catalog[].class);
    	Assert.notNull(list);
    	if(emr.getStateId() == list[IndexOfFieldState.FIRST_STATE.getValue()].getSecondaryId()){
    		emr.setStateId(list[IndexOfFieldState.SECOND_STATE.getValue()].getSecondaryId());
    		result = this.emrRepository.save(emr);
    	}
    	return result;
    }
}
