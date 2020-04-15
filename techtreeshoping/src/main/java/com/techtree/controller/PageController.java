package com.techtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techtree.shoppingbacken.dao.CategoryDAO;
import com.techtree.shoppingbacken.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/","home","/index"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		//view.addObject("greeting", "Welcome to Spring web MVC");
		
		view.addObject("title", "Home");
		
		
		
		
		//passing the list of categories
		view.addObject("categories", categoryDAO.list());
		view.addObject("userClickHome", true);
		
		return view;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView view = new ModelAndView("page");
		//view.addObject("greeting", "Welcome to Spring web MVC");
		
		view.addObject("title", "About Us");
		view.addObject("userClickAbout", true);
		
		return view;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView view = new ModelAndView("page");
		//view.addObject("greeting", "Welcome to Spring web MVC");
		
		view.addObject("title", "Contact Us");
		view.addObject("userClickContact", true);
		
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
	
	/**
	 * Method to load all the products and based on category
	 */
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView view = new ModelAndView("page");
		
		view.addObject("title", "All Products");
		
		//passing the list of categories
		view.addObject("categories", categoryDAO.list());
		view.addObject("userClickAllProducts", true);
		
		return view;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		
		Category category =null;
		category = categoryDAO.get(id);
		
		view.addObject("title", category.getName());
		
		//passing the list of categories
		view.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		view.addObject("category", category);
		
		view.addObject("userClickCategoryProducts", true);
		
		return view;
	}
	
}
