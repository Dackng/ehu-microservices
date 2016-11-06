package com.unmsm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.CatalogRepository;

@Service
public class CatalogService {

	private CatalogRepository catalogRepository;
	
	@Autowired	
	public CatalogService(CatalogRepository catalogRepository){
		this.catalogRepository = catalogRepository;
	}
	
	public Catalog findElementNameByIdPrimaryAndIdSecondary(Long idPrimary, Long idSecondary){
		return catalogRepository.findElementNameByIdPrimaryAndIdSecondary(idPrimary, idSecondary);
	}
	
	public List<Catalog> findElementsGroupByIdPrimary(Long idPrimary){
		return catalogRepository.findElementsGroupByIdPrimary(idPrimary);
	}
}
