package com.techtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","home","/index"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		view.addObject("greeting", "Welcome to Spring web MVC");
		return view;
	}

	/*
	 * @RequestMapping(value = "/test") //HTTP Status 400 – Bad Request if we use
	 * this method without using greeting in url ---> public ModelAndView
	 * test(@RequestParam("greeting") String greeting) public ModelAndView
	 * test(@RequestParam(value = "greeting", required=false) String greeting) {
	 * if(greeting==null) { greeting= "Hello There"; } ModelAndView view = new
	 * ModelAndView("page"); view.addObject("greeting", greeting); return view; }
	 */
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if(greeting==null) {
			greeting= "Hello There";
		}
		ModelAndView view = new ModelAndView("page");
		view.addObject("greeting", greeting);
		return view;
	}
}
