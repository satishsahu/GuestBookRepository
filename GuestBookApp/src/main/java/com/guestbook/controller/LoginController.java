package com.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guestbook.model.Login;
import com.guestbook.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public boolean isLogginSuccessForGuest(@RequestBody String loginStr){
		System.out.println("Inside Login..."+loginStr);
		String str[] = loginStr.split("-");
		Login login = new Login();
		System.out.println("Inside str[0]..."+str[0]+">>>>"+str[1]);
		if(str[0]!=null && str[1] != null){
			login.setUsername(str[0]);
			login.setPassword(str[1].substring(0, str[1].length() - 1));
			return loginService.findByUserNamePassword(login);
		}
		
		return false;
		//return loginService.findByUserNamePassword(login);
	}
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public boolean isLogginSuccessForAdmin(@RequestBody String loginStr){
		System.out.println("Inside Login..."+loginStr);
		String str[] = loginStr.split("-");
		Login login = new Login();
		System.out.println("Inside str[0]..."+str[0]+">>>>"+str[1]);
		if(str[0]!=null && str[1] != null){
			login.setUsername(str[0]);
			login.setPassword(str[1].substring(0, str[1].length() - 1));
			return loginService.findByUserNamePasswordAdmin(login);
		}
		
		return false;
		//return loginService.findByUserNamePassword(login);
	}
	
	@RequestMapping(value = "/getlogin", method = RequestMethod.GET)
	public List<Login> getloginList(){
		System.out.println("Inside controller.........");
		return loginService.getAllGuests();
	}
}
