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

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
	
	private CatalogService catalogService;
	
	@Autowired	
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService; 
	}
	
	@RequestMapping(path = "/element/{idPrimary}/{idSecondary}", method = RequestMethod.GET, name = "findElementNameByIdPrimaryAndIdSecondary")
	public ResponseEntity<Catalog> getElementNameById(
			@PathVariable("idPrimary") Long idPrimary, @PathVariable("idSecondary") Long idSecondary){
		return Optional.ofNullable(catalogService.findElementNameByIdPrimaryAndIdSecondary(idPrimary, idSecondary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(path = "/elements/{idPrimary}", method = RequestMethod.GET, name = "findElementsGroupByIdPrimary")
	public ResponseEntity<List<Catalog>> getElementsGroupById(@PathVariable("idPrimary") Long idPrimary){
		return Optional.ofNullable(catalogService.findElementsGroupByIdPrimary(idPrimary))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
}
