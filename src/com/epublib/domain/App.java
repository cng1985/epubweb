package com.epublib.domain;

/**
 * App entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class App implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String key;
	private String contents;

	// Constructors

	/** default constructor */
	public App() {
	}

	/** full constructor */
	public App(String name, String key, String contents) {
		this.name = name;
		this.key = key;
		this.contents = contents;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}