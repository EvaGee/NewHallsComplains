package com.halls.complain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HallsController {
	
@Autowired
ServiceHalls service;
	
@RequestMapping("/halls")
public String getHalls()
{
	return "login";
}

@PostMapping("/register")
public String getLogin(Details details)
{
	service.save(details);
	return "login";
}

@PostMapping("/login")
public String validate(@RequestParam String regno,
		@RequestParam String password, Model model)

{	
	Details details=service.getDetails(regno, password);
	
	if(details!=null) {
		model.addAttribute("details", details);
		return "welcome";
	}
	else {
		return "login";
	}
	
}

@PostMapping("/welcome")
public String submitComplains(@RequestParam String comment,
		@RequestParam String name,@RequestParam String regno,
		@RequestParam String block,@RequestParam String hostel,
		@RequestParam String room
		,Model model)
{
	
	Complains details=new Complains();
	details.setRegno(regno);
	details.setBlock(block);
	details.setComment(comment);
	details.setHostel(hostel);
	details.setName(name);
	details.setRoom(room);
	String message=service.saved(details);
	model.addAttribute("message", message);
	model.addAttribute("details", details);
	return "Welcome";
}

@RequestMapping("/admin")
public String adminRegistration(){
	return "AdminLogin";
}
@PostMapping("/adminregister")
public String adminLogin(Admin admin) {
	service.save(admin);
	return "AdminLogin";
}

@PostMapping("/adminlogin")
public String validateAdmin(@RequestParam String staffno,
		@RequestParam String password, Model model) {
	Admin admin=service.validate(staffno, password);
	if(admin!=null) {
		model.addAttribute("admin", admin);
		return "AdminWelcome";
	}
	else {
		return "AdminLogin";
	}
	
}

@RequestMapping("/custo")
public String custoRegister() {
	return "CustoLogin";
}

@PostMapping("/custoregister")
public String custoLogin(Custo custo) { 
	service.save(custo);
	return "CustoLogin";
}

@PostMapping("/custologin")
public String validateCusto(@RequestParam String staffno,
		@RequestParam String password, Model model) {
	Custo custo=service.validation(staffno, password);
	if(custo!=null){
	model.addAttribute("custo", custo);
	return "CustoWelcome";
	}
	else {
		return "CustoLogin";
	}
	}
	@RequestMapping("/getComplains")
	public String getAll(Model model) {
		List<Complains> myList=service.getAll();
		model.addAttribute("myList", myList);
	    return "AdminWelcome";
	}
    
	@RequestMapping("/getHostel")
	public String getHostels(@RequestParam String hostel,Model model) {
		List<Complains> myList=service.getHostel(hostel);
		model.addAttribute("myList", myList);
		
	    return "CustoView";
	}
	
	@RequestMapping("/registration")
	public String registration() {
	return "Register";
	}
	@RequestMapping("/adminregistration")
	public String adminregistration() {
	return "AdminRegister";
	}
	@RequestMapping("/custoregistration")
	public String custoregistration() {
	return "CustoRegister";
	}
	
	@RequestMapping("/seeAll")
	public String seeAll(@RequestParam String regno,Model model)
	{
		Complains complain=service.findComplain(regno);
		model.addAttribute("complain", complain);
		return "AdminView";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam String regno,
			@RequestParam String name,@RequestParam String room,
			@RequestParam String block,@RequestParam String hostel,
			@RequestParam String comment,
			Model model) {
		ViewedComplains viewed=new ViewedComplains();
		viewed.setBlock(block);
		viewed.setComment(comment);
		viewed.setHostel(hostel);
		viewed.setName(name);
		viewed.setRegno(regno);
		viewed.setRoom(room);
		String message=service.saveViewed(viewed);
		model.addAttribute("message",message);
		Status status=new Status();
		status.setRegno(regno);
		status.setMyStatus(true);
		service.saveStatus(status);
		service.deleteComplain(regno);
		return "AdminWelcome";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam String regno) {
		Status status=new Status();
		status.setRegno(regno);
		status.setMyStatus(false);
		service.saveStatus(status);
		service.deleteComplain(regno);
		return "AdminWelcome";
	}
	
}


