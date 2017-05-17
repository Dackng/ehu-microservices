package com.unmsm.generalmedicine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GeneralMedicineTest implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer id;
	private String employeeCode;
	private Double weight;
	private Double stature;
	private Integer pulse;
	private Date lmp;
	private Integer systolic;
	private Integer diastolic;
	private Double rightEye;
	private Double leftEye;
	private Date updatedAt;
	private Boolean isFinished;
	private Integer emrPacientCode;
	private Integer emrHealthPlanId;
	
	public GeneralMedicineTest(){}
	
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getStature() {
		return stature;
	}
	public void setStature(Double stature) {
		this.stature = stature;
	}
	public Integer getPulse() {
		return pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}
	public Date getLmp() {
		return lmp;
	}
	public void setLmp(Date lmp) {
		this.lmp = lmp;
	}
	public Integer getSystolic() {
		return systolic;
	}
	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}
	public Integer getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}
	public Double getRightEye() {
		return rightEye;
	}
	public void setRightEye(Double rightEye) {
		this.rightEye = rightEye;
	}
	public Double getLeftEye() {
		return leftEye;
	}
	public void setLeftEye(Double leftEye) {
		this.leftEye = leftEye;
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
	public Integer getEmrPacientCode() {
		return emrPacientCode;
	}
	public void setEmrPacientCode(Integer emrPacientCode) {
		this.emrPacientCode = emrPacientCode;
	}
	public Integer getEmrHealthPlanId() {
		return emrHealthPlanId;
	}
	public void setEmrHealthPlanId(Integer emrHealthPlanId) {
		this.emrHealthPlanId = emrHealthPlanId;
	}
	@PreUpdate
	protected void onUpdate() {
	    updatedAt = new Date();
	}

	@Override
	public String toString() {
		return "GeneralMedicineTest [id=" + id + ", employeeCode=" + employeeCode + ", weight=" + weight + ", stature="
				+ stature + ", pulse=" + pulse + ", lmp=" + lmp + ", systolic=" + systolic + ", diastolic=" + diastolic
				+ ", rightEye=" + rightEye + ", leftEye=" + leftEye + ", updatedAt=" + updatedAt + ", isFinished="
				+ isFinished + ", emrPacientCode=" + emrPacientCode + ", emrHealthPlanId=" + emrHealthPlanId + "]";
	}
}
