<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
<meta charset="UTF-8">
<script type="text/javascript">
	function doJump()
	{
		var currentPage=jump.value;
		if(currentPage<0||currentPage>${page.totalPage})
		{
			alert("页面输入错误！");
		}
		else{
			window.location.href="/schoolCardManager/selectByPage.do?currentPage="+currentPage;
		}
	}
</script>
</head>
<body>
	<div class="container  table-responsive">
	<table class="table-hover table table-condensed table-bordered ">
		<tr  align="center"><td colspan="6"><h3>所用用户信息</h3></td></tr>
		<tr class=" active "  align="center">
			<td>姓名</td>
			<td>学号</td>
			<td>性别</td>
			<td>民族</td>
			<td>电话</td>
			<td>身份证</td>
		</tr>
		<c:forEach items="${page.users }" var="user">
		
		<tr align="center">
				<td>${user.name }</td>
				<td>${user.stunumber }</td>
				<td>${user.sex }</td>
				<td>${user.nation }</td>
				<td>${user.phone }</td>
				<td>${user.idcard }</td>
		 </tr>
			 <c:forEach items="${user.card }" var="c">
	<!-- 		  <tr align="center">
			 	<td >持卡人姓名</td>
				<td colspan="2">卡号</td>
				<td>余额</td>
				<td>最后充值</td>
				<td>今日消费</td>		
			  </tr> -->
			  
			 <tr align="center">
			  <c:if test="${user.card!=null }">		
					   <td>持卡人姓名  ${user.name }</td>
						<td colspan="2">卡号   ${c.cardid }</td>
						<td>余额   ${c.money }</td>
						<td>最后充值   ${c.lastadd }</td>
						<td>今日消费   ${c.consume }</td>			  
				</c:if> 
			 </tr>
			  </c:forEach>
			  	 <tr height="20px"></tr>
		 </c:forEach>
	</table>
	<div class="container ">
		<ul class="pager">
			<li>当前页：${page.currentPage }</li>&nbsp;&nbsp;&nbsp;
			<li>总页数：${page.totalPage }</li>&nbsp;&nbsp;&nbsp;
			<li><a href="selectByPage.do?currentPage=1">首页</a></li>
			<c:if test="${page.currentPage!=1 }">
			<li><a href="selectByPage.do?currentPage=${page.currentPage-1 }">上一页</a></li>
			</c:if>
			<c:if test="${page.currentPage!=page.totalPage }">
			<li><a href="selectByPage.do?currentPage=${page.currentPage+1 }">下一页</a></li>
			</c:if>
			<li><input type="text" id="jump"><input type="button" value="跳转" onclick="doJump()"></li>
		</ul>
	</div>
	</div>
</body>
</html>