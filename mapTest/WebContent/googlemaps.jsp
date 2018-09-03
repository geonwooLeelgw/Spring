<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <%@ page import="bean.Informationbean" %>
    <%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>	googlemap v3 </title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&key=AIzaSyCpHG4TQGThig4a3UwY8U4PdZvVdpRwFGM"></script>




<style type="text/css">
.wrap { position:relative; height; /*감싸는 레이어에 포지션 속성을 잡아주는 게 필수!(relative, absolute, fixed 중 택1*/
background:; text-align:center; line-height:0px; margin:0 auto; 
 color:#000; font-size:12px; }
.over { position:absolute; bottom:0px;/*위에 올라가는 레이어의 포지션은 top, bottom 둘 중 하나
, left, right 둘 중 하나의 속성을 선택하여 잡아준다.*/ 



;}
</style>


</head>


<SCRIPT LANGUAGE="JavaScript">


var contentArray = [];
var iConArray = [];
var markers = [];
var iterator = 0;
var markerArray = [];
var map;
 
<% ArrayList<Informationbean> infoResult = 

	(ArrayList<Informationbean>)request.getAttribute("InfoResult"); %>
	
	<% System.out.println("사이즈 테스트2 :"+infoResult.size()); %>

	var Result = new Array();
	
	<% for(int i=0; i<infoResult.size(); i++){ %>
	
	var obj = {"location":"<%=infoResult.get(i).getJOB_LOCATION()%>"
	, "location1":"<%=infoResult.get(i).getJOB_LOCATION1()%>"
	, "company_information":"<%=infoResult.get(i).getCOMPANY_INFORMATION()%>"
	, "job_family":"<%=infoResult.get(i).getJOB_FAMILY()%>"
	, "job_gestalt":"<%=infoResult.get(i).getJOB_GESTALT()%>"
	, "job_period":"<%=infoResult.get(i).getJOB_PERIOD()%>"
	, "job_day":"<%=infoResult.get(i).getJOB_DAY()%>"
	, "job_time":"<%=infoResult.get(i).getJOB_TIME()%>"
	, "job_money":"<%=infoResult.get(i).getJOB_MONEY()%>"
	, "job_kindofpay":"<%=infoResult.get(i).getJOB_KINDOFPAY()%>"};
	Result.push(obj);
	
	<% } %>
	
	console.log("이상있는가?"+Result)
 
	for(var i = 0; i<Result.length; i++){
 
// infowindow contents 배열

 contentArray[i] ='<form action="dday.bo" method="post" name = "conditionform">'+
	 '<h2>'+Result[i].company_information+'</h2>'+
 					'<p>'+"   업무형태:   "+Result[i].job_family+'</p>'+
 					'<p>'+"   고용형태:   "+Result[i].job_gestalt+'</p>'+
 					'<p>'+"   고용기간:   "+Result[i].job_period+'</p>'+
 					'<p>'+"   근무요일:   "+Result[i].job_day+'</p>'+
 					'<p>'+"   근무시간:   "+Result[i].job_time+'</p>'+
 					'<p>'+"   급여:   "	+Result[i].job_kindofpay
 					+"  "+Result[i].job_money+'</p>'
 					+'<body>'+'<input type="button" name="dday" value="알바가즈아">'+'</body>'
					+'</form>'
 					
 					
 					
 					// marker icon 배열

 iConArray[i] = "http://maps.google.com/mapfiles/ms/micons/red-dot.png";

 
// 위경도 배열

	markerArray[i] = new google.maps.LatLng(Result[i].location,Result[i].location1);

	}
function initialize() {
    var mapOptions = {
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: new google.maps.LatLng(37.438622, 126.675389)
    };
 
    map = new google.maps.Map(document.getElementById('map'),mapOptions);
 
    for (var i = 0; i < markerArray.length; i++) {
        addMarker();
    }
}
 
 
// 마커 추가
function addMarker() {
 
    var marker = new google.maps.Marker({
        position: markerArray[iterator],
        map: map,
        draggable: false,
        icon: iConArray[iterator]
    });
    markers.push(marker);
 
    var infowindow = new google.maps.InfoWindow({
      content: contentArray[iterator]
    });
 
    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map,marker);
    });
    iterator++;
}
 
