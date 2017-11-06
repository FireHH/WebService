package com.lmf.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lmf.service.TelNumService;

/*@author:小火
 *@time:2017年10月31日下午7:20:02
 *@version:1.0
 */

@Controller
public class UploadExcelController {

	@Resource
	TelNumService telService;
	
	@RequestMapping("/uploadexcel")
	public String uploadExcel(Model model, HttpServletRequest req, MultipartFile file) {

		// 获得servlet上下文引用，从上下文引用获得上传目录
		String path = req.getServletContext().getRealPath("upload");
		String filename = file.getOriginalFilename();

		// 创建上传文件的对象
		File tempfile = new File(path, filename);
		// 判断上传文件对象是否为空，为空则创建目录,包含父目录
		if (tempfile.exists()) {
			tempfile.mkdirs();
		}

		int n=0;
		// 把上传的文件保存到目录
		try {
			file.transferTo(tempfile);
			n=telService.insertData(tempfile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 提示信息
		if(n>0) {
			model.addAttribute("msg", "数据录入成功");
		}

		return "success";
		

	}
}
