package com.example.studentmanagement.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.Domain.AttendanceHistory;
import com.example.studentmanagement.Domain.AttendanceView;
import com.example.studentmanagement.Domain.Course;
import com.example.studentmanagement.Domain.Student;
import com.example.studentmanagement.Domain.StudentDAO;
import com.example.studentmanagement.Repository.AttendanceRepository;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Service.AttendanceService;
import com.example.studentmanagement.Service.StudentService;


@Controller
@RequestMapping("/Attendance")
public class AttendanceController {

	 long millis=System.currentTimeMillis();
	Date attDate = new Date(millis) ;
	
	
	
	
	@Autowired
	private AttendanceService service;
	
	@Autowired
	private StudentService services;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
	
	 List<AttendanceView> attHistBackup = new ArrayList<>();
	
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("atthistory") AttendanceHistory att)
	{
		System.out.println("dateeee "+att.getAttdate());
		attDate = att.getAttdate() ;
		 return "redirect:/Attendance/attendance";
	  //  return "redirect:/attendance";
	} 
	/*
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("atthistory") AttendanceHistory att)
	{
		List<AttendanceHistory> attList = service.attList(att.getAttdate() );
	//	List<AttendanceHistory> result = attendanceRepository.findAllByPublicationDate(att.getAttdate() );
				
			
		services.save(att);
		 return "redirect:/Attendance/attendance";
	  //  return "redirect:/attendance";
	}

*/
	
	
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String viewStudentPage(Model model) {
		
		System.out.println("std at date "+attDate);
		
		List<Object[]> studentAttList = studentRepository.findStudentAttList(attDate) ;
		
		System.out.println(studentAttList);
		System.out.println(studentAttList.size());
		
		 List<AttendanceView> li = new ArrayList<>();
		 attHistBackup = new ArrayList<>();
		 
		 for(Object[] o : studentAttList  )
		 {
			 AttendanceView student = new AttendanceView();
			 
			 student.setId(Long.parseLong(String.valueOf(o[0])));
			 student.setStname((String)o[1]);
			 student.setCoursename((String)o[2]);
			 student.setAttdance((String)o[3]);
			 System.out.println("Hiii"  );
			 System.out.println(o[4]);
			 if(o[4] == null)
			 {
				 
				 student.setAttboolean(false);  
			 }
			 else
			 {
			 if(Long.parseLong(String.valueOf(o[4]))==1)
			 {
				 System.out.println("True"  );
				 student.setAttboolean(true);
				 }
			 else if(Long.parseLong(String.valueOf(o[4]))==0)
			 {
				 System.out.println("false"  );
				 student.setAttboolean(false); 
			 }
			 }
			 li.add(student);
			
			 attHistBackup.add(student);
		 }
		 
		    model.addAttribute("liststudent", li);
		    AttendanceHistory attHistory =  new AttendanceHistory();
		    attHistory.setAttdate(attDate);
		    model.addAttribute("atthistory", attHistory);
		    return "attendance";
		}
	
	
	
	
	
/*@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String viewStudentPage(Model model) {
		
		System.out.println("std at date "+attDate);
		
		List<Object[]> studentAttList = studentRepository.findStudentAttList(attDate) ;
		
		System.out.println(studentAttList);
		System.out.println(studentAttList.size());
		
		 List<AttendanceView> li = new ArrayList<>();
		 
		 for(Object[] o : studentAttList  )
		 {
			 AttendanceView student = new AttendanceView();
			 
			 student.setId(Long.parseLong(String.valueOf(o[0])));
			 student.setStname((String)o[1]);
			 student.setCoursename((String)o[2]);
			 student.setAttdance((String)o[3]);
			 System.out.println("Hiii"  );
			 System.out.println(o[4]);
			 if(o[4] == null)
			 {
				 
				 student.setAttboolean(false);  
			 }
			 else
			 {
			 if(Long.parseLong(String.valueOf(o[4]))==1)
			 {
				 System.out.println("True"  );
				 student.setAttboolean(true);
				 }
			 else if(Long.parseLong(String.valueOf(o[4]))==0)
			 {
				 System.out.println("false"  );
				 student.setAttboolean(false); 
			 }
			 }
			 li.add(student);
		 }
		 
		    model.addAttribute("liststudent", li);
		    AttendanceHistory attHistory =  new AttendanceHistory();
		    attHistory.setAttdate(attDate);
		    model.addAttribute("atthistory", attHistory);
		    return "attendance";
		}
	
	*/

	@RequestMapping("/presentAll")
	public String presentAll()
	{
		System.out.println("presentAll "+attHistBackup);
		System.out.println(attHistBackup.size());
		
		for(AttendanceView obj : attHistBackup)
		{

			List<Object[]> attList = service.attList(attDate,obj.getId());
			
		
			
			if(attList.size()>0)
			{
				System.out.println("ifffffffffff");
				
				
				 AttendanceHistory attHistory = new AttendanceHistory();
				attHistory.setId(Long.parseLong(String.valueOf(attList.get(0)[0])));
				attHistory.setStdid(Long.parseLong(String.valueOf(attList.get(0)[1])));
				 attHistory.setAttdate(attDate);
				
				  attHistory.setAttdance("P");
				    attHistory.setAttboolean(true);
				    service.saveAttendance(attHistory);
				   
			}
			else
			{
				System.out.println("elssssssss");
				  Student std = services.get(obj.getId());
				
				
				    AttendanceHistory attHistory = new AttendanceHistory();
				    attHistory.setStdid(std.getId());
				   // attHistory.setCourseid(std.getCourse());
				    attHistory.setAttdate(attDate);
				    attHistory.setAttdance("P");
				    attHistory.setAttboolean(true);
				    service.saveAttendance(attHistory);
				   
				
			}
				
			
			
			
		}
		
		
		 return "redirect:/Attendance/attendance";
	  //  return "redirect:/attendance";
	} 

	@RequestMapping("/absentAll")
	public String absentAll()
	{
		System.out.println("absentAll "+attHistBackup);
		System.out.println(attHistBackup.size());
		
		for(AttendanceView obj : attHistBackup)
		{

			List<Object[]> attList = service.attList(attDate,obj.getId());
			
		
			
			if(attList.size()>0)
			{
				System.out.println("ifffffffffff");
				
				
				 AttendanceHistory attHistory = new AttendanceHistory();
				attHistory.setId(Long.parseLong(String.valueOf(attList.get(0)[0])));
				attHistory.setStdid(Long.parseLong(String.valueOf(attList.get(0)[1])));
				 attHistory.setAttdate(attDate);
				
				  attHistory.setAttdance("A");
				    attHistory.setAttboolean(false);
				    service.saveAttendance(attHistory);
				   
			}
			else
			{
				System.out.println("elssssssss");
				  Student std = services.get(obj.getId());
				
				
				    AttendanceHistory attHistory = new AttendanceHistory();
				    attHistory.setStdid(std.getId());
				   // attHistory.setCourseid(std.getCourse());
				    attHistory.setAttdate(attDate);
				    attHistory.setAttdance("A");
				    attHistory.setAttboolean(false);
				    service.saveAttendance(attHistory);
				   
				
			}
				
			
			
			
		}
		
		
		 return "redirect:/Attendance/attendance";
	  //  return "redirect:/attendance";
	} 

	
	

