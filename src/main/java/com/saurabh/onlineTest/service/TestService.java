package com.saurabh.onlineTest.service;

import com.saurabh.onlineTest.entity.Question;

public interface TestService {

	Question showQuestion();

	void calculateScore(String questNo, int parseInt);

	int getScore();

}
