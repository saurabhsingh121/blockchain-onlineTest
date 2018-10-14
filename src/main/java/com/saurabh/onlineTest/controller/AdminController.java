package com.saurabh.onlineTest.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.onlineTest.entity.Question;
import com.saurabh.onlineTest.entity.User;
import com.saurabh.onlineTest.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getUserList")
	public String getGetUserList(Model theModel){
		List<User> theUsers = adminService.getUserList();
		theModel.addAttribute("theUsers", theUsers);
		return "admin-dashboard";
	}
	
	@GetMapping("/showFormForAddingQuestion")
	public String showFormForAddingQuestion() {
		return "question-form";
	}
	
	@GetMapping("/showFormForAddingTransfer")
	public String showFormForAddingTransfer(Model theModel) {
		theModel.addAttribute("user", new User());
		return "user-form";
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestParam("questionNo") int questionNo,
			@RequestParam("question") String question,
			@RequestParam("correctOption") int correctOption,
			@RequestParam("option1") String option1,
			@RequestParam("option2") String option2,
			@RequestParam("option3") String option3,
			@RequestParam("option4") String option4){
		List<String> optionList = new LinkedList<>();
		optionList.add(option1);
		optionList.add(option2);
		optionList.add(option3);
		optionList.add(option4);
		
		Question newQuestion = new Question(questionNo, question, correctOption, option1, option2, option3, option4);
		log.info("Inside addQuestion()===>New Question Detail===>"+ newQuestion);
		adminService.addQuestion(newQuestion);
		return "redirect:/admin/getUserList";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User theUser) {
		
		adminService.addUser(theUser);	
		
		return "redirect:/admin/getUserList";
	}
}
