package com.koreait.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/async")
	public @ResponseBody String async() {
		// 비동기처리시,
		// 페이지 이동 xxx
		// 정보 전달 O
		return "apple";
	}
	
}