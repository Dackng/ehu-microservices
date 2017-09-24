package com.unmsm.medicaltest;

public enum FieldValue {
	FOUR_MEDICAL_TEST(4),//for new patient
    TWO_MEDICAL_TEST(2);//for old patient
	private Integer value;
	private FieldValue(Integer value){ 
		this.value = value; 
	}
	public Integer getValue() {
        return value;
    }
}
