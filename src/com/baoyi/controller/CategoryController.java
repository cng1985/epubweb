package com.baoyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baoyi.dao.CategoryDaoImpl;
import com.epublib.category.service.CategoryService;
import com.epublib.domain.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("Category") Category Category, Model model,
			BindingResult result) {
		categoryService.add(Category);
		return "Category/add";
	}

	@RequestMapping(value = "/preadd", method = RequestMethod.GET)
	public String preAdd() {
		return "Category/preadd";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable String id, Model model) {
		System.out.println(id);
		return "Category/add";
	}

	public HttpSession getSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession contextSess = attr == null ? null : attr.getRequest()
				.getSession(true);

		return contextSess;
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		model.addAttribute("Categorys",categoryService.find("from Category"));
		model.addAttribute("title", "最新上传的电子书");
		return "Category/list";
	}
}
