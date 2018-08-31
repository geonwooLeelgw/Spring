<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
	table{
		text-align: center;
		margin: auto;
	}
	h2{
		text-align: center;
	}
	#hi{
		background-color: skyblue;
	}
	h3{
		text-align: center;
	}
</style>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세보기!</h2>
	
	<table border="1">
	<tr>
	<td id="hi" colspan="2">글 내용 상세보기</td>
	</tr>
	<tr>
	<td>
	글쓴이</td><td>${boardView.bName}
	</td>
	</tr>
	<tr>
	<td>
	제목</td><td>${boardView.bTitle}
	</td>
	</tr>
	<tr>
	<td>파일</td><td><a href="boardFileDown?downFile=${boardView.bFileName}">${boardView.bFileName}</a></td>
	</tr>
	<tr>
	<td>
	내용</td><td>${boardView.bContent}</td>
	</tr>
	</table>
	<h3><a href="boardList">목록</a>　<a href="boardUpdate?bId=${boardView.bId}">수정이</a>
	　<a href="baordDelete?bId=${boardView.bId}">삭제요</a></h3>
	
	


</body>
</html>