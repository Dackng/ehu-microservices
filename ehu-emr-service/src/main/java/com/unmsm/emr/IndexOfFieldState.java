package com.unmsm.emr;

public enum IndexOfFieldState {
    FIRST_STATE(0),
    SECOND_STATE(1),
	THIRD_STATE(2);
	private Integer value;
	
	private IndexOfFieldState(Integer value){ 
		this.value = value; 
	}
	public Integer getValue() {
        return value;
    }
}
