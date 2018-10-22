<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>

<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
var count = parseInt(3);
function findcode() {
	var random = $('#randomId').val();
	var code = $('#code').val();
 	if(code == random) {
 		alert("인증번호 확인이 완료되었습니다.");
		document.getElementById('frm').submit();
 	}else{
 		alert("인증번호가 다릅니다.")
 		event.preventDefault();
 		count--;
 	}
 	if(count == 0){
 		alert("인증번호 3번 틀리셨습니다. 다시 진행하시기 바랍니다.");
 		location.href="views/Findps.jsp";
 	}
}
</script>
</head>
<body>
등록된 핸드폰 번호로 인증코드를 전송했습니다. 인증코드를 입력해주세요.
<form action="CodeSuccess" method="get" id=frm name=frm >
<input type="text" name="code1" id="code">
<input type="hidden" name="hiddenId1" id="hiddenId" value="${id}">
<input type="hidden" name="randomId1" id="randomId" value="${random}">
<input type="button" value="확인" onclick="findcode()">
</form>
</body>
</html>