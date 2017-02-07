package com.yh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当前这个项目走tomcat需要8.0+
 * @author yh
 *
 */
@Controller
public class HelloController {
	
	//http://localhost:8080/spring4/index
	@RequestMapping("/index")
	public String hello(){
		return "index";
	}

}
