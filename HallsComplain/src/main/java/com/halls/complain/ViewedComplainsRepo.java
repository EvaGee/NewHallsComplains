package com.halls.complain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedComplainsRepo extends JpaRepository
<ViewedComplains, String>{

	 public List<Complains> findByHostel(String hostel);

}
