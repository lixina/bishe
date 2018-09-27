package com.etc.jxls;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJxls {
	
	public static void main(String[] args) throws Exception {
		 //single();
		 //loop();
		 nestedLoop();
	    }
	 
	 /**
	  * ��򵥵�ģ�嵼��
	  * @throws Exception
	  */
	 public static void single() throws Exception {
		    // ģ��·���������
	        String templatePath = "E:\\template.xls";
	        OutputStream os = new FileOutputStream("E:\\out.xls");
	        // ����һ��Map�����������Ҫ��ģ������ʾ����
	        Map<String, Object> model = new HashMap<String, Object>();
	        model.put("id", "001");
	        model.put("name", "����");
	        model.put("age", 18);
	        //����֮ǰд�Ĺ����࣬����ģ��·�������������װ������Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
	        System.out.println("��");
	}
	 
	 /**
	  * ѭ������һ�����������
	  * @throws Exception
	  */
	 public static void loop() throws Exception {
		 // ģ��·���������
	        String templatePath = "E:\\template1.xls";
	        OutputStream os = new FileOutputStream("E:\\out1.xls");
	        // ����һ��Map�����������Ҫ��ģ������ʾ����
	        List<Person> persons = new ArrayList<Person>();
	        
	        Person person1 = new Person(001, "haha", 15);
	        Person person2 = new Person(002, "haha", 13);
	        Person person3 = new Person(003, "haha", 19);
	        
	       /* Person person1 = new Person();
	        person1.setAge(1);
	        person1.setId(2);
	        person1.setName("22");*/
	        
	        persons.add(person1);
	        persons.add(person2);
	        persons.add(person3);
	        
	        Map<String, Object> model = new HashMap<String, Object>();
	        
	        model.put("person", persons);
	        
	        //����֮ǰд�Ĺ����࣬����ģ��·�������������װ������Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
		    System.out.println("ѭ��");
		}
	 
	 /**
	  * Ƕ��ѭ������һ�����������
	  * @throws Exception
	  */
	 public static void nestedLoop() throws Exception {
		 // ģ��·���������
	        String templatePath = "E:\\template2.xls";
	        OutputStream os = new FileOutputStream("E:\\out2.xls");
	        
	        // ����һ��Map�����������Ҫ��ģ������ʾ����
	        List<Doraemon> doraemons = new ArrayList<Doraemon>();
	        
	        Tool tool1 = new Tool("������", "��ȥ�ľ�ȥ��");
	        Tool tool2 = new Tool("������", "����ľͷ���");
	        Tool tool3 = new Tool("������", "������");
	        
	        List<Tool> tools1 = new ArrayList<Tool>();
	        tools1.add(tool1);
	        tools1.add(tool2);
	        
	        List<Tool> tools2 = new ArrayList<Tool>();
	        tools2.add(tool3);
	        
	        Doraemon doraemon1 = new Doraemon("����A��һ��", tools1);
	        Doraemon doraemon2 = new Doraemon("����A�ζ���", tools2);
	        
	        doraemons.add(doraemon1);
	        doraemons.add(doraemon2);
	        
	        Map<String, Object> model = new HashMap<String, Object>();
	        
	        model.put("doraemons", doraemons);
	        
	        //����֮ǰд�Ĺ����࣬����ģ��·�������������װ������Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
		    System.out.println("Ƕ��ѭ��");
		}
}
