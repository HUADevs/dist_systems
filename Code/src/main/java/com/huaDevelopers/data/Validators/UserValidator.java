package com.huaDevelopers.data.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.Interfaces.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user= (User) target;
		boolean userNameAvailable=true;
		boolean emailAdressAvailable=true;
		for (User u : this.userService.listAllUser()) {
	        if (user.getUserName().equals(u.getUserName())) {
	            userNameAvailable=false;
	        }
	        if(u.getEmailAdress().equals(user.getEmailAdress())){
	        	emailAdressAvailable=false;
	        }
	    }
		if(!userNameAvailable){
			errors.rejectValue("userName", "user.userName","This username is already in use.Try using a different one.");
		}
		if(!emailAdressAvailable){
			errors.rejectValue("emailAdress", "user.emailAdress","This email is already in use.Try using a different one.");
		}
		
	}
	
}
