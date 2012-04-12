package com.epublib.domain;

import java.util.Date;

/**
 * Request entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Request implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appid;
	private String appname;
	private Date accessdate;
	private Integer size;
	private Integer hour;

	// Constructors

	/** default constructor */
	public Request() {
	}

	/** full constructor */
	public Request(Integer appid, String appname, Date accessdate,
			Integer size, Integer hour) {
		this.appid = appid;
		this.appname = appname;
		this.accessdate = accessdate;
		this.size = size;
		this.hour = hour;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppid() {
		return this.appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public Date getAccessdate() {
		return this.accessdate;
	}

	public void setAccessdate(Date accessdate) {
		this.accessdate = accessdate;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

}