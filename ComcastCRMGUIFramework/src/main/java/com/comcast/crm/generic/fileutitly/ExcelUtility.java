package com.comcast.crm.generic.fileutitly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDtaFromExcel(String sheet,int rowNum,int celNum) throws Exception, Exception
	{
		FileInputStream fis =new FileInputStream("./TestData/OrgData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheet).getRow(rowNum).getCell(celNum).getStringCellValue().toString();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheet) throws Exception
	{
		FileInputStream fis =new FileInputStream("./TestData/OrgData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheet,int rowNum,int celNum,String data) throws Exception
	{
		FileInputStream fis =new FileInputStream("./TestData/OrgData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(rowNum).createCell(celNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./TestData/OrgData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
