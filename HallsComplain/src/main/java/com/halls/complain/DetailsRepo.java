package com.halls.complain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepo extends JpaRepository<Details, String>
{
	public Details findByRegnoAndPassword(String regno, String password);
}
