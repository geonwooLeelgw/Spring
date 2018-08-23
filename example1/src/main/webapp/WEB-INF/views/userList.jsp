<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보<br>
<c:forEach var="user" items="${userList}">
아이디 : <a href="userView?id=${user.id}">${user.id}</a><br>
비밀번호 : ${user.password}<br>
나이 : ${user.age}<br>
성별 : ${user.gender }<br>
이메일 : ${user.email}<br><br>
</c:forEach>
</body>
</html>