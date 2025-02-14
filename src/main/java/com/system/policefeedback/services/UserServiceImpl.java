package com.system.policefeedback.services;

import com.system.policefeedback.entities.User;
import com.system.policefeedback.repositories.UserRepository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        
		
    }

    @Override
    public User saveUser(User user) {
    	return userRepository.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
   
}
