package com.unmsm.ubigeo;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Ubigeo{
	
	private String ubigeoCode;
	private String departmentCode;
	private String departmentDescription;
	private String provinceCode;
	private String provinceDescription;
	private String districtCode;
	private String districtDescription;
	
	public Ubigeo(){}
	
	public String getUbigeoCode() {
		return ubigeoCode;
	}
	public void setUbigeoCode(String ubigeoCode) {
		this.ubigeoCode = ubigeoCode;
	}
	@Transient
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	@Transient
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	@Transient
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	@Transient
	public String getProvinceDescription() {
		return provinceDescription;
	}
	public void setProvinceDescription(String provinceDescription) {
		this.provinceDescription = provinceDescription;
	}
	@Transient
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	@Transient
	public String getDistrictDescription() {
		return districtDescription;
	}
	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}

	@Override
	public String toString() {
		return "Ubigeo [ubigeoCode=" + ubigeoCode + ", departmentCode=" + departmentCode + ", departmentDescription="
				+ departmentDescription + ", provinceCode=" + provinceCode + ", provinceDescription="
				+ provinceDescription + ", districtCode=" + districtCode + ", districtDescription="
				+ districtDescription + "]";
	}
}
