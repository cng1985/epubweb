package com.epublib.domain;

/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer pid;
	private String username;
	private String title;
	// Constructors

	/** default constructor */
	public Category() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public Category(Integer id, Integer userid, Integer pid, String username,
			String title) {
		super();
		this.id = id;
		this.userid = userid;
		this.pid = pid;
		this.username = username;
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}