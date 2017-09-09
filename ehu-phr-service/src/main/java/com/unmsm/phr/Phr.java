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
	private List<EmrSummary> emrSummaryList;
	
	public Phr(){
		emrSummaryList = new ArrayList<>();
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
	public List<EmrSummary> getEmrSummaryList() {
		return emrSummaryList;
	}
	public void setEmrSummaryList(List<EmrSummary> emrSummaryList) {
		this.emrSummaryList = emrSummaryList;
	}
	public EmrSummary getEmrSummary(int index) {
		return this.getEmrSummaryList().get(index);
	}
	
	@Override
	public String toString() {
		return "Phr [phrId=" + phrId + ", patientSummary=" + patientSummary + ", emrSummaryList=" + emrSummaryList + "]";
	}

}
