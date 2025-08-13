<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<!-- lib 추가 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>		<!-- path는 플젝명 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

<script type="text/javascript">

	// data: 'json'인 경우
	$(function () {
		$('#btn1').click(function() {
			
			let _jsonInfo = '{"name" : "박나래", "tel" : "010-1111-2222","address" : "서울시 서초구", "email" : "pnr@gmail.com"}';
			
			$.ajax({
				// url
				url: '${path}/basic5_next.jq',		// 3. controller basic5_next.jq 호출
				type: 'POST',
				data: {jsonInfo : _jsonInfo},	// jsp의 setAttribute 기능 => {key : value}
				success: function(result) { // 6. 콜백함수 - 전송 성공시의 결과가 result에 전달된다.
					
					$('#display').html(result);
				},
				error: function() {
					alert('오류');
				}
			});
		});
	});

</script>
</head>
<body>

	   <!-- JSON이란?  => 중요
      자바스크립트 객체 표기법을 JSON(JavaScript Object Notation)이라고 한다.
      JSON은 데이터를 전달할 때 사용하는 표준 형식으로, JSON은 속성(key)과 값(value)이 하나의 쌍을  이루고 있다.
      
      기본형 => {"속성1":값1, "속성2":값2, "속성3":값3,...}
      배열{객체} => [{"속성1":값1, "속성2":값2, "속성3":값3,...}, {"속성1":값1, "속성2":값2, "속성3":값3,...}...]
      -->

	<!-- 2. 버튼 클릭 -->
	<button id="btn1"> Ajax 요청 </button>
	<br><br>
	<hr>
	
	<div id="display">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>