package com.epublib.domain;

/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer name;
	private Integer pid;
	private String username;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Integer name, Integer pid, String username) {
		this.name = name;
		this.pid = pid;
		this.username = username;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return this.name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}