<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function doDelete(){
		var stunumber=fm.stunumber.value;	
		var flag = confirm("是否确定删除用户"+stunumber);
		if(flag){
			window.location.href="/schoolCardManager/deleteUser.do?stunumber="+stunumber;
		}
	}
</script>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
</head>
<body>
	<c:choose>
	<c:when test="${result==0 }">
	<script type="text/javascript">
	alert("删除失败,查无此人");</script>
	</c:when>
	<c:when test="${result==1 }">
	<script type="text/javascript">
	alert("删除成功");</script>
	</c:when>
	<c:when test="${result==3 }">
	<script type="text/javascript">
	alert("更新成功");</script>
	</c:when>
	<c:when test="${result==4 }">
	<script type="text/javascript">
	alert("更新失败");</script>
	</c:when>
	</c:choose>
	<div class="container  table-responsive" >
	<form id="fm" action="/schoolCardManager/selectUser.do" method="post">
		<table class="table-hover table table-condensed  " >
			<tr >
				<td colspan="2" align="center">	
					<h3>注销用户</h3>
				</td>
			</tr>
			<tr >
				<td >	
					请输入学号:<input type="text" name="stunumber"/>		
				</td>
				<td>
					<input type="button" value="删除"  onclick="doDelete()">
				</td>
			</tr>	
			<tr >
				<td colspan="2" align="center">	
					<h3>修改用户信息</h3>
				</td>
			</tr>
			<tr >
				<td >	
					请输入学号:<input type="text" name="updatestunumber"/>		
				</td>
				<td>
					<input type=submit value="修改"  onclick="doUpdate()">
				</td>
			</tr>	
		  </table>
		  </form>
	</div>
</body>
</html>