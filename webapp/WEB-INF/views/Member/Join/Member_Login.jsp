<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id="title_bar">
	<span> 회원 로그인 </span> 
	<img src="./resources/images/title_bar/join_title.png">
</div>


<div id="join_div_3">
 <b>인증번호입력</b> 

   <br>
   <br>
  <div class="join_text" >
  
  	<font color="#58ACFA">Kosta 아파트</font> 회원이 아니신분은 <font color="#58ACFA">회원 가입</font>을 해주세요 . <br>
본 홈페이지는 관리사무소에 입주자 등록을 한 후, <br>
<font color="#CEECF5">이메일로 인증번호를 받은 입주민만 가입이 가능</font>합니다.<br>

<font color="#CEECF5">회원가입 관련 문의는 관리사무소로 연락</font>바랍니다.<br>
<img src ="./resources/images/register/phone.png" alt="가입완료"/>031-1234-5678~9	
  
  </div>
  
  <br>
  <br>
  
  <!-- 로그인 실패 message 처리 -->
		<c:if test="${param.error != null}">
			<div>
				로그인 실패<br>
				  <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
      					이유 : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
     				</c:if>			
			</div>
		</c:if>
<!-- 로그인 END -->
    
  <!-- <form action="member_login.ams" id="" method="post"> -->
  <c:url value="/login" var="loginURL"></c:url>
  <form action="${loginURL}" method="post">
  <div id="input_num">
  	
  	아이디<input type="text" name="username" ><br>
  	비밀번호 <input type="password" name="password"> <br>  	
  	<input type="submit" value="로그인"> 
  
  </div> 	
  		
  </form>
  
 <font color="#FA5858" size="4">비밀 번호를 잊어버리신 경우</font> <a href="">여기</a>를 눌러주세요.
					
	
	

</div>





