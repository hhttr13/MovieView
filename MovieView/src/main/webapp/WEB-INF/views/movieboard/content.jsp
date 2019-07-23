<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">

</script>
</body>
</html>