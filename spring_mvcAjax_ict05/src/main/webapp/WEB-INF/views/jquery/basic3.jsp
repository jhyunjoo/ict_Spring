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

	// dataType: 'xml'인 경우
	$(function () {
		$('#btn1').click(function() {
			$.ajax({
				// url
				url: '${path}/resources/data/basic3_data.xml',		// 3. new > other > xml > XML File > 파일명
				type: 'GET',
				dataType: 'xml',
				
				// callback
				success: function(result) { // 6. 콜백함수 - 전송 성공시의 결과가 result에 전달된다.
					let strText = "";
					$(result).find('holiday').each(function() {
						let item_text = $(this).text();		// 실제값을 추출
						strText += item_text;
						$('#display').html(strText);
					});
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
	<button id="btn1"> Ajax 요청 </button>
	<br><br>
	<hr>
	
	<div id="display">
		<!-- 결과 출력 위치 -->	<!-- 설날 삼일절 어린이날 석가탄신일 현충일 광복절 추석 개천절 한글날 크리스마스 -->
	</div>

</body>
</html>