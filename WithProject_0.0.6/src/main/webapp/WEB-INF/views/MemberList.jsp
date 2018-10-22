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
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>유저 목록</h3>	
<table border="1">
	<tr id="up"><td>아이디</td><td>상세보기</td>
	<c:forEach var="member" items="${member}">
	<tr>
	<td> 
	${member.id}
	</td>
	<td id="sub">
	<a href="MemberDetail?id=${member.id}">상세보기</a>
	</td>
	</tr>
	</c:forEach>
</table>
<button onclick="location.href='home';">뒤로가기</button>
<button onclick="location.href='DriverApproval';">승인 대기중인 기사</button>

</body>
</html>