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
		// ��ȡ����ļ�
		FileInputStream inputStream = new FileInputStream("d:\\my1.xls");
		// ����HSSFWorkbook����
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// ��ȡ�ĵ��еĵ�һ����
		int sheetNumber = workbook.getNumberOfSheets();
		// ��sheet�е�ÿһ�н��е���
		for (int i = 0; i < sheetNumber; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);
			// ��ȡ��
			int firstRow = sheet.getFirstRowNum();
			int lastRow = sheet.getLastRowNum();
			for (int j = firstRow; j <= lastRow; j++) {
				HSSFRow row = sheet.getRow(j);
				// ��ȡ��Ԫ��
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
