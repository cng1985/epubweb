package com.baoyi.actions;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baoyi.common.page.PageResult;
import com.epublib.category.service.CategoryService;
import com.epublib.domain.Category;
import com.epublib.domain.Epub;
import com.epublib.epub.service.EpubService;

public class EpubAction {
	private EpubService epubService;
	private Epub epub;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPagerMethod() {
		return pagerMethod;
	}

	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private CategoryService categoryService;
	private List<Category> categorys;
	private int pageSize;
	private String currentPage;

	PageResult pageResult;
	private String pagerMethod;

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

	public EpubService getEpubService() {
		return epubService;
	}

	public void setEpubService(EpubService epubService) {
		this.epubService = epubService;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public Epub getEpub() {
		return epub;
	}

	public void setEpub(Epub epub) {
		this.epub = epub;
	}

	public String add() {
		epubService.add(epub);
		return "success";
	}

	public String preAdd() {
		categorys = categoryService.find("from Category");
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable String id, Model model) {
		System.out.println(id);
		return "epub/add";
	}

	@RequestMapping("/list")
	public String list() {
		String sql = "from Epub";
		pageResult = categoryService.getPageResult(sql, currentPage,
				pagerMethod, 10);
		return "success";
	}
}
