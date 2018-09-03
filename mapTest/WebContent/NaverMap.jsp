<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>지도</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=qDFggXUvO47lb6Uumpr9&submodules=geocoder"></script>
</head>
<body>
<div id="map" style="width:100%;height:800px;"></div>

<script>
/* //맵 불러오기
var mapOptions = {
    center: new naver.maps.LatLng(37.3595704, 127.105399),
    zoom: 10
};

var map = new naver.maps.Map('map', mapOptions);

//맵 스타일 (+,-)
 var mapOptions = {
        zoomControl: true,
        zoomControlOptions: {
            style: naver.maps.ZoomControlStyle.SMALL,
            position: naver.maps.Position.TOP_RIGHT
        }
    };

    var map = new naver.maps.Map(document.getElementById('map'), mapOptions);
    
//마커 찍기
var position = new naver.maps.LatLng(37.3595704, 127.105399);

var map = new naver.maps.Map('map', {
    center: position,
    zoom: 10
});

var marker = new naver.maps.Marker({
    position: position,
    map: map
});

naver.maps.Event.addListener(map, 'click', function(e) {
    marker.setPosition(e.coord);
});
//서울, 부산, 제주도 , 독도로 이동하기
var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.5666805, 126.9784147),
    zoom: 4
});

var jeju = new naver.maps.LatLng(33.3590628, 126.534361),
    busan = new naver.maps.LatLng(35.1797865, 129.0750194),
    dokdo = new naver.maps.LatLngBounds(
                new naver.maps.LatLng(37.2380651, 131.8562652),
                new naver.maps.LatLng(37.2444436, 131.8786475)),
    seoul = new naver.maps.LatLngBounds(
                new naver.maps.LatLng(37.42829747263545, 126.76620435615891),
                new naver.maps.LatLng(37.7010174173061, 127.18379493229875));

$("#to-jeju").on("click", function(e) {
    e.preventDefault();

    map.setCenter(jeju);
});

$("#to-1").on("click", function(e) {
    e.preventDefault();

    map.setZoom(1, true);
});

$("#to-dokdo").on("click", function(e) {
    e.preventDefault();

    map.fitBounds(dokdo);
});

$("#to-busan").on("click", function(e) {
    e.preventDefault();

    map.panTo(busan);
});

$("#to-seoul").on("click", function(e) {
    e.preventDefault();

    map.panToBounds(seoul);
});

$("#panBy").on("click", function(e) {
    e.preventDefault();

    map.panBy(new naver.maps.Point(10, 10));
});
 */
// 좌표 검색하기
var map = new naver.maps.Map("map", {
    center: new naver.maps.LatLng(37.3595316, 127.1052133),
    zoom: 10,
    mapTypeControl: true
});

var infoWindow = new naver.maps.InfoWindow({
    anchorSkew: true
});

map.setCursor('pointer');

// search by tm128 coordinate
function searchCoordinateToAddress(latlng) {
    var tm128 = naver.maps.TransCoord.fromLatLngToTM128(latlng);

    infoWindow.close();

    naver.maps.Service.reverseGeocode({
        location: tm128,
        coordType: naver.maps.Service.CoordType.TM128
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }

        var items = response.result.items,
            htmlAddresses = [];

        for (var i=0, ii=items.length, item, addrType; i<ii; i++) {
            item = items[i];
            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]';

            htmlAddresses.push((i+1) +'. '+ addrType +' '+ item.address);
        }

        infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 좌표</h4><br />',
                htmlAddresses.join('<br />'),
                '</div>'
            ].join('\n'));

        infoWindow.open(map, latlng);
    });
}

// result by latlng coordinate
function searchAddressToCoordinate(address) {
    naver.maps.Service.geocode({
        address: address
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }

        var item = response.result.items[0],
            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]',
            point = new naver.maps.Point(item.point.x, item.point.y);

        infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 주소 : '+ response.result.userquery +'</h4><br />',
                addrType +' '+ item.address +'<br />',
                '</div>'
            ].join('\n'));


        map.setCenter(point);
        infoWindow.open(map, point);
    });
}

function initGeocoder() {
    map.addListener('click', function(e) {
        searchCoordinateToAddress(e.coord);
    });

    $('#address').on('keydown', function(e) {
        var keyCode = e.which;

        if (keyCode === 13) { // Enter Key
            searchAddressToCoordinate($('#address').val());
        }
    });

    $('#submit').on('click', function(e) {
        e.preventDefault();

        searchAddressToCoordinate($('#address').val());
    });

    searchAddressToCoordinate('정자동 178-1');
}

naver.maps.onJSContentLoaded = initGeocoder;

//구글맵
/* var directionsDisplay;
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
 */
 
 //마커 연결하기
 /* var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.3700065, 127.121359),
    zoom: 9
});

var polyline = new naver.maps.Polyline({
    map: map,
    path: [],
    strokeColor: '#5347AA',
    strokeWeight: 2
});

naver.maps.Event.addListener(map, 'click', function(e) {

    var point = e.coord;

    var path = polyline.getPath();
    path.push(point);

    new naver.maps.Marker({
        map: map,
        position: point
    });
}); */
</script>

<!-- <style type="text/css">
.search { position:absolute;z-index:1000;top:20px;left:20px; }
.search #address { width:150px;height:20px;line-height:20px;border:solid 1px #555;padding:5px;font-size:12px;box-sizing:content-box; }
.search #submit { height:30px;line-height:30px;padding:0 10px;font-size:12px;border:solid 1px #555;border-radius:3px;cursor:pointer;box-sizing:content-box; }
</style> -->

<div id="wrap" class="section">
    <div id="map" style="width:100%;height:600px;">
        <div class="search" style="">
            <input id="address" type="text" placeholder="검색할 주소" value="불정로 6" />
            <input id="submit" type="button" value="주소 검색" />
        </div>
    </div>
    <code id="snippet" class="snippet"></code>
</div>

</body>
</html>