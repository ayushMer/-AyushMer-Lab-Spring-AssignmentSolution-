package com.example.CollegeDebateRegistration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeDebateRegistration.Entity.CollegeStudent;
import com.example.CollegeDebateRegistration.Repository.CollegeStudentRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeStudentRepository repo;
	
	@Override
	public List<CollegeStudent> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	
	}

	@Override
	public CollegeStudent findById(int theStudentId) {
		// TODO Auto-generated method stub
		//CollegeStudent stud=repo.findById(theStudentId);
		return repo.findById(theStudentId).get();
	}

	@Override
	public void save(CollegeStudent theStudentData) {
		// TODO Auto-generated method stub
		repo.save(theStudentData);
		
	}

	@Override
	public void delete(int StudentId) {
		// TODO Auto-generated method stub
		repo.deleteById(StudentId);
	}



}
