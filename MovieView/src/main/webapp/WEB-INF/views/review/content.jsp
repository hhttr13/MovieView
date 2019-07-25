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

<table border = "1" style="width : 200px; height : 200px">
<th width="200" colspan="4">
	리뷰 게시물 내용
</th>

<tr>
	<td width="50">리뷰 번호 </td>
	<td width="50"> ${review.reviewNo }</td>
	
	<td width="50">등록일 </td>
	<td width="50"> ${review.regDate }</td>
</tr>

<tr>
	<td width="50">작성자 </td>
	<td width="50"> ${review.reviewWriter}</td>
	
	<td width="50">조회수 </td>
	<td width="50"> ${review.viewCnt }</td>
</tr>

<tr>
	<td> 제목 </td>
	<td colspan="3"> ${review.reviewTitle }</td>
</tr>

<tr>
	<td>내용  </td>
	 <td colspan="3"><textarea rows="30" cols="50" >${review.reviewContent} </textarea> </td>
	
</tr>



</table>

<div>
	<a href="<c:url value='/review/modify?reviewNo=${review.reviewNo}'/>">
	수정
	</a>
	<a href="<c:url value='/review/delete?reviewNo=${review.reviewNo}'/>">
	삭제
	</a>
	<a href="<c:url value='/review/list'/>">
	목록
	</a>
</div>


이 리뷰의 점수는? 여기다 별점화면 추가

</body>
</html>