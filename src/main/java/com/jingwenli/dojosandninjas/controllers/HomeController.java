package com.jingwenli.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jingwenli.dojosandninjas.models.Dojo;
import com.jingwenli.dojosandninjas.models.Ninja;
import com.jingwenli.dojosandninjas.services.MainService;

@Controller
public class HomeController {

	@Autowired
	private MainService mainService;
	
//	FIND ALL dojos
	@GetMapping("/")
	public String allDojos(Model model) {
		model.addAttribute("dojoList", mainService.allDojos());
		return "dashboard.jsp";
	}
	
//	CREATE NEW DOJO
//	to show form
	@GetMapping("/dojos/new")
	public String newDojoForm(Model model) {
		model.addAttribute("newDojo", new Dojo());
		return "newDojoForm.jsp";
	}

//	to process form
	@PostMapping("/dojos/new")
	public String processNewDojo(
			@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojoForm.jsp";
		} else {
			mainService.createNewDojo(dojo);
			return "redirect:/";
		}
	}
	
//	CREATE NEW NINJA
//	to show form
	@GetMapping("/ninjas/new") 
	public String newNinjaForm(Model model) {
		model.addAttribute("newNinja", new Ninja());
		model.addAttribute("dojoList", mainService.allDojos());
		return "newNinjaForm.jsp";
	}
	
//	to process form
	@PostMapping("/ninjas/new")
	public String processNewNinja(
			@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojoList", mainService.allDojos());
			return "newNinjaForm.jsp";
		} else {
			mainService.createNewNinja(ninja);
//			return "redirect:/dojos/{ninja.dojo.id}";
			return "redirect:/";
		}
	}
		
//	FIND ONE DOJO
	@GetMapping("/dojos/{id}")
	public String dojoDetails (@PathVariable("id") Long id, Model model) {
		Dojo foundDojo = mainService.findOneDojo(id);
		model.addAttribute("dojo", foundDojo);
		return "oneDojo.jsp";
	}

//	ADD NEW NINJA TO DOJO
//	to show form
	@GetMapping("/ninjas/add/{dojoId}") 
	public String addNinjaForm(@PathVariable("dojoId") Long id, Model model) {
		model.addAttribute("newNinja", new Ninja());
		model.addAttribute("dojoId", id);
		return "addNinjaForm.jsp";
	}
	
//  to process form
	@PostMapping("/ninjas/add")
	public String processAddNinja (
			@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "addNinjaForm.jsp";
		} else {
			mainService.createNewNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
			
			
			
			
			
			
}
