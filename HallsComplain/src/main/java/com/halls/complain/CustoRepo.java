package com.halls.complain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustoRepo extends JpaRepository<Custo, String>
{
	public Custo findByStaffnoAndPassword(String staffno, String password);
}
