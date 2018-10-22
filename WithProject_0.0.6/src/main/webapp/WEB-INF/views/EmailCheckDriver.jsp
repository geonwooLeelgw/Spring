<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript">
var count;
count =3;
zerocount = 0;
function EmailCheck() {
	var CheckEmail = document.getElementById("Check").value; 
	var CheckEmail1 = <%=session.getAttribute("random")%>
	if(count==zerocount){
		alert("인증이 3회 틀렸습니다. 다시 확인해주시기 바랍니다.")
		history.back(-3);
	}
	else if(CheckEmail != CheckEmail1){
		count = count-1;
		alert("인증번호가 다릅니다.");
		event.preventDefault();
	}
	if(CheckEmail == CheckEmail1){
		alert("회원가입이 완료되었습니다.");
		document.getElementById('frm').submit();
	}
	
}
</script>
</head>
<body>

<h1>MailCheckView.jsp입니다.</h1>
<h2>입력하신 메일로 인증번호를 전송했습니다. 인증번호를 입력해주세요.</h2>
<form action="DriverJoinPro" method="get" id="frm">
<input type="hidden" name="Id" value="<%=request.getParameter("Id")%>">
<input type="hidden" name="Password" value="<%=request.getParameter("Password")%>">
<input type="hidden" name="Name" value="<%=request.getParameter("Name")%>">
<input type="hidden" name="Gender" value="<%=request.getParameter("Gender")%>">
<input type="hidden" name="Email" value="<%=request.getParameter("Email")%>">
<input type="hidden" name="Tel" value="<%=request.getParameter("Tel")%>">
<input type="hidden" name="Address" value="<%=request.getParameter("Address")%>">
인증번호 입력 : <input type="text" name="Check" id="Check">
<%=session.getAttribute("random")%>
</form>
<input type="submit" value="확인" onclick="EmailCheck()">

</body>
</html>