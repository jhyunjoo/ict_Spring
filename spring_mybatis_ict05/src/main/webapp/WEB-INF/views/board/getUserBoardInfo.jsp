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

	<h3> getBoardInfo </h3>
	
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="10">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 등록일 </th>
				<th colspan="3"> 게시글 </th>	<!-- 글번호 타이틀 글내용 -->
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
		</table>
	</form>
	
</body>
</html>