package com.unmsm.laboratory;

public enum FieldValue {
    FINISHED(true),
    NOT_FINISH(false);
	
	private Boolean value;
	
	private FieldValue(Boolean value){ 
		this.value = value; 
	}
	public Boolean getValue() {
        return value;
    }
}
