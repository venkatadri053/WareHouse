package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
@Component
public class UomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//object -> Model class
		//new way of errors check
		Uom uom=(Uom)target;
		
		if("".equals(uom.getType())) {
			errors.rejectValue("type", null, "Please choose one Type");
		}
		if("".equals(uom.getModel().trim())) {
			errors.rejectValue("model", null, "Please Enter Model");
		}
		if("".equals(uom.getDsc().trim())) {
			errors.rejectValue("dsc", null, "Please enter Description");
		}
	}

}

