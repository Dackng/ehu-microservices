package com.unmsm.pacient;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.unmsm.ubigeo.Ubigeo;

@Entity
public class Pacient implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long code;
	private String names;
	private String paternalSurname;
	private String maternalSurname;
	private Long idCivilStatus;
	private String nameCivilStatus;
	private String email;
	private Long idMedicalStatus;
	private String nameMedicalStatus;
	private Long idEap;
	private String nameEap;
	private Date birthDate;
	private Long telephone;
	private Character sex;
	private Ubigeo ubigeo;
	
	public Pacient(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
	public Long getIdCivilStatus() {
		return idCivilStatus;
	}
	public void setIdCivilStatus(Long idCivilStatus) {
		this.idCivilStatus = idCivilStatus;
	}
	@Transient
	public String getNameCivilStatus() {
		return nameCivilStatus;
	}
	public void setNameCivilStatus(String nameCivilStatus) {
		this.nameCivilStatus = nameCivilStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdMedicalStatus() {
		return idMedicalStatus;
	}
	public void setIdMedicalStatus(Long idMedicalStatus) {
		this.idMedicalStatus = idMedicalStatus;
	}
	@Transient
	public String getNameMedicalStatus() {
		return nameMedicalStatus;
	}
	public void setNameMedicalStatus(String nameMedicalStatus) {
		this.nameMedicalStatus = nameMedicalStatus;
	}
	public Long getIdEap() {
		return idEap;
	}
	public void setIdEap(Long idEap) {
		this.idEap = idEap;
	}
	@Transient
	public String getNameEap() {
		return nameEap;
	}
	public void setNameEap(String nameEap) {
		this.nameEap = nameEap;
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
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	
	@Embedded
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	@Override
	public String toString() {
		return "Pacient [id=" + id + ", code=" + code + ", names=" + names + ", paternalSurname=" + paternalSurname
				+ ", maternalSurname=" + maternalSurname + ", idCivilStatus=" + idCivilStatus + ", nameCivilStatus="
				+ nameCivilStatus + ", email=" + email + ", idMedicalStatus=" + idMedicalStatus + ", nameMedicalStatus="
				+ nameMedicalStatus + ", idEap=" + idEap + ", nameEap=" + nameEap + ", birthDate=" + birthDate
				+ ", telephone=" + telephone + ", sex=" + sex + ", ubigeo=" + ubigeo + "]";
	}

}
