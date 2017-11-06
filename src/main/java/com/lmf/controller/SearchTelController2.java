package com.lmf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmf.po.TelNum;
import com.lmf.service.TelNumService;

/*@author:小火
 *@time:2017年11月4日下午9:14:14
 *@version:1.0
 */
@Controller
public class SearchTelController2 {

	@Resource
	TelNumService telService;
	@RequestMapping("search")
	public String getTel(Model model,String tel) {
		if(tel.length()>11||tel.length()<7) {
			model.addAttribute("result", "输入号码太长或太短");
		}else {
			String number=tel.substring(0, 7);
			TelNum telNum=telService.getTel(number);
			
			model.addAttribute("result", "号码归属地:"+telNum.getMobileArea()+"\t"+telNum.getMobileType());
		}
		return "search";
	}

}
