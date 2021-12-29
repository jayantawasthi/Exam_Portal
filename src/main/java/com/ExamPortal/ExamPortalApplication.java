package com.ExamPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamPortalApplication     {
	
//	@Autowired
//	public StudentRepo studentRepo;
//	
//	@Autowired
//	public UserService userService;
	
	

	public static void main(String[] args)  {
		SpringApplication.run(ExamPortalApplication.class, args);
	
	}

//@Override
//public void run(String... args) throws Exception {
//	
//	User user=new User();
//	user.setPassword("skwewee");
//	user.setEmail("harish@gmail.com");
//	user.setEnabled(true);
//	user.setPhone("2424242424");
//	user.setProfile("profile.jpg");
//	user.setUsername("harish bhatt");
//	
//	Role role1=new Role();
//	role1.setRoleid(224);
//	role1.setRoleName("ADMIN");
//	
//	Set<User_role> userRoleSet=new HashSet<User_role>();
//	User_role user_role=new User_role();
//	user_role.setRole(role1);
//	user_role.setUser(user);
//	
//	
//	userRoleSet.add(user_role);
//role1.setUser_roles(userRoleSet);
//	User localuser = userService.CreateUser(user, userRoleSet);
//	System.out.println(localuser);
//	


}
