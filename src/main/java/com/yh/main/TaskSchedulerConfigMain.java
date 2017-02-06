package com.yh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.config.TaskSchedulerConfig;

public class TaskSchedulerConfigMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext taskContext = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
	}

}
