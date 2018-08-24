<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%!
int a = 2;
String name = "lx";
int b = 3;
int c = a+b;
int add(int x ,int y){
	return x+y;
}
//表达式方法
String print(){
	String result = "";
	for(int i = 1;i<10;i++){
	    for(int j = 1; j<=i;j++){
	    	result +=  j+"*"+i+"="+j*i+"&nbsp;&nbsp;&nbsp;&nbsp;" ;
	    }
	    result += "<br>";
	}
	return result ;
}
//脚本方法
 void print1(JspWriter out) throws Exception{
    String result = "";
    for(int i = 1;i<10;i++){
        for(int j = 1; j<=i;j++){
        	out.println(j+"*"+i+"="+j*i+"&nbsp;&nbsp;&nbsp;&nbsp;");
        }
        out.println( "<br>"); 
    }
} 
%>
<br> 
你好，<%=name %><br>
x+y=<%=add(10,5) %>
打印九九乘法表<br><%=print()%> <br>
<%print1(out);%>
</body>
</html>