
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
function findid() {
	<% System.out.println("테스트 sex"); %>
		$.ajax({
			type : "post",
			url : "SelectFindId", //서버로 간다능 (컨트롤러)
			data : {"Name" : frm.Name.value,
					"Email" : frm.Email.value},
			dataType : "text", //retrun Type
			success : function(data){
				if(data=="1"){
					alert("인증번호를 전송하였습니다.");
					document.getElementById('frm').submit();
				}else {
					alert("이메일 주소를 다시 확인해주시기 바랍니다.");
					event.preventDefault();
				}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
		});
	}

</script>
<head>
</head>
<body>


<form action="FindIdPro" method="get" id=frm name=frm >
이름 : <input type="text" name="Name" required autofocus><br>
이메일 : <input type="text" name="Email" required autofocus><br>
<input type="button" value="인증번호 받기" onclick="findid()">
</form>
</body>
</html>