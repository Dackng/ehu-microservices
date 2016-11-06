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

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.PrimaryGroup;

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
	
	private CatalogService catalogService;
	
	@Autowired	
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService; 
	}
	
	@RequestMapping(path = "/element/civil-status/{idSecondary}", method = RequestMethod.GET, name = "findCivilStatusByIdSecondary")
	public ResponseEntity<Catalog> findCivilStatusByIdSecondary(
			@PathVariable("idSecondary") Long idSecondary){
		return Optional.ofNullable(catalogService.findElementByIdPrimaryAndIdSecondary(PrimaryGroup.CIVIL_STATUS, idSecondary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/list/civil-status", method = RequestMethod.GET, name = "getCivilStatusList")
	public ResponseEntity<List<Catalog>> getCivilStatusList(){
		return Optional.ofNullable(catalogService.findElementsListByIdPrimary(PrimaryGroup.CIVIL_STATUS))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
}
