package com.unmsm.pacient;

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
public class Pacient implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private Long code;
	private String names;
	private String paternalSurname;
	private String maternalSurname;
	private Long civilStatusId;
	private String civilStatusName;
	private String email;
	private Long medicalStatusId;
	private String medicalStatusName;
	private Long eapId;
	private String eapName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	private Long telephone;
	private Character gender;
	private String address;
	private Ubigeo ubigeo;
	
	public Pacient(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
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
	public Long getCivilStatusId() {
		return civilStatusId;
	}
	public void setCivilStatusId(Long civilStatusId) {
		this.civilStatusId = civilStatusId;
	}
	@Transient
	public String getCivilStatusName() {
		return civilStatusName;
	}
	public void setCivilStatusName(String civilStatusName) {
		this.civilStatusName = civilStatusName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMedicalStatusId() {
		return medicalStatusId;
	}
	public void setMedicalStatusId(Long medicalStatusId) {
		this.medicalStatusId = medicalStatusId;
	}
	@Transient
	public String getMedicalStatusName() {
		return medicalStatusName;
	}
	public void setMedicalStatusName(String medicalStatusName) {
		this.medicalStatusName = medicalStatusName;
	}
	public Long getEapId() {
		return eapId;
	}
	public void setEapId(Long eapId) {
		this.eapId = eapId;
	}
	@Transient
	public String getEapName() {
		return eapName;
	}
	public void setEapName(String eapName) {
		this.eapName = eapName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
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
		return "Pacient [id=" + id + ", code=" + code + ", names=" + names + ", paternalSurname=" + paternalSurname
				+ ", maternalSurname=" + maternalSurname + ", civilStatusId=" + civilStatusId + ", civilStatusName="
				+ civilStatusName + ", email=" + email + ", medicalStatusId=" + medicalStatusId + ", medicalStatusName="
				+ medicalStatusName + ", eapId=" + eapId + ", eapName=" + eapName + ", birthDate=" + birthDate
				+ ", telephone=" + telephone + ", gender=" + gender + ", address=" + address + ", ubigeo=" + ubigeo
				+ "]";
	}
}