@RequestMapping("/present/{id}")
public String presentStudentPage(@PathVariable(name = "id") int id) {

	

	List<Object[]> attList = service.attList(attDate,(long)id);
	
	System.out.println(attList);
	System.out.println(attList.size());
	
	if(attList.size()>0)
	{
		System.out.println("ifffffffffff");
		
		
		 AttendanceHistory attHistory = new AttendanceHistory();
		attHistory.setId(Long.parseLong(String.valueOf(attList.get(0)[0])));
		attHistory.setStdid(Long.parseLong(String.valueOf(attList.get(0)[1])));
		 attHistory.setAttdate(attDate);
		
		  attHistory.setAttdance("P");
		    attHistory.setAttboolean(true);
		    service.saveAttendance(attHistory);
		    return "redirect:/Attendance/attendance";
	}
	else
	{
		System.out.println("elssssssss");
		  Student std = services.get(id);
		
		
		    AttendanceHistory attHistory = new AttendanceHistory();
		    attHistory.setStdid(std.getId());
		   // attHistory.setCourseid(std.getCourse());
		    attHistory.setAttdate(attDate);
		    attHistory.setAttdance("P");
		    attHistory.setAttboolean(true);
		    service.saveAttendance(attHistory);
		    return "redirect:/Attendance/attendance";
		
	}
		
		 
}
		 
	
		
		
	 
	 
/*
    Student std = services.get(id);
    std.setAttdance("P");
    std.setAttboolean(true);
    
    
    
    AttendanceHistory attHistory = new AttendanceHistory();
    attHistory.setStdid(std.getId());
   // attHistory.setCourseid(std.getCourse());
    attHistory.setAttdate(attDate);
    attHistory.setAttdance("P");
    attHistory.setAttboolean(true);
    service.saveAttendance(attHistory);
   
    return "redirect:/Attendance/attendance";  */
    
  
    


/*
@RequestMapping("/present/{id}")
public String presentStudentPage(@PathVariable(name = "id") int id) {


    Student std = services.get(id);
    std.setAttdance("P");
    std.setAttboolean(true);
    
    
    
    AttendanceHistory attHistory = new AttendanceHistory();
    attHistory.setStdid(std.getId());
   // attHistory.setCourseid(std.getCourse());
    attHistory.setAttdate(attDate);
    attHistory.setAttdance("P");
    attHistory.setAttboolean(true);
    service.saveAttendance(attHistory);
    return "redirect:/Attendance/attendance";
    
  
    
}

*/






@RequestMapping("/absent/{id}")
public String absentStudentPage(@PathVariable(name = "id") int id) {



	List<Object[]> attList = service.attList(attDate,(long)id);
	
	System.out.println(attList);
	System.out.println(attList.size());
	
	if(attList.size()>0)
	{
		System.out.println("ifffffffffff");
		
		
		 AttendanceHistory attHistory = new AttendanceHistory();
		attHistory.setId(Long.parseLong(String.valueOf(attList.get(0)[0])));
		attHistory.setStdid(Long.parseLong(String.valueOf(attList.get(0)[1])));
		 attHistory.setAttdate(attDate);
		
		  attHistory.setAttdance("A");
		    attHistory.setAttboolean(false);
		    service.saveAttendance(attHistory);
		    return "redirect:/Attendance/attendance";
	}
	else
	{
		System.out.println("elssssssss");
		  Student std = services.get(id);
		
		
		    AttendanceHistory attHistory = new AttendanceHistory();
		    attHistory.setStdid(std.getId());
		   // attHistory.setCourseid(std.getCourse());
		    attHistory.setAttdate(attDate);
		    attHistory.setAttdance("A");
		    attHistory.setAttboolean(false);
		    service.saveAttendance(attHistory);
		    return "redirect:/Attendance/attendance";
		
	}
		
	
    
}

/*
@RequestMapping("/absent/{id}")
public String absentStudentPage(@PathVariable(name = "id") int id) {


    Student std = services.get(id);
    std.setAttdance("A");
    std.setAttboolean(false);
    services.save(std);
    return "redirect:/Attendance/attendance";
    
  
    
}

*/

}
