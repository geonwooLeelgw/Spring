<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function LicenseUpload() {
		alert("���̼��� ����� �Ϸ�Ǿ����ϴ�<br> �������� ������ �Ϸ�Ǹ� ������ �����մϴ�.");
		document.getElementById('frm').submit();
	}
</script>	
</head>
<body>
<H1>License.jsp�Դϴ�.</H1>
<h2>���̼��� �ڰݵ���ϱ�</h2>
<h3>�ýÿ����ڰ��� �̹����� ÷�����ֽñ� �ٶ��ϴ�.</h3>
<form action="LicenseUpload" method="post" enctype="multipart/form-data" id="frm">
�������:<input type="file" name="file" id="file">
<input type="hidden" name="Id" value="<%=session.getAttribute("id") %>">
<input type="submit" value="Ȯ��" onclick="LicenseUpload()">
</form>
</body>
</html>