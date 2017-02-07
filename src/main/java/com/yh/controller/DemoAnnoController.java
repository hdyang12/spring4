package com.yh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.model.DemoObj;

/**
 * 注解演示控制器
 * @author yh
 *
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	
	//http://localhost:8080/spring4/anno
	//@ResponseBody 支持 将返回值 放在response体内，而不是返回一个页面
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request){
		return "url:" + request.getRequestURI() + " can access";
	}
	
	//http://localhost:8080/spring4/anno/pathvar/demo1
	@RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathvar(@PathVariable String str,HttpServletRequest request){
		return "url:" + request.getRequestURI() + " can access " + str;
	}
	
	//http://localhost:8080/spring4/anno/requestParam?id=5
	@RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
		return "url:" + request.getRequestURI() + " can access " + id;
	}
	
	//http://localhost:8080/spring4/anno/obj?id=5&name=zhangsan
	@RequestMapping(value = "/obj",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj obj,HttpServletRequest request){
		return "url:" + request.getRequestURI() + " can access, obj id:" + obj.getId() + " obj name:" + obj.getName();
	}
	
	//http://localhost:8080/spring4/anno/name2
	@RequestMapping(value = {"/name1" , "/name2"},produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request){
		return "url:" + request.getRequestURI() + " can access";
	}

}
