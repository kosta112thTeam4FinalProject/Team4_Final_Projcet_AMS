<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      <div id="title_bar">	
	         <span> 익명게시판 </span> 
	         <img src = "./resources/images/anonymous_title.png">   	
	      </div>
	      
	      <div id="board_top">
	      	<form name="board_list">
						<!-- form tag에 action이 없으면 현재 URL 주소로 submit -->
						<select name="ps" onchange="submit()">
							<%-- <c:forEach var="i" begin="10" end="50" step="10">
								<c:choose>
									<c:when test="${pageSize == i}">
										<option value='${i}' selected>${i}건</option>
									</c:when>
									<c:otherwise>
										<option value='${i}'>${i}건</option>
									</c:otherwise>
								</c:choose>
							</c:forEach> --%>
							<option selected="selected">10</option>
			      		    <option>20</option>
			      		    <option>30</option>
			      		    <option>40</option>
			      		    <option>50</option>							
						</select>
				</form>
				
				<a href="" >최신순 |</a>  <a href="">조회순</a>
	      
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
	      		
	      		<c:forEach var="anony" items="${list}">
	      		
	      		<tbody>
	      			<tr>
	      			 <td>
	      			<c:choose>	
	      			    <c:when test="${anony.depth > 0}">
	      			  	<input type="hidden" name="board_idx" value="${anony.board_idx}">
	      			  </c:when>
	      			  
	      			   <c:otherwise>
	      			   ${anony.board_idx}
	      			  </c:otherwise>	      			  
	      			 </c:choose>
	      			   &nbsp; <img src="./resources/images/anonymous_tag.png"> 
	      			  <c:forEach begin="0" end="${anony.depth}">
	      			  &nbsp;
	      			  </c:forEach>
	      			  <a href="anonymous_detail.ams?board_idx=${anony.board_idx}&pg=${pg}">${anony.title}</a></td>
	      			  
	      			  <td>${anony.nickname} </td>
	      			  <td>${anony.regdate}</td>
	      			  <td>${anony.hit}</td>
	      			</tr>  						      			    	      		
	      		</tbody> 
	      		</c:forEach>     	     	
	      	</table>
	      	 <button class="reg_button"><a href="anonymous_write.ams">등록</a></button>
	      	</div>
	      	
	      	
	      	<div id="board_page">
	      	  
	      	  <!-- 이전  -->
	      	  <c:if test="${pg>1}"> <!-- 이전 페이지가 있는 경우  -->
	      	  <a href="anonymous_list.ams?pg=${pg-1}">[이전]</a>
	      	  </c:if>
	      	 <%--  <c:if test="${pg<=block}"> <!-- 이전 페이지가 없는 경우  -->
	      	  <span style="color:gray">[이전]</a>
	      	  </c:if>  --%>
	
	      			      	  
	      	  <!-- 1,2,3.....  -->
	      	  <ul>
	      	    <c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"> <li style="color:red">${i}</li> </c:if>
					<c:if test="${i!=pg}"> <li><a href="anonymous_list.ams?pg=${i}">${i}</a></li>
					</c:if>					
				</c:forEach>
			 </ul>
			 
			 <!-- 다음  -->
			 <c:if test="${pg < allPage}">
	      	  	<a href="anonymous_list.ams?pg=${pg+1}">[다음]</a>
	      	 </c:if>
	      	 
	      <%-- 	 <c:if test="${toPage>=allPage}"> <!-- 다음 페이지가 없는 경우  -->
	      	  	<span style="color:gray">[다음]</a>
	      	 </c:if> --%>
		

	      	
	      	</div> 
	      	
	      	<div id="board_search" >
	      		<form class="search_form" id="" action="anonymous_search.ams" method="post">
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
	    