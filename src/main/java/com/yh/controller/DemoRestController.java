package com.yh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yh.model.DemoObj;

@RestController	//@RestController是一个组合注解,组合了@Controller 和   @ResponseBody
@RequestMapping("/rest")
public class DemoRestController {
	
	//application/json  返回数据的媒体类型为json
	//http://localhost:8080/spring4/rest/getjson?id=5&name=zhangsan
	@RequestMapping(value = "/getjson", produces = {"application/json;charset=UTF-8"})
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId() + 1, obj.getName() + "yh");//返回对象自动转换成json
	}
	
	//http://localhost:8080/spring4/rest/getxml?id=5&name=zhangsan
	@RequestMapping(value = "/getxml", produces = {"application/xml;charset=UTF-8"})
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId() + 1, obj.getName() + "yh");
	}

}
