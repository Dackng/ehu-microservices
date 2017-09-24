package com.unmsm.api;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.unmsm.catalog.Catalog;
import com.unmsm.emr.Emr;
import com.unmsm.emr.EmrRepository;
import com.unmsm.emr.IndexOfFieldState;
import com.unmsm.medicaltest.ColorOfFieldState;
import com.unmsm.medicaltest.FieldValue;
import com.unmsm.medicaltest.MedicalTest;
import com.unmsm.medicaltest.MedicalTestRepository;

@Service
public class EmrService{

	private EmrRepository emrRepository;
	private MedicalTestRepository medicalTestRepository;
	private RestTemplate restTemplate;

	@Autowired
	public EmrService(EmrRepository emrRepository, MedicalTestRepository medicalTestRepository
			, RestTemplate normalRestTempalte){
		this.emrRepository = emrRepository;
		this.medicalTestRepository = medicalTestRepository;
		this.restTemplate = normalRestTempalte;
	}
	
	public Emr findEmrByHealthPlanIdAndPatientCode(Integer healthPlanId, Integer patientCode){
		return emrRepository.findEmrByHealthPlanIdAndPatientCode(healthPlanId, patientCode); 
	}
	
	public Emr registerEmr(Emr emr){
		emr.setMedicalTests(createMedicalTestList(emr));
		emrRepository.save(new HashSet<Emr>(){
			private static final long serialVersionUID = 1L;
		{
			add(emr);
		}});
		return emrRepository.findEmrByHealthPlanIdAndPatientCode(emr.getHealthPlanId(), emr.getPatientCode());
	}
	
	@HystrixCommand()
    public Emr validateEmrStateUpdated(Emr emr, Integer testTypeId) {
		Emr result = null;
    	Catalog[] list = getItemsOfEmrState();
    	medicalTestRepository.updateMedicalTestByEmrIdAndTestTypeId(emr.getId(), testTypeId);
    	if(emr.getStateId() == list[IndexOfFieldState.FIRST_STATE.getValue()].getSecondaryId()){
    		emr.setStateId(list[IndexOfFieldState.SECOND_STATE.getValue()].getSecondaryId());
    		result = emrRepository.save(emr);
    	} else { 
    		Long totalMedicalTests = medicalTestRepository.countMedicalTestByEmrId(emr.getId());
    		boolean emrIsCompleted = medicalTestRepository
    				.validateMedicalTestsCompleted(emr.getId(), totalMedicalTests);
    		if(emrIsCompleted){
	    		emr.setStateId(list[IndexOfFieldState.THIRD_STATE.getValue()].getSecondaryId());
	    		emr.generateCode();
	    		result = emrRepository.save(emr);
    		}
    	}
    	return result;
    }
	
	@HystrixCommand()
	public List<MedicalTest> findMedicalTestsByType(Integer healthPlanId, Integer patientCode
			, Integer testTypeId){
		List<MedicalTest> list = medicalTestRepository.findAllByHealthPlanIdAndPatientCode
				(healthPlanId, patientCode);
		list.sort(Comparator.comparing(MedicalTest::getTypeId));
    	Catalog[] catalogOfMedicalTestList = getItemsOfMedicalTest(list.size());
    	Catalog[] catalogOfEmrStateList = getItemsOfEmrState();
    	for (int i = 0; i < list.size(); i++){
    		list.get(i).setTypeName(catalogOfMedicalTestList[i].getName());
    		if(list.get(i).getIsFinished()){ 
    			list.get(i).setStateName(catalogOfEmrStateList[IndexOfFieldState.THIRD_STATE.getValue()].getName());
    			list.get(i).setColor(ColorOfFieldState.PRIMARY.getValue());
    		}else if(testTypeId == catalogOfEmrStateList[i].getSecondaryId()){
    			list.get(i).setStateName(catalogOfEmrStateList[IndexOfFieldState.SECOND_STATE.getValue()].getName());
    			list.get(i).setColor(ColorOfFieldState.INFO.getValue());
    		}else{
    			list.get(i).setStateName(catalogOfEmrStateList[IndexOfFieldState.FIRST_STATE.getValue()].getName());
    			list.get(i).setColor(ColorOfFieldState.DANGER.getValue());
    		}
    	}
    	return list; 
	}
    
    private Set<MedicalTest> createMedicalTestList(Emr emr){
    	Set<MedicalTest> medicalTests = new HashSet<MedicalTest>(){
    		private static final long serialVersionUID = 1L;
    		{
    			String url = "http://ehu-catalog-service/api/list/medical-test/";
    	    	List<Emr> emrList = emrRepository.findEmrByPatientCode(emr.getPatientCode());
    	    	Catalog[] itemsList = null;
    	    	if(emrList!= null && !emrList.isEmpty()) url += "old-patient";//if Patient have an EMR registered
    	    	else url += "new-patient";//when Patient doesn't have an EMR	
    	    	itemsList = restTemplate.getForObject(url, Catalog[].class);
    	    	for (int i = 0; i < itemsList.length; i++){
    	    		add(new MedicalTest(itemsList[i].getSecondaryId(), emr));
    	    	}
    		}
    	};
    	return medicalTests;
    }
    
    private Catalog[] getItemsOfMedicalTest(Integer countMedicalTests){
    	String endPoint = "http://ehu-catalog-service/api/list/medical-test/";
    	Catalog[] itemsList = null;
    	if(countMedicalTests == FieldValue.FOUR_MEDICAL_TEST.getValue()) endPoint += "new-patient";//if Patient have an EMR registered
    	else endPoint += "old-patient";//when Patient doesn't have an EMR
    	itemsList = restTemplate.getForObject(endPoint, Catalog[].class);
    	Assert.notNull(itemsList);
    	return itemsList;
    }
    
    private Catalog[] getItemsOfEmrState(){
    	Catalog[] itemsList = restTemplate.getForObject(
				"http://ehu-catalog-service/api/list/emr-state", Catalog[].class);
    	Assert.notNull(itemsList);
    	return itemsList;
    }
    
}
