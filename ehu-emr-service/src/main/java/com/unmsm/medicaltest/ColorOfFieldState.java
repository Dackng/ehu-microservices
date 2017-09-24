package com.unmsm.medicaltest;

public enum ColorOfFieldState {
    INFO("info"),
    PRIMARY("primary"),
	SUCCESS("success"),
	DANGER("danger"),
	WARNING("warning");
	private String value;
	
	private ColorOfFieldState(String value){ 
		this.value = value; 
	}
	public String getValue() {
        return value;
    }
}
