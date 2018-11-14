package com.app.validator;

import java.util.regex.Pattern;

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
		if(Pattern.compile("").matcher(uom.getModel()).matches()){
			errors.rejectValue("model", null, "Enter Valid Model[4 to 10 UpperCase letters only]");
		}
		if("".equals(uom.getDsc().trim())) {
			errors.rejectValue("dsc", null, "Please enter Description");
		}
	}

}

