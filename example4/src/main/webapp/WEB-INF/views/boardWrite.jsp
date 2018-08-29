<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	h4{
		text-align: center;
	}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h2>게시판 글등록</h2>
<form action="boardWritePro" method="post" enctype="multipart/form-data" name="boardfrom">
<table>
<tr><td id="t1">글쓴이</td><td id="t2"><input type="text" name="bName" required="required"></td></tr>
<tr><td id="t1">제 목</td><td id="t2"><input type="text" name="bTitle" required="required"></td></tr>
<tr><td id="t1">내 용</td><td id="t2"><textarea name="bContent" rows="20" cols="50" required="required"></textarea></td></tr>
<tr><td id="t1">파일 첨부</td><td id="t2"><input name="bFile" type="file" ></td></tr>
<tr><td></td><td id="t3"><input type="submit" value="등록" >　<input type="reset" value="다시쓰기"></td></tr>
</table>
<h4><a href="boardList">상위 메뉴</a></h4>
</form>
</body>
</html>