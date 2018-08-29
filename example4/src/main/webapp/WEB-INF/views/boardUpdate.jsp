<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<style>
	h2{
		text-align: center;
	}
	table{
		margin: auto;
	}
	#t1{
		background-color: orange;
		text-align: center;
	}
	#t2{
		background-color: skyblue;
	}
	span{
		text-align: center;
	}
	#t3{
		text-align: center;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- javascript:loginform.submit()
	<input type="hidden" name="fileanme1" value="//filename1 %>">
 -->
<body>
<h2>board_update.jsp 파일</h2>
<h2>게시판 글수정</h2>
<table>

<form name="board_update" action="./boardUpdateWritePro?bId=${boardUpdate.bId}" method="post">

 <tr><td id="t1">글쓴이</td><td id="t2"><input type="text" name="bName" required="required" value="${boardUpdate.bName}"></td></tr>
 <tr><td id="t1">제 목</td><td id="t2"><input type="text" name="bTitle" required="required" value="${boardUpdate.bTitle}"></td></tr>
 <tr><td id="t1">내 용</td><td id="t2"><textarea name="bContent" rows="20" cols="50" required="required" placeholder="${boardUpdate.bContent}"></textarea></td></tr>
 <tr><td id="t1">파 일</td><td id="t2"><input type="text" name="bFile" required="required" value="${boardUpdate.bFile}"></td></tr>
 <tr><td></td><td id="t3"><a href="javascript:board_update.submit()">[수정]</a>　<a href="boardView?board_num=${boardUpdate.bId}">[뒤로]</a></td></tr>

</form>

</table>
</body>
</html>