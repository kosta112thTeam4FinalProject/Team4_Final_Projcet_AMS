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
	     
	     <input type="hidden" name="send_idx" value="${send_message.send_idx}"/><!-- 해당 쪽지 번호 -->	     
	
	     <button><a href="message_send.ams">목록</a></button>
	     <button><a href="messgae_send_delete.ams?send_idx=${send_message.send_idx}">삭제</a></button>
	      	<table>
	      		<tr> 
	      			<td> 받는 사람 </td>
	      			<td> ${send_message.userid}</td> 
	      		
	      		</tr>
	      		<tr> 
	      			<td>제목</td>
	      			<td>${send_message.title}</td>
	      		
	      		</tr>
	      		</table>
	      		
	      		<br>
	      		<br>
	      		
	      
	      		<textarea cols="100" rows="15" readonly="readonly">
	      		
	      		 ${send_message.content}
	      		
	      		</textarea>
	      		
	      		</div>
	      		