package com.unmsm.medicaltest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unmsm.emr.Emr;

@Entity
public class MedicalTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer typeId;
	private String typeName;
	private String stateName;
	private String color;
	private Boolean isFinished;
	@JsonIgnore
	private Emr emr;
	
	public MedicalTest(){}
	
	public MedicalTest(Integer typeId, Emr emr){
		this.typeId = typeId;
		this.isFinished = false; //by default
		this.emr = emr;
	}
	
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
	public Boolean getIsFinished() {
		return isFinished;
	}
	@Transient
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Transient
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Transient
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
	@ManyToOne
	public Emr getEmr() {
		return emr;
	}
	public void setEmr(Emr emr) {
		this.emr = emr;
	}

	@Override
	public String toString() {
		return "MedicalTest [id=" + id + ", typeId=" + typeId + ", typeName=" + typeName 
				+ ", stateName=" + stateName + ", color=" + color
				+ ", isFinished=" + isFinished + "]";
	}
}
