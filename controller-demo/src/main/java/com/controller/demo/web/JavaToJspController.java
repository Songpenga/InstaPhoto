package com.controller.demo2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaToJspController {

	@GetMapping("/jsp/java")
	public String jspToJava() {
		return "d";
	}
	
	@GetMapping("/jsp/java/model")
	public String jspToJavaToModel(Model model) { //함수의 파라미터에 modelㅇ르 선언
		
		User user = new User();
		user.setUsername("ssar");
		
		model.addAttribute("usename", user.getUsername()); //addAttribute 함수로 전달
		return "e";
	}
}
