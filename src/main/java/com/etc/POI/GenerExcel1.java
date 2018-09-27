/**
 * 动态生成表格
 */
package com.etc.POI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GenerExcel1 {
	
	public static void main(String[] args) throws IOException {
		// 创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建HSSFSheet对象
		HSSFSheet sheet = workbook.createSheet("lx");
		// 创建HSSFRow对象(纵坐标)
		HSSFRow row0 = sheet.createRow(0);
		// 创建HSSFCell对象并设值(横坐标) short(5位) 
		row0.createCell((short) 0).setCellValue("姓名");
		row0.createCell((short) 1).setCellValue("年龄");
		row0.createCell((short) 2).setCellValue("班级");
		row0.createCell((short) 3).setCellValue("成绩");
		// 创建HSSFRow对象(纵坐标)
		HSSFRow row1 = sheet.createRow(1);
		// 创建HSSFCell对象并设值(横坐标) short(5位) 
		row1.createCell((short) 0).setCellValue("lx");
		row1.createCell((short) 1).setCellValue("18");
		row1.createCell((short) 2).setCellValue("2.1");
		row1.createCell((short) 3).setCellValue("100");
		// 创建HSSFRow对象(纵坐标)
		HSSFRow row2 = sheet.createRow(2);
		// 创建HSSFCell对象并设值(横坐标) short(5位) 
		row2.createCell((short) 0).setCellValue("xy");
		row2.createCell((short) 1).setCellValue("80");
		row2.createCell((short) 2).setCellValue("2.1");
		row2.createCell((short) 3).setCellValue("59");
		// 输出Excel
		FileOutputStream outputStream = new FileOutputStream("d:\\my1.xls");
		workbook.write(outputStream);
		outputStream.flush();
		System.out.println("ok");
	}
}
