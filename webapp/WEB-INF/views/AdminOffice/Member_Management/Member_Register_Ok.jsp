<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



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


<div id="member_reg_ok">


	<font color="#58ACFA">Kosta 아파트</font> 회원 가입을 위한 인증번호가 발송되었습니다. <br>


	<table>
		<tr>
			<th>아이디</th>
			<td>${member_certification.userid}</td>
		</tr>

		<tr>
			<th>세대주명</th>
			<td>${member_certification.name}</td>
		</tr>

		<tr>
			<th>이메일</th>
			<td>${member_certification.email}</td>
		</tr>

		<tr>
			<th>인증번호</th>
			<td>${member_certification.checknum}</td>
		</tr>
	</table>

	<center>
		<button>
			<a href="index.ams">메인으로 이동 </a>
		</button>
	</center>

</div>



