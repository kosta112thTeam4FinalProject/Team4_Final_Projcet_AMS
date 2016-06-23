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
	      		<a href="message_write.ams">쪽지쓰기</a>
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
	     쪽지 보기<br>
	     
	     <input type="hidden" name="receive_idx" value="${receive_message.receive_idx}"/><!-- 해당 쪽지 번호 -->
	     
	     <button><a href="message_rewrite.ams?receive_idx=${receive_message.receive_idx}">답장</a></button>
	     <button><a href="message_received.ams">목록</a></button>
	     <button><a href="message_receive_delete.ams?receive_idx=${receive_message.receive_idx}">삭제</a></button>
	      	<table>
	      		<tr> 
	      			<td> 보낸 사람 </td>
	      			<td> ${receive_message.sender}</td> 
	      		
	      		</tr>
	      		<tr> 
	      			<td>제목</td>
	      			<td>${receive_message.title}</td>
	      		
	      		</tr>
	      		</table>
	      		
	      		<br>
	      		<br>
	      		
	      
	      		<textarea cols="100" rows="15" readonly="readonly">
	      		
	      		 ${receive_message.content}
	      		
	      		</textarea>
	      		
	      		</div>
	      		