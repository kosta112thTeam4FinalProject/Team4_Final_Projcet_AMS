<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
$(document).ready(
	function() {
		$("#datepicker").datepicker({
				dateFormat : 'yy-mm-dd',
				prevText : '이전 달',
				nextText : '다음 달',
				monthNames : [ '1월', '2월', '3월', '4월',
						'5월', '6월', '7월', '8월', '9월',
						'10월', '11월', '12월' ],
				monthNamesShort : [ '1월', '2월', '3월', '4월',
						'5월', '6월', '7월', '8월', '9월',
						'10월', '11월', '12월' ],
				dayNames : [ '일', '월', '화', '수', '목', '금',
						'토' ],
				dayNamesShort : [ '일', '월', '화', '수', '목',
						'금', '토' ],
				dayNamesMin : [ '일', '월', '화', '수', '목',
						'금', '토' ],
				showMonthAfterYear : true,
				changeMonth : true,
				changeYear : true,
				yearSuffix : '년'
			}

		);
		 
		//차량 정보 입력
		$('#carselect').change(function(){
			
			var car = document.getElementById("carselect");
			var carNum = car.options[car.selectedIndex].value;

			console.log("선택된 값 : " + carNum);

			var add = "";
			
			for (var i = 0; i < carNum; i++) {
				
				add += "<br>차명 <input type='text' name='carname_" + i + "'><br>";
				add += "차량번호 <input type='text' name='carnumber_" + i + "'><br>"
			}
			
			$("#carinfo").html(add);
			
		})
		
		// 가족 멤버 추가
		var member = 1;

		$("#add_family").on("click", function() {
			addMember();
		});

		
		$("#next3").click(function() {

		});//end 3단계	
		
		function addMember(){
			var add = "";
			add += "<p>";
			add += "<br>이름 <input type='text' name='name_" + member + "'><br>";
			add += "나이 <input type='text' name='age_" + member + "'><br>";
			add += "성별 <input type='radio' name='gender_" + member + "' value='male'>남자";
			add += "<input type='radio' name='gender_" + member++ + "' value='female'>여자<br>"
			add += "<a href='' id='delete' name='delete'>삭제</a>";
			add += "</p>";
			
			$("#family_info").append(add);
			
			$("a[name='delete']").on("click", function(e) { //삭제 버튼
				e.preventDefault();
				$(this).parent().remove();
			});
		}
		
		$("a[name='delete']").on("click", function(e) { //삭제 버튼
			e.preventDefault();
			$(this).parent().remove();
		});
		
	});
</script>



</head>

<body>
	<div id="title_bar">
		<span> 회원가입 </span> <img
			src="./resources/images/title_bar/join_title.png">
	</div>

	<div id="join_title">
		<img src="./resources/images/register/Be_accept_terms.png" alt="약관동의" />

		<img src="./resources/images/register/arrow.png" alt="화살표" /> <img
			src="./resources/images/register/Be_certification.png" alt="인증번호입력" />

		<img src="./resources/images/register/arrow.png" alt="화살표" /> <img
			src="./resources/images/register/Af_register.png" alt="정보입력" /> <img
			src="./resources/images/register/arrow.png" alt="화살표" /> <img
			src="./resources/images/register/Be_register_ok.png" alt="가입완료" />

	</div>


	<div id="join_div_4">
		<b>정보입력</b> <br> 회원가입 정보는 입주자 카드를 보완, 아파트 입주민 확인절차와 편의제공을 위한 자료로
		사용됩니다. <br>

		<form action="member_join_info.ams" method="post">
				
			<table>
				<tr>
					<th width=130>아이디</th>
					<td><input type="text" name="userid" value="${member.userid }"></td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="pwd" name="password" value=""></td>
				</tr>

				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id ="pwdCheck" name="password2" value="">
						<span id="checkedPWD"></span></td>
				</tr>

				<tr>
					<th>세대주 성명</th>
					<td><input type="text" name="name" value="${member.name}"></td>
				</tr>

				<tr>
					<th>동/호수</th>
					<td><input type="text" name="addr_1" value="${member.addr_1}">동
						<input type="text" name="addr_2" value="${member.addr_2 }">호</td>
				</tr>

				<tr>
					<th>휴대전화</th>
					<td><input type="text" name="phone" value=""></td>
				</tr>

				<tr>
					<th>비상 연락처</th>
					<td><input type="text" name="emerphone" value=""></td>
				</tr>

				<tr>
					<th>생일</th>
					<td><input type="text" name="birthday" value=""
						id="datepicker"></td>
				</tr>

				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" value="${member.email }"></td>
				</tr>
						
				<tr>
					<th>세대 구성원</th>
					<td>
						<div id="family_info">
							세대주를 포함한 구성원 정보를 입력해주세요 
							<input type="button" id="add_family" value="추가">
							<p>
								<br> 이름 <input type="text" name="name_0" value="${member.name }">
								<br> 나이 <input type="text" name="age_0">
								<br> 성별 <input type="radio" name="gender_0" value="male">남자
										<input type="radio" name="gender_0" value="female">여자
								<!-- <a href="" class="btn" id="delete" name="delete">삭제</a> -->
							</p>
						</div>
					</td>
				</tr>

				<tr>
					<th>차량 정보</th>
					<td><sub>세대별 소유 하신 차량 대수를 선택해주세요</sub> <br> 
					<select id="carselect">
							<option value="0">선택</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
					</select> 대 <br>
						<div id="carinfo">
							<!-- 
								차명 <input type="text" name="carname_0"><br>
								차량 번호 <input type="text" name="carnumber_0">
							 -->
						</div>
					</td>
				</tr>

			</table>

			<center>
				<input type="reset" value="가입 취소">
				<input type="submit" value="가입 신청">
			</center>

		</form>

	</div>
</body>
</html>



