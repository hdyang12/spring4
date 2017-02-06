package com.yh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.config.TaskExecutorConfig;
import com.yh.service.AsyncTaskService;

public class TaskExecutorConfigMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext taskContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService asyncTaskService = taskContext.getBean(AsyncTaskService.class);
		for (int i = 0; i < 10; i++) {
			asyncTaskService.executeAsyncTask(i);
			asyncTaskService.executeAsyncTaskPlus(i);
		}
		taskContext.close();
	}

}
