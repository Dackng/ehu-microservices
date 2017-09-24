package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.unmsm.phr.EmrSummary;
import com.unmsm.phr.Phr;
import com.unmsm.phr.PhrRepository;

@Service
public class PhrService {
	
	private PhrRepository phrRepository;
	
	@Autowired
	public PhrService(PhrRepository phrRepository){
		this.phrRepository = phrRepository;
	}
	
	public Phr findPhrByPatientCode(Integer patientCode){
		return phrRepository.findByPatientCode(patientCode);
	}
	
	public Phr registerPhr(Phr phr){
		return phrRepository.save(phr);
	}
	
	public Phr registerEmrSummary(Integer patientCode, EmrSummary emrSummary){
		Phr phr = phrRepository.findByPatientCode(patientCode);
		Assert.notNull(phr);
		Assert.notNull(emrSummary);
		phr.getEmrSummaryList().add(emrSummary);
		return phrRepository.save(phr);
	}
	
	public Phr updateEmrSummary(Integer patientCode, EmrSummary emrSummary){
		Phr phr = phrRepository.findByPatientCode(patientCode);
		Assert.notNull(phr);
		Assert.notNull(emrSummary);
		for(int i = 0; i < phr.getEmrSummaryList().size(); i++){
			if (phr.getEmrSummary(i).getHealthPlan().equals(emrSummary.getHealthPlan())){
				phr.getEmrSummary(i).setFields(emrSummary);
				phr = phrRepository.save(phr);
				break;
			}
		}
		return phr;
		
	}
}
