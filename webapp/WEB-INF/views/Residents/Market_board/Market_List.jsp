<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      
	      <div id="title_bar">	
	         <span> 벼룩시장 </span> 
	         <img src = "./resources/images/market_title.png">   	
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
	      			<tr>
	      			  <td>1 &nbsp; <img src="./resources/images/market_tag.png"> <a href="market_detail.ams">공지사항 테스트 </a></td>
	      			  <td> 104-201</td>
	      			  <td> 2016.03.10</td>
	      			  <td>5</td>
	      			</tr>
	      			<c:forEach items="${list}" var="m">
	      			<tr>
	      			  <td class="board_idx">${m.board_idx} <img src="./resources/images/notice_tag.png"> <a href="market_detail.ams?board_idx=${m.board_idx}"> ${m.title} </a> </td>
	      			  <td class="writer"> ${m.writer} </td>
	      			  <td class="regdate"> ${m.regdate} </td>
	      			  <td class="hit">${m.hit}</td>
	      			</tr>
	      			</c:forEach>
	      			      			    	      		
	      		</tbody>      	     	
	      	</table>
	      	 <button class="reg_button"><a href="market_write.ams">등록</a></button>
	      	</div>
	      	
	      	
	      	<div id="board_page">
	      	  
	      	  <a href="">[이전]</a>
	      	  <ul>
				<!-- <li><a class=strong href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li> -->
				<c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"><li>${i}</li></c:if>
					<c:if test="${i!=pg}">
						<li><a href="market_list.ams?pg=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
			 </ul>
	      	  <a href="">[다음]</a>
	      	
	      	</div> 
	      	
	      	
	      	<%-- <p id="cur-page" class="margin-small">
		<span class="strong">1</span> / 10 page
	</p>
	<div id="pager-wrapper" class="margin-small">
		<div class="pager clear">			
			<ul>
				
				<!-- 블록 범위 찍기 -->
				<c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"><li>${i}</li></c:if>
					<c:if test="${i!=pg}">
						<li><a href="notice.htm?pg=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				
				
			</ul>
			
		</div>
	</div> --%>
	      	
	      	<div id="board_search" >
	      		<form class="search_form" id="" action="market_search.ams" method="post">
	      		   <select id="" >
	      		   	<option selected="selected">선택하세요</option>
	      		    <option>1일</option>
	      		    <option>1주일</option>
	      		    <option>1개월</option>
	      		    <option>기간입력	      		    
	      		      <input type="text" id="" name=""> ~ <input type="text" id="" name="">	
	      		      <button>설정</button>     		    
	      		    </option>       		   
	      		   </select> 
	      		   
	      		       		   
	      		   <select id="">
	      		    <option selected="selected">선택하세요</option>
	      		    <option>전체</option>
	      		    <option>제목 + 내용</option>
	      		    <option>제목만</option>
	      		    <option>글작성자</option>
	      		    <option>댓글내용</option>
	      		    <option>댓글작성자</option>      		   
	      		   </select> 
	      		   
	      		   <input type="text" id="" name="">
	      		   <input type="submit"	 id=""  name="" value="검색">
	      		
	      		</form>   	
	      	
	      	</div>   
	      
	  