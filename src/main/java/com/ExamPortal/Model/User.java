package com.ExamPortal.Model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int uid;	
	private  String username;
	private  String password;
	private  String email;
	private  String profile;
	private  String phone;
	private  boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private  Set<User_role>  roles =new HashSet<>();	

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<User_role> getRoles() {
		return roles;
	}

	public void setRoles(Set<User_role> roles) {
		this.roles = roles;
	}

	public User(int uid, String username, String password, String email, String profile, String phone, boolean enabled,
			Set<User_role> roles) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.phone = phone;
		this.enabled = enabled;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", profile=" + profile + ", phone=" + phone + ", enabled=" + enabled + ", roles=" + roles + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Set<Authority> authorities=new HashSet<>();
		
		 this.roles.forEach(userRole->{
			 authorities.add(new Authority(userRole.getRole().getRoleName()));
		 });
		 
		
		 
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	

}
