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
				var today = new Date();
				var d = today.getDate();
				var m = today.getMonth();
				var y = today.getFullYear();
				
				$('#calendar').fullCalendar(
						{
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'month'
							},
							
							
							
							//var date = $('#calendar').fullCalendar( 'today' );

							/* selectable : false,
							selectHelper : false,
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
											eventData, true);
									$.ajax({
										type : "POST",
										url : "apt_calendar_Insert.ams",
										dataType : "text",
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
									});
											
								}

								$('#calendar').fullCalendar('unselect');
							}, */
					
							//editable : true,
							//droppable : true, // this allows things to be dropped onto the calendar
							eventLimit : true, // allow "more" link when too many events
							defaultDate : today,

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
							
							
							eventAfterRender: function(event, element, view) {
				                console.log("view : " + $(view));
				                //$('div.fc-day-content').css({"height":"50px"});
				                //$('.fc-event').css({"height":"90px"});
				               //$('.fc-event').css('font-size', '1.85em');
				                $('.fc-event').css('text-align', 'center');	
				                console.log(today);

				             },
				             
				            /*  eventRender: function(event, element, view) {
				            	    if(view.name === 'basicDay') {
				            	        $(element).height(100);
				            	    }
				            },  */

							
						});

			});
</script>

<style>

</style>

</head>
<body>
	<div id="title_bar">
		<span> 아파트 일정 </span> <img
			src="./resources/images/aptCalendar_title.png">
	</div>

	<div id='calendar'></div>


</body>
</html>