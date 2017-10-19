<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
	<h1>用户列表</h1>
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>
				<th>功能</th>
			</tr>
		</thead>
		<tbody>
			<!-- 迭代 -->
			<c:forEach items="${list}" 
				var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.address}</td>
					<c:url var="editUrl" value="/user/edit.action?id=${user.id}"/>
					<c:url var="deleteUrl" value="/user/delete.action?id=${user.id}"/>
					<td> <a href="${editUrl}">编辑</a> <a href="${deleteUrl}">删除</a> </td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>





