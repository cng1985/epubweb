package com.epublib.domain;

import java.util.Date;

/**
 * Userinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private String username;
	private String userpassword;
	private Date lastlogintime;
	private Integer loginsize;
	private Long lastpi;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username) {
		this.username = username;
	}

	/** full constructor */
	public Userinfo(String username, String userpassword, Date lastlogintime,
			Integer loginsize, Long lastpi) {
		this.username = username;
		this.userpassword = userpassword;
		this.lastlogintime = lastlogintime;
		this.loginsize = loginsize;
		this.lastpi = lastpi;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Date getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public Integer getLoginsize() {
		return this.loginsize;
	}

	public void setLoginsize(Integer loginsize) {
		this.loginsize = loginsize;
	}

	public Long getLastpi() {
		return this.lastpi;
	}

	public void setLastpi(Long lastpi) {
		this.lastpi = lastpi;
	}

}