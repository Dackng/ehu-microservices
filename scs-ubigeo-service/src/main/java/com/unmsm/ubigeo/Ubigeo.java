package com.unmsm.ubigeo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ubigeo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private String code;
	private String departmentCode;
	private String departmentDescription;
	private String provinceCode;
	private String provinceDescription;
	private String districtCode;
	private String districtDescription;
	
	public Ubigeo(){}
	
	public Ubigeo(String departmentCode, String departmentDescription, String provinceCode, 
			String provinceDescription, String districtCode, String districtDescription){
		this.departmentCode = departmentCode;
		this.departmentDescription = departmentDescription;
		this.provinceCode = provinceCode;
		this.provinceDescription = provinceDescription;
		this.districtCode = districtCode;
		this.districtDescription = districtDescription;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceDescription() {
		return provinceDescription;
	}
	public void setProvinceDescription(String provinceDescription) {
		this.provinceDescription = provinceDescription;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictDescription() {
		return districtDescription;
	}
	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}
	@Override
	public String toString() {
		return "Ubigeo [id=" + id + ", code=" + code + ", departmentCode=" + departmentCode + ", departmentDescription="
				+ departmentDescription + ", provinceCode=" + provinceCode + ", provinceDescription="
				+ provinceDescription + ", districtCode=" + districtCode + ", districtDescription="
				+ districtDescription + "]";
	}
}
