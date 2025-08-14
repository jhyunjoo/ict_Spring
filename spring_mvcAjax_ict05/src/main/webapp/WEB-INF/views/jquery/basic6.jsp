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
	$(function() {
		$('#btn').click(function() {
			let obj = new Object();
			obj.id = "james";
			obj.pwd = "james1234";
			obj.name = "jamesD";
			
			// 자바스크립트 객체를 String 객체로 변환
			let jsonData = JSON.stringify(obj);
			// 컨트롤러 호출
			$.ajax({
				url: '${path}/basic6_next.jq',	// 3. 컨트롤러 basic6_next.jq 호출
				type: 'POST',
				data: jsonData,
				contentType: 'application/json;charset=UTF-8',	// 오타 주의
				success: function(result) {	// 콜백함수
					// alert(alert)
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
	<button id="btn"> Ajax 요청 </button>	
	<br><br>
	<hr>
	
	<div id="display">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>