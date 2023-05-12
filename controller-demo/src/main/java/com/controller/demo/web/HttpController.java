package com.controller.demo2.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //File을 응답하는 컨트롤러(클라이언트가 브라우저면 .html을)
@RestController//data를 응답하는 컨트롤러(클라이언트가 핸드폰이면 data)
public class HttpController {

	@GetMapping("/get")
	public String get() {
		return "<h1>get요청됨</h1>";
	}
	
	@PostMapping("/post")
	public String post() {
		return "Post요청됨";
	}
	
	@PutMapping("/put")
	public String put() {
		return "Put요청됨";
	}
	
	@DeleteMapping("/delete")
	public String delete() {
		return "Delete요청됨";
	}
}
