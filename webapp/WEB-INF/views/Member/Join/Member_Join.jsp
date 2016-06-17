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
	
	$("img:nth-child(2)").hide();
	$("img:nth-child(4)").hide();
	$("img:nth-child(7)").hide();
	$("img:nth-child(10)").hide();
	$("#join_div_3").hide();
	$("#join_div_4").hide();
	$("#join_div_5").hide();
	
	$("#next1").click(function() {
		
		 if ($("#join_check").is(":checked") == false) {
			alert("약관에 동의해 주세요");
			$(this).focus();
			return false;
		} else {
		
	    $("#join_div_2").hide();
	    $("#join_div_3").show();
		$("img:nth-child(1)").hide();
		$("img:nth-child(2)").show();
		$("img:nth-child(4)").show();
		$("img:nth-child(5)").hide();
		$("img:nth-child(7)").hide();
		$("img:nth-child(10)").hide();
	
		
		 } 
		
	});//end 1단계	
	
	$("#next2").click(function() {
		
		
		
	    $("#join_div_3").hide();
	    $("#join_div_4").show();
		$("img:nth-child(1)").hide();
		$("img:nth-child(2)").show();
		$("img:nth-child(4)").hide();
		$("img:nth-child(5)").show();
		$("img:nth-child(7)").show();
		$("img:nth-child(8)").hide();
		$("img:nth-child(10)").hide();
	
		
		
		
	});//end 2단계
	
	$("#next3").click(function() {
		
		
		
	    $("#join_div_4").hide();
	    $("#join_div_5").show();
		$("img:nth-child(1)").hide();
		$("img:nth-child(2)").show();
		$("img:nth-child(4)").hide();
		$("img:nth-child(5)").show();
		$("img:nth-child(7)").hide();
		$("img:nth-child(8)").show();
		$("img:nth-child(10)").show();
		$("img:nth-child(11)").hide();
		

		
	});//end 3단계
	
	
	
	
	
	
	
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
	<img src ="./resources/images/register/Be_accept_terms.png" alt="약관동의"/>
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>
	
	<img src ="./resources/images/register/Af_certification.png" alt="인증번호입력"/>
	<img src ="./resources/images/register/Be_certification.png" alt="인증번호입력"/>
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>
	
	<img src ="./resources/images/register/Af_register.png" alt="정보입력"/>
	<img src ="./resources/images/register/Be_register.png" alt="정보입력"/>
	
	<img src ="./resources/images/register/arrow.png" alt="화살표"/>
	
	<img src ="./resources/images/register/Af_register_ok.png" alt="가입완료"/>
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
	<center><button type="button" id="next1" class=""><a href="#"> 다음</a></button></center>

</div>

<div id="join_div_3">
 <b>인증번호입력</b> <br>
회원 가입 시 이용약관 및 개인정보 활용에 대한 동의 <br>

   <br>
   <br>
  <div class="join_text" >
  
  	<font color="#58ACFA">Kosta 아파트</font> 입주민 여러분을 <font color="#58ACFA">환영합니다.</font> <br>
본 홈페이지는 관리사무소에 입주자 등록을 한 후, <br>
<font color="#CEECF5">이메일로 인증번호를 받은 입주민만 가입이 가능</font>합니다.<br>

아직 <font color="#CEECF5">인증번호를 받지 못하신 입주민 분께서는 관리사무소로 연락</font>바랍니다.<br>
<img src ="./resources/images/register/phone.png" alt="가입완료"/>031-1234-5678~9	
  
  </div>
  
  <br>
  <br>
  
  이메일을 통해 확인 한, <font color="#FA5858" size="4">인증번호를 정확히</font> 입력해주세요.
  
  <form action="" id="" method="post">
  <div id="input_num">
  	
  	아이디<input type="text" name="userid" value=""><br>
  	세대주명 <input type="text" name="name"> <br>  	
  	인증번호 <input type="text" name="checknum">
  
  
  </div>
  		<center>
  		<input type="reset" value="다시입력">
  		<button type="button" id="next2" class=""><a href="#"> 다음</a></button></center>
  		
  </form>
					
	
	

</div>

<div id="join_div_4">
<b>정보입력</b> <br>
회원가입 정보는 입주자 카드를 보완, 아파트 입주민 확인절차와 편의제공을 위한 자료로 사용됩니다.
 <br>
	
	<form action=""	 id="" method="post">	
	
	<table>
		<tr>
		 <th> 아이디 </th>
		 <td> <input type="text" name="username" value=""> </td>		 
		</tr>
		
		<tr>
		 <th> 비밀번호 </th>
		 <td> <input type="password" name="password" value=""> </td>		 
		</tr>
		
		<tr>
		 <th> 비밀번호 확인 </th>
		 <td> <input type="password" name="password2" value=""> </td>		 
		</tr>
		
		<tr>
		 <th> 세대주 성명 </th>
		 <td> <input type="text" name="user" value=""> </td>		 
		</tr>
		
		<tr>
		 <th>동/호수 </th>
		 <td> <input type="text" name="addr_1" value="">동
		 	<input type="text" name="addr_2" value="">호
		  </td>		 
		</tr>
		
		<tr>
		 <th>휴대전화 </th>
		 <td> <input type="text" name="phone" value=""> </td>		 
		</tr>
		
		<tr>
		 <th>비상 연락처 </th>
		 <td> <input type="text" name="emerphone" value=""> </td>		 
		</tr>
		
		<tr>
		 <th>생일 </th>
		 <td> <input type="text" name="birthday" value=""> </td>		 
		</tr>
		
		<tr>
		 <th>이메일</th>
		 <td> <input type="email" name="email" value=""> </td>		 
		</tr>
		
		<tr>
		 <th>세대 구성원</th>
		 <td> <input type="text" name="family" value="">  <br>
		 	   <div>
		 	   	구성원 정보를 입력해주세요
		 	   	이름 <input type="text" name="f_name"> 
		 	   	나이 <input type="text" name="f_age">
		 	   	성별 <input type="radio" name="f-gender" value="M">
		 	   	<input type="radio" name="f-gender" value="F">
		 	   	
		 	   	<button id="add_family">추가</button>
		 	    
		 	   </div>
		 
		 </td>		 
		</tr>
		
		<tr>
		 <th>차량 정보</th>
		 <td> <select id="carselect">
		 			<option selected="selected">선택</option>
		 			<option>1대</option>
		 			<option>2대</option>
		 			<option>3대</option>
		       </select> <sub>세대별 소유 하신 차량 대수를 선택해주세요</sub>  <br>
		 	   <div>
		 	   	차명 <input type="text" name="c_name"> 
		 	   	차량 번호 <input type="text" name="c_number">
		 	   	
		 	    
		 	   </div>
		 
		 </td>		 
		</tr>
		
	</table>	
		
	<center>
	<input type="reset" value="가입 취소">
	<button type="button" id="next3" class=""><a href="#"> 가입 신청</a></button></center>
	
	</form>	

</div>

<div id="join_div_5">
회원가입 완료 <br>
<div class="join_text" >
	<center><font color="#58ACFA" size="6">회원 가입</font>을 축하드립니다</center> <br>
	<font color="#58ACFA">Kosta 아파트</font>  홈페이지의 회원이 되신 것을 <font color="#CEECF5">진심으로 축하드립니다.</font>  <br>
<br>
저희 <font color="#58ACFA">Kosta 아파트</font> 에서는 항상 입주민들이 살기 좋은 아파트가 될 수 있도록 노력하겠습니다.

<center><button><a href="index.ams">메인으로 이동 </a></button></center>
	
	

</div>
 


</div>


</body>
</html>



