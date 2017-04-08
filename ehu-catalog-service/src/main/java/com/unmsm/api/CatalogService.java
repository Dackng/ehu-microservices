package com.unmsm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unmsm.catalog.Catalog;
import com.unmsm.catalog.CatalogRepository;
import com.unmsm.catalog.NamesField;
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
	
	public List<Catalog> getElementsListByIdPrimary(PrimaryGroup idPrimary){
		return catalogRepository.findElementsListByIdPrimary(idPrimary.getValue());
	}
	
	/**
	 * This method will return a list of only one element where this element is the first
	 * of primary group ordered asc
	 * @param idPrimary
	 * @return
	 */
	public Catalog getFirstElementOfPrimaryGroup(PrimaryGroup idPrimary){
		List<Catalog> list = catalogRepository.findTop1ByIdPrimary(idPrimary.getValue(), 
				sortByIdAsc(NamesField.ID_SECONDARY.getValue()));
		return list != null ? list.get(0) : null; 
	}
	
	private Sort sortByIdAsc(String catalogNameField) {
        return new Sort(Sort.Direction.ASC, catalogNameField);
    }
}
