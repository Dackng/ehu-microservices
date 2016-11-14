package com.unmsm.catalog;

public enum NamesField {
	ID_SECONDARY("idSecondary"),
    NAME("name");
	
	private String value;
	
	private NamesField(String value){ 
		this.value = value; 
	}
	
	public String getValue() {
        return value;
    }
}
