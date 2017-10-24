package com.practice.spring.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.spring.springmvc.model.Activity;
import com.practice.spring.springmvc.model.Exercise;
import com.practice.spring.springmvc.service.ExerciseService;

@Controller
public class MinutesController {

	@Autowired
	ExerciseService exerciseService;
	
	@RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
	public String addMinutes(Model model) {

		Exercise exercise = new Exercise();
		exercise.setMinutes(10);
		exercise.setActivity("Run");

		model.addAttribute("exercise", exercise);
		return "addMinutes";
		
		// return "forward:addMoreMinutes.html";
		// return "redirect:addMoreMinutes.html";
	}
	
	@RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise,  BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		System.out.println("exercise: " + exercise);
		
		if(result.hasErrors()) {
			return "redirect:addGoal.html";
		}
		return "addMinutes";
		// return "forward:addMoreMinutes.html";
		// return "redirect:addMoreMinutes.html";
	}

	@RequestMapping(value = "/activities", method= RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities()
	{	
		return exerciseService.findAllActivities();

	}

	// @RequestMapping(value = "/addMoreMinutes")
	// public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise)
	// {
	//
	// System.out.println("exercising: " + exercise.getMinutes());
	//
	// return "addMinutes";
	// }
}
