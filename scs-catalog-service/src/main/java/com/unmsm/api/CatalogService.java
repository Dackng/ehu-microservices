package com.unmsm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.CatalogRepository;
import com.unmsm.catalog.PrimaryGroup;

@Service
public class CatalogService {

	private CatalogRepository catalogRepository;
	
	@Autowired	
	public CatalogService(CatalogRepository catalogRepository){
		this.catalogRepository = catalogRepository;
	}
	
	public Catalog findElementByIdPrimaryAndIdSecondary(PrimaryGroup idPrimary, Long idSecondary){
		return catalogRepository.findElementByIdPrimaryAndIdSecondary(idPrimary.getValue(), idSecondary);
	}
	
	public List<Catalog> findElementsListByIdPrimary(PrimaryGroup idPrimary){
		return catalogRepository.findElementsListByIdPrimary(idPrimary.getValue());
	}
}