google.maps.event.addDomListener(window, 'load', initialize);
//-->
</SCRIPT>
<body>

<div class="wrap">
<div id="map" style="width:2100px;height:1050px;margin-top:20px;position:relative;"></div>


 <div class="over">
<div style="position: relative; height:1050px; width:300px; top: 0px; background-color:white;">

 <form action="condition.bo" method="post" name = "conditionform">
<div style="position: relative; height:50px; width:300px;  line-height:10px;  display: block;
 background-color:white; border-bottom:2px solid #BDBDBD;border-top:2px solid #BDBDBD; text-align:center;font-size: 15px;"><h2>지역</h2>

 <br><input type="checkbox" id="JUAN" name="village"
               value="주안동"/>주안동<br>
               
<br><input type="checkbox" id="HAGIK1" name="village"
               value="학익1동"/>학익1동<br>
               
 <br><input type="checkbox" id="HAGIK2" name="village"
               value="학익2동"/>학익2동<br>
               
 <br><input type="checkbox" id="HAGIK" name="village"
               value="학익동"/>학익동<br> 	          	   
            
   </div> 
          
 <div style="position: relative; height:50px; width:300px; top:120px; line-height:10px;  display: block;
 background-color:white; border-bottom:2px solid #BDBDBD;border-top:2px solid #BDBDBD; text-align:center;font-size: 15px;"><h2>근무기간</h2>
<br><br>  
  <br><input type="checkbox" id="month1" name="calendar"
               value="1개월이상"/>1개월이상~3개월미만<br><br><br>
               
 <input type="checkbox" id="month3" name="calendar"
               value="3개월이상"/>3개월이상~6개월미만<br><br><br>
               
 <input type="checkbox" id="month6" name="calendar"
               value="6개월이상"/>6개월이상~1년미만<br><br><br>
               
 <input type="checkbox" id="year1" name="calendar"
               value="1년이상"/>1년이상<br><br> <br>   
               
  
  <div style="position: relative; height:50px; width:300px; top:20px; line-height:10px;  display: block;
 background-color:white; border-bottom:2px solid #BDBDBD;border-top:2px solid #BDBDBD; text-align:center;font-size: 15px;"><h2>근무요일</h2>
 <br><br><input type="checkbox" id="monsun" name="dayofweek"
               value="월~일"/>월요일  ~ 일요일 <br><br>
               
 <input type="checkbox" id="monsat" name="dayofweek"
               value="월~토"/>월요일 ~ 토요일  <br><br>
               
 <input type="checkbox" id="monfri" name="dayofweek"
               value="월~금"/>월요일 ~ 금요일<br><br>
                  
  <input type="checkbox" id="week" name="dayofweek"
               value="주말"/>주말<br><br>
 
    
<div style="position: relative; height:330px; width:300px; top:50px; line-height:30px;  display: block;
 background-color:white; border-bottom:2px solid #BDBDBD;border-top:2px solid #BDBDBD; text-align:center;font-size: 15px;">


<div style="position: relative; height:70px; width:300px; top:0px; line-height:30px;  display: block;
 background-color:white; border-bottom:2px solid #BDBDBD;border-top:2px solid #BDBDBD; text-align:center;font-size: 15px;"><h2>근무시간</h2>

<br><input type="checkbox" id="morning" name="day"
               value="오전"/>오전<br><br>
               
  <input type="checkbox" id="afternoon" name="day"
               value="오후"/>오후<br><br>
    
    <input type="checkbox" id="evening" name="day"
               value="저녁"/>저녁<br><br>  
               
 <input type="checkbox" id="night" name="day"
               value="야간"/>야간<br><br>     
</form> 
<input type="submit" name="connect">검색
	
 </div>
</div>

</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>
