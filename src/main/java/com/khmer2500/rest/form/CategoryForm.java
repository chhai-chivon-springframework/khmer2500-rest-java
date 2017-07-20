package com.khmer2500.rest.form;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("DESCRIPTION")
	private String description;
	@JsonProperty("DATE")
	private Date date;
	@JsonProperty("USER")
	private Long userId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return userId;
	}
	public void setId(Long userId) {
		this.userId= userId;
	}
}
