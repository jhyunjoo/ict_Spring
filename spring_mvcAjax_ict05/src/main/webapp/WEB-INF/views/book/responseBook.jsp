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
	function load() {
		//alert("load~~~");
		
		// 4.
		sendRequest(loadBooks_callback, "bookInfo.do", "post", "");	// 컨트롤러 - bookInfo.do 결과페이지
	}
	
	// 6. 콜백함수 - 결과처리
	function loadBooks_callback() {
		let result = document.getElementById("book_result");
		if(httpRequest.readyState == 4) {	// 4 : completed => 전체 데이터 취득 완료
			if(httpRequest.status == 200) {	// 200 : 정상종료
				//result.innerHTML = "정상종료!!";
				// 6-1. 응답결과가 html이면 responseText로 받고, xml이면 responseXML로 받는다.
				let data = httpRequest.responseText;
				
				// 책 1권별('|')로 자른다. (10건의 정보를 books에 담는다.)
				let books = data.split("|");
				
				let bookList = "";	// 결과변수
				
				// 배열생성
				let array = new Array();
				
				// 배열의 길이만큼 콤마를 기준으로 자른 후
				for(let i=0; i < books.length; i++) {
					array = books[i].split(",");
					
					// bookList에 제목,저자,가격을 누적해서 result에 출력한다.
					bookList += "제목 : " + array[0] + "<br>"
								+ "작가 : " + array[1] + "<br>"
								+ "가격 : " + array[2] + "<br><br>"; 
				}
				
				result.innerHTML = bookList; 
				
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
	<h3> 베스트 셀러 </h3>	

	<input type="button" value="확인" onclick="load()">	
	<hr>
	
	<div id="book_result">
		<!-- 결과 출력 위치 -->
	</div>

</body>
</html>