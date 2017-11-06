package com.lmf.controller;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

/*@author:小火
 *@time:2017年11月4日下午2:38:20
 *@version:1.0
 */
@WebService
public interface SearchTel {

	public String getTel(String tel,HttpServletRequest request) ;
	public String getIp(HttpServletRequest request);
}
