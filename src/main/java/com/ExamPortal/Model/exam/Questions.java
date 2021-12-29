package com.ExamPortal.Model.exam;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quesId;
	
	private String content;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String answer;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;


	public Questions(long quesId, String content, String option1, String option2, String option3, String option4,
			String answer, Quiz quiz) {
		super();
		this.quesId = quesId;
		this.content = content;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.quiz = quiz;
	}


	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Questions [quesId=" + quesId + ", content=" + content + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", quiz=" + quiz + "]";
	}


	public long getQuesId() {
		return quesId;
	}


	public void setQuesId(long quesId) {
		this.quesId = quesId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	

}
