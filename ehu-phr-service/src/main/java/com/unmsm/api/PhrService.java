package com.unmsm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.unmsm.phr.Emr;
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
	
	public Phr registerEmr(Integer patientCode, Emr emr){
		Phr phr = phrRepository.findByPatientCode(patientCode);
		Assert.notNull(phr);
		phr.getEmrList().add(emr);
		return phrRepository.save(phr);
	}
}
