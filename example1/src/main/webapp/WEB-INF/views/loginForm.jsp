<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<form  name="login" action="login" method="post" >
ID : <input type="text" name="id"><br>
PASSWORD : <input type="password" name="password"><br>
<a href="javascript:login.submit()" >로그인</a>
<a href="joinForm">회원가입</a>
</form>
</body>
</html>