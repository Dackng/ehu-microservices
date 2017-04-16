package com.unmsm.catalog;

/**
 * The fields should be equals to JSON fields
 * @author diego
 *
 */
public class Catalog {

	private Long secondaryId;
	private String name;

	public Long getSecondaryId() {
		return secondaryId;
	}
	public void setSecondaryId(Long secondaryId) {
		this.secondaryId = secondaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
