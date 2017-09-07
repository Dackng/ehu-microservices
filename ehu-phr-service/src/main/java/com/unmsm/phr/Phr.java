package com.unmsm.phr;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Phr {
	
	@Id
	private ObjectId phrId;
	private PatientSummary patientSummary;
	private List<EmrSummary> emrList;
	
	public Phr(){
		emrList = new ArrayList<>();
	}
	
	public String getPhrId() {
		return phrId != null ? phrId.toHexString() : null;
	}
	public void setPhrId(ObjectId phrId) {
		this.phrId = phrId;
	}
	public PatientSummary getPatientSummary() {
		return patientSummary;
	}
	public void setPatientSummary(PatientSummary patientSummary) {
		this.patientSummary = patientSummary;
	}
	public List<EmrSummary> getEmrList() {
		return emrList;
	}
	public void setEmrList(List<EmrSummary> emrList) {
		this.emrList = emrList;
	}
	public EmrSummary getEmrSummary(int index) {
		return this.getEmrList().get(index);
	}
	
	@Override
	public String toString() {
		return "Phr [phrId=" + phrId + ", patientSummary=" + patientSummary + ", emrList=" + emrList + "]";
	}

}
