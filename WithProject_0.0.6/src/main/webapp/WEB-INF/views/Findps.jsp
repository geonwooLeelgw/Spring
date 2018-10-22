
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
function findPs() {
		$.ajax({
			type : "post",
			url : "SelectFindPs", //서버로 간다능 (컨트롤러)
			data : {"Id" : frm.Id.value},
			dataType : "text", //retrun Type
			success : function(data){
				if(data=="1"){
					alert("인증번호를 전송하였습니다.");
					document.getElementById('frm').submit();
				}else {
					alert("등록된 정보가 없습니다.");
					event.preventDefault();
				}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
<form action="FindPsPro" method="get" id=frm name=frm >
아이디 : <input type="text" name="Id" required autofocus><br>
<input type="button" value="다음" onclick="findPs()">
</form>
</body>
</html>