package com.unmsm.ubigeo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UbigeoRepository extends CrudRepository<Ubigeo, Long>{
	
	@Query("SELECT new Ubigeo(u.departmentCode, u.departmentDescription, '', '', '', '') "
			+ " FROM Ubigeo u GROUP BY u.departmentCode ORDER BY u.departmentDescription")
	List<Ubigeo> findDepartments();
	
	@Query("SELECT new Ubigeo('', '', u.provinceCode, u.provinceDescription, '', '') "
			+ " FROM Ubigeo u WHERE u.departmentCode = :departmentCode"
			+ " GROUP BY u.provinceCode ORDER BY u.provinceDescription")
	List<Ubigeo> findProvincesByDepartmentCode(@Param("departmentCode")String departmentCode);
	
	@Query("SELECT new Ubigeo('', '', '', '', u.districtCode, u.districtDescription)"
			+ " FROM Ubigeo u WHERE u.provinceCode = :provinceCode"
			+ " GROUP BY u.districtCode ORDER BY u.districtDescription")
	List<Ubigeo> findDistrictsByProvinceCode(@Param("provinceCode")String provinceCode);
	
	Ubigeo findUbigeoByCode(String code);
}
