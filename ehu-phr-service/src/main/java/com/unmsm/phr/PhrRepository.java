package com.unmsm.phr;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhrRepository extends PagingAndSortingRepository<Phr, String> {

	@Query("{ 'patientSummary.code' : ?0 }")
	Phr findByPatientCode(Integer patientCode);
}
