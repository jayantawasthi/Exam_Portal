package com.ExamPortal.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User_role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_roleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;
	
	

	public long getUser_roleId() {
		return user_roleId;
	}

	public void setUser_roleId(long user_roleId) {
		this.user_roleId = user_roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User_role [user_roleId=" + user_roleId + ", user=" + user + ", role=" + role + "]";
	}

	public User_role(long user_roleId, User user, Role role) {
		super();
		this.user_roleId = user_roleId;
		this.user = user;
		this.role = role;
	}

	public User_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
