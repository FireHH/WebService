package com.lmf.controller;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

/*@author:С��
 *@time:2017��11��4������2:38:20
 *@version:1.0
 */
@WebService
public interface SearchTel {

	public String getTel(String tel,HttpServletRequest request) ;
	public String getIp(HttpServletRequest request);
}
