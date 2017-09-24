package com.unmsm.phr;

import java.io.Serializable;

public class Ubigeo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String departmentDescription;
	private String provinceDescription;
	private String districtDescription;
	
	public Ubigeo(){}
	
	public Ubigeo(String departmentDescription, String provinceDescription
			, String districtDescription){
		this.departmentDescription = departmentDescription;
		this.provinceDescription = provinceDescription;
		this.districtDescription = districtDescription;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getProvinceDescription() {
		return provinceDescription;
	}
	public void setProvinceDescription(String provinceDescription) {
		this.provinceDescription = provinceDescription;
	}
	public String getDistrictDescription() {
		return districtDescription;
	}
	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}
	
	@Override
	public String toString() {
		return "Ubigeo [departmentDescription=" + departmentDescription + ", provinceDescription="
				+ provinceDescription + ", districtDescription=" + districtDescription + "]";
	}
}
