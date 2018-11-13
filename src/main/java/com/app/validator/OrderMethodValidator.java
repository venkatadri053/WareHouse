package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orderMethod=(OrderMethod)target;

		if("".equals(orderMethod.getMode())){
			errors.rejectValue("mode", null, "Please choose one Mode");
		}
		//if("".equals(orderMethod.getCode().trim())) {
			if(!Pattern.compile("[A-Za-z]{4,6}").matcher(orderMethod.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter code(4 to 6 letters)");
		}
		if("".equals(orderMethod.getMethod().trim())) {
			errors.rejectValue("method", null, "Please Enter method");
		}

		if(orderMethod.getAccept()==null || orderMethod.getAccept().isEmpty()) {
			errors.rejectValue("accept", null,"Please choose any one" );
		}
		//if("".equals(orderMethod.getCode().trim())) {
			if(!Pattern.compile("[A-Za-z]{4,50}").matcher(orderMethod.getCode()).matches()) {
			errors.rejectValue("dsc", null, "Please Enter Description");
		}

	}

}
