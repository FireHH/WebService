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

/*@author:С��
 *@time:2017��10��31������7:20:02
 *@version:1.0
 */

@Controller
public class UploadExcelController {

	@Resource
	TelNumService telService;
	
	@RequestMapping("/uploadexcel")
	public String uploadExcel(Model model, HttpServletRequest req, MultipartFile file) {

		// ���servlet���������ã������������û���ϴ�Ŀ¼
		String path = req.getServletContext().getRealPath("upload");
		String filename = file.getOriginalFilename();

		// �����ϴ��ļ��Ķ���
		File tempfile = new File(path, filename);
		// �ж��ϴ��ļ������Ƿ�Ϊ�գ�Ϊ���򴴽�Ŀ¼,������Ŀ¼
		if (tempfile.exists()) {
			tempfile.mkdirs();
		}

		int n=0;
		// ���ϴ����ļ����浽Ŀ¼
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
		
		// ��ʾ��Ϣ
		if(n>0) {
			model.addAttribute("msg", "����¼��ɹ�");
		}

		return "success";
		

	}
}
