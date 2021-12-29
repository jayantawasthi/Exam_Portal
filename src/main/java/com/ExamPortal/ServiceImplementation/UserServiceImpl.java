package com.ExamPortal.ServiceImplementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortal.Model.Role;
import com.ExamPortal.Model.User;
import com.ExamPortal.Model.User_role;
import com.ExamPortal.Repositories.RoleRepository;
import com.ExamPortal.Repositories.UserRepository;
import com.ExamPortal.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User CreateUser(User user, Set<User_role> user_roles) throws Exception {
		
		
		User findByUserName = this.userRepository.findByUsername(user.getUsername());
		
		if (findByUserName!=null) {
			System.out.println("User already is there!!");
			throw new Exception("User already present");			
		}
		else {
			for(User_role ur:user_roles)
			{
				 roleRepository.save(ur.getRole());
			}
			
			user.getRoles().addAll(user_roles);
			

			findByUserName = this.userRepository.save(user);
			
		}
		
		
		return findByUserName;
	}

	@Override
	public User GetUser(String username) {

		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void DeleteUser(int userid) {

		this.userRepository.deleteById(userid);
	}

}
