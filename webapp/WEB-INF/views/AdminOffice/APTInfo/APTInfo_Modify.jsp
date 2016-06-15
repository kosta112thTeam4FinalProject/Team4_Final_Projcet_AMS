<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		
		<script>
			$(function() {
				$("#tabs").tabs();
			});
		</script>
	</head>

	<body>

		<div id="title_bar">
			<span> 아파트 소개 </span> <img src="./resources/images/aptInfo_title.png">
		</div>
		
		<div id="main_content">
	
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">단지소개</a></li>
					<li><a href="#tabs-2">단지위치</a></li>
					<li><a href="#tabs-3">단지배치도</a></li>
					<li><a href="#tabs-4">단지평형도</a></li>
					<li><a href="#tabs-5">편의시설</a></li>
				</ul>
				<div id="tabs-1">
					<form action="apt_intro_modify.ams" id="" method="post">
		
						<img src="./resources/images/aptIntro.png">
						
						<input type="submit" value="수정완료">
						
						<button>
							<a href="apt_intro.ams">취소</a>
						</button>
					</form>
				</div>
				<div id="tabs-2">
					<form action="apt_location_modify.ams" id="" method="post">
		
						<img src="./resources/images/aptLocation.png"> 
						
						<input type="submit" value="수정완료">
						
						<button>
							<a href="apt_intro.ams">취소</a>
						</button>
					</form>
				</div>
				<div id="tabs-3">
					<form action="apt_layout_modify.ams" id="" method="post">
		
						<img src="./resources/images/aptLayout_1.png">
						<img src="./resources/images/aptLayout_2.png">
						
						<input type="submit" value="수정완료">
						<button>
							<a href="apt_intro.ams">취소</a>
						</button>
					</form>
				</div>
				<div id="tabs-4">
					<form action="apt_size_modify.ams" id="" method="post">
		
						<img src="./resources/images/aptSize_1.png"> 
						<img src="./resources/images/aptSize_2.png"> 
						
						<input type="submit" value="수정완료">
							
						<button>
							<a href="apt_intro.ams">취소</a>
						</button>
					</form>
				</div>
				<div id="tabs-5">
					<form action="apt_facility_modify.ams" id="" method="post">
		
						<img src="./resources/images/aptFacility.png"> 
						
						<input type="submit" value="수정완료">
						<button>
							<a href="apt_intro.ams">취소</a>
						</button>
					</form>
				</div>
			</div>
		</div>





	</body>
</html>