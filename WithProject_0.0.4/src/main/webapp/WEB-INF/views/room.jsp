<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@page import="org.springframework.web.context.request.RequestAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%-- <%@page import="com.with.project.vo.RoomVO" %> --%>
    <%-- <%@ page import="bean.EditorBean"%> --%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>


<script>
$(document).ready(function () {
    updateData();
});

function updateData(){
    $.ajax({
      url: "realTime",
      type:"post",
      data : {"roomId" : roomId.value, "Id" : Id.value},
      cache : false,
      success: function(data){
       $('#showtime').html(data);
      }
    });
    setTimeout("updateData()", 10000); // 2초 단위로 갱신 처리
}
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String id = (String)session.getAttribute("id");
%>
<body onload="updateData()">
<div id="showtime">
<input type="hidden" id="Id" name="Id" value="<%=id%>">
<input type="hidden" id="roomId" name="roomId" value="${Room.roomId}">
<h2>room.jsp</h2>
<h3>room페이지에서는 뒤로가기 금지!</h3>
성별 옵션: ${Room.opGender }<br>
<%int num = 0; %>
<c:if test="${Room.rId1 != null}">
<% num += 1; %>
</c:if>
<c:if test="${Room.rId2 != null }">
<% num +=1; %>
</c:if>
<c:if test="${Room.rId3 != null }">
<% num +=1; %>
</c:if>
<c:if test="${Room.rId4 != null }">
<% num +=1; %>
</c:if>
인원 수: <%=num %> / ${Room.maximum}<br>
<c:if test="${Room.rId1 != null}">
현재 입장중인 ID: ${Room.rId1}<br>
</c:if>
<c:if test="${Room.rId2 != null}">
현재 입장중인 ID: ${Room.rId2}<br>
</c:if>
<c:if test="${Room.rId3 != null}">
현재 입장중인 ID: ${Room.rId3}<br>
</c:if>
<c:if test="${Room.rId4 != null}">
현재 입장중인 ID: ${Room.rId4}<br>
</c:if>
<c:if test="${Room.driverId == null}">
기사 ID : 현재 입장중인 기사가 없습니다.<br>
</c:if>
<c:if test="${Room.driverId != null}">
기사 ID : <a href="DriverInfo?Id=${Room.driverId}">${Room.driverId}</a><br>
</c:if>


<br>
출발지 : ${Room.rStart}<br>
도착지 : ${Room.rEnd }<br>
예상거리 : ${Room.preDistance }<br>

(예상금액 / 최대인원 한 값)예상금액 : ${Room.finalMoney }원<br>
예상시간 : ${Room.preTime }<br>
<a href="ChattingRoom">채팅방 입장</a><br>

<c:if test="${pay.okCash == null}">
결제 미완료<br>
<a href="pay?finalMoney=${Room.finalMoney }&roomId=${Room.roomId}">결제</a><br>

</c:if>
<c:if test="${pay.okCash == '1'}">
동승중<br>
<a href="payCancel?roomId=${Room.roomId }">결제 취소</a><br>
</c:if>

<c:if test="${pay.okCash == null}">
<a href="RoomOut?roomId=${Room.roomId }">방 나가기</a><br>
</c:if>

<a href="home">메인으로</a>
<c:if test="${member.passuser == 2}">
<br>
<a href="EndDriver?roomId=${Room.roomId}">운행완료 ^^7</a>
</c:if>
<!--  
<c:if test="${LoginMember.passuser == 2}">
<a href="DriverStart">기사용 시작하기</a><br><br>
<a href="DriverMyPage">마이페이지 기사용</a><br><br>
</c:if>
-->
</div>
</body>
</html>