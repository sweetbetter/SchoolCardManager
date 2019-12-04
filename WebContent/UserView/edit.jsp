<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
</head>
<body>
	<div class="container  table-responsive" >
	<form action="update.go" method="post">
		<table  class="table-hover table table-condensed  " width="50%">
			<tr >
				<td colspan="2" align="center"><h3> 修改</h3></td>
			</tr>			
			<tr>
				<td>学号：</td>
				<td><input id="stunumber" type="text" name="stunumber" value="${list[0].stunumber }"  required="required"></td> 
			</tr>
			
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" name="name" value="${list[0].name }"  required="required"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
				
					<input type="radio" name="sex" <c:if test="${list[0].sex=='男' }" >checked</c:if> required="required" value="男">男
					<input type="radio" name="sex" value="女" <c:if test="${list[0].sex=='女' }"  >checked</c:if> required="required">女
				</td>
			</tr>
	
			<tr>
				<td>民族：</td>
				<td><input type="text" name="nation" value="${list[0].nation }"  required="required"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="tel" name="phone" value="${list[0].phone }"  required="required"></td>
			</tr>
			
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="idcard" value="${list[0].idcard }"  required="required"></td>
			</tr>	
			<div class="form-group">
			<tr>
				<td ><button type="submit" class="btn btn-default">提交</button></td>
				<td ><button type="reset" class="btn btn-default">重置</button></td>
			</tr>
			</div>
		</table>
	</form>
	</div>
</body>
</html>
