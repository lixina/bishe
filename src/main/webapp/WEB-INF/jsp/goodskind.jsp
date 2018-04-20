<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>商品分类</title>
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
function dianji(goodsid){
	location.href="/qqq?goodsid="+goodsid;
}
</script>
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
	 $("#dropdown-menu li").click(function(){ 
		 $(this).find("a").attr("href","/goodskindd?type=" + $(this).find("a").html());
	 });
	 //点击显示购物车
	 $("#togoodscart").click(function(){
		 var username = ${sessionScope.username}
		 $(this).find("a").attr("href","/showgoodscar?username="+username);
	 });
	 //点击显示订单及个人信息toordermsg
	 $("#toordermsg").click(function(){
		 var username = ${sessionScope.username}
		 $(this).find("a").attr("href","/showorders?username="+username);
	 });
	//退出
	 $("#backmain").click(function(){
	 	 $(this).find("a").attr("href","/backmain");
	 })
}) 
//加入购物车
 function putincart(goodsid){
	 if("${sessionScope.username}" == "undefined" || "${sessionScope.username}"==""||"${sessionScope.username}"==null){
		 alert("未登录不能加入购物车！")
	 }else{
	//alert("${sessionScope.username}");
	 var username = ${sessionScope.username}
	 location.href="/getgoodsmsgbyid?goodsid="+goodsid+"&username="+username};
}  
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
	   
	   <div class="row clearfix"style="margin-left: 0px;">
				<div class="column"  >
					<div style="text-align: center;"><img alt="140x140" src="img/gentics-content (1).jpg" /></div>
				    <div style="text-align: center;"><h2>甄选</h2></div>
				</div>
			</div>
			
			 <div class="row clearfix"style="margin-left: 0px;">
	           <c:forEach items="${goodslist}" var="goodslist">
				<div class="column" style="display: inline-block;width: 220px;height: 250px;" >
					<div style="text-align: center;" onclick="dianji(${goodslist.id})"><img alt="140x140" src="img/${goodslist.image.imageurl}" /></div>
				    <div style="display: none"><input class="goodsid" type="text" value="${goodsmsg.goodsid}" /></div>
				    <div style="text-align: center;">${goodslist.goodsname}</div>
				    <div style="text-align: center;">CNY：${goodslist.goodsprice}</div><br/>
				    <div style="text-align: center;"><button style="color: white;background-color: black;border:none" onclick="putincart(${goodslist.id})">加入购物车</button></div><br/>
				</div>
				 </c:forEach>
			</div> 
	   
	   <div class="row clearfix"style="margin-left: 0px;">
				<div class="column" style="display: inline-block;">
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
