package com.unmsm.symptom;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.unmsm.generalmedicine.GeneralMedicineTest;

@Entity
public class Symptom implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer typeId;
	private String typeName;
	private Integer cieId;
	private String cieName;
	@JsonDeserialize(using=CustomerDateAndTimeDeserialize .class)
	private Date appointment;
	private String observation;
	@JsonIgnore
	private GeneralMedicineTest generalMedicineTest;
	
	public Symptom(){}
	
	public Symptom(Integer typeId, Integer cieId, Date appointmet, String observation, GeneralMedicineTest generalMedicineTest){
		this.typeId = typeId;
		this.cieId = cieId;
		this.appointment = appointmet;
		this.observation = observation;
		this.generalMedicineTest = generalMedicineTest;
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
	@Transient
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getCieId() {
		return cieId;
	}
	public void setCieId(Integer cieId) {
		this.cieId = cieId;
	}
	@Transient
	public String getCieName() {
		return cieName;
	}
	public void setCieName(String cieName) {
		this.cieName = cieName;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAppointment() {
		return appointment;
	}
	public void setAppointment(Date appointment) {
		this.appointment = appointment;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	@ManyToOne
	public GeneralMedicineTest getGeneralMedicineTest() {
		return generalMedicineTest;
	}
	public void setGeneralMedicineTest(GeneralMedicineTest generalMedicineTest) {
		this.generalMedicineTest = generalMedicineTest;
	}

	@Override
	public String toString() {
		return "Symptom [id=" + id + ", typeId=" + typeId + ", typeName=" + typeName + ", cieId=" + cieId + ", cieName="
				+ cieName + ", appointment=" + appointment + ", observation=" + observation  + "]";
	}
}
