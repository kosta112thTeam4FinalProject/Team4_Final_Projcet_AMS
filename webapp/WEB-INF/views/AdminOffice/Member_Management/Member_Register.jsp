<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#btnmember_reg_2").hide();

		$("#btnmember_reg_1").click(function() {

			$("#btnmember_reg_1").hide();
			$("#btnmember_reg_2").show();

		}); //end btnmemberlist.click

		$("#btnCheckNum").click(function() {
			/* 
			var info = {
				userid : $('#userid').val(),
				name : $('#name').val(),
				email : $('#email').val()

			}

			console.log("userid : " + info.userid);
			console.log("name : " + info.name);
			console.log("email : " + info.email);
			*/
			 
			$.ajax({
				url : "member_Create_checkNum.ams",
				success : function(data) {
					alert("생성된 인증 번호 : " + data);
					$('#checknum').val(data);
				},

				error : function(xhr) {
					alert(xhr.status + "Error");
				}

			});
		});

	});
</script>
</head>
<body>
	<div id="title_bar">
		<span> 회원관리 </span> <img
			src="./resources/images/title_bar/membermange_title.png">
	</div>

	<div id="management_memu">

		<a href="member_list.ams"><img id="btnmemberlist_1"
			src="./resources/images/member/Be_member_list.png"></a>
		<!-- <a href ="member_list.ams"><img id="btnmemberlist_2" src="./resources/images/member/Af_member_list.png"></a>  -->

		&nbsp; &nbsp;&nbsp;&nbsp; <a id="btnmember_reg_1"
			href="member_Register.ams"><img
			src="./resources/images/member/Be_member_reg.png"></a> <a
			id="btnmember_reg_2" href=""><img
			src="./resources/images/member/Af_member_reg.png"></a>


	</div>

	<div id="member_reg">

		<form action="member_Register_Num_Ok.ams" id="" method="POST">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" id="userid"></td>
				</tr>

				<tr>
					<td>세대주명</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" id="email"></td>
				</tr>
				<tr>
					<td>인증번호</td>
					<td><input type="text" name="checknum" id="checknum">
						<input type="button" id="btnCheckNum" value="번호생성"></td>
				</tr>
			</table>

			<center>
				<button name="" value="" >회원 등록 및 인증번호 발송</button>
			</center>

		</form>

	</div>	
	

</body>
</html>

