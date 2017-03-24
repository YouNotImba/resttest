package com.someco.entity;

import java.util.UUID;

/**
 * @author ikarmatsky
 *
 */
public class Data implements DomainObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8247230708416369968L;
	
	private UUID id;
	private String description;
	
	public Data() {
		super();
	}

	public Data(UUID id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
