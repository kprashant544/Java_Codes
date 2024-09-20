package com.quiz.app;

import java.util.List;

public class Question {
	String question;
	List<String> optionList;
	int correctAnswer;
	
	public Question(String question,List<String> optionList, int correctAnswer) {
		this.question=question;
		this.optionList=optionList;
		this.correctAnswer=correctAnswer;
	}
}