<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
<script type="text/javascript">
	function doRechange(cardid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var money=0;	
		money=fm.money.value;
		if(cardid==null)
		{
			cardid=fm.cardid.value;
		/* 	alert(cardid); */
		}
		var flag = confirm("是否确定充值(卡号"+cardid+",金额:"+money+")");
		if(flag&&money!=0){
			window.location.href="/schoolCardManager/rechange.work?cardid="+cardid+"&money="+money;	
		}
	}
</script>
<c:choose>
<c:when test="${rechangeMessage==1 }">
<script type="text/javascript">
alert("充值成功！");
</script>
</c:when>
<c:when test="${rechangeMessage==0 }">
<script type="text/javascript">
alert("充值失败，请检查卡号是否正确！");
</script>
</c:when>

<c:when test="${result==0 }">
<script type="text/javascript">
alert("查无此人，输入信息有误！");
</script>
</c:when>

<c:when test="${result==1 }">
<script type="text/javascript">
alert("该用户尚未开卡！");
</script>
</c:when>
</c:choose>

</head>
<body>
	<div class="container  table-responsive" >
		<form action="/schoolCardManager/selectCard.work" method="post" name="fm">
		<table class="table-hover table table-condensed  ">
			<tr >
				<td colspan="5">	
					按姓名:<input type="text" name="name" value="${searchMessage1 }"/>
					&nbsp;&nbsp;&nbsp;
					按学号:<input type="text" name="stunumber"  value="${searchMessage2 }"/>
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					充值金额:<input type="text" name="money" id="money"/>&nbsp;
				<!-- 	充值卡号:<input type="text" name="cardid"/> -->
					<!-- <input type="button" value="充值" onclick="doRechange(null)"> -->
				</td>
			</tr>		
		  <tr align="center">
			<td>卡号</td>
			<td>余额</td>
			<td>最后充值</td>
			<td>今日消费</td>
			<td></td>
		  </tr>
			<c:forEach items="${card}" var="c">
				  <tr align="center">
					<td>${c.cardid }</td>
					<td>${c.money }</td>
					<td>${c.lastadd }</td>
					<td>${c.consume }</td>
					<td><input type="button" value="充值"  onclick="doRechange(${c.cardid})"></td>
				  </tr>
			  </c:forEach>
		  </table>
	  </form>
	</div>
</body>
</html>
