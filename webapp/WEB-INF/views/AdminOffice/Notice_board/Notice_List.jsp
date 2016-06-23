<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      <div id="title_bar">	
	         <span> 공지사항 </span> 
	         <img src = "./resources/images/notice_title.png">   	
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
	      			  <td>1 &nbsp; <img src="./resources/images/notice_tag.png"> <a href="notice_detail.ams">공지사항 테스트 </a></td>
	      			  <td> 관리사무소</td>
	      			  <td> 2016.03.10</td>
	      			  <td>5</td>
	      			</tr>
	     	   <!-- 글의 list 를 뿌려주는 for 문 -->
	     	   <c:forEach items="${list}" var="m">
                  <tr>
                    <td class="board_idx">${m.board_idx} 
                    <img src= "./resources/images/notice_tag.png"> 
                    <a href="notice_detail.ams?board_idx=${m.board_idx}"> ${m.title} </a> 
                    </td>
                    <td class="writer"> ${m.writer} </td>
                    <td class="regdate"> ${m.regdate} </td>
                    <td class="hit">${m.hit}</td>
                  </tr>
                  </c:forEach>
	      			      			    	      		
	      		</tbody>      	     	
	      	</table>
	      	 <button class="reg_button"><a href="notice_write.ams">등록</a></button>
	      	</div>
	      	
	      	
	      	<div id="board_page">
	      	  
	      	  <a href="">[이전]</a>
	      	  <ul>
	      	  <!-- 하단의 페이징 처리를 위한 for 문 -->
	  		<c:forEach begin="${fromPage}" end="${toPage}" var="i">
               <c:if test="${i==pg}"><li>${i}</li></c:if>
               <c:if test="${i!=pg}">
                  <li><a href="notice_list.ams?pg=${i}">${i}</a></li>
               </c:if>
            </c:forEach>
          </ul>
	      	  <a href="">[다음]</a>
	      	
	      	</div> 
	      	<!-- 검색 할 부분 -->
	      	<div id="board_search" >
	      		<form class="search_form" id="" action="notice_search.ams" method="post">
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
	      
	     
