<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("session_id") %>님 환영합니다. 
<h2>main.jsp</h2>

<%  String id = (String)session.getAttribute("session_id");
	if(id.equals("admin")){
%> <a href="userList">회원목록</a> <%}%>

<a href="logout">로그아웃</a>
</body>
</html>