package com.unmsm.catalog;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends 	CrudRepository<Catalog, Integer> {
	
	Catalog findElementByPrimaryIdAndSecondaryId(Integer primaryId, Integer secondaryId);
	
	List<Catalog> findElementsListByPrimaryId(Integer primaryId);
	
	/**
	 * Find the first element in a primary group where it will ordered.
	 * This "Top1" return only 1 row 
	 * @param primaryId
	 * @return
	 */
	List<Catalog> findTop1ByPrimaryId(Integer primaryId, Sort sortSecondaryIdAsc);

	Catalog findElementByPrimaryIdAndState(Integer primaryId, Character state);
}
