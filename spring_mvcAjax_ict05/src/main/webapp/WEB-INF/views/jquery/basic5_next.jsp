<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- lib 추가 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>		<!-- path는 플젝명 -->
<!-- 6. 결과페이지 : 콜백함수의 result로 전달 => display에 출력 -->

<!-- 방법1. 전달받은 후 표현식으로 출력 -->
<%
	// 한글 안깨지게 처리
	request.setCharacterEncoding("UTF-8");

	String strName = (String)request.getAttribute("name");
	String strTel = (String)request.getAttribute("tel");
	String strAddress = (String)request.getAttribute("address");
	String strEmail = (String)request.getAttribute("email");
%>

이름 : <%= strName %> <br>
전화전호 : <%= strTel %> <br>
주소 : <%= strAddress %> <br>
이메일 : <%= strEmail %> <br><br>

<!-- 방법2. EL태그로 출력 -->

이름 : ${name} <br>
전화전호 : ${tel} <br>
주소 : ${address} <br>
이메일 : ${email} <br>