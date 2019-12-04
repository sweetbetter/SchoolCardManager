<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
		<link rel="stylesheet" href="/schoolCardManager/css/main.css" />
		<script src="../js/jquery-1.11.0.js"></script>
        <script src="../	js/bootstrap.min.js"></script>
		<title>管理员管理</title>
	</head>
	<body>
		<!-- 顶部导航部分 -->
		<nav>
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" title="" href="#">校园卡管理系统</a>
				</div>
				
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li role="presentation" >  
							 <a href="#">管理员：<span class="badge">${sessionScope.name }</span></a>
						</li>
						 <li>
						<a href="../logout.do"><span>退出登录</span></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- 顶部导航部分 -->
		
<!-- 中间主体内容部分 -->
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar">
         <ul class="nav nav-stacked nav-pills">
             <li role="presentation">
                 <a href="../selectByPage.do?currentPage=1" target="mainFrame" >查询所用用户和卡号</a>
             </li>
              <li role="presentation">
                 <a href="selectInfo.jsp" target="mainFrame" >查询用户及卡户信息</a>
             </li>
         
             <li role="presentation">
                 <a href="register.jsp" target="mainFrame">添加用户</a>
             </li>
             <li role="presentation">
                 <a href="addCard.jsp" target="mainFrame">用户开卡</a>
             </li>
          	  <li role="presentation">
                 <a href="deleteUser.jsp" target="mainFrame" >注销/更新用户信息</a>
             </li>
         </ul>
     </div>
 <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
       <iframe src="welcome.jsp" id="mainFrame" name="mainFrame" 
       frameborder="0" width="100%"  height="100%" frameBorder="0">
       </iframe> 
     </div>

 </div>
  <!-- 底部页脚部分 -->
 <div class="footer">
     <p class="text-center">
         2019 &copy; 校园卡管理系统   </p>
 </div>
	
</body>
</html>