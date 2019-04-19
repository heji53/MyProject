package com.hj;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWordController {
	@RequestMapping("/aab")
	public String say() {
		return "HelloWord";
	}
}
