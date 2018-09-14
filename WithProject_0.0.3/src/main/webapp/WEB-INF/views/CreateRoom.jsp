<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>방 만들기 페이지</h2>
아이디 값 : <%=session.getAttribute("id") %><br>
출발지 확인 :${Room.rStart}<br>
 도착지 확인 :${Room.rEnd}<br>
예상 거리 :${Room.preDistance}<br>
예상 금액 :${Room.preMoney}<br>
예상 시간 :${Room.preTime}<br> 

동승자 성별선택 :<input type=radio name="gender" value="남">남자
	  <input type="radio" name="gender" value="여">여자
	  <input type="radio" name="gender" value="상관없음">상관없음<br>
최대 인원 선택 : <select name="Maximum">
<option>2명</option>
<option>3명</option>
<option>4명</option>
</select><br>

<input type="submit" value="바로만들기">　<strong><input type="button" value="예약" onclick="innerHTMLReservation()" name="pay"></strong><br>
<span id="Send"></span>


</body>
</html>