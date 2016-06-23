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
<link href='./resources/css/bootstrap.min.css' rel='stylesheet'
	media='print' />
<script src='./resources/js/jquery.min.js'></script>
<script src='./resources/js/jquery-ui.custom.min.js'></script>
<script src='./resources/js/bootstrap.min.js'></script>
<script src='./resources/js/moment.min.js'></script>
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
								var title = prompt('예약 가능 시간등록 :');
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
										url : "complain_calendar_insert.ams",
										dataType : "text",
										//data : {'title' : '1', 'start_cal' : '1', 'end_cal' : '1'},
										data : "reserve_o=" + title
												+ "&start_cal="
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
									/////////////////////////////////////////////////		
								}

								$('#calendar').fullCalendar('unselect');
							},

							//editable : true,
							droppable : true, // this allows things to be dropped onto the calendar
							eventLimit : true, // allow "more" link when too many events

							events : function(start, end, timezone, callback) {
								$.ajax({
									type : "GET",
									url : 'complain_calendar_get.ams',
									dataType : 'json',
									success : function(data) {
										//alert('aaaa');
										var events = [];
										console.log(data);
										if (data != null) {
											$.each(data, function(index, obj) {
												console.log(obj.reserve_o);
												console.log(obj.complain_idx);
												console.log(obj.start_cal);
												console.log(obj.end_cal);

												events.push({
													id : obj.complain_idx,
													title : obj.reserve_o,
													start : obj.start_cal,
													end : obj.end_cal,
													allDay : true
												});

											});
										}
										callback(events); //다시 함수 호출해서 화면에 출력
									},
									error : function() {
										alert('error');
									}
								});
							},

							eventClick : function(calEvent, jsEvent, view) {

								console.log("calEvent" + calEvent.id);
								console.log("jsEvent  " + jsEvent.id);
								console.log("view  " + view.id);
								
								console.log("title ::  " + calEvent.title);
								
								//$("#eventContent").modal("show");
	
								if (calEvent.title != "예약 완료") {
									if(confirm("정말 삭제하시겠습니까?") == true){
									$.ajax({
										type : "POST",
										url : "complain_calendar_delete.ams",
										dataType : "text",
										data : "complain_idx=" + calEvent.id,
										success : function(data) {
											alert('삭제되었습니다.');
											location.reload(); //삭제후 새로고침 
										},
									});
									}else{
										return;
									}
								} else {
									alert('예약 내용 보기');
									//$("#eventContent").modal("show");
									
									$.ajax({
										type : "POST",
										url : "complain_calendar_getContent.ams",
										dataType : "json",
										data : "complain_idx=" + calEvent.id,
										success : function(data) {
											console.log('read content success');
											console.log(data);
											console.log(data.content);
											//location.reload(); //삭제후 새로고침 
											$("#content").val(data.content);
											$("#eventContent").modal("show");
										},
										
									});
								}

							},

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

	<div id="fullcalendar"></div>

	

	<div id="eventContent" title="Event Details" style="display: none;">
		time : <span id="startTime"></span><br> <br>
		<p id="eventInfo"></p>
		<div class="modal-body">
			<input type="content" id="content" name="content" readonly="readonly" />
		</div>
	</div>

</body>
</html>