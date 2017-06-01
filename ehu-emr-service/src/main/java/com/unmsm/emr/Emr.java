package com.unmsm.emr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Emr implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private Integer patientCode;
	private String employeeCode;
	private String code;
	private Integer stateId;
	private String stateName;
	private Date createdAt;
	private Date updatedAt;
	private Integer healthPlanId;
	
	public Emr(){}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPatientCode() {
		return patientCode;
	}
	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	@Transient
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getHealthPlanId() {
		return healthPlanId;
	}
	public void setHealthPlanId(Integer healthPlanId) {
		this.healthPlanId = healthPlanId;
	}
	@PreUpdate
	protected void onUpdate() {
	    updatedAt = new Date();
	}
	@Override
	public String toString() {
		return "Emr [id=" + id + ", patientCode=" + patientCode + ", employeeCode=" + employeeCode + ", code=" + code
				+ ", stateId=" + stateId + ", stateName=" + stateName + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", healthPlanId=" + healthPlanId + "]";
	}
}
