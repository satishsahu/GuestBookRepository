package com.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guestbook.model.Guest;
import com.guestbook.model.Login;
import com.guestbook.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Transactional
	public List<Login> getAllGuests() {
		return (List<Login>) loginRepository.findAll();
	}

	@Transactional
	public boolean findByUserNamePassword(Login login) {
		System.out.println("uname "+login.getUsername()+" >> "+login.getPassword());
		Login login1 = loginRepository.findByUserNamePassword(login.getUsername(), login.getPassword());
		System.out.println("login1: "+login1);
		if(login1!= null){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional
	public boolean findByUserNamePasswordAdmin(Login login) {
		System.out.println("uname "+login.getUsername()+" >> "+login.getPassword());
		Login login1 = loginRepository.findByUserNamePasswordAdmin(login.getUsername(), login.getPassword(), "yes");
		System.out.println("login1: "+login1);
		if(login1!= null){
			return true;
		}else{
			return false;
		}
	}
}
