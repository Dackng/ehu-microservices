package com.unmsm.laboratory;

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
import com.unmsm.laboratory.Constants;

@Entity
public class LaboratoryTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private String employeeCode;
	private Integer serologicalTestId;
	private Double hemoglobin;
	private Integer hemoglobinStateId;
	private Integer bloodCountId;
	private String observation;
	private Date updatedAt;
	private Boolean isFinished;
	private Integer emrPacientCode;
	private Integer emrHealthPlanId;
	
	public LaboratoryTest(){}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Integer getSerologicalTestId() {
		return serologicalTestId;
	}
	public void setSerologicalTestId(Integer serologicalTestId) {
		this.serologicalTestId = serologicalTestId;
	}
	public Double getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(Double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public Integer getHemoglobinStateId() {
		return hemoglobinStateId;
	}
	public void setHemoglobinStateId(Integer hemoglobinStateId) {
		this.hemoglobinStateId = hemoglobinStateId;
	}
	public Integer getBloodCountId() {
		return bloodCountId;
	}
	public void setBloodCountId(Integer bloodCountId) {
		this.bloodCountId = bloodCountId;
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
	public Integer getEmrHealthPlanId() {
		return emrHealthPlanId;
	}
	public void setEmrHealthPlanId(Integer emrHealthPlanId) {
		this.emrHealthPlanId = emrHealthPlanId;
	}
	public Integer getEmrPacientCode() {
		return emrPacientCode;
	}
	public void setEmrPacientCode(Integer emrPacientCode) {
		this.emrPacientCode = emrPacientCode;
	}
	@PrePersist
	protected void onCreate() {
		isFinished = Constants.NOT_FINISH.getValue();
	}

	@Override
	public String toString() {
		return "LaboratoryTest [id=" + id + ", employeeCode=" + employeeCode + ", serologicalTestId="
				+ serologicalTestId + ", hemoglobin=" + hemoglobin + ", hemoglobinStateId=" + hemoglobinStateId
				+ ", bloodCountId=" + bloodCountId + ", observation=" + observation + ", updatedAt=" + updatedAt
				+ ", isFinished=" + isFinished + ", emrPacientCode=" + emrPacientCode + ", emrHealthPlanId="
				+ emrHealthPlanId + "]";
	}
}
