package com.unmsm.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.ubigeo.Ubigeo;

@RestController
@RequestMapping(path = "/api")
public class UbigeoController {

	private UbigeoService ubigeoService;
	
	@Autowired
	public UbigeoController(UbigeoService ubigeoService){
		this.ubigeoService = ubigeoService;
	}
	
	@RequestMapping(path = "/list/departments", method = RequestMethod.GET, name = "getDepartmentsList")
	public ResponseEntity<List<Ubigeo>> getDepartmentsList(){
		return Optional.ofNullable(ubigeoService.getDepartmentsList())
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/provinces/{departmentCode}", method = RequestMethod.GET, name = "getProvincesListByDepartmentCode")
	public ResponseEntity<List<Ubigeo>> getProvincesListByDepartmentCode(
			@PathVariable("departmentCode") String departmentCode){
		return Optional.ofNullable(ubigeoService.getProvincesListByDepartmentCode(departmentCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/districts/{provinceCode}", method = RequestMethod.GET, name = "getDistrictsListByProvinceCode")
	public ResponseEntity<List<Ubigeo>> getDistrictsListByProvinceCode(
			@PathVariable("provinceCode") String provinceCode){
		return Optional.ofNullable(ubigeoService.getDistrictsListByProvinceCode(provinceCode))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/element/ubigeo/{code}", method = RequestMethod.GET, name = "getUbigeoByCode")
	public ResponseEntity<Ubigeo> getUbigeoByCode(@PathVariable("code") String code){
		return Optional.ofNullable(ubigeoService.getUbigeoByCode(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
