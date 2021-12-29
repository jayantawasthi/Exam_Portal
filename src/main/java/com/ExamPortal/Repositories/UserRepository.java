package com.ExamPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ExamPortal.Model.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
