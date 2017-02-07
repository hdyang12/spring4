package com.yh.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 计划任务执行类
 * @author yh
 *
 */
@Service
public class ScheduledTaskService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	//每隔固定时间5s执行
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("每隔5秒执行一次：" + dateFormat.format(new Date()));
	}
	
	//每天的15:00:00执行
	@Scheduled(cron = "00 03 15 ? * *")
	public void fixTimeExecution(){
		System.out.println("在指定时间：" + dateFormat.format(new Date()) + "执行");
	}

}
