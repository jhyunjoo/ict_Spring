<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> getUser </h3>
	
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="10">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 등록일 </th>
			</tr>
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.regDate}</td>
			</tr>
		</table>
	</form>
</body>
</html>