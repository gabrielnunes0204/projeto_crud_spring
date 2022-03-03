package br.com.cad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping(path = "/")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("index");
		
		return model;
	}
	
	
}
