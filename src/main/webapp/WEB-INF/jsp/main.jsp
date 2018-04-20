<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>店铺首页</title>
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
	 $("#dropdown-menu li").click(function(){ 
		 $(this).find("a").attr("href","/goodskindd?type=" + $(this).find("a").html());
	 });
	 //退出
	 $("#backmain").click(function(){
		 $(this).find("a").attr("href","/backmain");
	 })
	//点击购物袋
	 $("#togoodscart").click(function(){
	 	 var username = ${sessionScope.username}
	 	 $(this).find("a").attr("href","/showgoodscar?username="+username);
	 });
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
		<img src="img/swarovski_v2016.png"  style="margin-left: 400px;">
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
							 <a href="#">首页</a>
						</li>
						<li>
							 <a href="/goodsmsg">全部商品</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类<strong class="caret"></strong></a>
							<ul class="dropdown-menu" id="dropdown-menu">
								<li><a >腕表</a></li>
								<li>
									 <a >配饰</a>
								</li>
								<li>
									 <a >摆件</a>
								</li>
								<li>
									 <a>首饰</a>
									
								</li>
								<li class="divider">
								</li>
								<li>
									 <a >其他</a>
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
							 <a href="more.jsp">关于店铺</a>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column" style="width: 1000px;">
			<img src="img/1 (2).jpg" />
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column" >
			<div style="margin-left: 430px;">
				<h1>新品上市</h1>
			</div>
			<div style="background: #000000;width: 100px;margin-left: 490px;height: 40px;">
				<h4 style="color: white ;padding-top: 11px;padding-left: 14px;">
				<a href="/goodsmsg">立即选购</a>
			    </h4>
			</div>
			
		</div>
	</div>
	<br />
	<div class="row clearfix" style="background: #E8E8E8;">
		<div class="col-md-12 column" style="margin-left: 200px;">
			<img  src="img/gentics-conent (2).jpg" />
		</div>
	</div>
	<div class="row clearfix" style="margin-left: 200px;">
		<div class="col-md-12 column" style="margin-left: 200px;">
			<img  src="img/80305143824.png" />
		</div>
	</div>
	<br />
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-130856" style="width: 950px;margin-left: 100px;">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-130856">
					</li>
					<li data-slide-to="2" data-target="#carousel-130856">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/gentics-content (1).jpg" />
						<div class="carousel-caption">
							<h2>
								以风格庆祝
							</h2>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/gentics-content.jpg" />
						<div class="carousel-caption">
							<h2>
								创意组合时尚百变
							</h2>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-130856" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-130856" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="row clearfix"style="margin-left: 90px;">
				<div class="col-md-4 column" >
					<img alt="140x140" src="img/1.jpg" />
				</div>
				<div class="col-md-4 column">
					<img alt="140x140" src="img/2.jpg" />
				</div>
				<div class="col-md-4 column">
					<img alt="140x140" src="img/3.jpg" />
				</div>
			</div>
			<div class="row clearfix"style="margin-left: 50px;">
				<div class="col-md-4 column" >
					<strong>这款以蝴蝶为灵感的戒指套装，势必为您惹来不少艳羡目光。浪漫妩媚、充满夏日气息的设计，揉合了闪亮迷人粉红色密镶Swarovski仿水晶及玫瑰金色镀层。由于其中一枚是关节戒指，可套在手指关节之上。</strong>
				</div>
				<div class="col-md-4 column">
					<strong>就以这款瑰丽迷人的发夹投入温暖的夏日怀抱！瞩目耀眼的设计，缀有立体蝴蝶装饰以及闪闪生辉的粉红色密镶Swarovski仿水晶，不但为您的秀发即时增添施华洛世奇的特有光彩，也是送礼的不二之选。</strong>
				</div>
				<div class="col-md-4 column">
					<strong>这款彩虹色调的挂链是以蝴蝶为灵感，并揉合闪亮迷人的密镶Swarovski仿水晶及玫瑰金色镀层。时尚风格、典雅线条与浪漫设计巧妙融合，为夏日装扮注入鲜艳夺目的色彩。另有同款穿孔耳环以供选购。</strong>
				</div>
			</div>
		</div>
	</div>
	<br />
	<div class="row clearfix" style="margin-left: 60px;">
		<div class=" column" style="display: inline-block;">
			<img  src="img/gentics-cont(2).jpg" />
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class=" column" style="display: inline-block;">
			<img  src="img/gentics-content (3).jpg" />
		</div>
	</div>
	<div class="row clearfix" style="margin-left: 60px;">
		<div class="column" style="background: #F5F5F5;height: 60px;width: 470px;display: inline-block;">
			<h4 style="margin-left: 200px;margin-top: 20px;">生日礼物</h4>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="column" style="background: #F5F5F5;height: 60px;display: inline-block;width: 470px;">
			<h4 style="margin-left: 180px;margin-top: 20px;">闪耀炫目的笔</h4>
		</div>
	</div>
	<div class="row clearfix">
		<div class=" column" style="display: inline-block;padding-left: 90px;">
			<ul style="list-style:none">
				<li>
					<a href="more.jsp"><h3>关于我们</h3></a>
				</li>
				
				<li>
                <strong>  施华洛世奇通讯</strong> 
				</li>
				<li>
				&nbsp<br>
				</li>
				<li>
					<strong>常见问题</strong>
				</li>
				<li>
				&nbsp<br>
				</li>
				<li>
					<strong>其他施华洛世奇网站</strong>
				</li>
				<li>
				&nbsp<br>
				</li>
			</ul>
		</div>
		<div class=" column" style="display: inline-block;padding-left: 170px;">
			<ul style="list-style:none">
				<li>
					<a href="more.jsp"><h3>法律条款</h3></a>
				</li>
				<li>
					<strong>使用条款</strong>
				</li>
				<li>
					<strong>条款和条件</strong>
				</li>
				<li>
					<strong>隐私条款</strong>
				</li>
				<li>
					<strong>版权</strong>
				</li>
				<li>
					<strong>网站地图</strong>
				</li>
				<li>
				&nbsp<br>
				</li>
			</ul>
		</div>
		<div class="column" style="display: inline-block;padding-left:200px;">
			<ul style="list-style:none">
				<li>
					<a href="more.jsp"><h3>企业</h3></a>
				</li>
				<li>
					<strong><em>Crystals fOR Professionals</em></strong>
				</li>
				<li>
					<strong><em>Zirconia and Gemstones for</em></strong>
				</li>
				<li>
					<strong><em>Professionals</em></strong>
				</li>
				<li>
					<strong>商务礼品</strong>
				</li>
				<li>
					<strong>职业</strong>
				</li>
				<li>
					<strong><em>Swaroskigroup.com</em></strong>
				</li>
				
			</ul>
		</div>
	</div>
	<div class="row clearfix"style="margin-left: 0px;">
				<!--<div class="column" style="display: inline-block;">
					<img alt="140x140" src="img/gentics-content 9.jpg" />
				</div>-->
				<div class="column" style="display: inline-block;">
					<img alt="140x140" src="img/gentics-content8.jpg" />
				</div>
				<!--<div class="column" style="display: inline-block;">
					<img alt="140x140" src="img/gentics-content9.jpg" />
				</div>-->
			</div>
	<!--<div class="row clearfix">
		<div class="col-md-12 column" style="background: black;height: 10px;">
		</div>
	</div>-->
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <address style="margin-left: 500px;"> <strong>@Swarovski Crystal Online AG</strong><br />   沪ICP备12041668号-7<br /> 沪公网安备31010102004213号<br /> <abbr title="Phone">P:</abbr> (123) 456-7890</address>
		</div>
	</div>
</div>
	</body>
</html>
		