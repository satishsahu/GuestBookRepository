package com.guestbook.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.model.Login;

@Repository
public interface LoginRepository  extends CrudRepository<Login, Long> {
	@Query(value = "SELECT * FROM login t where t.username = ?1 and t.password = ?2", nativeQuery = true) 
	Login findByUserNamePassword(String uname, String psw);
	
	@Query(value = "SELECT * FROM login t where t.username = ?1 and t.password = ?2 and t.admin = ?3", nativeQuery = true) 
	Login findByUserNamePasswordAdmin(String uname, String psw, String admin);
}
