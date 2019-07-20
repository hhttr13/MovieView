<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<form action="/movie/movieboard/insert" method="POST">
<tr>
	<th>제목</th>
	<td><input type="text" name="title"></td>
</tr>
<tr>
	<th>장르</th>
	<td><input type="text" name="genre"></td>
</tr>
<tr>
	<th>국가</th>
	<td><input type="text" name="nation"></td>
</tr>
<tr>
	<th>개봉일</th>
	<td><input type="text" name="openDate"></td>
</tr>
<tr>
	<th>감독</th>
	<td><input type="text" name="director"></td>
</tr>
<tr>
	<th>배우</th>
	<td><input type="text" name="actor"></td>
</tr>
<tr>
	<th>줄거리</th>
	<td><textarea id="synoposis" name="synoposis" rows="15" cols="40"
             placeholder="내용을 입력해주세요" style="resize: none;"></textarea></td>
</tr>
<tr>
	<th>BUTTON</th>
	<td><input type="submit" value="작성"></td>
</tr>
</form>
</table>
</body>
</html>