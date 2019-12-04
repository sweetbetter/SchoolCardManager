<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
<script type="text/javascript">
function  getAjax(){
	   var xmlHttp;
	   try{ 
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }
	
		return xmlHttp;
	 }

	function checkExist()
	{
		//创建XMLHttpRequst
		var ajax=getAjax();
		
		//获取id	
		var cardid =document.getElementById("cardid").value;
		ajax.open("POST","../checkCardIsExist.do",true);
		
		//重写OnReadystatechangge函数
		ajax.onreadystatechange=function()
		{
			//判断radaystate的值
			if(ajax.readyState==4)
			{	
				if(ajax.status==200)
					{
						var result=ajax.responseText;
						if(result == 1){
							//alert(ajax.responseText);
							document.getElementById("message").innerHTML = "<font color='red'>卡号已存在!</font>";
						}else{
							document.getElementById("message").innerHTML = "<font color='green'>卡号可用!</font>";
						}
					}
			}			
			
		}
		//发送
	
        ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        ajax.send("cardid="+cardid);
	}
</script>
</head>
<body>
	<div class="container  table-responsive" >
	<form action="../addCard.do" method="post">
		<table  class="table-hover table table-condensed  " width="50%">
			<tr >
				<td colspan="2" align="center"><h3> 开卡</h3></td>
			</tr>	
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name"  required="required"></td>
			</tr>					
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="idcard"  required="required"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"  required="required"></td>
			</tr>
			<tr>
				<td>新开卡号：</td>	
				<td><input type="text" name="cardid" id="cardid" required="required"  onblur="checkExist()"> <span id="message"> </span></td>
			</tr>
			<tr>
				<td>初始金额：</td>	
				<td><input type="text" name="money"></td>
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
