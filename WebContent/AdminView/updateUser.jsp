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
	<form action="updateUser.do" method="post">
		<table  class="table-hover table table-condensed  " width="50%">
			<tr >
				<td colspan="2" align="center"><h3>修改</h3></td>
			</tr>			
			<tr>
				<td>学号：</td>
				<td><input id="stunumber" type="text" name="stunumber" value="${user.stunumber } "  required="required">
					<input type="hidden" name="id" value="${user.id }" />
				</td> 
				
			</tr>
			
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" name="name" value="${user.name }"  required="required"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
				
					<input type="radio" name="sex" required="required" <c:if test="${user.sex=='男' }" >checked</c:if>  value="男">男
					<input type="radio" name="sex" value="女"  required="required"<c:if test="${user.sex=='女' }" >checked</c:if>>女
				</td>
			</tr>
	
			<tr>
				<td>民族：</td>
				<td><input type="text" name="nation" value="${user.nation }" required="required"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="tel" name="phone" value="${user.phone }" required="required"></td>
			</tr>
			
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="idcard" value="${user.idcard }" required="required"></td>
			</tr>	
			<div class="form-group">
			<tr>
				<td ><button type="submit" class="btn btn-default">提交</button></td>
				<td ><button type="reset" class="btn btn-default" >重置</button></td>
			</tr>
			</div>
		</table>
	</form>
	</div>
</body>
</html>
