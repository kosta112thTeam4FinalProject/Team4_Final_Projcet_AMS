<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      
	      <div id="title_bar">	
	         <span> 벼룩시장 </span> 
	         <img src = "./resources/images/market_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="market_modify.ams" id="" method="post" enctype="multipart/form-data">
	       	<input type="hidden" name="board_idx" value="${modify.board_idx}" /> <!-- 글 번호  -->
	       	<table>
				<tr>
					<th>카테고리</th>
					<td>
						<select id="kind" name="kind">
							<option selected="selected">선택</option>
							<option>팝니다</option>
							<option>삽니다</option>
							<option>기타</option>												
						</select>					
					</td>
					<td>
						<input type="checkbox" value="Y"  name="notice" id="">공지사항
					</td>
					
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="writer" id="" value="writer" >
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
						<input type="text" name="title" id="" value="${modify.title}" >
					</td>
				</tr>
				<tr>
				 	<td colspan="6"><textarea id="" name="content" cols="100" rows="15" >
				 	${modify.content}</textarea></td> 
				</tr>
				<tr>
					<th>첨부파일</th><td colspan="5"></td>
				</tr>
							
				<tr>
					<td class="center" colspan="6">					    
						<input type="submit" name="" value="수정완료"> <!--추후, 버튼으로 변경해서 유효성 검사  -->
						<button><a href="market_list.ams">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
	    
	      
	    