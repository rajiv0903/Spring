package com.practice.spring.springmvcassessment.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.practice.spring.springmvcassessment.vo.CustomerVO;

@Component
public class RegistrationValidator implements Validator {
	// Implement the validation login here.

	@Override
	public boolean supports(Class clazz) {
		return CustomerVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CustomerVO customerVO = (CustomerVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address", "field.address.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "field.state.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "field.dob.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "field.confirmpassword.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "field.gender.empty");
		
		if(!customerVO.getIsAgreed()) {
			errors.rejectValue("isAgreed", "field.isAgreed.empty");
		}
		if(customerVO.getName() != null 
				&& customerVO.getName().equals(customerVO.getPassword())) {
			errors.reject("namepassword.match");
		}
		if(customerVO.getPassword() != null 
				&& !customerVO.getPassword().equals(customerVO.getConfirmpassword())) {
			errors.reject("password.notmatch");
		}
	}
}
