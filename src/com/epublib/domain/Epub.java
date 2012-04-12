package com.epublib.domain;

/**
 * Epub entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Epub implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer categoryid;
	private String name;
	private String picurl;
	private String fileurl;
	private String description;
	private Integer sourtnum;

	// Constructors

	/** default constructor */
	public Epub() {
	}

	/** full constructor */
	public Epub(Integer categoryid, String name, String picurl, String fileurl,
			String description, Integer sourtnum) {
		this.categoryid = categoryid;
		this.name = name;
		this.picurl = picurl;
		this.fileurl = fileurl;
		this.description = description;
		this.sourtnum = sourtnum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getFileurl() {
		return this.fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSourtnum() {
		return this.sourtnum;
	}

	public void setSourtnum(Integer sourtnum) {
		this.sourtnum = sourtnum;
	}

}