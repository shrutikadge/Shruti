package com.shruti.finalrealestate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shruti.finalrealestate.pojo.Person;


@Component
public class UserValidator implements Validator{
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Person.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Person user = (Person) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
    }
	

}
