package com.saurabh.onlineTest.entity;

import java.util.List;

public class Question {
	
	private int questionNo;
	
	private String question;
	
	private int correctOption;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	public Question() {
		
	}

	

	public Question(int questionNo, String question, int correctOption, String option1, String option2, String option3,
			String option4) {
		this.questionNo = questionNo;
		this.question = question;
		this.correctOption = correctOption;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}



	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
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



	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", question=" + question + ", correctOption=" + correctOption
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ "]";
	}


	
	
}
