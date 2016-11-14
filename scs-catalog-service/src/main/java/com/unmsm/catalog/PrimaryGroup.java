package com.unmsm.catalog;

public enum PrimaryGroup {
    CIVIL_STATUS(1L),
    MEDICAL_STATUS(2L),
	EAP(3L);
	
	private Long value;
	
	private PrimaryGroup(Long value){ 
		this.value = value; 
	}
	
	public Long getValue() {
        return value;
    }

}
