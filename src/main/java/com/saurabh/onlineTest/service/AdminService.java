package com.saurabh.onlineTest.service;

import java.util.List;

import com.saurabh.onlineTest.entity.Question;
import com.saurabh.onlineTest.entity.User;

public interface AdminService {

	List<User> getUserList();

	void addQuestion(Question newQuestion);

	void addUser(User theUser);

}
