package com.unmsm.radiology;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RadiologyTest implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer id;
	private Integer typeId;
	private String employeeCode;
	private String observation;
	private Date updatedAt;
	private Boolean isFinished;
	private Integer emrPatientCode;
	private Integer emrHealthPlanId;
	
	public RadiologyTest(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
	@PrePersist
	protected void onCreate() {
		isFinished = FieldValue.NOT_FINISH.getValue();
	}
	@Override
	public String toString() {
		return "Radiology [id=" + id + ", typeId=" + typeId + ", employeeCode=" + employeeCode + ", observation="
				+ observation + ", updatedAt=" + updatedAt + ", isFinished=" + isFinished + ", emrPatientCode="
				+ emrPatientCode + ", emrHealthPlanId=" + emrHealthPlanId + "]";
	}
}
