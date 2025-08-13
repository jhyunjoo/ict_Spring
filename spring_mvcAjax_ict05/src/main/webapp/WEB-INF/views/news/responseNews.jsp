<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- lib 추가 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>		<!-- path는 플젝명 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${path}/resources/js/request.js"></script>
<script type="text/javascript">
	// 3 
	function load(url) {
		//alert("load~~~");
		
		// 4.
		sendRequest(loadNews_callback, url, "post", "");
	}
	
	// 6. 콜백함수 - 결과처리
	function loadNews_callback() {
		let result = document.getElementById("news_result");
		if(httpRequest.readyState == 4) {	// 4 : completed => 전체 데이터 취득 완료
			if(httpRequest.status == 200) {	// 200 : 정상종료
				// result.innerHTML = "정상종료!!";
				// 6-1. 응답결과가 html이면 responseText로 받고, xml이면 responseXML로 받는다.
				result.innerHTML = httpRequest.responseText;
			} else {
				result.innerHTML = "status 상태 : " + httpRequest.status;
			}
		} else {
			result.innerHTML = "readyStatus 상태 : " + httpRequest.readyState;
		}
	}
</script>
</head>
<body>

	<!-- 2. -->
	<h3> 오늘의 뉴스 </h3>	
	<a onclick="load('${path}/news1.do')">퇴근길 쓰러진 시민 살린 새내기 간호사…"침착한 CPR 덕에 생명 지켜"</a><br>
	<a onclick="load('${path}/news2.do')">[속보] 폭염 위기경보 '심각' 상향…중대본 1단계 가동</a><br>
	<a onclick="load('${path}/news3.do')">태풍 3개 '트리플 북상'..제주, 태풍 간접 영향으로 '비'</a><br>
	
	<hr>
	
	<div id="news_result">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>