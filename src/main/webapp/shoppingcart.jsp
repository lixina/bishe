<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>购物车</title>
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
	  $().ready(function(){
			 if("${sessionScope.username}" == ""){
			   	$("#span2").css('display','none');
			   	$("#span3").css('display','none');
				$("#span4").css('display','none');
			    }else{
			    	$("#span1").css('display','none');
			    }
			});
	  //退出
$("#backmain").click(function(){
	 $(this).find("a").attr("href","/backmain");
})
//点击显示订单及个人信息toordermsg
$("#toordermsg").click(function(){
	 var username = ${sessionScope.username}
	 $(this).find("a").attr("href","/showorders?username="+username);
});
  })
 
</script>
	</head>
	<body>
	<div class="container">
		<div class="row clearfix"  style="height:50px">
		<div class="col-md-3 column" style="margin-top: 20px;">
		|CHINA/中国大陆       <i class="icon ion-location"></i>店铺
		</div>
		<div class="col-md-3 column" style="margin-top: 20px;" id="backmain">
		<span id="span3" style="padding-left: 60px;"><a>退出</a></span>
		</div>
		<div class="col-md-3 column" style="margin-top: 20px;" >
			<span id="span1" style="padding-left: 60px;"><a href="login.jsp"><i class="icon ion-log-in"></i> 登录</a> &nbsp&nbsp&nbsp <a href="register.jsp"><i class="icon ion-person"></i>注册</a></span><span id="span2"><div  id="togoodscart"><i class="icon ion-ios-paw-outline"></i>欢迎，${sessionScope.username}&nbsp<a><i class="icon ion-bag"></i>购物袋</a></div></span>
		</div>
		<div class="col-md-3 column" >
		<span id="span4" style="padding-left:20px;"><div id="toordermsg"><a>订单信息</a></div></span>
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
	 <div><h3>您的购物袋</h3></div> <br>
	 <div>
	 <input type="button" id="delbtn"  value="删除" style="color: white;background-color: black;border:none;width: 120px;height: 38px;margin-left: 1020px"/><br><br>
	 </div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table border="2" style="height: 60%;width: 100%;">
				<tr >
					<th style="text-align:center;" ><h4>您的产品</h4></th>
					<th style="text-align:center;"><h4>数量</h4></th>
					<th style="text-align:center;"><h4>总计</h4></th>
					<th style="text-align:center;"><h4>选择</h4></th>
				</tr>
				<c:forEach items="${list}" var="list" >
				<tr>
				<th>
				<div style="text-align: center"><input type="checkbox" name="mycheck" id="mycheck" value="${list.goodscarid}" style="height: 40px;width: 40px;border:none;"/></div>
				</th>
					<th style="text-align:center;">
						<div id="mydiv" class="row clearfix">
				    <div class="column" style="display: inline-block;width: 220px;height: 100px;" >
				    <br>
				    <div style="text-align: center;"><h3>${list.goodsname}</h3></div>
				    <br>
				    <div style="text-align: center;"><h3>CNY：${list.goodsprice}</h3></div><br/>
				</div>
	   </div>
					</th>
					<th style="text-align:center;">
					<input type="button" style="height: 40px;width: 30px;" value="-" />&nbsp;&nbsp;&nbsp;
                    <span>${list.goodscount}</span>&nbsp;&nbsp;&nbsp;
    				<input type="button" style="height: 40px;width: 30px;" value="+" />
					</th>
					<th style="text-align:center;">${list.goodsprice*list.goodscount}</th>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-8 column">
		</div>
		<div class="col-md-4 column">
			 <h3>总计：</h3><br />
			<button style="color: white;background-color: black;border:none;width: 150px;height: 45px;"><h4>安全结账</h4></button></div>
		</div>
	</div>
		<br /><br />	 
	   
	   <div class="row clearfix"style="margin-left: 0px;">
			<div class="column" style="display: inline-block;margin-left: 300px">
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