package com.ExamPortal.Model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  cId;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizs=new LinkedHashSet<>();
	
	
	public Set<Quiz> getQuizs() {
		return quizs;
	}


	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(long cId, String title, String description) {
		super();
		this.cId = cId;
		this.title = title;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Category [cId=" + cId + ", title=" + title + ", description=" + description + "]";
	}


	public long getcId() {
		return cId;
	}


	public void setcId(long cId) {
		this.cId = cId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

