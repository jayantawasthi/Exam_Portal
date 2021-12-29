package com.ExamPortal.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortal.Model.User;
import com.ExamPortal.Model.jwtRequest;
import com.ExamPortal.Model.jwtResponse;
import com.ExamPortal.SecurityConfiguration.JwtUtil;
import com.ExamPortal.ServiceImplementation.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody jwtRequest jwtRequest) throws Exception{

		try {

			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("user not found");
		}
		
		// authencate
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new jwtResponse(token));
		
	}
	
	private void authenticate(String username,String password) throws Exception {
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			
		} catch (DisabledException e) {
			throw new Exception("User disabled"+e.getMessage());
			
		}
		catch (BadCredentialsException e) {
			throw new Exception("invlid credentials"+e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
	public  User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	}

}
