package com.example.CollegeDebateRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CollegeDebateRegistration.Entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User getByUsername(String username);
	
}
