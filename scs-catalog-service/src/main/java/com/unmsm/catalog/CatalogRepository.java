package com.unmsm.catalog;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends 	CrudRepository<Catalog, Long> {
	
	Catalog findElementByIdPrimaryAndIdSecondary(Long idPrimary, Long idSecondary);
	
	List<Catalog> findElementsListByIdPrimary(Long idPrimary);
	
	/**
	 * Find the first element in a primary group where it will ordered.
	 * This "Top1" return only 1 row 
	 * @param idPrimary
	 * @return
	 */
	List<Catalog> findTop1ByIdPrimary(Long idPrimary, Sort sortIdSecondaryAsc);
}
