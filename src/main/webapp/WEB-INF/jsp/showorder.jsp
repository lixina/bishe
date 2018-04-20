<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单显示</title>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
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
		    }else{
		    	$("#span1").css('display','none');
		    }
		});
	 $(".btn-primary").click(function(){
		 var userphone = $("#userphone").val();
		 var useraddress = $("#useraddress").val();
		 var username = $("#username").val();
		 $.get("/saveusermsg",{"userphone":userphone,"useraddress":useraddress,"username":username},function(msg){
			 if(msg == "1111"){
			 }
		 })
	 })
	//点击购物袋
$("#togoodscart").click(function(){
	 var username = ${sessionScope.username}
	 $(this).find("a").attr("href","/showgoodscar?username="+username);
});
	 $("#dropdown-menu li").click(function(){ 
		 $(this).find("a").attr("href","/goodskindd?type=" + $(this).find("a").html());
	 });
})
//确认收货
function imsure(orderstate,ordernum,username){
	if(orderstate == "待发货"){
		 alert("提醒发货成功") 
	}else{
		 $.get("/goodssure",{"+orderstate":orderstate,"ordernum":ordernum,"username":username},function(orderlist){
		 })
	 }
	
}
</script>
</head>
<body>
	<div class="container">
		<div class="row clearfix"  style="height:50px">
		<div class="col-md-4 column" style="margin-top: 16px;">
		|CHINA/中国大陆       <i class="icon ion-location"></i>店铺
		</div>
		<div class="col-md-4 column" style="margin-top: 16px;" id="backmain">
		<span id="span3" style="padding-left: 60px;"><a>退出</a></span>
		</div>
		<div class="col-md-4 column" style="margin-top: 16px;">
			<span id="span1" style="padding-left: 60px;"><a href="login.jsp"><i class="icon ion-log-in"></i> 登录</a> &nbsp&nbsp&nbsp <a href="register.jsp"><i class="icon ion-person"></i>注册</a></span><span id="span2"><div  id="togoodscart"><i class="icon ion-ios-paw-outline"></i>欢迎，${sessionScope.username}&nbsp<a><i class="icon ion-bag"></i>购物袋</a></div></span>
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
	   
	<div>
		<h3>您的订单信息</h3>
		<table style="border:groove;margin-left: 200px;height: 200px;width: 700px;">
<tr >
	<th style="border: groove;text-align: center;">订单号</th>
	<th style="border: groove;text-align: center;">订单日期</th>
	<th style="border: groove;text-align: center;">商品名称</th>
	<th  style="border: groove;text-align: center;">商品单价</th>
	<th style="border: groove;text-align: center;">订单数量</th>
	<th style="border: groove;text-align: center;">订单总价</th>
	<th style="border: groove;text-align: center;">订单状态</th>
</tr>	
<c:forEach items="${orderlist}" var="orderlist">	
<tr>
	<th style="border: groove;text-align: center;">${orderlist.ordernum}</th>
	<th style="border: groove;text-align: center;">${orderlist.orderdate}</th>
	<th style="border: groove;text-align: center;">${orderlist.goodsname}</th>
	<th style="border: groove;text-align: center;">${orderlist.goodsprice}</th>
	<th style="border: groove;text-align: center;">${orderlist.goodscount}</th>
	<th style="border: groove;text-align: center;">${orderlist.ordertotalprice}</th>
	<th style="border: groove;text-align: center;"><input type="button" value="${orderlist.orderstate}" style="border:false;background-color: black;color: white;" onclick="imsure('${orderlist.orderstate}',${orderlist.ordernum},${orderlist.username})"/></th>
</tr>
</c:forEach>
		</table>
	</div>
	<div>
		<h3>您的个人信息</h3>
		<div style="margin-left: 50px;">
			 <a id="modal-606308" href="#modal-container-606308" role="button" class="btn" data-toggle="modal" style="margin-left: 150px;background: black;height: 35px;width: 110px;color: white;">修改</a><br /><br />
			
			<div class="modal fade" id="modal-container-606308" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								个人信息修改
							</h4>
						</div>
						<div class="modal-body">
						<c:forEach items="${userlist}" var="userlist">
							<table style="margin-left: 0px;height: 200px;width: 500px;">
			<tr>
				<th style="text-align: center;width: 200px;">用户名称</th>
			    <th><input type="text" id="username" disabled="disabled" value="${userlist.username}"/></th>
			</tr>
			<tr>
				<th style="text-align: center;">用户电话</th>
				<th><input type="text" name="userphone" id="userphone" value="${userlist.userphone }"/></th>
			</tr>
			<tr>
				<th style="text-align: center;">用户地址</th>
			    <th><input type="text" name="useraddress" id="useraddress" value="${userlist.useradress}"/></th>
			</tr>
		</table>
		 <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 200px">关闭</button> <button data-dismiss="modal" type="button" id="savebtn" class="btn btn-primary">保存</button>
		</c:forEach>
						</div>
						<div class="modal-footer">
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:forEach items="${userlist}" var="userlist">
		<table style="border:groove;margin-left: 200px;height: 200px;width: 700px;">
			<tr>
				<th style="border: groove;text-align: center;width: 200px;">用户名称</th>
			    <th style="border: groove;text-align: center;">${userlist.username}</th>
			</tr>
			<tr>
				<th style="border: groove;text-align: center;">用户电话</th>
				<th style="border: groove;text-align: center;">${userlist.userphone }</th>
			</tr>
			<tr>
				<th style="border: groove;text-align: center;">用户地址</th>
			    <th style="border: groove;text-align: center;">${userlist.useradress}</th>
			</tr>
		</table>
		</c:forEach>
	</div>
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