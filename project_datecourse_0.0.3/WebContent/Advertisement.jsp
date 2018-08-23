<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>

function setCookie(name, value, expiredays){

var todayDate = new Date();

todayDate.setDate(todayDate.getDate() + expiredays);

document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"

}



function closePop(){

setCookie("close20150406","close20150406",1);

window.close();

}

</script>






</head>

<body>

<h2 style="text-align: center;">광고 팝업</h2>

<img src="${AB. advertisement_num}.jpg" style="width: 390px; height: 200px;">

<hr>
업체명 : ${AB.company_name }
<br/>
업체 번호 : ${AB.company_tel }
<br/>
업체 주소 : ${AB.company_address }	
<br>

<input type="checkbox" onClick="closePop();">오늘 하루 동안 열지 않음













</body>

</html>


