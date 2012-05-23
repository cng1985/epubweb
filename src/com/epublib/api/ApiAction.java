package com.epublib.api;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.baoyi.dao.EpubDaoImpl;
import com.epublib.domain.Epub;
import com.google.gson.Gson;

public class ApiAction {

	public EpubDaoImpl getEpubDaoImpl() {
		return epubDaoImpl;
	}

	public void setEpubDaoImpl(EpubDaoImpl epubDaoImpl) {
		this.epubDaoImpl = epubDaoImpl;
	}

	public Integer getCurpage() {
		return curpage;
	}

	public void setCurpage(Integer curpage) {
		this.curpage = curpage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private EpubDaoImpl epubDaoImpl;
	private String json;
	private Integer curpage;
	private Integer id;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	private CacheManager cacheManager;

	public String CategoryApi() {
		return "success";
	}

	/**
	 * 根据目录id查找目录下面的所有内容
	 * http://localhost:8080/epubweb/Epubs_By_CategoryApi.ada?id=0&curpage=1
	 * 
	 * @return
	 */
	public String Epubs_By_CategoryApi() {
		String key = "Epubs_By_CategoryApi" + curpage + "id" + id;
		Cache cache = cacheManager.getCache("sampleCache1");
		Element element = cache.get(key);

		if (element != null) {
			Object value = element.getValue();
			json = (String) value;
		} else {
			List<Epub> eplus = epubDaoImpl.page_by_category(curpage, id);
			Gson gson = new Gson();
			json = gson.toJson(eplus);
			Element putelement = new Element(key, json);
			cache.put(putelement);
		}
		return "success";
	}

}
