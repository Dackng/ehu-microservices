package com.unmsm.catalog;

/**
 * The fields should be equals to JSON fields
 * @author diego
 *
 */
public class Catalog {

	private Integer secondaryId;
	private String name;

	public Integer getSecondaryId() {
		return secondaryId;
	}
	public void setSecondaryId(Integer secondaryId) {
		this.secondaryId = secondaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
