package com.unmsm.phr;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String names;
	private String paternalSurname;
	private String maternalSurname;
	private String civilState;
	private String email;
	private String eap;
	private Date birthDate;
	private Integer telephone;
	private String gender;
	private String address;
	private Ubigeo ubigeo;
	
	public Patient(){}
	
	public Patient(Integer code, String names, String paternalSurname, String maternalSurname,
			String civilState, String email, String  eap, Date birthDate, Integer telephone, String gender,
			String address, Ubigeo ubigeo){
		this.code = code;
		this.names = names;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
		this.civilState = civilState;
		this.email = email;
		this.eap = eap;
		this.birthDate = birthDate;
		this.telephone = telephone;
		this.gender = gender;
		this.address = address;
		this.ubigeo = ubigeo;
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
	public String getCivilState() {
		return civilState;
	}
	public void setCivilState(String civilState) {
		this.civilState = civilState;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEap() {
		return eap;
	}
	public void setEap(String eap) {
		this.eap = eap;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	@Override
	public String toString() {
		return "Patient [code=" + code + ", names=" + names + ", paternalSurname=" + paternalSurname
				+ ", maternalSurname=" + maternalSurname + ", civilState=" + civilState + ", email=" + email + ", eap="
				+ eap + ", birthDate=" + birthDate + ", telephone=" + telephone + ", gender=" + gender + ", address="
				+ address + ", ubigeo=" + ubigeo + "]";
	}
}
