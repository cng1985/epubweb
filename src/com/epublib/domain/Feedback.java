package com.epublib.domain;

import java.util.Date;

/**
 * Feedback entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appid;
	private String appname;
	private String messages;
	private String appversion;
	private String sdkversion;
	private Date pubdate;

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(Integer appid, String appname, String messages,
			String appversion, String sdkversion, Date pubdate) {
		this.appid = appid;
		this.appname = appname;
		this.messages = messages;
		this.appversion = appversion;
		this.sdkversion = sdkversion;
		this.pubdate = pubdate;
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

	public String getMessages() {
		return this.messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
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

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

}