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

public class GenerExcel1 {
	
	public static void main(String[] args) throws IOException {
		// ����HSSFWorkbook����
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����HSSFSheet����
		HSSFSheet sheet = workbook.createSheet("lx");
		// ����HSSFRow����(������)
		HSSFRow row0 = sheet.createRow(0);
		// ����HSSFCell������ֵ(������) short(5λ) 
		row0.createCell((short) 0).setCellValue("����");
		row0.createCell((short) 1).setCellValue("����");
		row0.createCell((short) 2).setCellValue("�༶");
		row0.createCell((short) 3).setCellValue("�ɼ�");
		// ����HSSFRow����(������)
		HSSFRow row1 = sheet.createRow(1);
		// ����HSSFCell������ֵ(������) short(5λ) 
		row1.createCell((short) 0).setCellValue("lx");
		row1.createCell((short) 1).setCellValue("18");
		row1.createCell((short) 2).setCellValue("2.1");
		row1.createCell((short) 3).setCellValue("100");
		// ����HSSFRow����(������)
		HSSFRow row2 = sheet.createRow(2);
		// ����HSSFCell������ֵ(������) short(5λ) 
		row2.createCell((short) 0).setCellValue("xy");
		row2.createCell((short) 1).setCellValue("80");
		row2.createCell((short) 2).setCellValue("2.1");
		row2.createCell((short) 3).setCellValue("59");
		// ���Excel
		FileOutputStream outputStream = new FileOutputStream("d:\\my1.xls");
		workbook.write(outputStream);
		outputStream.flush();
		System.out.println("ok");
	}
}
