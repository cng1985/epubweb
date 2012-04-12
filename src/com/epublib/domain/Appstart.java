package com.epublib.domain;

import java.util.Date;

/**
 * Appstart entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Appstart implements java.io.Serializable {

	// Fields

	private Integer id;
	private String appname;
	private String appversion;
	private String sdkversion;
	private Date accesstime;
	private Long ip;

	// Constructors

	/** default constructor */
	public Appstart() {
	}

	/** full constructor */
	public Appstart(String appname, String appversion, String sdkversion,
			Date accesstime, Long ip) {
		this.appname = appname;
		this.appversion = appversion;
		this.sdkversion = sdkversion;
		this.accesstime = accesstime;
		this.ip = ip;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getAppversion() {
		return this.appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public String getSdkversion() {
		return this.sdkversion;
	}

	public void setSdkversion(String sdkversion) {
		this.sdkversion = sdkversion;
	}

	public Date getAccesstime() {
		return this.accesstime;
	}

	public void setAccesstime(Date accesstime) {
		this.accesstime = accesstime;
	}

	public Long getIp() {
		return this.ip;
	}

	public void setIp(Long ip) {
		this.ip = ip;
	}

}