package com.company.generator.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("${admin.url.prefix}")
public class IndexController {

	@GetMapping
	public ModelAndView index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return new ModelAndView("modules/generator/index/index");
}
}
