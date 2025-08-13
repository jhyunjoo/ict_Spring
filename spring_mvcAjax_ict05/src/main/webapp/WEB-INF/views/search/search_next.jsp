<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- lib 선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="listFrom" method="post">
		<!-- 반복문을 돌면서 검색결과를 뿌린다 -->
		<c:forEach var="dto" items="${list}">
			${dto.keyword}<br>
		</c:forEach>
	</form>
</body>
</html>