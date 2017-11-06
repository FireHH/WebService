package com.lmf.controller;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmf.po.TelNum;
import com.lmf.service.TelNumService;

/*@author:小火
 *@time:2017年11月4日上午3:10:52
 *@version:1.0
 */

@WebService
public class SearchTelController implements SearchTel{
	
	@Autowired
	TelNumService telService;
	@Override
	public String getTel(@WebParam(name="tel")String tel,HttpServletRequest request) {
		 
		if(tel.length()>11||tel.length()<7) {
			return "输入号码太长或太短";
		}else {
			String number=tel.substring(0, 7);
			TelNum telNum=telService.getTel(number);
			return "号码归属地:"+telNum.getMobileArea()+"\t"+telNum.getMobileType()+"ip:"+getIp(request);
		}
		
	}
	
	public String getIp(HttpServletRequest request) {
		 String ip = request.getHeader("X-Real-IP");
	        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	        ip = request.getHeader("X-Forwarded-For");
	        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
	            // 多次反向代理后会有多个IP值，第一个为真实IP。
	            int index = ip.indexOf(',');
	            if (index != -1) {
	                return ip.substring(0, index);
	            } else {
	                return ip;
	            }
	        } else {
	            return request.getRemoteAddr();
	        }
	}

}
