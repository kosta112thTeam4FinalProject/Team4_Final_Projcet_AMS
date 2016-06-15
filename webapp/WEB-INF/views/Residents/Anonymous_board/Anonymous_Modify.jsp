<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	      
	      <div id="title_bar">	
	         <span> 익명게시판 </span> 
	         <img src = "./resources/images/anonymous_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="anonymous_modify.ams" id="" method="post" enctype="multipart/form-data">
	       	<input type="hidden" name="noti_idx" value="" /> <!-- 글 번호  -->
	       	<table>	       	   
	       	  			
				<tr>								
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="userid" id="" value="${member.userid }" >
					</td>
					
					<th> 닉네임 </th>
					<td colspan="2">
						<input type="text" name="userid" id="" value="등록시 사용한 닉네임" >
					</td>					
					
				</tr>
				<tr>
					<th> 설문조사 </th>
					<td colspan="2">
						<button><a href="">설문조사 등록</a></button>					
					</td>
					
					<th> 파일 첨부 </th>
					<td colspan="2">
						<button><a href="">파일첨부</a></button>					
					</td>
							
				</tr>
				
				 <tr>
					<th>제목</th>
					<td colspan="5">
						<input type="text" name="noti_title" id="" value="수정할 글의 제목${anonymous.noti_title}" >
					</td>
				</tr>
				
				<tr>
				 	<td colspan="6"><textarea id="" name="" cols="100" rows="15" >
				 	수정할 글의 내용이 보여질 예정${anonymous.noti_content}</textarea></td> 
				</tr>
				<tr>
					<th>첨부파일</th><td colspan="5"></td>
				</tr>
							
				<tr>
					<td class="center" colspan="6">					    
						<input type="button" name="" value="수정완료" onclick=""> <!--추후, 버튼으로 변경해서 유효성 검사  -->
						<button><a href="anonymous_list.ams">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
	    