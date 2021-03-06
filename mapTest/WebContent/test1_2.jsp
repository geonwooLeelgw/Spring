<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>길찾기</title>
<style type="text/css">
html,body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map-canvas,#map_canvas {
	height: 100%;
}

@media print {
	html,body {
		height: auto;
	}
	#map_canvas {
		height: 650px;
	}
}

#panel {
	position: absolute;
	top: 5px;
	left: 50%;
	margin-left: -180px;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var map;

	function initialize() {
		directionsDisplay = new google.maps.DirectionsRenderer();
		var korea = new google.maps.LatLng(37.493258, 127.03149);
		var mapOptions = {
			zoom : 7,
			mapTypeId : google.maps.MapTypeId.ROADMAP,
			center : korea
		}
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		directionsDisplay.setMap(map);
	}
		function calcRoute() {
			var start = document.getElementById('start').value;
			var end = document.getElementById('end').value;
			var mode = document.getElementById('mode').value;

			var request = {
				origin : start,
				destination : end,
				travelMode : eval("google.maps.DirectionsTravelMode." + mode)
			};
			directionsService.route(request, function(response, status) {
				alert(status); // 확인용 Alert..미사용시 삭제
				if (status == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(response);
				}
			});
		}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="panel">
		<b>출발: </b> 
		<input type="text" id="start" /></br> 
		<b>도착: </b>
		<input type="text" id="end" />
		<div>
			<strong>교통수단: </strong> <select id="mode">
				<option value="DRIVING">자동차</option>
				<option value="WALKING">도보</option>
				<option value="BICYCLING">자전거</option>
				<option value="TRANSIT">지하철</option>
			</select> <input type="button" value="길찾기" onclick="Javascript:calcRoute();" />
		</div>
	</div>
	<div id="map-canvas"></div>
</body>
</html>