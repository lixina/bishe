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

public class GenerExcel {
	
	public static void main(String[] args) throws IOException {
		// 创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建HSSFSheet对象
		HSSFSheet sheet = workbook.createSheet("lx");
		// 创建HSSFRow对象(纵坐标)
		HSSFRow row = sheet.createRow(0);
		// 创建HSSFCell对象(横坐标) short(5位)
		HSSFCell cell = row.createCell((short) 0);
		// 设置单元格的值
		cell.setCellValue("lx  2hhhhh");
		// 输出Excel
		FileOutputStream outputStream = new FileOutputStream("d:\\my.xls");
		workbook.write(outputStream);
		outputStream.flush();
		System.out.println("ok");
	}
}
