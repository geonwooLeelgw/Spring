<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<style>
	h2{
	text-align: center;
	}	
	h3{
	text-align: center;
	}
	table{
		text-align :center;
		margin: auto;
	}
	#up{
		background-color: skyblue;
	}
	#sub{
		text-align: left;
	}
	h4{
	text-align: center;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시판 목록</h3>	
<table border="1">
	<tr id="up"><td>번호</td><td>글 제목</td><td>날짜</td><td>조회수</td></tr>
	<c:forEach var = "board" items="${boardList}">
	<tr>
	<td> 
	${board.board_num}
	</td>
	<td id="sub">
	<a href="boardViewAction?board_num=${board.board_num}">${board.board_subject}</a>
	</td>
	<td>
	${board.date}
	</td>
	<td>
	${board.board_readcount}
	</td>
	</tr>
	</c:forEach>
</table>
<h3><a href="boardWrite">게시판글쓰기</a></h3>
</body>
</html>