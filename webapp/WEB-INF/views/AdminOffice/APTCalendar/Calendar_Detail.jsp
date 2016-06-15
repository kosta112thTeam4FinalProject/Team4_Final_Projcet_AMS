<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<script type='text/javascript' src='.js/fullcalendar.js'></script>
		<script type="text/javascript" src='.js/sjquery-ui-1.10.3.custom.min.js'></script>
		
		<script type='text/javascript'>
	$(document).ready(function() {

		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		$('#calendar').fullCalendar({
			header: {
				left: "prev,next today",
				center: "title",
				right: "month,basicWeek,basicDay"
				},
				titleFormat: {
				month: "yyyy년 MMMM",
				week: "[yyyy] MMM d일{ [yyyy] MMM d일}",
				day: "yyyy년 MMM d일 dddd"
				},
				allDayDefault: true,
				editable: true,
				weekends : true,
				monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
				monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
				dayNames: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
				dayNamesShort: ["일","월","화","수","목","금","토"],
				buttonText: {
				today : "오늘",
				month : "월별",
				week : "주별",
				day : "일별"
				},
		});

	});
	</script>
	</head>
	<body>
		<div id="title_bar">
			<span> 아파트 일정 </span> <img src="./resources/images/aptCalendar_title.png">
		</div>
		
		<div id="calendar">
		
		</div>
		
	</body>
</html>