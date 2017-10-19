<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑用户信息</title>
<!-- edit.jsp -->
</head>
<body>
	<h1>编辑用户信息</h1>
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<form action="update.action" method="post">
		<input type="hidden" name="user.id" 
			value="${user.id}"> 
		<div>
			<label>姓名</label>
			<input name="user.name" type="text"
				value="${user.name}">
			<span>${nameError}</span>
		</div>
		<div>
			<label>年龄</label>
			<input name="user.age" type="text"
				value="${user.age}">
		</div>
		<div>
			<label>地址</label>
				<!-- ognl表达式 -->
			<input name="user.address" type="text" value='<s:property value="user.address"/>'>
		</div>
		<div>
			<input type="submit" value="保存">  
		</div>
	</form>
	<s:debug></s:debug>
</body>
</html>







