package com.unmsm.laboratory;

public enum Constants {
    FINISHED(true),
    NOT_FINISH(false);
	
	private Boolean value;
	
	private Constants(Boolean value){ 
		this.value = value; 
	}
	public Boolean getValue() {
        return value;
    }
}
