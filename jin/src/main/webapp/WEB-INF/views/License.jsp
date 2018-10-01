<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function LicenseUpload() {
		alert("라이센스 등록이 완료되었습니다<br> 관리자의 승인이 완료되면 정상사용 가능합니다.");
		document.getElementById('frm').submit();
	}
</script>	
</head>
<body>
<H1>License.jsp입니다.</H1>
<h2>라이센스 자격등록하기</h2>
<h3>택시운전자격증 이미지를 첨부해주시기 바랍니다.</h3>
<form action="LicenseUpload" method="post" enctype="multipart/form-data" id="frm">
사진등록:<input type="file" name="file" id="file">
<input type="hidden" name="Id" value="<%=session.getAttribute("id") %>">
<input type="submit" value="확인" onclick="LicenseUpload()">
</form>
</body>
</html>