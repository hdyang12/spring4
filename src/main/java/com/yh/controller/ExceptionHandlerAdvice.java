package com.yh.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过@ControllerAdvice,我们可以将对于控制器的全局配置放置在同一个位置,
 * 注解了@Controller的类的方法可使用@ExceptionHandler、@ModelAttribute
 * 、@InitBinder注解到方法上
 * @author yh
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	//http://localhost:8080/spring4/exception    当代码报错有异常时,会走到这里
	//@ExceptionHandler:全局处理控制器里的异常
	@ExceptionHandler(value = Exception.class)//value是过滤拦截条件,此处是拦截所有的Exception
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");//error页面
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute//绑定键值对到Model中;此处是让全局的@RequestMapping都能获得此处设置的键值对
	public void addAttributes(Model model) {
		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder//用来设置webDataBinder,webDataBinder用来自动绑定前台请求参数到Model中
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}
	
}
