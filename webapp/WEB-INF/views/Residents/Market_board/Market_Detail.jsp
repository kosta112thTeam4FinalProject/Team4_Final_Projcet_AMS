<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function reply(index) {
		$('#reply_write2').show();
		$('#reply_id').val($('#writer'+index).text());
		$('#reply_content').text($('#content'+index).text());
		$('#comment_idx').val($('#idx'+index).val());
		//alert(index);
		 
	}
	
	 $(document).ready(function() {
		
		 $('#reply_submit').click(function(){
			$.ajax({
				type: 'post',
				url: 'market_comment_Modify.ams',
				data:{'comment_idx':$('#comment_idx').val(), 'writer':$('#reply_id').val(), 'content':$('#reply_content').val()},
				success: function(){
					alert('댓글이 수정 되었습니다.');
				}
			}) ;
		 });

	});

</script>

	      
	      <div id="title_bar">	
	         <span> 벼룩시장 </span> 
	         <img src = "./resources/images/market_title.png">   	
	      </div>
	      
	      <div id="board_content">
	       	<table>
				<tr>
					<th>제목</th>
					<td colspan="3">${detail.title}</td>
					<td colspan="2" class="right">
					 <button><a href="market_modify.ams?board_idx=${detail.board_idx}">수정</a></button>
					 <button><a href="market_delete.ams?board_idx=${detail.board_idx}">삭제</a></button></td>
				</tr>
				<tr>
					<th>등록일</th><td>${detail.regdate}</td>
					<th>작성자</th><td>${detail.writer}</td>
					<th>조회수</th><td>${detail.hit}</td>					
				</tr>
				<tr>
					<th>첨부파일</th><td class="left" colspan="5">test.txt</td>
				</tr>
		

				<tr>
					<td colspan="6"><textarea readonly="readonly" id="" name="" cols="100" rows="15">${detail.content}</textarea></td> 
					<!-- <td colspan="6">내용</td> -->
				</tr>
				
				<tr>
					<td class="right" colspan="6">
					  <button><a href="market_rewrite.ams?ref=${detail.ref}&board_idx=${detail.board_idx}">답글</a></button>
						<button><a href="market_list.ams">목록</a></button>
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
	      	<c:forEach items="${list}" var="m" varStatus="i">
	      		<tr>
	      			<td colspan="4">106-105 <span id="writer${i.index}">${m.writer}</span><sup>2016.03.29</sup></td>	  
	      			<td colspan="2" class="right"><a href="javascript:reply(${i.index})" id="reply${i.index}"><button value="${m.comment_idx}">수정</button></a>
	      			<a href="market_commentDel.ams?comment_idx=${m.comment_idx}&board_idx=${detail.board_idx}"><button>삭제</button></a><input type="hidden" id="idx${i.index}" value="${m.comment_idx}"></td> 		
	      		</tr>>
	      		<tr>
	      			<td colspan="6" id="content${i.index}">${m.content}</td>
	      		</tr>
	      	</c:forEach>
	   	     </table>	      
	      </div>
		  <!-- 덧글 수정 -->
		  <div id="reply_write2" hidden>
		  <form action="market_comment_Modify.ams" id="" method="post">
	        <input type="hidden" name="board_idx" value="${detail.board_idx}"> <!-- 내가 현재 reply을 다려는 글 번호를 알아야 함!  -->
	      	<table>
	      		<tr>
	      			<td colspan="2"><input type="text" name="writer" id="reply_id" value="RE:로그인한 아이디"></td>	
	      			<td colspan="4"><input type="hidden" id="comment_idx"></td>   
	      				
	      		</tr>
	      		
	      		<tr>
	      			<td colspan="5"><textarea name="content" rows="5" cols="100" id="reply_content">RE:댓글은 10자(20byte) 이상 입력해주세요</textarea></td>
	      		    <td class="right"><input type="submit" id="reply_submit" value="등록"></td>
	      		</tr>  	
	      	
	      	</table>
	      </form>
	      </div>
	      
	      <div id="reply_write">
	        <sub>통신예절에 어긋나는 글이나 상업적인 글, 
	        우리 아파트와 무관한 글은 관리자에 의해 사전 통보 없이 삭제 될 수 있습니다. </sub>
	        <form action="market_comment.ams" id="" method="post">
	        <input type="hidden" name="board_idx" value="${detail.board_idx}"> <!-- 내가 현재 reply을 다려는 글 번호를 알아야 함!  -->
	      	<table>
	      		<tr>
	      			<td colspan="2"><input type="text" name="writer" id="" value="로그인한 아이디"></td>	
	      			<td colspan="4"></td>   
	      					
	      		</tr>
	      		
	      		<tr>
	      			<td colspan="5"><textarea name="content" rows="5" cols="100">댓글은 10자(20byte) 이상 입력해주세요</textarea></td>
	      		    <td class="right"><input type="submit" value="등록"></td>
	      		</tr>  	
	      	
	      	</table>
	      </form>
	    
	      </div>

	      