package com.unmsm.catalog;

public enum NamesField {
	SECONDARY_ID("secondaryId"),
    NAME("name");
	
	private String value;
	
	private NamesField(String value){ 
		this.value = value; 
	}
	
	public String getValue() {
        return value;
    }
}
