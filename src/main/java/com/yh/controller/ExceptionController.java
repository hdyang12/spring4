package com.yh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	//http://localhost:8080/spring4/exception
	@RequestMapping(value = "/exception")
	public String exception(@ModelAttribute("msg") String msg){
		throw new IllegalArgumentException("参数错误:" + msg);
	}

}
