<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<form action="/movie/movieboard/update" method="POST">
<tr>
	<th>No.</th>
	<td><input type="text" name="movieNo" value="${movie.movieNo }" readonly></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="${movie.title }"></td>
</tr>
<tr>
	<th>장르</th>
	<td><input type="text" name="genre" value="${movie.genre}"></td>
</tr>
<tr>
	<th>국가</th>
	<td><input type="text" name="nation" value="${movie.nation}"></td>
</tr>
<tr>
	<th>개봉일</th>
	<td><input type="text" name="openDate" value="${movie.openDate}"></td>
</tr>
<tr>
	<th>감독</th>
	<td><input type="text" name="director" value="${movie.director}"></td>
</tr>
<tr>
	<th>배우</th>
	<td><input type="text" name="actor" value="${movie.actor}"></td>
</tr>
<tr>
	<th>줄거리</th>
	<td><textarea id="synoposis  " name="synoposis" rows="15" cols="40"
             placeholder="내용을 입력해주세요" style="resize: none;"">${movie.synoposis }</textarea></td>
</tr>
<tr>
	<th><input type="submit" value="수정"></th>
</tr>
</form>
</table>
</body>
</html>