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

	<h3> getUserSearchInfo </h3>
	
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="10">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 등록일 </th>
				<th> 글번호 </th>
				<th> 타이틀 </th>
				<th> 내용 </th>
			</tr>
			<!-- 반복문 -->
			<c:forEach var="user" items="${list}">
				<c:forEach var="board" items="${user.boardDTO}">
					<tr>
						<td> ${user.userId} </td>
						<td> ${user.userName} </td>
						<td> ${user.regDate} </td>
						<td> ${board.boardNum} </td>
						<td> ${board.boardTitle} </td>
						<td> ${board.boardContent} </td>
					</tr>
				</c:forEach>
			</c:forEach>
			<!-- 
			아이디	이름		등록일			글번호	타이틀	내용
			1	john	2025-08-08	100	자바	반복문
			 -->
		</table>
	</form>
	
</body>
</html>