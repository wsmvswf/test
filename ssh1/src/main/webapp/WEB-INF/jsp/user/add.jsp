<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
	<h1>添加用户</h1>
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<form action="save.action" method="post">
		<div>
			<label>姓名</label>
			<input name="name" type="text"
				value="${name}">
			<span>${nameError}</span>
		</div>
		<div>
			<label>年龄</label>
			<input name="age" type="text"
				value="${age}">
		</div>
		<div>
			<label>地址</label>
			<input name="address" type="text"
				value="${address}">
		</div>
		<div>
			<input type="submit" value="保存">  
		</div>
	</form>
</body>
</html>







