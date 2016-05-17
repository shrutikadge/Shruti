package com.shruti.finalrealestate;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shruti.finalrealestate.pojo.Property;


public class PropertyValidator implements Validator{

	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Property.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Property property = (Property) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propTypes", "error.invalid.propTypes", "type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "price Required");
    }

	
	
}
