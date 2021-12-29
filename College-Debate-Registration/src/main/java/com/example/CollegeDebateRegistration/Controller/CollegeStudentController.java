package com.example.CollegeDebateRegistration.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.CollegeDebateRegistration.Entity.CollegeStudent;
import com.example.CollegeDebateRegistration.Service.CollegeService;

@Controller
public class CollegeStudentController {

	@Autowired
	CollegeService service;
	
	@RequestMapping("/list")
	public String listStudents(Model model)
	{
		List<CollegeStudent> list=service.findAll();
		
		model.addAttribute("Students", list);
		
		return "studentList";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		CollegeStudent student=new CollegeStudent();
		
		theModel.addAttribute("Student",student);
		
		return "showFormForAdd";
	}
	
	@RequestMapping(value="/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int StudentId,Model theModel)
	{
		
		CollegeStudent stud=service.findById(StudentId);
		
		theModel.addAttribute("Student",stud);
		
		return "showFormForAdd";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("department") String department,
			@RequestParam("country") String country)
	{
		
		
		CollegeStudent stud;
		if(id!=0)
		{
			stud=service.findById(id);
			stud.setCountry(country);
			stud.setDepartment(department);
			stud.setName(name);
		}
		else
		{
			stud=new CollegeStudent(name,department,country);
		}
		
		service.save(stud);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id)
	{
		service.delete(id);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}
