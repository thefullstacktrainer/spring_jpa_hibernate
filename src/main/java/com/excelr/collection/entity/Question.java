package com.excelr.collection.entity;

import java.util.List;  

public class Question {  
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	private String qname;
	private List<String> answers;// List can be of any type
  
//getters and setters  
  
}  