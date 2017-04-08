package com.unmsm.catalog;

/**
 * The fields should be equals to JSON fields
 * @author diego
 *
 */
public class Catalog {

	private Long idSecondary;
	private String name;

	public Long getIdSecondary() {
		return idSecondary;
	}
	public void setIdSecondary(Long idSecondary) {
		this.idSecondary = idSecondary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
