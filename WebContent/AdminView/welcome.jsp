<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
		<c:if test="${result==1 }">
		<script type="text/javascript">
		alert("操作成功！");
		</script>
		</c:if>
		<c:if test="${result==0 }">
		<script type="text/javascript">
		alert("操作失败！");
		</script>
		</c:if>
	</head>
	<body>
		<div class="container" align="center">
		
			<h1 >欢迎使用校园卡管理系统</h1>
			<p> 请点击右方使用相关功能</p>
		</div>
	</body>
</html>
