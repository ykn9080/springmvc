package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/hello")
	public String main() {
		System.out.println("hellooooo");
		return "hello1";
	}

}
