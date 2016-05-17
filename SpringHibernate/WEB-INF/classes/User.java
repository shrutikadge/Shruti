package com.mikadosolutions.training.springmvc.bean;

import java.lang.annotation.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotNull;


public class User
{
	//@NotNull
	@NotEmpty 
	@Email
	String username;

	@NotEmpty
	String password;

	public User()
	{
	}
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	public String toString()
	{
		return "Username = "+ username + " Password = " +password;
	}
};