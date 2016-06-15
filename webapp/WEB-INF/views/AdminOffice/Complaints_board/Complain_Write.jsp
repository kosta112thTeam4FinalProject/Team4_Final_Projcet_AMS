<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      
	      <div id="title_bar">	
	         <span> 민원게시판 </span> 
	         <img src = "./resources/images/complain_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="complain_write.ams" id="" method="post" enctype="multipart/form-data">
	       	<table>
				<tr>
				<!-- 민원게시판의 카테고리를 민원으로만 하기위해 추후 수정 예정  -->
					<th>카테고리</th>
					<td colspan="1">
						<select id="" name="">
							<option selected="selected">민원</option>
							<option>공지</option>
							<option>대표</option>
							<option>부녀회</option>
							<option>노인회</option>						
						</select>					
					</td>
					
					<td>
						<input type="checkbox" value=""  name="" id="">공지사항
					</td>
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="userid" id="" value="${memeber.userid}">
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
						<input type="text" name="noti_title" id="" >
					</td>
				</tr>
				<tr>
				 	<td colspan="6"><textarea id="" name="" cols="100" rows="15">
				 	 공지사항을 등록해주세요</textarea></td> 
				</tr>
				<tr>
					<th>첨부파일</th><td colspan="5"></td>
				</tr>
							
				<tr>
					<td class="center" colspan="6">					    
						<input type="button" name="" value="등록" onclick=""> <!--추후, 버튼으로 변경해서 유효성 검사  -->
						<button><a href="complain_list.ams">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
	    