package com.yh.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * �ƻ�����ִ����
 * @author yh
 *
 */
@Service
public class ScheduledTaskService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	//ÿ���̶�ʱ��5sִ��
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("ÿ��5��ִ��һ�Σ�" + dateFormat.format(new Date()));
	}
	
	//ÿ���15:00:00ִ��
	@Scheduled(cron = "00 03 15 ? * *")
	public void fixTimeExecution(){
		System.out.println("��ָ��ʱ�䣺" + dateFormat.format(new Date()) + "ִ��");
	}

}
