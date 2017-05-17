package com.unmsm.catalog;

public enum FieldNames {
	SECONDARY_ID("secondaryId"),
    NAME("name");
	private String value;
	private FieldNames(String value){ 
		this.value = value; 
	}
	public String getValue() {
        return value;
    }
}
