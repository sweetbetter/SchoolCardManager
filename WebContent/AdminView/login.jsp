<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>校园卡管理系统</title>
		<link rel="stylesheet" href="/schoolCardManager/css/main.css" />
		<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form class="form-horizontal" action="/schoolCardManager/login.do" method="post">
						<span class="heading">登录界面</span>
						<div class="form-group">		
							<input type="radio" name="identity" checked="checked" value="1">管理员
							<input type="radio" name="identity" value="2">充值员
							<input type="radio" name="identity" value="3">用户
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="stunumber" placeholder="请输入学号或管理员/充值员工号">
						</div>
						
						<div class="form-group">
							<input type="password" class="form-control" name="password" placeholder="密码">
						</div>
		
						<div class="form-group">
							<button type="submit" class="btn btn-default">登录</button>
								<c:if test="${loginmessage==0 }">
							<span><font color="red"> 账号或密码错误</font></span>
							</c:if>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
