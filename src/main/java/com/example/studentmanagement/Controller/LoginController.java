package com.example.studentmanagement.Controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.Domain.Login;
import com.example.studentmanagement.Service.LoginService;



@Controller
public class LoginController {
	
	@Autowired
    private LoginService userService;

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
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    	
	  
        return "redirect:/";
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile()
	{
	   
	    return "profile";
	}
	
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String attendance()
	{
	   
	    return "attendance";
	}
	
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
	   
	    return "leaves";
	}
    

	
	
	
}
