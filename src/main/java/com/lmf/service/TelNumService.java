package com.lmf.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.lmf.dao.TelNumMapper;
import com.lmf.po.TelNum;

/*@author:小火
 *@time:2017年11月3日下午7:18:04
 *@version:1.0
 */

@Service
public class TelNumService {

	@Resource
	TelNumMapper telMapper;
	
	
	public TelNum getTel(String number) {
		return telMapper.getTel(number);
	}

	public int insertData(File tempfile) {
		int n = 0;

//		List<TelNum> list = new ArrayList<TelNum>();

		// 读取文件内容到workbook
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(tempfile);
			// 4、遍历工作簿下面的所有工作表
			int sheetnum = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetnum; i++) {
				// 获取到单个工作表
				Sheet sheet = workbook.getSheetAt(i);
				// 获取工作表下的所有行数
				int rownum = sheet.getPhysicalNumberOfRows();
				// 获取第一行的单元格个数
				for (int j = 1; j < rownum; j++) {
					// 获取到每一行
					Row row = sheet.getRow(j);
					int cellnum = row.getPhysicalNumberOfCells();

					List<Object> objlist=new ArrayList<Object>();
					// 获取每一行下的全部单元格
					for (int x = 0; x < cellnum; x++) {
						
						Cell cell = row.getCell(x);
						Object obj=null;
						// 获得一行里面的每一个单元格
						if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							obj=cell.getStringCellValue() ;
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							obj=cell.getNumericCellValue();
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
							obj=cell.getBooleanCellValue();
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
							obj=null;
						} else {
							obj=cell.getDateCellValue();
						}
						objlist.add(obj);
						
					}
					TelNum tm = new TelNum(); 
					
					tm.setMobileNumber((String)objlist.get(1)); 
					tm.setMobileArea((String)objlist.get(2));
					tm.setMobileType((String)objlist.get(3));
					tm.setAreaCode(Integer.parseInt(String.valueOf(objlist.get(4)))); 
					tm.setPostCode(Integer.parseInt(String.valueOf(objlist.get(5)))); 
					
					n = telMapper.insertData(tm);
//					list.add(tm);
				}
			}
			
			// 调用接口插入数据
//			n = telMapper.insertData(list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;
	}
	
	

}
