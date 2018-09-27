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
	  * 最简单的模板导出
	  * @throws Exception
	  */
	 public static void single() throws Exception {
		    // 模板路径和输出流
	        String templatePath = "E:\\template.xls";
	        OutputStream os = new FileOutputStream("E:\\out.xls");
	        // 定义一个Map，往里面放入要在模板中显示数据
	        Map<String, Object> model = new HashMap<String, Object>();
	        model.put("id", "001");
	        model.put("name", "张三");
	        model.put("age", 18);
	        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
	        System.out.println("简单");
	}
	 
	 /**
	  * 循环导出一个链表的数据
	  * @throws Exception
	  */
	 public static void loop() throws Exception {
		 // 模板路径和输出流
	        String templatePath = "E:\\template1.xls";
	        OutputStream os = new FileOutputStream("E:\\out1.xls");
	        // 定义一个Map，往里面放入要在模板中显示数据
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
	        
	        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
		    System.out.println("循环");
		}
	 
	 /**
	  * 嵌套循环导出一个链表的数据
	  * @throws Exception
	  */
	 public static void nestedLoop() throws Exception {
		 // 模板路径和输出流
	        String templatePath = "E:\\template2.xls";
	        OutputStream os = new FileOutputStream("E:\\out2.xls");
	        
	        // 定义一个Map，往里面放入要在模板中显示数据
	        List<Doraemon> doraemons = new ArrayList<Doraemon>();
	        
	        Tool tool1 = new Tool("任意门", "想去哪就去哪");
	        Tool tool2 = new Tool("竹蜻蜓", "想飞哪就飞哪");
	        Tool tool3 = new Tool("空气炮", "空气炮");
	        
	        List<Tool> tools1 = new ArrayList<Tool>();
	        tools1.add(tool1);
	        tools1.add(tool2);
	        
	        List<Tool> tools2 = new ArrayList<Tool>();
	        tools2.add(tool3);
	        
	        Doraemon doraemon1 = new Doraemon("哆啦A梦一号", tools1);
	        Doraemon doraemon2 = new Doraemon("哆啦A梦二号", tools2);
	        
	        doraemons.add(doraemon1);
	        doraemons.add(doraemon2);
	        
	        Map<String, Object> model = new HashMap<String, Object>();
	        
	        model.put("doraemons", doraemons);
	        
	        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
	        JxlsUtils.exportExcel(templatePath, os, model);
	        os.close();
		    System.out.println("嵌套循环");
		}
}
