<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      <div id="title_bar">	
	         <span> 익명게시판 </span> 
	         <img src = "./resources/images/anonymous_title.png">   	
	      </div>
	      
	      <div id="board_content">
	       	<table>
				<tr>
				    <input type="hidden" name="ref" value="${anony_board.ref}"/>
					<input type="hidden" name="step" value="${anony_board.step}"/>
					<input type="hidden" name="depth" value="${anony_board.depth}"/>
					<input type="hidden" name="board_idx" value="${anony_board.board_idx}"/>
					
					<th>제목</th>
					<td colspan="3">${anony_board.title}</td>
					<td colspan="2" class="right">
					 <button><a href="anonymous_modify.ams?board_idx=${anony_board.board_idx}&pg=${pg}">수정</a></button>
					 <button><a href="anonymous_delete.ams?board_idx=${anony_board.board_idx}&pg=${pg}">삭제</a></button></td>
				</tr>
				<tr>
					<th>등록일</th><td>${anony_board.regdate}</td>
					<th>작성자</th><td>${anony_board.nickname}</td>
					<th>조회수</th><td>${anony_board.hit}</td>					
				</tr>
				<tr>
					<th>첨부파일</th><td class="left" colspan="5">test.txt</td>
				</tr>
		

				<tr>
					<td colspan="6"><textarea id="" name="" cols="100" rows="15">내용</textarea></td> 
					<!-- <td colspan="6">내용</td> -->
				</tr>
				
				<tr>
					<td class="right" colspan="6">
					  <button><a href="anonymous_rewrite.ams?board_idx=${anony_board.board_idx}&pg=${pg}">답글</a></button>
						<button><a href="anonymous_list.ams?pg=${pg}">목록</a></button>
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
	      	   <c:forEach var="acomment" items="${clist}">
	      	   <!--댓글 상세보기 부분 -->
 	      		<tr>
	      			<input type="hidden" name="writer" value="${acomment.writer}"/>
	      			<input type="hidden" name="board_idx" value="${acomment.board_idx}"/>
	      			<input type="hidden" name="comment_idx" value="${acomment.comment_idx}">
	      			<input type="hidden" name="ref" value="${acomment.ref}"/>
					<input type="hidden" name="step" value="${acomment.step}"/>
					<input type="hidden" name="depth" value="${acomment.depth}"/>
	      			
	      			<td colspan="4">${acomment.nickname} 
	      				<sup>${acomment.regdate}</sup>
	      				<sup><a href="anonymous_comment_rewrite.ams?comment_idx=${acomment.comment_idx}&pg=${pg}">답글</a></sup>
	      			</td>	  
	      			
	      			<td colspan="2" class="right">
	      				<button><a href="anonymous_comment_modify.ams?comment_idx=${acomment.comment_idx}&pg=${pg}">수정</a></button> 
	      				<button><a href="anonymous_comment_delete.ams?comment_idx=${acomment.comment_idx}&pg=${pg}">삭제</a></button>
	      			</td> 		
	      		</tr>
	      		<tr>
	      			<td colspan="6">
	      				${acomment.content}
	      			</td>
	      		</tr>
	      		</c:forEach>
	   	     </table>
	   	     	
	   	      <!--  댓글 페이징 처리 부분 -->
	   	     	<div id="board_page">
	      	  
	      	  <!-- 이전  -->
	      	  <c:if test="${pg>1}"> <!-- 이전 페이지가 있는 경우  -->
	      	  <a href="anonymous_comment_list.ams?board_idx=${anony_board.board_idx}&pg=${pg-1}">[이전]</a>
	      	  </c:if>
	      	 <%--  <c:if test="${pg<=block}"> <!-- 이전 페이지가 없는 경우  -->
	      	  <span style="color:gray">[이전]</a>
	      	  </c:if>  --%>
	
	      			      	  
	      	  <!-- 1,2,3.....  -->
	      	  <ul>
	      	    <c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"> <li style="color:red">${i}</li> </c:if>
					<c:if test="${i!=pg}"> <li><a href="anonymous_comment_list.ams?board_idx=${anony_board.board_idx}&pg=${i}">${i}</a></li>
					</c:if>					
				</c:forEach>
			 </ul>
			 
			 <!-- 다음  -->
			 <c:if test="${pg < allPage}">
	      	  	<a href="anonymous_comment_list.ams?board_idx=${anony_board.board_idx}&pg=${pg+1}">[다음]</a>
	      	 </c:if>
	      	 
	      <%-- 	 <c:if test="${toPage>=allPage}"> <!-- 다음 페이지가 없는 경우  -->
	      	  	<span style="color:gray">[다음]</a>
	      	 </c:if> --%>
		

	      	
	      	</div>       
	      </div>
	      
	      <div id="reply_write">
	        <sub>통신예절에 어긋나는 글이나 상업적인 글, 
	        우리 아파트와 무관한 글은 관리자에 의해 사전 통보 없이 삭제 될 수 있습니다. </sub>
	        <form action="anonymous_comment_write.ams" method="post">
	        <input type="hidden" name="board_idx" value="${anony_board.board_idx}"/>
	        <input type="hidden" name="writer" value="test"/>
	         <!-- 내가 현재 reply을 다려는 글 번호를 알아야 함!  -->
	      	<table>
	      		<tr>
	      			<!-- <input type="hidden" name="writer" value="test"/> -->
	      			<!-- <input type="hidden" name="comment_idx" /> -->
	      			<td colspan="2">닉네임</td>	
	      			<td colspan="4"><input type="text" name="nickname"></td>   
	      					
	      		</tr>
	      		
	      		<tr>
	      			<td colspan="5">
	      				<textarea rows="5" cols="100" name="content">
	      			    	댓글은 10자(20byte) 이상 입력해주세요
	      			    </textarea>
	      			</td>
	      		    <td class="right"><input type="submit" value="등록"></td>
	      		</tr>  	
	      	
	      	</table>
	      </form>
	      
	      </div>
	      