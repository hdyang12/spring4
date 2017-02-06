package com.yh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.config.DiConfig;
import com.yh.service.BeanWayService;

public class DiConfigMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		BeanWayService beanWayService = context.getBean(BeanWayService.class);
		context.close();
	}

}
