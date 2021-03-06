<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SRC2/popupca/style.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="/SRC2/popupca/calendar.js"></script>
</head>
<style>
.picker-container {
position: absolute;
z-index: 99;

}


.cal {
background-color: white;
display: block;
width: 216px;
-webkit-box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.4);
box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.4);
border-collapse: collapse;
border-spacing: 0;
}

.cal a {
text-decoration: none;
}

.cal tr, .cal th, .cal td {
margin: 0;
padding: 0;
border: 0;
font-size: 100%;
font: inherit;
vertical-align: baseline;
}

.cal caption {
line-height: 32px;
font-weight: bold;
color: #e2e2e2;
text-align: center;
text-shadow: 0 -1px black;
background: #333;
//background: rgba(0, 0, 0, 0.35);
border-top: 1px solid #333;
border-bottom: 1px solid #313131;
-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.04);
box-shadow: inset 0 1px rgba(255, 255, 255, 0.04);
}
.cal caption a {
display: block;
line-height: 32px;
padding: 0 10px;
font-size: 15px;
color: #e2e2e2;
}
.cal caption a:hover {
color: white;
}
.cal caption .prev {
float: left;
}
.cal caption .next {
float: right;
}
.cal th, .cal td {
width: 30px;
text-align: center;
text-shadow: 0 1px rgba(255, 255, 255, 0.8);
font-family:'malgun gothic';
}
.cal th:first-child, .cal td:first-child {
border-left: 0;
}
.cal th {
line-height: 20px;
font-size: 11px;
color: #696969;
text-transform: uppercase;
background: #f3f3f3;
border-left: 1px solid #f3f3f3;
}
.cal td {
font-size: 11px;
font-weight: bold;
border-top: 1px solid #c2c2c2;
border-left: 1px solid #c2c2c2;
}
.cal td a {
clear: both;
display: block;
position: relative;
width: 30px;
line-height: 28px;
color: #666;
background-image: -webkit-linear-gradient(top, #eaeaea, #e5e5e5 60%, #d9d9d9);
background-image: -moz-linear-gradient(top, #eaeaea, #e5e5e5 60%, #d9d9d9);
background-image: -o-linear-gradient(top, #eaeaea, #e5e5e5 60%, #d9d9d9);
background-image: linear-gradient(to bottom, #eaeaea, #e5e5e5 60%, #d9d9d9);
-webkit-box-shadow: inset 1px 1px rgba(255, 255, 255, 0.5);
box-shadow: inset 1px 1px rgba(255, 255, 255, 0.5);
}
.cal td a:hover, .cal td.off a {
background: #f3f3f3;
}
.cal td.off a {
color: #b3b3b3;
}
.cal td.active a, .cal td a:active {
margin: -1px;
color: #f3f3f3;
text-shadow: 0 1px rgba(0, 0, 0, 0.3);
background: #6dafbf;
border: 1px solid #598b94;
-webkit-box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.05);
box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.05);
}
.cal td.active:first-child a, .cal td:first-child a:active {
border-left: 0;
margin-left: 0;
}
.cal td.active:last-child a, .cal td:last-child a:active {
border-right: 0;
margin-right: 0;
}
.cal tr:last-child td.active a, .cal tr:last-child td a:active {
border-bottom: 0;
margin-bottom: 0;
}

</style>
<script type="text/javascript">

(function ($) {
	/* "YYYY-MM[-DD]" => Date */
	function strToDate(str) {
		try {
			var array = str.split('-');
			var year = parseInt(array[0]);
			var month = parseInt(array[1]);
			var day = array.length > 2? parseInt(array[2]): 1 ;
			if (year > 0 && month >= 0) {
				return new Date(year, month - 1, day);
			} else {
				return null;
			}
		} catch (err) {}; // just throw any illegal format
	};

	/* Date => "YYYY-MM-DD" */
	function dateToStr(d) {
		/* fix month zero base */
		var year = d.getFullYear();
		var month = d.getMonth();
		return year + "-" + (month + 1) + "-" + d.getDate();
	};

	$.fn.calendar = function (options) {
		var _this = this;
		var opts = $.extend({}, $.fn.calendar.defaults, options);
		var week = ['일', '월', '화', '수', '목', '금', '토'];
		var tHead = week.map(function (day) {
			return "<th>" + day + "</th>";
		}).join("");

		_this.init = function () {
			var tpl = '<table class="cal">' +
			'<caption>' +
			'	<span class="prev"><a href="javascript:void(0);">&larr;</a></span>' +
			'	<span class="next"><a href="javascript:void(0);">&rarr;</a></span>' +
			'	<span class="month"><span>' +
			"</caption>" +
			"<thead><tr>" +
			tHead +
			"</tr></thead>" +
			"<tbody>" +
			"</tbody>" + "</table>";
			var html = $(tpl);
			_this.append(html);
		};

		function daysInMonth(d) {
			var newDate = new Date(d);
			newDate.setMonth(newDate.getMonth() + 1);
			newDate.setDate(0);
			return newDate.getDate();
		}

		_this.update = function (date) {
			var mDate = new Date(date);
			mDate.setDate(1); /* start of the month */
			var day = mDate.getDay(); /* value 0~6: 0 -- Sunday, 6 -- Saturday */
			mDate.setDate(mDate.getDate() - day) /* now mDate is the start day of the table */

			function dateToTag(d) {
				var tag = $('<td><a href="javascript:void(0);"></a></td>');
				var a = tag.find('a');
				a.text(d.getDate());
				a.data('date', dateToStr(d));
				if (date.getMonth() != d.getMonth()) { // the bounday month
					tag.addClass('off');
				} else if (_this.data('date') == a.data('date')) { // the select day
					tag.addClass('active');
					_this.data('date', dateToStr(d));
				}
				return tag;
			};

			var tBody = _this.find('tbody');
			tBody.empty(); /* clear previous first */
			var cols = Math.ceil((day + daysInMonth(date))/7);
			for (var i = 0; i < cols; i++) {
				var tr = $('<tr></tr>');
				for (var j = 0; j < 7; j++, mDate.setDate(mDate.getDate() + 1)) {
					tr.append(dateToTag(mDate));
				}
				tBody.append(tr);
			}

			/* set month head */
			var monthStr = dateToStr(date).replace(/-\d+$/, '');
			_this.find('.month').text(monthStr)
		};

		_this.getCurrentDate = function () {
			return _this.data('date');
		}

		_this.init();
		/* in date picker mode, and input date is empty,
		 * should not update 'data-date' field (no selected).
		 */
		var initDate = opts.date? opts.date: new Date();
		if (opts.date || !opts.picker) {
			_this.data('date', dateToStr(initDate));
		}
		_this.update(initDate);

		/* event binding */
		_this.delegate('tbody td', 'click', function () {
			var $this = $(this);
			_this.find('.active').removeClass('active');
			$this.addClass('active');
			_this.data('date', $this.find('a').data('date'));
			/* if the 'off' tag become selected, switch to that month */
			if ($this.hasClass('off')) {
				_this.update(strToDate(_this.data('date')));
			}
			if (opts.picker) {  /* in picker mode, when date selected, panel hide */
				_this.hide();
			}
		});

		function updateTable(monthOffset) {
			var date = strToDate(_this.find('.month').text());
			date.setMonth(date.getMonth() + monthOffset);
			_this.update(date);
		};

		_this.find('.next').click(function () {
			updateTable(1);

		});

		_this.find('.prev').click(function () {
			updateTable(-1);
		});

		return this;
	};

	$.fn.calendar.defaults = {
		date: new Date(),
		picker: false,
	};

	$.fn.datePicker = function () {
		var _this = this;
		var picker = $('<div></div>')
			.addClass('picker-container')
			.hide()
			.calendar({'date': strToDate(_this.val()), 'picker': true});

		_this.after(picker);

		/* event binding */
		// click outside area, make calendar disappear
		$('body').click(function () {
			picker.hide();
		});

		// click input should make calendar appear
		_this.click(function () {
			picker.show();
			return false; // stop sending event to docment
		});

		// click on calender, update input
		picker.click(function () {
			_this.val(picker.getCurrentDate());
			return false;
		});

		return this;
	};

	$(window).load(function () {
		$('.jquery-calendar').each(function () {
			$(this).calendar();
		});
		$('.date-picker:text').each(function () {
			$(this).datePicker();
		});
	});
}($));

</script>

<body>
<h2>방 만들기 페이지</h2>
아이디 값 : <%=session.getAttribute("id") %><br>
출발지 확인 :${Room.rStart}<br>
 도착지 확인 :${Room.rEnd}<br>
예상 거리 :${Room.preDistance}<br>
예상 금액 :${Room.preMoney}<br>
예상 시간 :${Room.preTime}<br>
<form action="CreateRealRoom?roomId=${Room.roomId}" method="post">
동승자 성별선택 :
<c:if test="${Gender.gender.equals('men')}">
<input type=radio name="gender" value="men">남자
</c:if>
<c:if test="${Gender.gender.equals('women')}">
<input type="radio" name="gender" value="women">여자
</c:if>
<input type="radio" name="gender" value="noProblem" checked="checked">상관없음<br>
최대 인원 선택 : <select name="maximum">
<option value="2">2명</option>
<option value="3">3명</option>
<option value="4">4명</option>
</select><br>

<input type="submit" value="바로만들기">
</form>
　<input type="button" value="예약" onclick="innerHTMLReservation()"><br>
<hr>
예약 누르면 InnerHTML로 밑에있는것들이 뜨게 만들기!<br>
<form action="ReservationRoom?roomId=${Room.roomId}" method="post">
날짜선택:<input class="date-picker" type="text" name="dayDay"/>
시간선택:<select name="times">
<option value="00:00">00:00</option>
<option value="01:00">01:00</option>
<option value="02:00">02:00</option>
<option value="03:00">03:00</option>
<option value="04:00">04:00</option>
<option value="05:00">05:00</option>
<option value="06:00">06:00</option>
<option value="07:00">07:00</option>
<option value="08:00">08:00</option>
<option value="09:00">09:00</option>
<option value="10:00">10:00</option>
<option value="11:00">11:00</option>
<option value="12:00">12:00</option>
<option value="13:00">13:00</option>
<option value="14:00">14:00</option>
<option value="15:00">15:00</option>
<option value="16:00">16:00</option>
<option value="17:00">17:00</option>
<option value="18:0">18:00</option>
<option value="19:00">19:00</option>
<option value="20:00">20:00</option>
<option value="21:00">21:00</option>
<option value="22:00">22:00</option>
<option value="23:00">23:00</option>
</select><br>
동승자 성별선택 :<input type=radio name="gender" value="men">남자
	  <input type="radio" name="gender" value="women">여자
	  <input type="radio" name="gender" value="noProblem" checked="checked">상관없음<br>
최대 인원 선택 : <select name="maximum">
<option value="2">2명</option>
<option value="3">3명</option>
<option value="4">4명</option>
</select><br>

<input type="submit" value="예약하기">
</form>
<span id="Send"></span>


</body>
</html>