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
		<table   class="table-hover table table-condensed  " width="50%">
			<tr >
				<td colspan="2" align="center"><h3>账号信息</h3></td>
			</tr>			
			<tr>
				<td>学号：</td>
				<td>${info[0].stunumber }</td> 
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td>${info[0].name }</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					${info[0].sex }
				</td>
			</tr>
	
			<tr>
				<td>民族：</td>
				<td>${info[0].nation }</td>
			</tr>
			
			<tr>
				<td>电话：</td>
				<td>${info[0].phone }</td>
			</tr>
			
			<tr>
				<td>身份证：</td>
				<td>${info[0].idcard }</td>
			</tr>	
		</table>
			<div class="form-group">
			<tr>
				<td ><a  href="edit.go" ><button type="submit"class="btn btn-default" >修改</button></a></td>
			</tr>
			</div>
	</div>
</body>
</html>
