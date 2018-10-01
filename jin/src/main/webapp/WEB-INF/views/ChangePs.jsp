<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 $(function(){
  $('#Password').keyup(function(){
   $('font[name=check]').text('');
  }); //#user_pass.keyup

  $('#Psrechange').keyup(function(){
   if($('#Password').val()!=$('#Psrechange').val()){
	   $('font[name=check1]').empty();
	   $('font[name=check]').text('');
    $('font[name=check]').html("암호가 일치하지 않습니다.");
   }else{
	$('font[name=check]').empty();
    $('font[name=check1]').text('');
    $('font[name=check1]').html("암호가 일치합니다.");
   }
  }); //#chpass.keyup
 });
</script>

<script type="text/javascript">
function PassWordCheck() {
		var Password = document.getElementById("Password").value; 
		var CheckPassword = document.getElementById("Psrechange").value; 
		console.log(Password);
		console.log(CheckPassword);
		if(Password != CheckPassword){
			alert("비밀번호를 다시 확인해주시기 바랍니다.");
			event.preventDefault();
		}else{
			alert("회원가입이 완료되었습니다.");
		}
		
}
	
	
</script>
</head>
<body>
<h1>비밀번호 변경</h1>
<form action="ChangePsPro" method="get" id=frm name=frm>
비밀번호 <input type="password" id="Password" name="Password">
<font name="check" size="2" color="red"></font> 
<font name="check1" size="2" color="blue"></font> 
비밀번호 재확인<input type="password" id="Psrechange" name="Psrechange">
<input type="hidden" name="Id" value="<% request.getParameter("hiddenId1");%>">
<input type="submit" value="다음" onclick="PassWordCheck()">
</form>
</body>
</html>