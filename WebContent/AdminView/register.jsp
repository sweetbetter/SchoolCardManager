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
		var stunumber =document.getElementById("stunumber").value;
		ajax.open("POST","../checkIsExist.do",true);
		
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
							document.getElementById("message").innerHTML = "<font color='red'>用户名已存在!</font>";
						}else{
							document.getElementById("message").innerHTML = "<font color='green'>用户名可用!</font>";
						}
					}
			}			
			
		}
		//发送
	
        ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        ajax.send("stunumber="+stunumber);
	}
</script>
</head>
<body>
	<div class="container  table-responsive" >
	<form action="../register.do" method="post">
		<table  class="table-hover table table-condensed  " >
			<tr >
				<td colspan="2" align="center"><h3> 注册</h3></td>
			</tr>
			<tr align="center" >
				<td colspan="2">
						<input  required="required" type="radio" name="identity" value="2" >充值员
						<input  required="required" type="radio" name="identity" value="3"checked="checked" >用户
				</td>
			</tr>		
			<tr>
				<td>学号：</td>
				<td><input id="stunumber" type="text" name="stunumber" id="stunumber"  required="required" onblur="checkExist()"><span id="message"> </span></td> 
			</tr>
	
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"  required="required"></td>
			</tr>
	
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" name="name"  required="required"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input  required="required" type="radio" name="sex" checked="checked" value="男">男
					<input  required="required" type="radio" name="sex" value="女">女
				</td>
			</tr>
	
			<tr>
				<td>民族：</td>
				<td><input type="text" name="nation"  required="required"></td>
			</tr>
			
			<tr>
				<td>电话：</td>
				<td><input type="tel" name="phone"  required="required"></td>
			</tr>
			
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="idcard"  required="required"></td>
			</tr>	
			<div class="form-group">
			<tr>
				<td ><button type="submit" class="btn btn-default">注册</button></td>
				<td ><button type="reset" class="btn btn-default">重置</button></td>
			</tr>
			</div>
		</table>
	</form>
	</div>
</body>
</html>
