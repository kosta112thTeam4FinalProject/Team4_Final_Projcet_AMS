<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>

</style>

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

<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 -->


<script type="text/javascript">
	$(document).ready(function() {
		
		var today = new Date();
		var d = today.getDate();
		var m = today.getMonth();
		var y = today.getFullYear();

		$('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month'
			},

			//editable : true,
			droppable : true, // this allows things to be dropped onto the calendar
			eventLimit : true, // allow "more" link when too many events

			events : function(start, end, timezone, callback) {
				
				var day = moment(today).format('YYYY-MM-DD');
				console.log("today : " + day);		
				
				$.ajax({
					type : "GET",
					url : 'complain_calendar_get.ams',
					dataType : 'json',
					success : function(data) {
						var events = [];
						console.log(data);
								
						if (data != null) {
							$.each(data, function(index, obj) {
								if(obj.start_cal >= day){
									console.log("현재날짜보다 작음");
								
								console.log("obj.reserve_0 : " + obj.reserve_o);
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
								}
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
				//alert('click');
				
				if(calEvent.title != "예약 완료"){
				$("#myModal").modal("show");
				$("#complain_idx").val(calEvent.id);
				console.log($("#complain_idx").val());
				console.log($("#content").val());
				//$("#myModal").modal("hide");
				}else{
					//alert("이미 예약된 시간입니다.");
					return;
				}
				
			},

		});

	});
</script>


</head>
<body>
	<div id="title_bar">
		<span> 아파트 일정 </span> <img
			src="./resources/images/aptCalendar_title.png">
	</div>

	<div id='calendar'></div>

	<div id="fullcalendar"></div>

	
	<div class="modal fade" id="myModal" role="dialog" hidden>
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
			<form action="complainCal_user_insert.ams" method="POST">
				<div class="modal-header">
					<h2 class="modal-title">상세예약 내용</h2>
					<input type="hidden" id="complain_idx" name="complain_idx" />
				</div>
				<div class="modal-body">
					<input type="content" id="content" name="content" />
				</div>
				<div class="modal-footer">
					<button type="submit">등록</button>
				</div>
			</form>
			</div>

		</div>
	</div>
	
	
	

</body>
</html>