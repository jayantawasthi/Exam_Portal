package com.ExamPortal.Service;

import java.util.Set;

import com.ExamPortal.Model.User;
import com.ExamPortal.Model.User_role;


public interface UserService {
	
	public User CreateUser(User user,Set<User_role> user_roles) throws Exception ;
	public User GetUser(String username);
	public void DeleteUser( int userid);
//	public UserService CreateUser(User user,Set<User_role> user_roles);
//	public UserService CreateUser(User user,Set<User_role> user_roles);
//	public UserService CreateUser(User user,Set<User_role> user_roles);

}
