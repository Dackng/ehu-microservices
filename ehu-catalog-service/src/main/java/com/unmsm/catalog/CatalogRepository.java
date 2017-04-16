package com.unmsm.catalog;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends 	CrudRepository<Catalog, Long> {
	
	Catalog findElementByPrimaryIdAndSecondaryId(Long primaryId, Long secondaryId);
	
	List<Catalog> findElementsListByPrimaryId(Long primaryId);
	
	/**
	 * Find the first element in a primary group where it will ordered.
	 * This "Top1" return only 1 row 
	 * @param primaryId
	 * @return
	 */
	List<Catalog> findTop1ByPrimaryId(Long primaryId, Sort sortSecondaryIdAsc);
}
