package com.system.policefeedback.services;


import com.system.policefeedback.entities.User;

public interface UserService {

	User saveUser(User user);

	User findByUsername(String username);

	
	
	 

}
