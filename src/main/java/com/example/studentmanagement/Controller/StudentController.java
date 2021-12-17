package com.example.studentmanagement.Controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.example.studentmanagement.Domain.Course;
import com.example.studentmanagement.Domain.Student;
import com.example.studentmanagement.Domain.StudentDAO;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Service.CourseService;
import com.example.studentmanagement.Service.StudentService;
 
@Controller
@RequestMapping("/Student")
 
public class StudentController {
@Autowired
    private StudentService service;
@Autowired
private CourseService services;

@Autowired
private StudentRepository studentRepository;
 
    @GetMapping("/addstudent")
    public String add(Model model) {
     List<Student> liststudent = service.listAll();
     List<Course> listcourse = services.listAll();
    model.addAttribute("listcourse", listcourse);
        model.addAttribute("liststudent", liststudent);
        model.addAttribute("student", new Student());
        return "addstudent";
    }
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std)
    {
        service.save(std);
        return "redirect:/student";
    }
    
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addstudent");
        List<Course> listcourse = services.listAll();
    
        Student std = service.get(id);
        mav.addObject("student", std);
        mav.addObject("listcourse", listcourse);
        return mav;
        
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteStudentPage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/student";
    }
    
  
    @RequestMapping(value = "/viewProfile/{id}", method = RequestMethod.GET)
    //  @RequestMapping("/viewProfile/{id}", method = RequestMethod.GET)
      public ModelAndView viewProfile(@PathVariable(name = "id") int id,ModelAndView modelAndView) {
        //  ModelAndView mav = new ModelAndView();
    	 List<StudentDAO> li = new ArrayList<>();
    	 StudentDAO student = new StudentDAO();
    	 for(Object[] o : studentRepository.findStudentProfile(id)  )
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
    	
    		 li.add(student);
    	 }
      
        //   Student std = service.get(id);
      //    Student Student = new Student();
      //	Student.setStname("profile");
      //    Student = service.get(id);
      	
      	modelAndView.addObject("student", student);
      	modelAndView.setViewName("viewProfile");
          return modelAndView;
          
       
          
      }
 
}