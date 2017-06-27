package com.example.demo;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/demo") 
public class NewController {
 
	private UserRepository userRepository;
	private Session sessionfactory;
	@GetMapping("/add")
	   public String greetingForm(Model model) {
	      
			model.addAttribute("user", new User());
			
	       return "index";
	   }
 
	
	
	@PostMapping("/add")
	   public  String greetingSubmit(@ModelAttribute User user,Model model) {
		 
			userRepository.save(user);
			
			
		   String list="";
		 
		  //return "result";
		  for (User users: userRepository.findAll()){
			  
			  list += users.toString()+"<br>";
			  
			  
		  };
		  
		  model.addAttribute("list", list);
		  
	
		  
		  return "result";
	   }

}
