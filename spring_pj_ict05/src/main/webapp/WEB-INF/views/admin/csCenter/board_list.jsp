<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시물 등록</title>
<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/admin/ad_boardList.css">

<!--  js -->
<script src="https://kit.fontawesome.com/7ea07dedd1.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>
<script type="text/javascript">
	$(function() {
		$('#btnInsert').click(function() {
			location.href="${path}/board_insert.bc";
		});
	});
</script>
</head>
<body>

	<div class="wrap">
		<!-- header 시각 -->
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<!-- header 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div>
					<h1 align="center"> 게시판 목록 </h1>
				</div>
				<!-- 상단 중앙1 종료 -->
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 좌측메뉴 시작 -->
					<%@ include file="/WEB-INF/views/admin/common/leftMenu.jsp" %>
					<!-- 좌측메뉴 종료 -->
					<!-- 우측메뉴 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="boardList">
								<table>
									<tr>
										<th> 글번호 </th>
										<th> 작성자 </th>
										<th> 글제목 </th>
										<th> 작성일 </th>
										<th> 조회수 </th>
									</tr>
									<!-- 게시글이 있으면 -->
									<c:forEach var="dto" items="${list}">
										<tr>
											<td>${dto.b_num}</td>
											<td>${dto.b_writer}</td>
											<td>
												<a href="${path}/board_detailAction.bc?b_num=${dto.b_num}" style="color:black"> 
													${dto.b_title} 
													<c:if test="${dto.b_comment_count != 0}">
														[${dto.b_comment_count}]
													</c:if>
												</a>
											</td>
											<td>${dto.b_regDate}</td>
											<td>${dto.b_readCnt}</td>
										</tr>
									</c:forEach>
									
									<tr>
										<td colspan="5" align="center">
											<ul class="pagination">
												<!-- 페이징 처리 -->
												<!-- 이전 버튼 활성화 -->
												<c:if test="${paging.startPage > 10}">
													<li>
														<a href="${path}/board_list.bc?pageNum=${paging.prev}" class="prevPage"> [이전] </a>
													</li>
												</c:if>
												
												<!-- 페이지 번호 처리 -->
												<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
													<li>
														<a href="${path}/board_list.bc?pageNum=${num}" class="<c:if test='${num == paging.currentPage}'> active </c:if>"> ${num} </a>
													</li>
												</c:forEach>
												
												<!-- 다음 버튼 활성화 -->
												<c:if test="${paging.endPage < paging.pageCount}">
													<li>
														<a href="${path}/board_list.bc?pageNum=${paging.next}" class="nextPage"> [다음] </a>
													</li>
												</c:if>
											</ul>
										</td>
									</tr>
									<!-- <tr>
										<td colspan="5">
											<div align="right">
												<br>
												<input type="button" class="inputButton" value="글쓰기" id="btnInsert">
												</div>
										</td>
									</tr> -->
								</table>
								<div align="right">
								<br>
								<input type="button" class="inputButton" value="글쓰기" id="btnInsert">
								</div>
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>
				<!-- 상단 중앙2 종료 -->
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
		
		
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- footer 끝 -->
	</div>

</body>
</html>