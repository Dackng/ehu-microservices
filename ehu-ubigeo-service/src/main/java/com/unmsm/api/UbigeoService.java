package com.unmsm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.ubigeo.Ubigeo;
import com.unmsm.ubigeo.UbigeoRepository;

@Service
public class UbigeoService {
	
	private UbigeoRepository ubigeoRepository;
	
	@Autowired
	public UbigeoService(UbigeoRepository ubigeoRepository){
		this.ubigeoRepository = ubigeoRepository;
	}
	
	public List<Ubigeo> getDepartmentsList(){
		return ubigeoRepository.findDepartments();
	}
	
	public List<Ubigeo> getProvincesListByDepartmentCode(String departmentCode){
		return ubigeoRepository.findProvincesByDepartmentCode(departmentCode);
	}
	
	public List<Ubigeo> getDistrictsListByProvinceCode(String provinceCode){
		return ubigeoRepository.findDistrictsByProvinceCode(provinceCode);
	}
	
	public Ubigeo getUbigeoByCode(String code){
		return ubigeoRepository.findUbigeoByCode(code);
	}
}
