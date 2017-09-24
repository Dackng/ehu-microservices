package com.unmsm.phr;

import java.io.Serializable;
import java.util.Date;

public class EmrSummary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	private String healthPlan;
	private String psychologicalResult;
	private String radiologyResult;
	private String serologicalResult;
	private String bloodType;
	private String hemoglobin;
	private String bloodCount;
	
	public EmrSummary(){}
	
	public EmrSummary(String code, String state, Date createAt, Date updateAt, String healthPlan
			, String psychologicalResult, String radiologyResult, String serologicalResult, String bloodType){
		this.code = code;
		this.state = state;
		this.createdAt = createAt;
		this.updatedAt = updateAt;
		this.healthPlan = healthPlan;
		this.psychologicalResult = psychologicalResult;
		this.radiologyResult = radiologyResult;
		this.serologicalResult = serologicalResult;
		this.bloodType = bloodType;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getHealthPlan() {
		return healthPlan;
	}
	public void setHealthPlan(String healthPlan) {
		this.healthPlan = healthPlan;
	}
	public String getPsychologicalResult() {
		return psychologicalResult;
	}
	public void setPsychologicalResult(String psychologicalResult) {
		this.psychologicalResult = psychologicalResult;
	}
	public String getRadiologyResult() {
		return radiologyResult;
	}
	public void setRadiologyResult(String radiologyResult) {
		this.radiologyResult = radiologyResult;
	}
	public String getSerologicalResult() {
		return serologicalResult;
	}
	public void setSerologicalResult(String serologicalResult) {
		this.serologicalResult = serologicalResult;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getBloodCount() {
		return bloodCount;
	}
	public void setBloodCount(String bloodcount) {
		this.bloodCount = bloodcount;
	}
	public void setFields(EmrSummary emrSummary){
		if(emrSummary.getState() != null) this.state = emrSummary.getState();
		if(emrSummary.getUpdatedAt() != null) this.updatedAt = emrSummary.getUpdatedAt();  
		if(emrSummary.getPsychologicalResult() != null) this.psychologicalResult = emrSummary.getPsychologicalResult();
		if(emrSummary.getRadiologyResult() != null) this.radiologyResult = emrSummary.getRadiologyResult();
		if(emrSummary.getSerologicalResult() != null) this.serologicalResult = emrSummary.getSerologicalResult();
		if(emrSummary.getBloodType() != null) this.bloodType = emrSummary.getBloodType();
		if(emrSummary.getHemoglobin() != null) this.hemoglobin = emrSummary.getHemoglobin();
		if(emrSummary.getBloodCount() != null) this.bloodCount = emrSummary.getBloodCount();
	}

	@Override
	public String toString() {
		return "Emr [code=" + code + ", state=" + state + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", healthPlan=" + healthPlan + ", psychologicalResult=" + psychologicalResult + ", radiologyResult="
				+ radiologyResult + ", serologicalResult=" + serologicalResult + ", bloodType=" + bloodType
				+ ", hemoglobin=" + hemoglobin + ", bloodCount=" + bloodCount + "]";
	}
}
