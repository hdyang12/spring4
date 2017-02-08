package com.yh.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务器端推送技术 
 * @author yh
 *
 */
@Controller
public class SseController {
	
	/*
	 * 这里使用输出的媒体类型为text/event-stream,这是服务器端SSE的支持,本例演示每5秒像浏览器推送随机消息
	 */
	@RequestMapping(value="/push", produces = "text/event-stream")
	public @ResponseBody String push(){
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "data: Testing 1,2,3" + r.nextInt() + "\n\n";
		
	}

}
