<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){	
	//失去焦点事件 验证用户名是否存在
$("#userName").blur(function(){
	var userName = $("#userName").val();
	$.get("/isuser",{"username":userName},function(msg){
		$("#username_msg").html(msg);
		if(msg == "available"){
			//设置下一个文本框可用
			$("#password").removeAttr("disabled");
			$("#userName").attr("readonly",true);
		}
	});
});
//验证密码
$("#password").blur(function(){
	var password = $("#password").val();  		
	$.get("/ispassword",{"password":password},function(msg1){ 
		$("#password_msg").text(msg1); 
		if(msg1 == "available"){
			//设置password文本框可用
			$("#passwordrepeat").removeAttr("disabled");
			$("#password").attr("readonly",true);
		}
	}); 
});
//验证密码是否一致
$("#passwordrepeat").blur(function(){
	var pwdrepeat = $("#passwordrepeat").val();  
	var password = $("#password").val(); 
	$.get("/ispasswordrepeat",{"passwordrepeat":pwdrepeat,"password":password},function(msg2){        			 
		$("#passwordrepeat_msg").html(msg2);
		if(msg2 == "success"){
			//设置password文本框可用
			$("#address").removeAttr("disabled");
			$("#passwordrepeat").attr("readonly",true);
		}
	}); 
});	
//验证地址
$("#address").blur(function(){
	var address = $("#address").val();  
	$.get("/isaddress",{"address":address},function(msg3){        			 
		$("#address_msg").html(msg3);
		if(msg3 == "available"){
			//设置password文本框可用
			$("#userphone").removeAttr("disabled");
			$("#address").attr("readonly",true);
		}
	}); 
});	
//电话验证
$("#userphone").blur(function(){
	var userphone = $("#userphone").val();
	$.get("/isuserphone",{"userphone":userphone},function(msg4){
		$("#userphone_msg").html(msg4);
		if(msg4 == "available"){
			//设置下一个文本框可用
			$("#regisretbtn").removeAttr("disabled");
			$("#userphone").attr("readonly",true);
		}
	});
});
//注册按钮点击事件
})
</script>
	</head>
<body>
	<div class="container">
		<div class="row clearfix"  style="height:50px">
		<div class="col-md-4 column" style="margin-top: 16px;">
		|CHINA/中国大陆       <i class="icon ion-location"></i>店铺   
		</div>
		<div class="col-md-4 column" style="margin-top: 16px;">
		</div>
		<div class="col-md-4 column" style="margin-top: 16px;">
			<span style="padding-left: 100px;"> <a href="login.jsp"><i class="icon ion-log-in"></i> 登录</a> &nbsp&nbsp&nbsp <a href="register.jsp"><i class="icon ion-person"></i>注册</a></span>
		</div>
	    </div>
	    <div class="main_img">
		<img src="./img/swarovski_v2016.png" alt="NEW IN" style="margin-left: 400px;">
	   </div>
	   
	   <div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">店铺</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="main.jsp">首页</a>
						</li>
						<li>
							 <a href="/goodsmsg">全部商品</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类<strong class="caret"></strong></a>
							<ul class="dropdown-menu" id="dropdown-menu">
								<li>
									 <a >腕表</a>
								</li>
								<li>
									 <a>配饰</a>
								</li>
								<li>
									 <a >摆件</a>
								</li>
								<li>
									 <a >首饰</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a h>其他</a>
								</li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search" action="/getgoodsbyname" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="goodsname"/>
						</div> <button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="#">关于店铺</a>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
	   
	<div class="row clearfix">
		<div class="col-md-4 column">
			
		</div>
		
		<div class="col-md-4 column">
			<h2><strong>创建新账户</strong></h2><br />
			<form action="/register" method="post">
			&nbsp;&nbsp;&nbsp;<div style="display: inline-block;"><strong>用户名*</strong><input type="text" id="userName" name="username" style="border:groove;border-color: darkgray;"/></div> &nbsp<div id="username_msg" style="display: inline-block;"></div><br /><br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div style="display: inline-block;"><strong>密码*</strong><input type="password" id="password" name="password" style="border:groove;border-color: darkgray;" disabled="disabled"/></div> &nbsp<div id="password_msg" style="display: inline-block;"></div><br /><br /><br />
			<div style="display: inline-block;"><strong>确认密码*</strong><input type="password" id="passwordrepeat" style="border:groove;border-color: darkgray;" disabled="disabled"/></div>&nbsp<div id="passwordrepeat_msg" style="display: inline-block;"></div><br /><br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div style="display: inline-block;"><strong>地址*</strong><input type="text" id="address" name="address" style="border:groove;border-color: darkgray;" disabled="disabled"/></div> &nbsp<div id="address_msg" style="display: inline-block;"></div><br /><br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div style="display: inline-block;"><strong>电话*</strong><input type="text" id="userphone" name="userphone"  style="border:groove;border-color: darkgray;" disabled="disabled"/></div>&nbsp<div id="userphone_msg" style="display: inline-block;"></div><br /><br /><br />
<!-- 			<button id="regisretbtn" style="height: 45px;width: 110px;color:white;background: black;margin-left: 100px;" disabled="disabled">注册</button> -->
		<input type="submit" value="注册" id="regisretbtn" style="height: 45px;width: 110px;color:white;background: black;margin-left: 100px;" disabled="disabled"/>
		</form>
		</div>
		<div class="col-md-4 column">
			
		</div>
	</div>
					
	
	</div>
		<br /><br />	 
	   
	   <div class="row clearfix"style="margin-left: 0px;">
				<div class="column" style="display: inline-block;margin-left: 100px;">
					<img alt="140x140" src="img/gentics-content8.jpg" />
				</div>
			</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <address style="margin-left: 500px;"> <strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123) 456-7890</address>
		</div>
	</div>
	</div>	
	</body>
</html>