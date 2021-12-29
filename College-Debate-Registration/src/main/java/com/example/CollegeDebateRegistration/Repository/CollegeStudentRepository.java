package com.example.CollegeDebateRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeDebateRegistration.Entity.CollegeStudent;

@Repository
public interface CollegeStudentRepository extends JpaRepository<CollegeStudent, Integer> {

}
