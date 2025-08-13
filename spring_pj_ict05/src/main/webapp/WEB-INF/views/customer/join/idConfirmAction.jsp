<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
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
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">

<!--  js -->
<script src="https://kit.fontawesome.com/7ea07dedd1.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>
<script src="${path}/resources/js/customer/join.js" defer></script>
</head>
<body>

	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center"> ID 중복 확인 </h1>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<div id="s2_inner">
						<div class="join">
							<form name="confirmform" action="idConfirmAction.do" method="post">
								<!-- id 중복일 떄, id를 입력받아 다시 중복체크 -->
								<c:if test="${selectCnt == 1}">
									<table align="center" width="500px">
										<tr>
											<th colspan="2">
												<span>${strId}는 사용할 수 없습니다.</span>
											</th>
										</tr>
										<tr>
											<th> * 아이디 </th>
											<td>
												<input type="text" class="input" name="user_id" size="20" placeholder="공백없이 20자 이내로 작성" required autofocus>
											</td>
										</tr>
										<tr>
											<td colspan="2" style="border-bottom: none">
												<br>
												<div align="right">
													<input class="inputButton" type="submit" value="확인">
													<input class="inputButton" type="reset" value="초기화">
												</div>
											</td>
										</tr>
									</table>
								</c:if>
								<!-- // id 중복아닐 때, 확인 후 창 닫기 -->
								<c:if test="${selectCnt != 1 }">
									<table align="center" width="500px">
										<tr>
											<th colspan="2">
												<span>${strId}는 사용할 수 있습니다.</span>
											</th>
										</tr>
										<tr>
											<td colspan="2" style="border-bottom: none">
												<br>
												<div align="right">
													<input class="inputButton" type="button" value="확인" onclick="setUserid('${strId}')">
												</div>
											</td>
										</tr>
									</table>
								</c:if>
							</form>
						</div>	<!-- join -->
					</div>
				</div>
				<!-- 상단 중앙2 끝 -->
				
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	</div>

</body>
</html>