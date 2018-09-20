<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>결제 페이지</h2>
<form action="" method="post">
예상 금액:${finalMoney }<br>
<input type="hidden" value="${finalMoney}" name="finalMoney">
보유포인트:${member.point}<br>
<input type="hidden" value="${member.point}" name="Point">
<a href="AddPoint">포인트 충전</a><br><br>
<input type="submit" value="결제하기">
</form>
</body>
</html>