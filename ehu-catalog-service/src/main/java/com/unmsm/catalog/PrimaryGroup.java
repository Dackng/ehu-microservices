package com.unmsm.catalog;

public enum PrimaryGroup {
    CIVIL_STATE(1),
    EMR_STATE(2),
	EAP(3),
	GENDER(4);
	private Integer value;
	
	private PrimaryGroup(Integer value){ 
		this.value = value; 
	}
	public Integer getValue() {
        return value;
    }
}
