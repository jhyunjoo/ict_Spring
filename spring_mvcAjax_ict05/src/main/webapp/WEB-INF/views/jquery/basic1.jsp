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

	$(function () {
		$('#btn').click(function() {
			$.ajax({
				// url
				url: '${path}/basic1_next.jq',		// 3. 컨트롤러 요청
				type: 'GET',
				dataType: 'text',
				
				// callback
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

	<!-- 2. 버튼 클릭 -->
	<button id="btn"> Ajax 요청 </button>
	<br><br>
	<hr>
	
	<div id="display">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>