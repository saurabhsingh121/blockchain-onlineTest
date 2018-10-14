package com.saurabh.onlineTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.onlineTest.entity.Question;
import com.saurabh.onlineTest.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/showQuestion")
	public String showQuestion(Model theModel){
		Question question = testService.showQuestion();
		theModel.addAttribute("question", question);
		
		return "question-page";
	}
	
	@PostMapping("/calculateScore")
	public String calculateScore(@RequestParam("questNo") String questNo, 
			@RequestParam("correctOption") String correctOption){
		testService.calculateScore(questNo, Integer.parseInt(correctOption));
		return "redirect:/test/showQuestion";
	}
	
	@GetMapping("/getScore")
	public String getScore(Model theModel){
		int score = testService.getScore();
		theModel.addAttribute("score", score);
		return "score-page";
	}
}
