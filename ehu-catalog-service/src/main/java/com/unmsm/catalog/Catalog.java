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
	private Long idPrimary;
	private Long idSecondary;
	private String name;
	private String description;
	
	public Catalog(){}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPrimary() {
		return idPrimary;
	}
	public void setIdPrimary(Long idPrimary) {
		this.idPrimary = idPrimary;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", idPrimary=" + idPrimary + ", idSecondary=" + idSecondary + ", name=" + name
				+ ", description=" + description + "]";
	}
	
}
