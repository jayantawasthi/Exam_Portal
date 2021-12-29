package com.ExamPortal.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleid;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<User_role> user_roles = new HashSet<>() ;
	
	
	
	
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User_role> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<User_role> user_roles) {
		this.user_roles = user_roles;
	}
	public Role(long roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", roleName=" + roleName + "]";
	}
	
	
	
	

}
