package com.lmf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmf.po.TelNum;

/*@author:С��
 *@time:2017��11��3������6:40:34
 *@version:1.0
 */
public interface TelNumMapper {
	
	
//	public int insertData(List<TelNum> list);
	public int insertData(TelNum telnum);
	public TelNum getTel(String tel);

}
