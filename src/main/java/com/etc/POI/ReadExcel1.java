package com.etc.POI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel1 {
	
	public static List<HSSFRow> getAllRow() throws IOException {
		// 读取表格文件
		FileInputStream inputStream = new FileInputStream("d:\\my1.xls");
		// 创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// 获取文档中的第一个表单
		int sheetNumber = workbook.getNumberOfSheets();
		// 对sheet中的每一行进行迭代
		for (int i = 0; i < sheetNumber; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);
			// 获取行
			int firstRow = sheet.getFirstRowNum();
			int lastRow = sheet.getLastRowNum();
			for (int j = firstRow; j <= lastRow; j++) {
				HSSFRow row = sheet.getRow(j);
				// 获取单元格
				int firstCell = row.getFirstCellNum();
				int lastCell = row.getLastCellNum();
				for (int k = firstCell; k <= lastCell; k++) {
					HSSFCell cell = row.getCell((short) k);
					System.out.println(cell.getStringCellValue());
				}
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		getAllRow();
	}
}
