package com.halls.complain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServiceHalls {
	@Autowired
	DetailsRepo drepo;
	
	@Autowired
	ComplainsRepo crepo;
	
	@Autowired
	AdminRepo arepo;
	
	@Autowired
	CustoRepo curepo;
	
	@Autowired
	ViewedComplainsRepo vcrepo;
	
	@Autowired
	StatusRepo srepo;
	
	public 	String saved(Complains details) {
		String message="";
		crepo.save(details);
		if(crepo.save(details)!=null) {
		message="Complain sent";	
		}else {
			message="Try again!";
		}
		return message;
	}
	
public void save (Details details) {
	 	drepo.save(details);
	}
	public Details getDetails(String regno, String password)
	{
		return drepo.findByRegnoAndPassword(regno, password);
		}
	
public void save(Admin admin)
	{
		arepo.save(admin);
	}
	public Admin validate(String staffno, String password)
	{
		return arepo.findByStaffnoAndPassword(staffno, password);
	}
	
public void save(Custo custo)
{
	curepo.save(custo);
}
	public Custo validation(String staffno, String password)
	{
		return curepo.findByStaffnoAndPassword(staffno, password);
	}

public void save(ViewedComplains viewed)
{
	vcrepo.save(viewed);
}
	public List<Complains> getAll() {
		
		return crepo.findAll();
		
	}

	public List<Complains> getHostel(String hostel) {
		
		return vcrepo.findByHostel(hostel);
	}

	public Complains findComplain(String regno) {
		return crepo.findByRegno(regno);
	}

	public String saveViewed(ViewedComplains viewed) {
		String message="";
	vcrepo.save(viewed);
	if(vcrepo.save(viewed)!=null) {
		message="saved successfully";
	}else {
		message="failed to save";
	}
		return message;
	}

	public void deleteComplain(String regno) {
		crepo.deleteById(regno);
		
	}

	public void saveStatus(Status status) {
		srepo.save(status);
		
	}

		
}
