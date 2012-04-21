package com.baoyi.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.epublib.category.service.CategoryService;
import com.epublib.domain.Category;

public class CategoryAction {
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private CategoryService categoryService;
	private Category category;
	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String add() {
		categoryService.add(category);
		return "success";
	}

	public String preAdd() {
		categorys = categoryService.find("from Category");
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable String id, Model model) {
		System.out.println(id);
		return "category/add";
	}


	public String list() {
		categorys = categoryService.find("from Category");
		return "success";
	}

	public String delete() {
		categoryService.delete(category);
		return "success";
	}

	public String update() {
		categoryService.update(category);
		return "success";
	}

	public String preUpdate() {
		categorys = categoryService.find("from Category");
		category = (Category) categoryService.findById(Category.class,
				category.getId());
		return "success";
	}
}
