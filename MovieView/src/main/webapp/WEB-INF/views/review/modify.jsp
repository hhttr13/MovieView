<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content page</title>
</head>
<body>
<form id="modifyForm" method="post" action="<c:url value='/review/modify' />">
<input type="hidden" name="movieNo" value="${review.movieNo }">
<div>
	리뷰 번호 : ${review.reviewNo }
	
</div>

<div>
	제목 : 
	<input id="reviewTitle" name="reviewTitle" value= "${review.reviewTitle}">
</div>
<div>
	작성자 : ${review.reviewWriter}
</div>
<div>
	등록일 : ${review.regDate}
</div>

<div>
	내용 : 
	<input id="reviewContent" name="reviewContent" value="${review.reviewContent}">
</div>


<input type="hidden" name="reviewNo" value="${review.reviewNo}">

<div>
	<button type="submit">수정</button>
	<button type="reset">초기화</button>
</div>
</form>

</body>
</html>