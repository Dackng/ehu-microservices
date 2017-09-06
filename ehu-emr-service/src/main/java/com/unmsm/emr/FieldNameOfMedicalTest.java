package com.unmsm.emr;

public enum FieldNameOfMedicalTest {
	IS_FINISHED("isFinished");
	
	private String value;
	private FieldNameOfMedicalTest(String value){ 
		this.value = value; 
	}
	public String getValue() {
        return value;
    }
}
