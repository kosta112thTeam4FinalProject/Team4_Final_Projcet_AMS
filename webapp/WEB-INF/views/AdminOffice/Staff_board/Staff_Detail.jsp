<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	      
	      <div id="title_bar">	
	         <span> 직원 전용 게시판 </span> 
	         <img src = "./resources/images/staff_title.png">   	
	      </div>
	      
	      <div id="board_content">
	       	<table>
				<tr>
					<th>제목</th>
					<td colspan="3">${staff_board.title}</td>
					<td colspan="2" class="right">
					 <button><a href="staff_modify.ams?board_idx=${staff_board.board_idx}">수정</a></button>
					 <button><a href="staff_delete.ams?board_idx=${staff_board.board_idx}">삭제</a></button></td>
				</tr>
				<tr>
					<th>등록일</th><td>${staff_board.regdate}</td>
					<th>작성자</th><td>${staff_board.writer}</td>
					<th>조회수</th><td>${staff_board.hit}</td>					
				</tr>
		<tr class="article-detail-row half-row">
			<th class="article-detail-title">첨부파일</th>
 			<c:forEach var="row" items="${list}">
				<input type="hidden" id="idx" value="${row.IDX }">
				<td class="article-detail-data half-data">
				<a href="download/downloadFile.ams?idx=${row.IDX}">${row.ORIGINAL_FILE_NAME}</a>
				(${row.FILE_SIZE})
				</td>
			</c:forEach> 
		</tr>
		

				<tr>
					<td colspan="6"><textarea id="" name="" cols="100" rows="15">${staff_board.content}</textarea></td> 
					<!-- <td colspan="6">내용</td> -->
				</tr>
				
				<tr>
					<td class="right" colspan="6">
					  <button><a href="staff_rewrite.ams">답글</a></button>
						<button><a href="staff_list.ams">목록</a></button>
					</td>
				
				</tr>
				
				<tr>
					<td> 이전글 </td> <td colspan="5">이전글 제목</td>					
				</tr>
				
				<tr>
					<td> 다음글 </td> <td colspan="5">다음글 제목</td>
				</tr>			
	       	</table>	       	
	      </div>
	      
	      <div id="board_reply">
	      	        
	      	<table>
	      		<tr>
	      			<td colspan="4">106-105 <sup>2016.03.29</sup></td>	  
	      			<td colspan="2" class="right"><button>수정</button><button>삭제</button></td> 		
	      		</tr>
	      		<tr>
	      			<td colspan="6">댓글 내용</td>
	      		</tr>
	   	     </table>	      
	      </div>
	      
	      <div id="reply_write">
	        <sub>통신예절에 어긋나는 글이나 상업적인 글, 
	        우리 아파트와 무관한 글은 관리자에 의해 사전 통보 없이 삭제 될 수 있습니다. </sub>
	        <form action="" id="" method="post">
	        <input type="hidden" name="idx" value="${staff.reply_write }"> <!-- 내가 현재 reply을 다려는 글 번호를 알아야 함!  -->
	      	<table>
	      		<tr>
	      			<td colspan="2"><input type="text" name="" id="" value="로그인한 아이디"></td>	
	      			<td colspan="4"></td>   
	      					
	      		</tr>
	      		
	      		<tr>
	      			<td colspan="5"><textarea rows="5" cols="100">댓글은 10자(20byte) 이상 입력해주세요</textarea></td>
	      		    <td class="right"><input type="submit" value="등록"></td>
	      		</tr>  	
	      	
	      	</table>
	      </form>
	      
	      </div>
