<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
<c:if test="${result==0 }">
		<script type="text/javascript">
		alert("查询失败，该用户没有开卡！");
		</script>
</c:if>
</head>
<body>
	<div class="container  table-responsive" >
		<table  class="table-hover table table-condensed  " width="50%">
			<tr >
				<td  colspan="4"  align="center"><h3> 卡号信息</h3></td>
			</tr>			
			<tr>
				<td>卡号</td>
				<td>余额</td>
				<td>最后充值</td>
				<td>今日消费</td>
			</tr>		
			<c:forEach items="${cards}" var="card" >
			<tr>
				<td>${card.cardid }</td>
				<td>${card.money }</td>
				<td>${card.lastadd }</td>
				<td>${card.consume }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
