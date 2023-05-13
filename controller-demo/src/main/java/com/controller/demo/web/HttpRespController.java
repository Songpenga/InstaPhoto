package com.controller.demo2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//파일을 리턴함
public class HttpRespController {

	@GetMapping("/txt")
	public String txt() {
		return "a.txt";
		//framework 사용(틀이 이미 정해져 있음)
		// 일반 정적 파일들은 resources/static 폴더 내부가 디폴트 경로이다.
	}
	
	@GetMapping("/mus")
	public String mus() {
		return "b";
		//머스태치 템플릿 엔진 라이브러리 등록완료 - templates폴더안에 .mustach을 나두면 확장자 없이
		//파일명만 적으면 자동으로 찾아감.
	}
	//jsp 엔진 사용 : src/main/webapp 폴더가 디폴트 경로
}
