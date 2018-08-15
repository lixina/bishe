<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
		<title>登录</title>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#zhuce").click(function(){
		location.href="register.jsp"
	})
})
</script>
</head>
<body>
	<div class="container">
		<div class="row clearfix"  style="height:50px">
		<div class="col-md-4 column" style="margin-top: 16px;">
		|CHINA/中国大陆        <i class="icon ion-location"></i>店铺
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
			<ul>
				<li>
					<h2><strong>我的账户</strong></h2>
				</li>
				<li>
					<h3>登录/注册</h3>
				</li>
				<li>
					<h3>个人资料</h3>
				</li>
				<li>
					<h3>订单</h3>
				</li>
			</ul>
		</div>
		<div class="col-md-4 column">
			<h2><strong>登录</strong></h2><br />
			<h4>使用现有用户</h4><br />
			<h3><strong>请填写您的用户名及密码</strong></h3><br />
			<!-- <form action="/login" method="post"> -->
			<form action="/login" method="post">
			<strong>用户名*</strong><input type="text" name="username" value="${usermsg.username}" style="border:groove;border-color: darkgray;"/><br /><br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;<strong>密码*</strong><input type="password" name="userpwd" value="${usermsg.userpwd}" style="border:groove;border-color: darkgray;"/><br /><br /><br />
			<input type="submit" value="登录" id="loginbtn" style="height: 45px; width: 110px;color:white;background: black;margin-left: 100px;"/>
            </form>
		</div>
		<div class="col-md-4 column">
			<h3>创建新账户</h3><br />
			<h4><strong><h4>如尚未注册账户，请点击此处</h4></strong></h4><br /><br />
			<button id="zhuce" style="height: 45px;width: 110px;color:white;background: black;margin-left: 100px;">创建账户</button>
		</div>
	</div>
					
	
	</div>
		<br /><br />	 
	   
	   <div class="row clearfix"style="margin-left: 180px;">
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