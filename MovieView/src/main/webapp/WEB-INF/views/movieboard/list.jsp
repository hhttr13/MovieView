<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../include/static-head.jsp" />
<style type="text/css">
a:link{
	text-decoration:none;
}
body{
	background-color: #090B08;
}
.row {
   margin-bottom: 4px;
   margin-top: 4px;
}
</style>
</head>
<body>
<jsp:include page="../include/main-navi.jsp"/>
<div class="container">
<div class="row">
	<div class="col-md-3">&nbsp</div>
	<div class="col-md-6">&nbsp</div>
	<div class="col-md-3">&nbsp</div>
</div>
<div class="row">
	<div class="col-md-3">&nbsp</div>
	<div class="col-md-6">&nbsp</div>
	<div class="col-md-3">&nbsp</div>
</div>
<div class="row">
	<div class="col-md-3">&nbsp</div>
	<div class="col-md-6">&nbsp</div>
	<div class="col-md-3">&nbsp</div>
</div>
<div class="row">
	<div class="col-md-3">&nbsp</div>
	<div class="col-md-6">&nbsp</div>
	<div class="col-md-3">&nbsp</div>
</div>
<div class="row">
<div class="col-md-1">&nbsp</div>
<div class="col-md-10">
<a href="/movie/movieboard/list?searchGenre=1">액션</a>
<a href="/movie/movieboard/list?searchGenre=2">판타지</a>
<a href="/movie/movieboard/list?searchGenre=3">SF</a>
<a href="/movie/movieboard/list?searchGenre=4">로맨스</a>
<table class="table" border="1">
<tr>
	<th>No.</th>
	<th>제목</th>
	<th>장르</th>
	<th>국가</th>
	<th>개봉일</th>
	<th>감독</th>
	<th>배우</th>
	<th>평점</th>
</tr>
<c:forEach var="list" items="${movielist }">
<tr>
	<td>${list.movieNo }</td>
	<td><a href="/movie/movieboard/content?movieNo=${list.movieNo }">${list.title }</a></td>
	<td>${list.genre }</td>
	<td>${list.nation }</td>
	<td>${list.openDate }</td>
	<td>${list.director }</td>
	<td>${list.actor }</td>
	<td>${list.score }</td>	
</tr>
</c:forEach>
<tr>
	<td colspan="8" style="text-align:right"><a href="/movie/movieboard/insert">게시물 작성&nbsp;&nbsp;</a></td>
</tr>
</table>
</div>
<div class="col-md-1">&nbsp</div>
</div>
</div>
<p>

<ul class="pagination">
<li class="page-item">
<c:if test="${pageCri.prev }">
<a class="page-link" href="/movie/movieboard/list?page=${pageCri.beginPage-1}&condition=${cri.condition}&keyword=${cri.keyword}&searchGenre=${cri.searchGenre}">이전</a>
</c:if>
</li>
<c:forEach var="number" begin="${pageCri.beginPage }" end="${pageCri.endPage }" step="1">
<li class="page-item"><a class="page-link" href="/movie/movieboard/list?page=${number }&condition=${cri.condition}&keyword=${cri.keyword}&searchGenre=${cri.searchGenre}">${number }</a></li>
</c:forEach>
<li class="page-item">
<c:if test="${pageCri.next }">
<a class="page-link" href="/movie/movieboard/list?page=${pageCri.endPage+1}&condition=${cri.condition}&keyword=${cri.keyword}&searchGenre=${cri.searchGenre}">다음</a>
</c:if>
</li>
</ul>

<form action="/movie/movieboard/list?condition=${cri.condition }&keyword=${cri.keyword}&searchGenre=${cri.searchGenre}" method="GET">
<div class="input-group">
	<div class="input-group-prepend">
		<span class="input-group-text">제목</span>
	</div>
	<input type="text" name="keyword" class="form-control" placeholder="입력바람">
	<input type="hidden" name="searchGenre" value="${cri.searchGenre }">
	<input type="hidden" name="condition" value="title" >
<button type="submit" class="btn btn-primary">검색</button>
</div>
</form>
</p>
<script type="text/javascript">
	const result="${message}";
	if(result === "insertSuccess"){
		alert("게시글 작성이 완료되었습니다.");
	}else if(result === "delSuccess"){
		alert("게시글 삭제가 완료되었습니다.")
	}else if(result === "updateSuccess"){
		alert("게시글 수정이 완료되었습니다.")
	}
	
</script>
</body>
</html>