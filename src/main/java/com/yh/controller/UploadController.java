package com.yh.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file){//使用MultipartFile接受上传的文件
		try {
			FileUtils.writeByteArrayToFile(new File("d:/upload/"+file.getOriginalFilename()),file.getBytes());
			return "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "wrong";
		}
	}

}
