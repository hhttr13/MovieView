<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>No.</th>
	<td>${movie.movieNo }</td>
</tr>
<tr>
	<th>제목</th>
	<td>${movie.title }</td>
</tr>
<tr>
	<th>장르</th>
	<td>${movie.genre }</td>
</tr>
<tr>
	<th>국가</th>
	<td>${movie.nation }</td>
</tr>
<tr>
	<th>개봉일</th>
	<td>${movie.openDate }</td>
</tr>
<tr>
	<th>감독</th>
	<td>${movie.director }</td>
</tr>
<tr>
	<th>배우</th>
	<td>${movie.actor }</td>
</tr>
<tr>
	<th>줄거리</th>
	<td><textarea id="synoposis" name="synoposis" rows="15" cols="40" readonly>${movie.synoposis }</textarea></td>
</tr>
<tr>
<td><a href="/movie/movieboard/update?movieNo=${movie.movieNo }">수정</a></td>
<td><a href="/movie/movieboard/delete?movieNo=${movie.movieNo }">삭제</a></td>
</tr>
<tr>
<td><a href="/movie/movieboard/list">목록으로</a></td>
</tr>
</table>

<table border = "1">
<tr>
	<th>ReviewNO</th>
	<th>TITLE</th>
	<th>WRITER</th>
	<th>CONTENT</th>
	<th>REGDATE</th>
	<th>VIEW_CNT</th>
</tr>

<c:if test="${reviews.size() <= 0 }">
	<tr>
		<td> 검색 결과가 없습니다</td>
	</tr>
	
</c:if>

<c:forEach var="review" items="${reviews }">
<tr>
	<td align="center">${review.reviewNo }</td>
	<td>
	<a href="<c:url value='/review/content${pageCreator.makeSearchURI(pageCreator.criteria.page)}&reviewNo=${review.reviewNo}'/>">
	${review.reviewTitle }
	</a>
	</td>
	<td>${review.reviewWriter }</td>
	<td>${review.reviewContent }</td>
	<td><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${review.regDate }"/></td>
	<td align="center">${review.viewCnt }</td>
</tr>
</c:forEach>
</table>

<input type="button" id="writeBtn" onclick="writeBtn_click();" value="리뷰 작성">
 
<div>
<ul>
		<c:if test="${pageCreator.prev}">                                
			<li><a href="<c:url value='/review/list${pageCreator.makeSearchURI(pageCreator.beginPage - 1)}' />">이전</a></li> 
		</c:if>                               
					              
		<c:forEach var="idx" begin="${pageCreator.beginPage}" end="${pageCreator.endPage}">              
			<!--<c:out value="${pageCreator.criteria.page == idx ? 'class=active' : ''}"/> -->
			<a href="<c:url value='/review/list${pageCreator.makeSearchURI(idx)}'/>">${idx}  </a>                                
		</c:forEach>    
					              
		<c:if test="${pageCreator.next}">               
			<li><a href="<c:url value='/review/list${pageCreator.makeSearchURI(pageCreator.endPage + 1)}' />">다음</a></li>
		</c:if>
</ul>					         	
</div>

<!-- 검색 -->
<div>
	<select id="condition" name="condition">
		<option value="title" <c:out value="${param.condition == 'title' ? 'selected' : ''}"/>>제목</option>
		<option value="content" <c:out value="${param.condition == 'content' ? 'selected' : ''}"/>>내용</option>
		<option value="writer" <c:out value="${param.condition == 'writer' ? 'selected' : ''}"/>>작성자</option>
	</select>
</div>

<div>
	<input type="text" name="keyword" id="keywordInput" value="${param.keyword}" placeholder="검색어">
	<button type="button" id="searchBtn">
		검색
	</button>
</div>
<script type="text/javascript">
const result = "${message}";

if(result == "regSuccess"){
	alert("게시물 등록이 완료되었습니다.");
}
else if(result =="modSuccess"){
	alert("게시물 수정이 완료되었습니다.");
}
else if(result =="delSuccess"){
	alert("게시물 삭제가 완료되었습니다.")
}


function writeBtn_click(){
	//alert("버튼을 누르셨습니다.");
	window.location.href='http://localhost:8181/movie/review/write?movieNo=${movie.movieNo}';
}

//맵핑문제, 학원가서체크
//JQUERY
$(document).ready(function(){
	//글쓰기 버튼 클릭 이벤트
	$("#testBtn").on("click", function(){
		console.log("write test");
		self.location = "/movie/review/write?movieNo=${review.movieNo}";
	});
	
	//검색버튼 클릭이벤트
	$("#searchBtn").on("click", function(){
		console.log("search event");
		self.location = "/movie/review/list${pageCreator.makePageURI(1)}"
						+ "&condition=" + $("select option:selected").val()
						+ "&keyword=" + $("#keywordInput").val()+"&movieNo=${movie.movieNo}";
	});
	
	
});
</script>
</body>
</html>