<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="writeForm" method="post" action="<c:url value='/review/write' />">

<table border = "1">
<th colspan = "2">작성게시판</th> 
<tr>
	<td>작성자</td>
	<td><input id="reviewWriter" name="reviewWriter"></td>
</tr>

<tr>
	<td>제목</td>
	<td><input id="reviewTitle" name="reviewTitle"></td>
</tr>

<tr>
	<td>내용</td>
	<td><textarea id="reviewContent" name="reviewContent" rows="20" cols="22" > </textarea></td>
	
</tr>

</table>

<div>
	<button type="reset">초기화</button>
	<button type="submit">등록 </button>
	<button type="button" id="backBtn">이전페이지</button>
</div>

</form>

<jsp:include page="include/plugin-js.jsp"/>

</body>

<script type="text/javascript">
$(document).ready(function(){
		//글쓰기 버튼 클릭 이벤트
		$("#backBtn").on("click", function(){
			self.location = "/movie/review/list";
		});
});
</script>
		
</html>