<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/schoolCardManager/css/bootstrap.css" />
</head>
<body>
	<div class="container  table-responsive" >
	<form action="../updatePwd.go"  method="post">
		<table  class="table-hover table table-condensed  " width="50%">
			<tr >
				<td colspan="2" align="center"><h3> 修改密码</h3></td>
			</tr>			
			<tr>
				<td>原密码：</td>
				<td><input type="password" name="oldpwd"   required="required"></td>
			</tr>
			
			<tr>
				<td>新密码：</td>
				<td><input type="password" name="newpwd1"  required="required" ></td>
			</tr>
			<tr>
				<td>再次输入：</td>
				<td><input type="password" name="newpwd2"  required="required" ></td>
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
