package com.etc.POI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		// ��ȡ����ļ�
		FileInputStream inputStream = new FileInputStream("d:\\my.xls");
		// ����HSSFWorkbook����
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// ����HSSFSheet����
		HSSFSheet sheet = workbook.getSheet("lx");
		// ����HSSFRow����(������)
		HSSFRow row = sheet.getRow(0);
		// ����HSSFCell����(������) short(5λ)
		HSSFCell cell = row.getCell((short) 0);
		// ���õ�Ԫ���ֵ
		String cellValue  = cell.getStringCellValue();
		 
		System.out.println(cellValue);
	}
}
