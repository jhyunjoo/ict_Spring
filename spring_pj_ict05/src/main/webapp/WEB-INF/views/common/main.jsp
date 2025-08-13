<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/common/main.css">

<!--  js -->
<script src="https://kit.fontawesome.com/7ea07dedd1.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>

<script type="text/javascript">
	window.onload = show;
	
	var tag = [
		"<img src='${path}/resources/images/main/냥.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥2.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥3.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥4.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥5.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥6.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥7.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥8.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥9.jpg' width='800px'>",
		"<img src='${path}/resources/images/main/냥10.jpg' width='800px'>",
		"<video src='${path}/resources/images/main/cat1.mp4' width='800px' controls='controls' muted autoplay playsinline loop/>",
		"<video src='${path}/resources/images/main/cat2.mp4' width='800px' controls='controls' muted autoplay playsinline loop/>",
		"<video src='${path}/resources/images/main/cat3.mp4' width='800px' controls='controls' muted autoplay playsinline loop/>"
	];
	
	function show() {
		var randomNum = Math.floor(Math.random() * tag.length);
		
		document.getElementById('random').innerHTML = tag[randomNum];
	};
</script>
</head>
<body>

	<div class="wrap">
		<!-- header 시각 -->
		<%@ include file="header.jsp" %>
		<!-- header 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<center>
			<h3> main 영역 </h3>
				<div id="random">
				
				</div>
			<!-- <video id="randomVideo" width="800px" controls="controls" muted autoplay playsinline loop/> -->
			<!-- <img id="randomImage" width="40%"> -->
		</center>
		<!-- 컨텐츠 끝 -->
		
		
		<!-- footer 시작 -->
		<%@ include file="footer.jsp" %>
		<!-- footer 끝 -->
	</div>

</body>
</html>