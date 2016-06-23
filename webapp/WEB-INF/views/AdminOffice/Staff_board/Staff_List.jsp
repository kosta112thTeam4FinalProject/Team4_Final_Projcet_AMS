<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      
	      <div id="title_bar">	
	         <span> 직원 전용 게시판 </span> 
	         <img src = "./resources/images/staff_title.png">   	
	      </div>
	      
	      
	      <div id="board">
	      	<table>
	      		<thead>
	      			<tr>
	      				<th>제목</th>
	      				<th>작성자</th>
	      				<th>작성일</th>
	      				<th>조회수</th>      			
	      			</tr>      		
	      		</thead>
	      		
	      		<tbody>
				<c:forEach items="${list}" var="staff">
	      			<tr>
	      			  <td>${staff.board_idx} <a href="staff_detail.ams?board_idx=${staff.board_idx}"> ${staff.title} </a> </td>
	      			  <td> ${staff.writer} </td>
	      			  <td> ${staff.regdate} </td>
	      			  <td>${staff.hit}</td>
	      			</tr>
	      		</c:forEach>
	      			      			    	      		
	      		</tbody>      	     	
	      	</table>
	      	 <button class="reg_button"><a href="staff_write.ams">등록</a></button>
	      	</div>
	      	
	      
	      	<div id="board_page">
	      	  <a href="">[이전]</a>			
	      	  <ul>
	      	  	<c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"><li>${i}</li></c:if>
					<c:if test="${i!=pg}">
						<li><a class=strong href="staff_list.ams?pg=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
			 </ul>
	      	  <a href="">[다음]</a>   	
	      	</div>
	      	
	      	<div id="board_search" >
	      	<!-- 	<form class="search_form" id="" action="staff_search.ams" method="post"> -->
<!-- 	      		   <select id="date" >
	      		   	<option selected="selected">선택하세요</option>
	      		    <option id ="day" value="day">1일</option>
	      		    <option id ="week" value="week">1주일</option>
	      		    <option id ="month" value="month">1개월</option>	   
	      		   </select>  -->
	      		   
<!-- 	      		   	<input type="checkbox" name="name" value="name" checked>작성자
					<input type="checkbox" name="email" value="email" >메일
					<input type="checkbox" name="home" value="home" >홈페이지 -->
	      		   
	      		       		   
	      	<form action="staff_search.ams" method="post">
				<select name="column">
					<option selected="selected">선택하세요</option>
					<option value="">전체</option>
					<option value="">제목 + 내용</option>
					<option value="title">제목만</option>
					<option value="writer">글작성자</option>
				</select>
				
				<input type="text" name="keyvalue">
				<input type="submit" value="검색">
				</form>
	      	</div>   
	      
	   