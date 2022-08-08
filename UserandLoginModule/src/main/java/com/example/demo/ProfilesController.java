package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class ProfilesController {

	
	@Autowired
	private ProfilesService service;
	
	
	@GetMapping("/profile")
	public String showProfilesPage(Model model) {
		Profiles profiles = new Profiles();
		model.addAttribute("profiles" , profiles);
		return "profile";
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfiles(@ModelAttribute("profiles") Profiles profiles) {
		service.save(profiles);
		return "profiledetails";
		
	
	}
	

}




