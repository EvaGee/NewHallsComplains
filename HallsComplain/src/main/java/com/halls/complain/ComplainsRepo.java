package com.halls.complain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainsRepo extends JpaRepository<Complains, String>
{
public List<Complains> findByHostel(String Hostel);

public Complains findByRegno(String regno);

}
