package com.example.CollegeDebateRegistration.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.CollegeDebateRegistration.Repository.UserRepository;
import com.example.CollegeDebateRegistration.Security.MyUserDetails;
import com.example.CollegeDebateRegistration.Entity.User;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getByUsername(username);
		return new MyUserDetails(user);
	}

}
