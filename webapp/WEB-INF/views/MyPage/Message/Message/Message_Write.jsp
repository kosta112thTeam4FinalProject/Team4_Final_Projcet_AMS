<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	      <div id="title_bar">	
	         <span> MyPage </span> 
	         <img src = "./resources/images/title_bar/mypage_title.png">   	
	      </div>
	      
	      <div id="mypage_menu" style="float: left;">
	      	<ul style="text-decoration: none">
	      		<li>
	      			<a href="member_modify">회원정보수정</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_write">쪽지쓰기</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_received.ams">받은 쪽지함</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_send.ams">보낸 쪽지함</a>
	      		</li>	      		
	      	
	      	</ul>	      
	      </div>      
	         
	      
	      <div id="board">
	        쪽지쓰기
	        <br>
	        <br>
	        <form action="message_write.ams" method="post">
	        
	      	<table>
	      		<input type="submit" value="보내기">	      		
	            <button><a href="message_received.ams">취소</a></button>
	      	<tr> 
	      			<td> 받는 사람 </td>
	      			<td> <input type="text" name="userid"> </td> 
	      		
	      		</tr>
	      		<tr> 
	      			<td>제목</td>
	      			<td><input type="text" name="title"> </td>
	      		
	      		</tr>
	      	</table>
	      		
	      		<br>
	      		<br>
	      		
	      
	      		<textarea cols="100" rows="15" name="content" >
	      		쪽지 내용
	      		
	      		
	      		</textarea>
	      		
	      
	      		   	     	
	     
	      	</form>
	      	
	      	</div>
	      	
	      	
	      