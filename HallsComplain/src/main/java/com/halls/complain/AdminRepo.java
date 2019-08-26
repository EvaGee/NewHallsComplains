package com.halls.complain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> 
{
	
	public Admin findByStaffnoAndPassword(String staffno, String password);

}
