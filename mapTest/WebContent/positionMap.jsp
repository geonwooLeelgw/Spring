<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Google Map</title>

    <script src="http://maps.google.com/maps?file=api&v=2&hl=&key=AIzaSyCW2M9BGzxaIwHnXTpZNcNFlpvHrjyBWZg" type="text/javascript"></script>
	<!--AIzaSyCW2M9BGzxaIwHnXTpZNcNFlpvHrjyBWZg  -->
    <script type="text/javascript">
        function fnAdjust() {
            var latitude = document.googleMap.latitude.value;
            var longitude = document.googleMap.longitude.value;
            alert(latitude);
            alert(longitude);
        }
        function fnAdjust2() {
            var latitude = document.googleMap2.latitude.value;
            var longitude = document.googleMap2.longitude.value;
            alert(latitude);
            alert(longitude);
        }    
        function load() {  
            if (GBrowserIsCompatible()) {
                var map = new GMap2(document.getElementById("map"));
                map.addControl(new GOverviewMapControl());
                map.addControl(new GLargeMapControl());
                map.addControl(new GMapTypeControl());
                map.addControl(new GScaleControl());
                map.enableDoubleClickZoom();
                var center = new GLatLng(37.44802, 126.65750);
       
                map.setCenter(center, 15, G_HYBRID_MAP);
                geocoder = new GClientGeocoder();
                var marker = new GMarker(center, {
                    draggable: true
                }); 
                map.addOverlay(marker);
                document.getElementById("lat").value = center.lat().toFixed(5);
                document.getElementById("lng").value = center.lng().toFixed(5);    
                GEvent.addListener(marker, "dragend", function() {   
                    var point = marker.getPoint();  
                    map.panTo(point);   
                    document.getElementById("lat").value = point.lat().toFixed(5);   
                    document.getElementById("lng").value = point.lng().toFixed(5);  
                });     
                GEvent.addListener(map, "moveend", function() {  
                    map.clearOverlays();
                    var center = map.getCenter();  
                    var marker = new GMarker(center, {
                        draggable: true
                    });  
                    map.addOverlay(marker);  
                    document.getElementById("lat").value = center.lat().toFixed(5);   
                    document.getElementById("lng").value = center.lng().toFixed(5);     
                    GEvent.addListener(marker, "dragend", function() {  
                        var point = marker.getPoint(); 
                        map.panTo(point);  
                        document.getElementById("lat").value = point.lat().toFixed(5); 
                        document.getElementById("lng").value = point.lng().toFixed(5);  
                    });  
                });    
            }
        }     
        function showAddress(address) {   
            var map = new GMap2(document.getElementById("map"));   
            map.addControl(new GSmallMapControl());   
            map.addControl(new GMapTypeControl());   
            if (geocoder) {
                geocoder.getLatLng(  address,   function(point) {
                    if (!point) {  
                        alert(address + " not found");
                    } else {  
                        document.getElementById("lat").value = point.lat().toFixed(5);   
                        document.getElementById("lng").value = point.lng().toFixed(5); 
                        map.clearOverlays()
                        map.setCenter(point, 14);   
                        var marker = new GMarker(point, {
                            draggable: true
                        });  
                        map.addOverlay(marker);  
                        GEvent.addListener(marker, "dragend", function() {  
                            var pt = marker.getPoint(); 
                            map.panTo(pt);  
                            document.getElementById("lat").value = pt.lat().toFixed(5); 
                            document.getElementById("lng").value = pt.lng().toFixed(5);
                        });     
                        GEvent.addListener(map, "moveend", function() {  
                            map.clearOverlays();
                            var center = map.getCenter();  
                            var marker = new GMarker(center, {
                                draggable: true
                            });  
                            map.addOverlay(marker);  
                            document.getElementById("lat").value = center.lat().toFixed(5);   
                            document.getElementById("lng").value = center.lng().toFixed(5);   
                            GEvent.addListener(marker, "dragend", function() { 
                                var pt = marker.getPoint();
                                map.panTo(pt);
                                document.getElementById("lat").value = pt.lat().toFixed(5);   
                                document.getElementById("lng").value = pt.lng().toFixed(5);
                            });  
                        });  
                    }  
                });  
            }
        }
        function showAddress2(address) {   
            var map = new GMap2(document.getElementById("map"));   
            map.addControl(new GSmallMapControl());   
            map.addControl(new GMapTypeControl());   
            if (geocoder) {
                geocoder.getLatLng(  address,   function(point) {
                    if (!point) {  
                        alert(address + " not found");
                    } else {  
                        document.getElementById("lat").value = point.lat().toFixed(5);   
                        document.getElementById("lng").value = point.lng().toFixed(5); 
                        map.clearOverlays()
                        map.setCenter(point, 14);   
                        var marker = new GMarker(point, {
                            draggable: true
                        });  
                        map.addOverlay(marker);  
                        GEvent.addListener(marker, "dragend", function() {  
                            var pt = marker.getPoint(); 
                            map.panTo(pt);  
                            document.getElementById("lat").value = pt.lat().toFixed(5); 
                            document.getElementById("lng").value = pt.lng().toFixed(5);
                        });     
                        GEvent.addListener(map, "moveend", function() {  
                            map.clearOverlays();
                            var center = map.getCenter();  
                            var marker = new GMarker(center, {
                                draggable: true
                            });  
                            map.addOverlay(marker);  
                            document.getElementById("lat").value = center.lat().toFixed(5);   
                            document.getElementById("lng").value = center.lng().toFixed(5);   
                            GEvent.addListener(marker, "dragend", function() { 
                                var pt = marker.getPoint();
                                map.panTo(pt);
                                document.getElementById("lat").value = pt.lat().toFixed(5);   
                                document.getElementById("lng").value = pt.lng().toFixed(5);
                            });  
                        });  
                    }  
                });  
            }
        }
    </script>
    </head>

<body onload="load()" onunload="GUnload()">
    <div style="padding:15px 45px 10px 45px;">
        <div id="map" style="width:600px; height: 500px" style="display:block;"></div>
    </div>

    <div style="padding:5px 45px 10px 85px;">
        <form name="googleMap" action="#" onsubmit="showAddress(this.address.value); return false">
        
            <table width="650">
            
                <tr>
                    <td colspan="5">
                        <input type="text" size="70" name="address" value="" />
                        <input type="submit" class="btn" value="Address Search" />
                    </td>
                    </tr>
            
                <tr height="10">
                    <td colspan="5"></td>
                    </tr>
            
                <tr>
                    <td width="117"><b>Latitude</b></td>
                    <td width="117">
                        <input id="lat" type="text" size="12" name="latitude" value="" />
                    </td>
                    <td width="117"><b>Longitude</b></td>
                    <td width="117">
                        <input id="lng" type="text" size="12" name="longitude" value="" />
                    </td>
                    <td width="182">
                        <input type="button" class="btn" value="Adjust" onclick="fnAdjust()" />
                    </td>
                    </tr>
            </table>
        </form>
    </div>
    
  
    </body>

</html>
