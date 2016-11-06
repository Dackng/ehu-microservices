package com.unmsm.catalog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends 	CrudRepository<Catalog, Long> {
	
	Catalog findElementByIdPrimaryAndIdSecondary(Long idPrimary, Long idSecondary);
	
	List<Catalog> findElementsListByIdPrimary(Long idPrimary);
}
