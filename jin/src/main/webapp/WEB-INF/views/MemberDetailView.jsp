<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
	
	function delconfirm(){
		var message = confirm("정말로 회원을 삭제하시겠습니까?");
		
		if(message == true){
			alert("삭제되었습니다.");
		}else
			return false;
	}
</script>
</head>
<body>
<h3>유저 목록</h3>	
<table border="1" colspan="2">
 <c:set var="passuser" value="${Memberdetail.passuser}" />
	<tr id="up">
    <td>아이디</td>
    <td>성별</td>
    <td>이메일</td>
    <td>전화번호</td>
    <td>주소</td>
    <td>유저 분류</td>
  </tr>
    <td>${Memberdetail.id}</td>
    <td>${Memberdetail.gender}</td>
     <td>${Memberdetail.email}</td>
      <td>${Memberdetail.tel}</td>
       <td>${Memberdetail.address}</td>
        <c:choose>
        <c:when test="${passuser eq '1'}">
         <td>일반</td>
          </c:when>
    <c:when test="${passuser eq '2'}">
    <td>기사</td>
     </c:when>
</c:choose>
</table>
<a href="MemberDelete?id=${Memberdetail.id}"><button onclick="return delconfirm()">삭제하기</button></a>
</body>
</html>