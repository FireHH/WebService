package com.lmf.po;
/*@author:С��
 *@time:2017��11��3������6:40:55
 *@version:1.0
 */
public class TelNum {
	private int id;
	private String MobileNumber;
	private String MobileArea;
	private String MobileType;
	private int AreaCode;
	private int PostCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getMobileArea() {
		return MobileArea;
	}
	public void setMobileArea(String mobileArea) {
		MobileArea = mobileArea;
	}
	public String getMobileType() {
		return MobileType;
	}
	public void setMobileType(String mobileType) {
		MobileType = mobileType;
	}
	public int getAreaCode() {
		return AreaCode;
	}
	public void setAreaCode(int areaCode) {
		AreaCode = areaCode;
	}
	public int getPostCode() {
		return PostCode;
	}
	public void setPostCode(int postCode) {
		PostCode = postCode;
	}
	
	
	

}
