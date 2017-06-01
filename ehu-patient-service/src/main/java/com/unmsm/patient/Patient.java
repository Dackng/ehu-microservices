package com.unmsm.patient;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unmsm.ubigeo.Ubigeo;

@Entity
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private Integer code;
	private String names;
	private String paternalSurname;
	private String maternalSurname;
	private Integer civilStateId;
	private String civilStateName;
	private String email;
	private Integer eapId;
	private String eapName;
	private Date birthDate;
	private Integer telephone;
	private Character gender;
	private String address;
	private Ubigeo ubigeo;
	
	public Patient(){}
	
	public Patient(Integer code, String names, String paternalSurname, String maternalSurname){
		this.code = code;
		this.names = names;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getPaternalSurname() {
		return paternalSurname;
	}
	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}
	public String getMaternalSurname() {
		return maternalSurname;
	}
	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}
	public Integer getCivilStateId() {
		return civilStateId;
	}
	public void setCivilStateId(Integer civilStateId) {
		this.civilStateId = civilStateId;
	}
	@Transient
	public String getCivilStateName() {
		return civilStateName;
	}
	public void setCivilStateName(String civilStateName) {
		this.civilStateName = civilStateName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEapId() {
		return eapId;
	}
	public void setEapId(Integer eapId) {
		this.eapId = eapId;
	}
	@Transient
	public String getEapName() {
		return eapName;
	}
	public void setEapName(String eapName) {
		this.eapName = eapName;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getBirthDate() {
		return birthDate; 
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	@Embedded
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", code=" + code + ", names=" + names + ", paternalSurname=" + paternalSurname
				+ ", maternalSurname=" + maternalSurname + ", civilStateId=" + civilStateId + ", civilStateName="
				+ civilStateName + ", email=" + email + ", eapId=" + eapId + ", eapName=" + eapName + ", birthDate=" + birthDate
				+ ", telephone=" + telephone + ", gender=" + gender + ", address=" + address + ", ubigeo=" + ubigeo
				+ "]";
	}
}
