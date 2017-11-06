package com.lmf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmf.po.TelNum;
import com.lmf.service.TelNumService;

/*@author:С��
 *@time:2017��11��4������9:14:14
 *@version:1.0
 */
@Controller
public class SearchTelController2 {

	@Resource
	TelNumService telService;
	@RequestMapping("search")
	public String getTel(Model model,String tel) {
		if(tel.length()>11||tel.length()<7) {
			model.addAttribute("result", "�������̫����̫��");
		}else {
			String number=tel.substring(0, 7);
			TelNum telNum=telService.getTel(number);
			
			model.addAttribute("result", "���������:"+telNum.getMobileArea()+"\t"+telNum.getMobileType());
		}
		return "search";
	}

}
