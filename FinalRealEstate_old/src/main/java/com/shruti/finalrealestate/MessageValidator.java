package com.shruti.finalrealestate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shruti.finalrealestate.pojo.MessageBean;
import com.shruti.finalrealestate.pojo.Property;

public class MessageValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(MessageBean.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "location Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propTypes", "error.invalid.propTypes", "type Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "price Required");
	}

}
