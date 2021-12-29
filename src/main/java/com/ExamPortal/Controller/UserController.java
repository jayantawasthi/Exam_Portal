package com.ExamPortal.Controller;

import java.util.HashSet;
import java.util.Set;import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortal.Model.Role;
import com.ExamPortal.Model.User;
import com.ExamPortal.Model.User_role;
import com.ExamPortal.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
// creating user
	@PostMapping("/")
	public User CreateUser(@RequestBody User user) throws Exception {
		
		Set<User_role> user_roles=new HashSet<User_role>();
		
		user.setEnabled(true);
		user.setProfile("photo.png");
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Role role=new Role();
//		role.setRoleid();
		role.setRoleName("NORMAL");
		
		User_role user_role=new User_role();
		user_role.setUser(user);	
		user_role.setRole(role);
		
		user_roles.add(user_role);
		
		return this.userService.CreateUser(user, user_roles);	
		
	}

//get single user
	@GetMapping("/{username}")
	public User getUser(@PathVariable ("username") String username) {
	
		 return this.userService.GetUser(username);
		
	}

//delete single user
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable("userid")int userid)
	{
		this.userService.DeleteUser(userid);
		
	}
	

}
