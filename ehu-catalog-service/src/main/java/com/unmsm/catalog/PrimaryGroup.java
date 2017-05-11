package com.unmsm.catalog;

public enum PrimaryGroup {
    CIVIL_STATE(1L),
    EMR_STATE(2L),
	EAP(3L),
	GENDER(4L);
	
	private Long value;
	
	private PrimaryGroup(Long value){ 
		this.value = value; 
	}
	
	public Long getValue() {
        return value;
    }

}
