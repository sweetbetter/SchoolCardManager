<%@page import="com.exam.model.SchoolCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
<c:if test="${failure=='1' }">
<script type="text/javascript">
alert("查询结果为空，输入信息有误！");
</script>
</c:if>
</head>
<body>
	<div class="container  table-responsive" >
		<form action="/schoolCardManager/selectAllInfo.do" method="post" name="fm">
		<table class="table-hover table table-condensed  ">
			<tr >
				<td colspan="6">		
					按学号:<input type="text" name="stunumber"  value="${message.stunumber}"/>
					&nbsp;&nbsp;&nbsp;
					按姓名:<input type="text" name="name" value="${message.name }"/>
					&nbsp;&nbsp;&nbsp;
					按身份证:<input type="text" name="idcard"  value="${message.idcard }"/>
					&nbsp;&nbsp;&nbsp;
					按电话:<input type="text" name="phone"  value="${message.phone }"/>
					<input type="submit" value="查询">
				</td>
			</tr>		
			  <tr align="center">
				<td colspan="6"><h3>用户信息</h3></td>	
			  </tr>
			  <tr align="center">
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>民族</td>
				<td>电话</td>
				<td>身份证</td>
			  </tr>
			<tr align="center">
				<td>${user.stunumber }</td>
				<td>${user.name }</td>
				<td>${user.sex }</td>
				<td>${user.nation }</td>
				<td>${user.phone }</td>
				<td>${user.idcard }</td>
			 </tr>
			  <tr align="center">
				<td colspan="6"><h2>卡号信息</h2></td>	
			  </tr>
			  <tr align="center">
			 	<td >持卡人姓名</td>
				<td colspan="2">卡号</td>
				<td>余额</td>
				<td>最后充值</td>
				<td>今日消费</td>		
			  </tr>
			<c:forEach items="${user.card }" var="u">
				  <tr align="center">
				   <td >${user.name }</td>
					<td colspan="2">${u.cardid }</td>
					<td>${u.money }</td>
					<td>${u.lastadd }</td>
					<td>${u.consume }</td>
				  </tr>
			  </c:forEach>
		  </table>
	  </form>
	</div>
</body>
</html>