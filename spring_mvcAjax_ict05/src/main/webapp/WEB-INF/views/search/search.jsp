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
		$('#keyword').keyup(function() {	// 키워드 입력이 끝났을 때
			
			let keyword = $('#keyword').val();	// input에 입력한 검색단어
			
			if(keyword.length == 0) {	// 검색 글자수가 0인 경우
				$('#display').css('visibility', 'hidden');	// 숨김
			} else {
				$('#display').css('visibility', 'visible');		// 표시
				$.ajax({
					// url
					url: '${path}/search_next.jq',		// 3. controller search_next.jq 호출
					type: 'POST',
					data: 'keyword=' + keyword,
					success: function(result) { // 6. 콜백함수 - 전송 성공시의 결과가 result에 전달된다.
						
						$('#display').html(result);
					},
					error: function() {
						alert('오류');
					}
				});
			}
		});
	});

</script>
</head>
<body>

	<!-- 2. 버튼 클릭 -->
	<h3> Ajax 검색 </h3>

	<form name="searchForm" method="post" action="#">
		검색할 단어를 입력하세요.<br>
		<input type="text" id="keyword" name="keyword">
		
		<br><br>
		<hr>
		
		<div id="display">
			<!-- 결과 출력 위치 -->
		</div>
	</form>

</body>
</html>