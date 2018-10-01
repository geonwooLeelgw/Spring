
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="ImageToolbar" content="no" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<meta name="Description" content="도로명주소 우편번호 API, Xeno Zip Finder">
<meta property="og:title" content="도로명주소 API">
<meta property="og:description" content="도로명주소(우편번호) 검색을 위한 무료 API 입니다.">
<title>도로명주소 검색 API :: Xeno Zip Finder</title>
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/jejuhallasan.css">
<style>
.banner {
	font-family: 'Jeju Hallasan', serif;
	font-size:30px;
	color:#333;
	text-decoration:none;
}
.banner span {
	color:#c00;
}
.addr {
	width: 350px;
}
xmp {
	font-family: 나눔고딕코딩, 궁서체, monospace;
	background: #eeeeee;
	color: black;
	font-size: 12px;
	overflow:scroll;
}
.notice {
	background:#eeffee;
	font-size: 14px;
}
.intro {
	background:#eeffff;
	font-size: 14px;
}

.license {
	background:#eeeeff;
	font-size: 14px;
}
strong {
	font-size:16px;
	color:#003399;
}
.ovscroll {
	width:90%;
	height:600px;
	overflow:scroll;
}
.line {
	width:99%;
	border-collapse:collapse;
	border:1px solid black;
	table-layout:fixed;
}
.line td, .line th {
	border:1px solid black;
	padding:5px;
}
.line p, .line a {
	margin:3px;
	padding:0;
}

.donated {
	font-size:14px;
	font-weight:bold;
	color:white;
	background:blue;
	display:inline-block;
	padding:4px 8px;
	border-radius:5px;
	margin-left:20px;
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-migrate/1.2.1/jquery-migrate.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.min.css" />
<script src="//xenosi.de/load/jquery/jquery.placeholder.min.js"></script>

<link rel="stylesheet" href="//xenosi.de/load/roadzip/roadzip.css" />
<script src="//xenosi.de/load/roadzip/roadzip.min.js"></script>

<link rel="stylesheet" href="//xenosi.de/load/select2/select2.css" />
<script src="//xenosi.de/load/select2/select2.min.js"></script>
<script src="//xenosi.de/load/roadzip/roadzip.mobile.min.js"></script>

<script>
function zipCallback(row) {
	console.log(row);
}

$(function() {
	$('input.XenoFindZip').each(XenoZipFinder);
	
	$('input.XenoFindZipMobile').each(XenoZipFinderMobile);
});
</script>
</head>
<body>
<form>
	<p>jQuery UI 예제</p>
	<label>
		<input type="text" placeholder="주소를 검색하세요." class="XenoFindZip" data-callback="zipCallback">
		<span class="XenoFindZipLabel"></span>
	</label>
	<p>select2 (모바일 대응) 예제</p>
	<label>
		<p class="XenoFindZipLabel"></p>
		<input type="search" placeholder="주소를 검색하세요." class="XenoFindZipMobile" data-callback="zipCallback">
	</label>
	<hr>
	<table>
	<tbody>
	<tr>
	<td>우편번호 /* 9월 초 에 기초구역번호 정보로 대체됩니다. */</td>
	<td><input type="text" name="zipcode"></td>
	</tr>
	<tr>
	<td>주소</td>
	<td><input type="text" class="addr" name="addr"></td>
	</tr>
	<tr>
	<td>상세주소</td>
	<td><input type="text" class="addr" name="addr_remain"></td>
	</tr>
	<tr>
	<td>영문주소</td>
	<td><input type="text" class="addr" name="addr_en"></td>
	</tr>
	<tr>
	<td>영문상세주소</td>
	<td><input type="text" class="addr" name="addr_remain_en"></td>
	</tr>
	<tr>
	<td>기초구역번호</td>
	<td><input type="text" name="regionno"></td>
	</tr>
	</tbody>
	</table>
</form>
</script>
</body>
</html>