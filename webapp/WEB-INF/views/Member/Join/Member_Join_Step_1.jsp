<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){ 

	$("#next").click(function() {
		
		 if ($("#join_check").is(":checked") == false) {
			alert("약관에 동의해 주세요");
			$(this).focus();
			return false;
		} else {
			
			location.replace("member_ceriti_check.ams");  
		
		 } 
		
	});//end 1단계	
	
	
});
</script>



</head>

<body>
<div id="title_bar">
	<span> 회원가입 </span> 
	<img src="./resources/images/title_bar/join_title.png">
</div>

<div id ="join_title">
	<img src ="./resources/images/register/Af_accept_terms.png" alt="약관동의"/>	
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>
		
	<img src ="./resources/images/register/Be_certification.png" alt="인증번호입력"/>
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>	
	
	<img src ="./resources/images/register/Be_register.png" alt="정보입력"/>
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>
		
	<img src ="./resources/images/register/Be_register_ok.png" alt="가입완료"/>

</div>

<div id="join_div_2">
    <b>약관동의</b> <br>
	회원 가입 시 이용약관 및 개인정보 활용에 대한 동의 <br>
					
	<iframe src="https://kr.koreanair.com/korea/ko/footers/Terms-of-Use.html" width="700" height="350">
					
	</iframe>
	<br>
	<br>
				
	<input type="checkbox" name="join_check" id="join_check">이용 약관에 동의 합니다 
	<br>
	<center><input type="button" id="next" class="" value="다음"><a href="#"></center>

</div>



</body>
</html>



