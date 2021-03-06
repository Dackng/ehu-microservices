package com.unmsm.psychological;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PsychologicalTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String employeeCode;
	private Integer depressionResult;
	private Integer depressionStateId;
	private Integer anxietyResult;
	private Integer anxietyStateId;
	private Integer diagnosisId;
	private String observation;
	private Date updatedAt;
	private Boolean isFinished;
	private Integer emrPatientCode;
	private Integer emrHealthPlanId;
	
	public PsychologicalTest(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Integer getDepressionResult() {
		return depressionResult;
	}
	public void setDepressionResult(Integer depressionResult) {
		this.depressionResult = depressionResult;
	}
	public Integer getDepressionStateId() {
		return depressionStateId;
	}
	public void setDepressionStateId(Integer depressionStateId) {
		this.depressionStateId = depressionStateId;
	}
	public Integer getAnxietyResult() {
		return anxietyResult;
	}
	public void setAnxietyResult(Integer anxietyResult) {
		this.anxietyResult = anxietyResult;
	}
	public Integer getAnxietyStateId() {
		return anxietyStateId;
	}
	public void setAnxietyStateId(Integer anxietyStateId) {
		this.anxietyStateId = anxietyStateId;
	}
	public Integer getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
	public Integer getEmrPatientCode() {
		return emrPatientCode;
	}
	public void setEmrPatientCode(Integer emrPatientCode) {
		this.emrPatientCode = emrPatientCode;
	}
	public Integer getEmrHealthPlanId() {
		return emrHealthPlanId;
	}
	public void setEmrHealthPlanId(Integer emrHealthPlanId) {
		this.emrHealthPlanId = emrHealthPlanId;
	}
	@Override
	public String toString() {
		return "PsychologicalTest [id=" + id + ", employeeCode=" + employeeCode + ", depressionResult="
				+ depressionResult + ", depressionStateId=" + depressionStateId + ", anxietyResult=" + anxietyResult
				+ ", anxietyStateId=" + anxietyStateId + ", diagnosisId=" + diagnosisId + ", observation=" + observation
				+ ", updatedAt=" + updatedAt + ", isFinished=" + isFinished + ", emrPatientCode=" + emrPatientCode
				+ ", emrHealthPlanId=" + emrHealthPlanId + "]";
	}
}
