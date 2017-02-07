package com.yh.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 多线程任务执行类
 * @author yh
 *
 */
@Service
public class AsyncTaskService {
	
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println("执行异步任务 ：" + i);
	}
	
	@Async
	public void executeAsyncTaskPlus(Integer i){
		System.out.println("执行异步任务 +1：" + i);
	}

}
