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

	function show() {
		// alert("show()~~~");
		// sendRequest(callback, url, method, params) {}
		sendRequest(simple_callback, "${path}/simple.do", "post", "");
	}
	
	// 콜백함수 - 결과처리
	// 서버로부터 응답이 오면 동작할 함수(비동기 함수를 관리하는 XMLHttpRequest 호출)
	// 콜백함수명은 sendRequest(콜백함수명)과 일치해야 한다.
	function simple_callback() {
		let result = document.getElementById("simple_result");
		if(httpRequest.readyState == 4) {	// 4 : completed => 전체 데이터 취득 완료
			if(httpRequest.status == 200) {	// 200 : 정상종료
				// result.innerHTML = "정상종료!!";
				const msg = "이름 : " + document.inputForm.username.value;
				result.innerHTML = msg;
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

	<h3> Ajax(Asynchronous JavaScript And XML , 비동기적인 자바스크립트와 XML) </h3>
	
	<form name="inputForm" method="post">
		<table border="1" cellspacing="0" cellpadding="10">
			<tr>
				<th> 이름 </th>
				<td> 
					<input type="text" name="username">
					<input type="button" value="확인" onclick="show()">
					
					
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
	
	<div id="simple_result">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>