<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul{
	list-style:none;
	margin:0;
	padding:0;
}

li{
	display:inline;
	padding:0 2px;
}
a:link{
	text-decoration:none;
}


</style>
</head>
<body>
<table border="1">
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
<p>
<ul>
<li>
<c:if test="${pageCri.prev }">
<a href="/movie/movieboard/list?page=${pageCri.beginPage-1}">이전</a>
</c:if>
</li>
<c:forEach var="number" begin="${pageCri.beginPage }" end="${pageCri.endPage }" step="1">
<li><a href="/movie/movieboard/list?page=${number }">${number }</a></li>
</c:forEach>
<li>
<c:if test="${pageCri.next }">
<a href="/movie/movieboard/list?page=${pageCri.endPage+1}">다음</a>
</c:if>
</li>
</ul>
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