<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- ajax를 이용한 아이디 중복확인 기능 -->
<!-- Asynchronous Javascript and XML -->

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

/* JSON() JavaScript Object Notation */
 
function idOverlap() {
		$.ajax({
			type : "post",
			url : "idOverlap", //서버로 간다능 (컨트롤러)
			data : {"id" : frm.Id.value},
			dataType : "text", //retrun Type
			success : function(data){
				if(data=="1"){
					alert("이 아이디는 사용 가능합니다.");
				}else {
					alert("이 아이디는 사용 할 수 없습니다.");
				}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
		});
	}
</script>
<script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 $(function(){
  $('#Password').keyup(function(){
   $('font[name=check]').text('');
  }); //#user_pass.keyup

  $('#CheckPassword').keyup(function(){
   if($('#Password').val()!=$('#CheckPassword').val()){
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
		var CheckPassword = document.getElementById("CheckPassword").value; 
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
<h2>UserJoin.jsp</h2>
<form action="EmailCheck" method="get" id=frm>
아이디 : <input type="text" name="Id" required autofocus> <input type="button" onclick="idOverlap()" value="중복확인"><br>
비밀번호 : <input type="password" name="Password" id="Password" required autofocus><br>
비밀번호 재확인: <input type="password" name="CheckPassword" id="CheckPassword" required autofocus><br>
<font name="check" size="2" color="red"></font> 
<font name="check1" size="2" color="blue"></font> 
이름 : <input type="text" name="Name" required autofocus><br>
성별 : <input type="radio" name="Gender" value="men" required autofocus>남자
	<input type="radio" name="Gender" value="women" required autofocus>여자<br>
본인확인용 이메일 : <input type="text" name="Email" required autofocus><br>
전화번호 : <input type="text" name="Tel" required autofocus><br>
주소 : <input type="text" name="Address" required autofocus><br>
<input type="submit" value="가입" onclick="PassWordCheck()">
</form>
</body>
</html>