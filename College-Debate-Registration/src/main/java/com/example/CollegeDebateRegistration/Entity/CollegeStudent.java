package com.example.CollegeDebateRegistration.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class CollegeStudent {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


	private String name;

    private String department;

    private String country;

	public CollegeStudent() {
		super();
	}

	public CollegeStudent(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
    
}
