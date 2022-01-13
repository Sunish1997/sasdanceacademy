package com.example.studentmanagement.Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.example.studentmanagement.Domain.AttendanceReport;
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
	
	java.util.Date  datee = new java.util.Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");  
	String strDate = dateFormat.format(datee); 
	
	String attMonth = strDate;
	
	
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
	
	@RequestMapping(value = "/submitMonth", method = RequestMethod.POST)
	public String submitMonthh(@ModelAttribute("atthistory") AttendanceReport attRpt)
	{
		System.out.println("monthhhh "+attRpt.getAttMonthString());
		attMonth = attRpt.getAttMonthString() ;
		
		 return "redirect:/Attendance/attendanceReport";
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
	
	
	@RequestMapping(value = "/attendanceReport", method = RequestMethod.GET)
	public String viewAttendanceReport(Model model) {
		System.out.println("Monthhhhhh "+attMonth);
		
		String[] splitDate = attMonth.split("-");
		
		Long year =Long.parseLong( splitDate[0]);
		Long month = Long.parseLong( splitDate[1]);
		System.out.println("year"+year);
		System.out.println("month"+month);
		int workingDays = 0;
		System.out.println("std at date "+attDate);
		
		List<Object[]> studentAttList = studentRepository.findStudentAttList(attDate) ;
	
		System.out.println(studentAttList);	
		System.out.println(studentAttList.size());
		
		 List<AttendanceReport> li = new ArrayList<>();
	//	 attHistBackup = new ArrayList<>();
		 
		 for(Object[] o : studentAttList  )
		 {
			 AttendanceReport attReport = new AttendanceReport();
			 
			 attReport.setId(Long.parseLong(String.valueOf(o[0])));
			 attReport.setStname((String)o[1]);
			 attReport.setCoursename((String)o[2]);
				int noOFdaysPresentCount = 0;
				int noOFdaysAbsentCount = 0;
			// System.out.println("attReport 1");	
			 List<Object[]> attendanceReportList = attendanceRepository.findAttReportList(year,month,Long.parseLong(String.valueOf(o[0]))) ;
			
			 System.out.println("studentAttList ");	
			 for(Object[] attRptList : attendanceReportList  )
			 {
				// java.util.Date  datee = new java.util.Date();
				//	DateFormat dateFormat = new SimpleDateFormat("dd");  
				//	String strDate = dateFormat.format(datee); 
				
			// System.out.println("strDay "+ attRptList[0]);
			System.out.println("PresentOrAbsent "+ (String)attRptList[1]);
			Long strDay = Long.parseLong(String.valueOf(attRptList[0]));
			String  strDays= String.valueOf(strDay);  
			System.out.println("strDays "+strDays);
			
			
			if(((String)attRptList[1]).equalsIgnoreCase("P"))
			{
			noOFdaysPresentCount++;	
				
			}
			else if(((String)attRptList[1]).equalsIgnoreCase("A"))
			{
			noOFdaysAbsentCount++;	
				
			}
			
			
		
				switch (strDays) {
				case "1":
					
					attReport.setAtt1((String)attRptList[1]	);
					break;
	case "2":
		attReport.setAtt2((String)attRptList[1]);
					break;
	case "3":
		attReport.setAtt3((String)attRptList[1]);
		break;
	case "4":
		attReport.setAtt4((String)attRptList[1]);
		break;
	case "5":
		attReport.setAtt5((String)attRptList[1]);
		break;
	case "6":
		attReport.setAtt6((String)attRptList[1]);
		break;
	case "7":
		attReport.setAtt7((String)attRptList[1]);
		break;
	case "8":
		attReport.setAtt8((String)attRptList[1]);
		break;
	case "9":
		attReport.setAtt9((String)attRptList[1]);
		break;
	case "10":
		attReport.setAtt10((String)attRptList[1]);
		break;
	case "11":
		attReport.setAtt11((String)attRptList[1]);
		break;
	case "12":
		attReport.setAtt12((String)attRptList[1]);
		break;
	case "13":
		attReport.setAtt13((String)attRptList[1]);
		break;
	case "14":
		attReport.setAtt14((String)attRptList[1]);
		break;
	case "15":
		attReport.setAtt15((String)attRptList[1]);
		break;
	case "16":
		attReport.setAtt16((String)attRptList[1]);
		break;
	case "17":
		attReport.setAtt17((String)attRptList[1]);
		break;
	case "18":
		attReport.setAtt18((String)attRptList[1]);
		break;
	case "19":
		attReport.setAtt19((String)attRptList[1]);
		break;
	case "20":
		attReport.setAtt20((String)attRptList[1]);
		break;
	case "21":
		attReport.setAtt21((String)attRptList[1]);
		break;
	case "22":
		attReport.setAtt22((String)attRptList[1]);
		break;
	case "23":
		attReport.setAtt23((String)attRptList[1]);
		break;
	case "24":
		attReport.setAtt24((String)attRptList[1]);
		break;
	case "25":
		attReport.setAtt25((String)attRptList[1]);
		break;
	case "26":
		attReport.setAtt26((String)attRptList[1]);
		break;
	case "27":
		attReport.setAtt27((String)attRptList[1]);
		break;
	case "28":
		attReport.setAtt28((String)attRptList[1]);
		break; 	
	case "29":
		attReport.setAtt29((String)attRptList[1]);
		break;
	case "30":
		attReport.setAtt30((String)attRptList[1]);
		break;
	case "31":
		attReport.setAtt31((String)attRptList[1]);
		break;
	
				} 
				
				attReport.setNoOFdaysPresent(noOFdaysPresentCount)	 ;
				attReport.setNoOFdaysAbsent(noOFdaysAbsentCount);
				if((noOFdaysPresentCount+noOFdaysAbsentCount)>workingDays)
				 workingDays = (noOFdaysPresentCount+noOFdaysAbsentCount);
				
			 }
			 
			
			//	attReport.setTotalWorkingDays(workingDays);
				
			 
			 attReport.setAttdance((String)o[3]);
		//	 System.out.println("Hiii"  );
			 System.out.println(o[4]);
			 if(o[4] == null)
			 {
				 
				 attReport.setAttboolean(false);  
			 }
			 else
			 {
			 if(Long.parseLong(String.valueOf(o[4]))==1)
			 {
				 System.out.println("True"  );
				 attReport.setAttboolean(true);
				 }
			 else if(Long.parseLong(String.valueOf(o[4]))==0)
			 {
				 System.out.println("false"  );
				 attReport.setAttboolean(false); 
			 }
			 }
			 li.add(attReport);
			
			// attHistBackup.add(student);
		 }
		 for(AttendanceReport a : li)
		 {
			a.setTotalWorkingDays(workingDays) ;
			 
		 }
		 
		    model.addAttribute("liststudent", li);
		    AttendanceReport attReport =  new AttendanceReport();
		    attReport.setAttMonthString(attMonth);
		    model.addAttribute("atthistory", attReport);
		    return "attendancereport";
		}
	
	/* 	
	if(strDays.equalsIgnoreCase("1"))
	{
		attReport.setAtt1((String)attRptList[1]	);
		System.out.println("PorA 1 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("2"))
	{
		attReport.setAtt2((String)attRptList[1]	);
		System.out.println("PorA 2 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("3"))
	{
		attReport.setAtt3((String)attRptList[1]	);
		System.out.println("PorA 3 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("4"))
	{
		attReport.setAtt4((String)attRptList[1]	);
		System.out.println("PorA 4 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("5"))
	{
		attReport.setAtt5((String)attRptList[1]	);
		System.out.println("PorA 5 "+(String)attRptList[1]);
	}
	
	if(strDays.equalsIgnoreCase("6"))
	{
		attReport.setAtt6((String)attRptList[1]	);
		System.out.println("PorA 6"+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("7"))
	{
		attReport.setAtt7((String)attRptList[1]	);
		System.out.println("PorA 7 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("8"))
	{
		attReport.setAtt8((String)attRptList[1]	);
		System.out.println("PorA 8 "+(String)attRptList[1]);
	}
	if(strDays.equalsIgnoreCase("9"))
	{
		attReport.setAtt9((String)attRptList[1]	);
		System.out.println("PorA 9 "+(String)attRptList[1]);
	}
	*/ 	
	
	
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
