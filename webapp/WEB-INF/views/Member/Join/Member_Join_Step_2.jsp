<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#next").click(function() {
			
			var userid = $('#userid').val();
			
			var info = {
				userid : $('#userid').val(),
				name : $('#name').val(),
				checknum : $('#checknum').val()
			}

			$.ajax({
				type : "POST",
				url : "member_ceriti_check.ams",
				data : info,

				success : function(data) {

					/* $('btnCheckUid').empty();*/
					console.log(data);

					alert(data);
					
					if(data == 1){
						alert("인증되었습니다");
						location.replace("member_join_info.ams?userid=" + userid);
					} else {
						alert("등록된 인증번호가 아닙니다. 관리사무소로 연락해주세요");
					}
				},
				
				error : function(xhr) {
					alert(xhr.status + "ERROR");
				}

			}); //end ajax	 */

		});//end 2단계		

		$('#reset').click(function(){
			$('#userid').val("");
			$('#name').val("");
			$('#checknum').val("");
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
			src="./resources/images/register/Af_certification.png" alt="인증번호입력" />
		<img src="./resources/images/register/arrow.png" alt="화살표" /> <img
			src="./resources/images/register/Be_register.png" alt="정보입력" /> <img
			src="./resources/images/register/arrow.png" alt="화살표" /> <img
			src="./resources/images/register/Be_register_ok.png" alt="가입완료" />
	</div>



	<div id="join_div_3">
		<b>인증번호입력</b> <br> <br>
		<div class="join_text">

			<font color="#58ACFA">Kosta 아파트</font> 입주민 여러분을 <font color="#58ACFA">환영합니다.</font>
			<br> 본 홈페이지는 관리사무소에 입주자 등록을 한 후, <br> <font color="#CEECF5">이메일로
				인증번호를 받은 입주민만 가입이 가능</font>합니다.<br> 아직 <font color="#CEECF5">인증번호를
				받지 못하신 입주민 분께서는 관리사무소로 연락</font>바랍니다.<br> <img
				src="./resources/images/register/phone.png" alt="가입완료" />031-1234-5678~9

		</div>

		<br> <br> 이메일을 통해 확인 한, <font color="#FA5858" size="4">인증번호를
			정확히</font> 입력해주세요.
		
		<form action="" method="POST">
			<div id="input_num">
				아이디 <input type="text" id="userid" name="userid"><br>
				세대주명 <input type="text" id="name" name="name"> <br>
				인증번호 <input type="text" id="checknum" name="checknum">
				<!-- <input type="button" id="check" value="인증번호 확인"> -->
			</div>
			<center>
				<input type="button" id="reset" value="다시입력"> 
				<input type="button" id="next" class="" value="다음">
			</center>
		</form>




	</div>


</body>
</html>



