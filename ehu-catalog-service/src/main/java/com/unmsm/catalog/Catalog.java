package com.unmsm.catalog;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Catalog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long id;
	private Integer primaryId;
	private Integer secondaryId;
	private String name;
	private String description;
	private Character state;
	
	public Catalog(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getState() {
		return state;
	}
	public void setState(Character state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", primaryId=" + primaryId + ", secondaryId=" + secondaryId + ", name=" + name
				+ ", description=" + description + ", state=" + state + "]";
	}
}
