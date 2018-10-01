<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
	
	function delconfirm(){
		var message = confirm("기사 요청을 승인하겠습니까?");
		
		if(message == true){
			alert("승인되었습니다.");
		}else
			return false;
	}
</script>
<title>Insert title here</title>
</head>
<body>
<h3>정보</h3>	
<table border="1">
아이디:${DriverDetail.id}
 사진:<img width="300px" height="300px" src="${pageContext.request.contextPath}/resources/${DriverDetail.certificate}">
<c:out value="${pageContext.request.contextPath}"/>
<c:out value="${DriverDetail.certificate}"/>
<a href="DriverAuthorityApproval?id=${DriverDetail.id}"><button onclick="return delconfirm()">승인하기</button></a>
</table>
</body>
</html>