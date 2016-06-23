<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='./resources/css/fullcalendar.css' rel='stylesheet' />
<link href='./resources/css/fullcalendar.print.css' rel='stylesheet'
	media='print' />
<script src='./resources/js/moment.min.js'></script>
<script src='./resources/js/jquery.min.js'></script>
<script src='./resources/js/jquery-ui.custom.min.js'></script>
<script src='./resources/js/fullcalendar.min.js'></script>
<script>
	$(document).ready(
			function() {


				$('#calendar').fullCalendar(
						{
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'month'
							},

							selectable : true,
							selectHelper : true,
							select : function(start, end) {
								var title = prompt('Event Title:');
								var eventData;
								if (title) {
									eventData = {
										title : title,
										start : start,
										end : end
									};
									$('#calendar').fullCalendar('renderEvent',
											eventData, true); // stick? = true
									console.log(title + '1');
									console.log(start + '2');
									console.log(end + '3');
									//////////////////////////////////////////////////
									$.ajax({
										type : "POST",
										url : "apt_calendar_Insert.ams",
										dataType : "text",
										//data : {'title' : '1', 'start_cal' : '1', 'end_cal' : '1'},
										data : "title=" + title + "&start_cal="
												+ start.format("YYYY-MM-DD")
												+ "&end_cal="
												+ end.format("YYYY-MM-DD"),
										success : function() {
											alert("일정이 등록되었습니다.");
											console.log(title);
											console.log(start);
											console.log(end);
										},
									/* error : function() {
										alert('error');
									}  */
									});
									/////////////////////////////////////////////////		
								}

								$('#calendar').fullCalendar('unselect');
							},
					
							editable : true,
							//droppable : true, // this allows things to be dropped onto the calendar
							eventLimit : true, // allow "more" link when too many events

							events : function(start, end, timezone, callback) {
								$.ajax({
									type : "GET",
									url : 'apt_calendar_get.ams',
									dataType : 'json',
									success : function(data) {
										//alert('aaaa');
										var events = [];
										console.log(data);
										if (data != null) {
											$.each(data, function(index, obj) {
												console.log(obj.title);
												console.log(obj.cal_idx);
												console.log(obj.start_cal);
												console.log(obj.end_cal);
												console.log(moment(obj.start_cal).format('YYYY-MM-DD'));
												
												//moment(event.end._d).format('YYYY-MM-DD');

												events.push({
													id : obj.cal_idx,
													title : obj.title,
													start : obj.start_cal,
													end : obj.end_cal,
													allDay : true
												});
												//eventColor: '#378006';
											});
										}
										callback(events); //다시 함수 호출해서 화면에 출력
									},
									error : function() {
										alert('error');
									}
								});
								//eventColor: '#378006'
							},
							
							eventDragStart: function (event, jsEvent, ui, view) {
								console.log('drag start');
								console.log(moment(event.start).format('YYYY-MM-DD'));
								console.log(moment(event.end).format('YYYY-MM-DD'));
								
							},
							
							eventDragStop: function (event, jsEvent, ui, view) {
								console.log('drag stop');
								console.log(event);
								console.log(moment(event.start._d).format('YYYY-MM-DD'));
								console.log(moment(event.end._d).format('YYYY-MM-DD'));
								
							},
							
						

							eventResize : function(event, delta, revertFunc) {
							
								var title = event.title;
								//var end = event.end._d;
								var end = moment(event.end._d).format('YYYY-MM-DD');
								console.log('resize');
								console.log(title);
								console.log(end);
								console.log('test');

								$.ajax({
									type : "POST",
									url : "apt_calendar_Resize.ams",
									dataType : "text",
									data : {title : title, end_cal : end},
									success : function() {
										alert('일정이 변경되었습니다.');
									}
									/* error : function() {
										alert('error');
									} */
									
								});
							},

							eventClick : function(calEvent, jsEvent, view) {

								console.log("calEvent" + calEvent.id);
								console.log("jsEvent  " + jsEvent.id);
								console.log("view  " + view.id);
								if(confirm("정말 삭제 하시겠습니까?") == true){
								$.ajax({
									type : "POST",
									url : "apt_calendar_Delete.ams",
									dataType : "text",
									data : "cal_idx=" + calEvent.id,
									success : function(data) {
										alert('삭제되었습니다.');
										
										location.reload(); //삭제후 새로고침 
									},

								});
								}else{
									return;
								}
							},
							
							
							
						});

			});
</script>

<style>
/* body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}

#wrap {
	width: 1100px;
	margin: 0 auto;
}

#external-events {
	float: left;
	width: 150px;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: left;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 10px 0;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	float: right;
	width: 900px;
} */
</style>

</head>
<body>
	<div id="title_bar">
		<span> 아파트 일정 </span> <img
			src="./resources/images/aptCalendar_title.png">
	</div>

	<div id='calendar'></div>

	<!-- <div id='wrap'>

		<div id='external-events'>
			<h4>보수 가능 시간</h4>
			<div class='fc-event'>10:00 ~ 12:00</div>
			<div class='fc-event'>14:00 ~ 16:00</div>
			<div class='fc-event'>16:00 ~ 18:00</div>
			<div class='fc-event'>이용시간 4</div>
			<div class='fc-event'>이용시간 5</div>
			<p>
				<input type='checkbox' id='drop-remove' />
				<label for='drop-remove'>remove after drop</label>
			</p>
		</div>

		<div id='calendar'></div>

		<div style='clear: both'></div>
	</div> -->

</body>
</html>