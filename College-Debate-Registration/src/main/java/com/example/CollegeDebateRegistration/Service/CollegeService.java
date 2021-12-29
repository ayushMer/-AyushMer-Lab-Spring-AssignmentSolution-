package com.example.CollegeDebateRegistration.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CollegeDebateRegistration.Entity.CollegeStudent;

@Service
public interface CollegeService {
	
	List<CollegeStudent> findAll();
	
	CollegeStudent findById(int theStudentId);
	
	void save(CollegeStudent theStudentData);
	
	void delete(int StudentId);
	
	
}
