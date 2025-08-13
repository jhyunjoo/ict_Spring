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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

	<div class="wrap">
		<!-- header 시각 -->
		<%@ include file="/WEB-INF/views/common/header.jsp" %>	<!-- customer/webapp/common/header.jsp -->
		<!-- header 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center"> 회원가입 </h1>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<div id="s2_inner">
						<div class="join">
							<form name="inputform" action="joinAction.do" method="post" onsubmit="return signInCheck()">
								<!-- 2-1. 중복확인 버튼 안 눌렀을 때 0으로 설정 -->
								<input type="hidden" name="hiddenUserid" value="0">
								<table>
									<tr>
										<th> * 아이디 </th>
										<td>
											<input type="text" class="input" name="user_id" size="20" placeholder="공백없이 20자 이내로 작성" required autofocus>
											<input type="button" name="dubChk" value="중복확인" style="margin-left:10px" onclick="confirmId()">
										</td>
									</tr>
									<tr>
										<th> * 비밀번호 </th>
										<td>
											<input type="password" class="input" name="user_password" size="20" placeholder="공백없이 20자 이내로 작성" required>
										</td>
									</tr>
									<tr>
										<th> * 비밀번호(확인) </th>
										<td>
											<input type="password" class="input" name="re_user_password" size="20" placeholder="비밀번호 확인" required>
										</td>
									</tr>
									<tr>
										<th> * 이름 </th>
										<td>
											<input type="text" class="input" name="user_name" size="50" placeholder="이름 작성" required>
										</td>
									</tr>
									<tr>
										<th> * 생년월일 </th>
										<td>
											<input type="date" class="input" name="user_birthday" size="8" placeholder="-없이 생년월일 8자리" required>
										</td>
									</tr>
									<tr>
										<th> * 주소 </th>
										<td>
											<input type="text" class="input" name="user_address1" id="user_address1" size="50" placeholder="주소 작성" required>
											<input type="button" style="margin-left:10px" value="주소찾기" onclick="searchAddress()"><br><br>
											<input type="text" class="input" name="user_address2" id="user_address2" size="50" placeholder="상세주소 작성" required>
										</td>
									</tr>
									<tr>
										<th> 연락처 </th>
										<td>
											<input type="text" class="input" name="user_hp1" size="3" style="width:50px">
											-
											<input type="text" class="input" name="user_hp2" size="4" style="width:70px">
											-
											<input type="text" class="input" name="user_hp3" size="4" style="width:70px">
										</td>
									</tr>
									<tr>
										<th> * 이메일 </th>
										<td>
											<input type="text" class="input" name="user_email1" size="20" style="width:100px" required>
											@
											<input type="text" class="input" name="user_email2" size="20" style="width:100px" required>
											<select class="input" name="user_email3" style="width:100px" onchange="selectEmailChk()">
												<option value="0">직접 입력</option>
												<option value="naver.com">네이버</option>
												<option value="google.com">구글</option>
												<option value="daum.net">다음</option>
												<option value="nate.com">네이트</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="2" style="border-bottom: none">
											<br>
											<div align="right">
												<input class="inputButton" type="submit" value="회원가입">
												<input class="inputButton" type="reset" value="초기화">
												<input class="inputButton" type="button" value="가입취소" onclick="window.location='main.do'">
											</div>
										</td>
									</tr>
								</table>
							</form>
						</div>	<!-- join -->
					</div>
				</div>
				<!-- 상단 중앙2 끝 -->
				
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
		
		
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- footer 끝 -->
	</div>

</body>
</html>