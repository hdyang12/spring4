package com.yh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.config.ConditionConfig;
import com.yh.service.ListService;

public class ConditionConfigMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService listService = context.getBean(ListService.class);
		System.out.println(listService.showListCmd());
		context.close();
	}

}
