/**
 * ��̬���ɱ��
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
		// ����HSSFWorkbook����
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����HSSFSheet����
		HSSFSheet sheet = workbook.createSheet("lx");
		// ����HSSFRow����(������)
		HSSFRow row = sheet.createRow(0);
		// ����HSSFCell����(������) short(5λ)
		HSSFCell cell = row.createCell((short) 0);
		// ���õ�Ԫ���ֵ
		cell.setCellValue("lx  2hhhhh");
		// ���Excel
		FileOutputStream outputStream = new FileOutputStream("d:\\my.xls");
		workbook.write(outputStream);
		outputStream.flush();
		System.out.println("ok");
	}
}
