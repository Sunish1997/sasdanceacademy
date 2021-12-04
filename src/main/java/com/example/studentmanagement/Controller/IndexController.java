package com.example.studentmanagement.Controller;
 
//import com.example.studentmanagement.Repository.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.Domain.Login;
import com.example.studentmanagement.Domain.Course;
import com.example.studentmanagement.Domain.StudentDAO;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Service.CourseService;
import com.example.studentmanagement.Service.StudentService;


 
@Controller
@RequestMapping("/") 
public class IndexController {
	
	
@Autowired
  private CourseService service;

@Autowired
private StudentService services;

@Autowired
private StudentRepository studentRepository;

 

@RequestMapping(value = "/student", method = RequestMethod.GET)
public String viewStudentPage(Model model) {
	 List<StudentDAO> li = new ArrayList<>();
	 for(Object[] o : studentRepository.findStudent()  )
	 {
		 StudentDAO student = new StudentDAO();
		 
		 student.setId(Long.parseLong(String.valueOf(o[0])));
		 student.setStname((String)o[1]);
		 student.setCoursename((String)o[2]);
		 li.add(student);
	 }
	 
	    model.addAttribute("liststudent", li);
	  
	    return "Student";
	}


@RequestMapping(value = "/index", method = RequestMethod.GET)
public String index()
{
   
    return "index";
}

@RequestMapping(value = "/course", method = RequestMethod.GET)
public String viewHomePage(Model model) {
	 List<Course> listcourse = service.listAll();
	    model.addAttribute("listcourse", listcourse);
	   System.out.println("Get / ");
	    return "Course";
	}


@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
public String adminlogin(Model model)
{
   
      model.addAttribute("user",new Login());

      return "login";
}





}