package com.unmsm.catalog;

public enum FieldName {
	SECONDARY_ID("secondaryId"),
    NAME("name");
	private String value;
	private FieldName(String value){ 
		this.value = value; 
	}
	public String getValue() {
        return value;
    }
}
