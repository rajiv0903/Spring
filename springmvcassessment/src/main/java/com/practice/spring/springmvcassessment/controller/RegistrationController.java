package com.practice.spring.springmvcassessment.controller;

import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.practice.spring.springmvcassessment.validator.RegistrationValidator;
import com.practice.spring.springmvcassessment.vo.Address;
import com.practice.spring.springmvcassessment.vo.CustomerVO;


@Controller
@SessionAttributes("customer")
public class RegistrationController {


	//Add the necessary implementation
	
	@Autowired
	RegistrationValidator registrationValidator;
	
	@RequestMapping(value ="registration", method= RequestMethod.GET)
	public String registration(Model model){
		
		CustomerVO customer = new CustomerVO();
		model.addAttribute("customer", customer);
		return "registration";	
	}
	
	@RequestMapping(value ="registration", method= RequestMethod.POST)
	public String registrationOnSuccess(
			@Valid @ModelAttribute("customer") CustomerVO customer,
			BindingResult result, SessionStatus status){
		
		registrationValidator.validate(customer, result);
		
		if(result.hasErrors())	{
			return "registration";	 
		}
		//status.setComplete();
		
		return "success";
	}
	
	@RequestMapping(value ="states", method= RequestMethod.GET)
	private @ResponseBody List<Address> getStates(){
		
		List<Address>  states = new LinkedList<Address>();
		
		Address state = new Address();
		state.setState("Tamilnadu");
		states.add(state);
		
		state = new Address();
		state.setState("Karnataka");
		states.add(state);
		
		state = new Address();
		state.setState("Maharashtra");
		states.add(state);
		
		return states;
		
	}
}
