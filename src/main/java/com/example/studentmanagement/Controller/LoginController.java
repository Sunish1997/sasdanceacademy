package com.example.studentmanagement.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.Domain.Course;
import com.example.studentmanagement.Domain.Login;
import com.example.studentmanagement.Domain.Student;
import com.example.studentmanagement.Domain.StudentDAO;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Service.CourseService;
import com.example.studentmanagement.Service.LoginService;
import com.example.studentmanagement.Service.StudentService;



@Controller
public class LoginController {
	
	@Autowired
    private LoginService userService;
	
	@Autowired
    private StudentService service;


@Autowired
private StudentRepository studentRepository;

  /*                                 
    @GetMapping("/login")
           
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }
*/
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {
    	
    	Login oauthUser = userService.login(user.getUsername(), user.getPassword());
    	

    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		return "adminuser";
    	
    		
    	} else {
    		return "redirect:/";
    		
    	
    	}

}
    
    @PostMapping("/StudentProfile")
    public ModelAndView Studentlogin(@ModelAttribute("user") Login user ) {
    	ModelAndView mav = new ModelAndView();
    	Login oauthUser = userService.login(user.getUsername(), user.getPassword());
    	

    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		// List<StudentDAO> li = new ArrayList<>();
        	 StudentDAO student = new StudentDAO();
        	 for(Object[] o : studentRepository.findStudentProfileByStdid(user.getPassword())  )
        	 {
        		// StudentDAO student = new StudentDAO();
        		 
        		 student.setId(Long.parseLong(String.valueOf(o[0])));
        		 student.setStname((String)o[1]);
        		 student.setCoursename((String)o[2]);
        		 student.setAddress((String)o[9]);
        		 student.setDob((java.sql.Date)o[8]);
        		 student.setEmail((String)o[7]);
        		 student.setGender((String)o[10]);
        		 student.setFee(Long.parseLong(String.valueOf(o[5])));
        		 student.setMobileno(Long.parseLong(String.valueOf(o[6])));
        		 student.setStudentid((String)o[11]);
        	
        		// li.add(student);
        	 }
          
            //   Student std = service.get(id);
          //    Student Student = new Student();
          //	Student.setStname("profile");
          //    Student = service.get(id);
          	
        	 mav.addObject("student", student);
        	 mav.setViewName("viewProfile");
              return mav;
    		
    		
    	//	return "adminuser";
    	
    		
    	} else {
    	//	return "redirect:/";
    		 mav.setViewName("studentlogin");
             return mav;
    	
    	}

}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    	
	  
        return "redirect:/";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView  profile(ModelAndView modelAndView)
	{
    	Student Student = new Student();
    	Student.setStname("profile");
      
        modelAndView.addObject("student", Student);
        modelAndView.setViewName("profile");
        return modelAndView;
	    
	}
	
	// @RequestMapping(value = "/attendance", method = RequestMethod.GET)
// 	public String attendance()
// 	{
	   
	//    return "attendance";
//	}
	
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees()
	{
	   
	    return "employees";
	}
	@RequestMapping(value = "/holidays", method = RequestMethod.GET)
	public String holidays()
	{
	   
	    return "holidays";
	}
	
	@RequestMapping(value = "/leaves", method = RequestMethod.GET)
	public String leaves()
	{
	   
	    return "studentlogin";
	}
	@RequestMapping(value = "/sloginf", method = RequestMethod.GET)
	public String sloginf()
	{
	   
	    return "sloginf";
	}

	
	
	
}
