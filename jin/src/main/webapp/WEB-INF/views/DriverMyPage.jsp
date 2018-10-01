<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

/* JSON() JavaScript Object Notation */
 
function Check() {
		$.ajax({
			type : "post",
			url : "DriverCheck", //서버로 간다능 (컨트롤러)
			data : {"id" : frm.Id.value},
			dataType : "text", //retrun Type
			success : function(data){
				if(data=="1"){
					alert("기사 승인이 허락되지 않은 아이디입니다.");
					event.preventDefault();
				}else{		
				}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				console.log(error);
				}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
<h3>DriverMyPage.jsp</h3>
<h3><%=session.getAttribute("id") %>님의 MyPage</h3>
<a href="PasswordForm">상세보기 및 개인정보 수정</a><br><br> <!-- 비밀번호 치고 들어가기 -->
<form action="check" method="get" id=frm>
<input type="hidden" name="Id" value="<%=session.getAttribute("id") %>">
<a onclick="Check()" name="check" href="RideTogetherList">현재 동승을 원하는 방 목록보기</a><br><br>
</form>
<!-- 곧 운행할 예정이라면 현재 입장중인 방페이지로가고 운행예정이없으면 얼럿창 -->
<a href="OperationSchedule">운행예정</a><br><br>
<a href="RideRecord">운행기록</a><br><br>
<a href="home">메인으로</a>
</body>
</html>