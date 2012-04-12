package com.baoyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.baoyi.dao.EpubDaoImpl;
import com.epublib.domain.Epub;

@Controller
@RequestMapping("/epub")
public class EpubController {
	@Autowired
	private EpubDaoImpl epubDaoImpl;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("epub") Epub epub, Model model,
			BindingResult result) {
		epubDaoImpl.add(epub);
		return "epub/add";
	}

	@RequestMapping(value = "/preadd", method = RequestMethod.GET)
	public String preAdd() {
		return "epub/preadd";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable String id, Model model) {
		System.out.println(id);
		return "epub/add";
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
		model.addAttribute("epubs", epubDaoImpl.top());
		model.addAttribute("title", "最新上传的电子书");
		return "epub/list";
	}
}
