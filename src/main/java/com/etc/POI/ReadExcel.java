package com.etc.POI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		// 读取表格文件
		FileInputStream inputStream = new FileInputStream("d:\\my.xls");
		// 创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// 创建HSSFSheet对象
		HSSFSheet sheet = workbook.getSheet("lx");
		// 创建HSSFRow对象(纵坐标)
		HSSFRow row = sheet.getRow(0);
		// 创建HSSFCell对象(横坐标) short(5位)
		HSSFCell cell = row.getCell((short) 0);
		// 设置单元格的值
		String cellValue  = cell.getStringCellValue();
		 
		System.out.println(cellValue);
	}
}
