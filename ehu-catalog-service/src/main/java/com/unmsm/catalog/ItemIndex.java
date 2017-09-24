package com.unmsm.catalog;

public enum ItemIndex {
    FIRST_ITEM(0),
    SECOND_ITEM(1),
	THIRD_ITEM(2),
	FOURTH_ITEM(3);
	private Integer value;
	
	private ItemIndex(Integer value){ 
		this.value = value; 
	}
	public Integer getValue() {
        return value;
    }
}
