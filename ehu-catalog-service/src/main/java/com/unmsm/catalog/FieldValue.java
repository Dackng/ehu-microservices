package com.unmsm.catalog;

public enum FieldValue {
	MALE('M'),
    FEMALE('F'),
    ACTIVE('1'),
    INACTIVE('0');
	private Character value;
	private FieldValue(Character value){ 
		this.value = value; 
	}
	public Character getValue() {
        return value;
    }
}
