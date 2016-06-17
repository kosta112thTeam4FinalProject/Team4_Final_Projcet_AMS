<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      <div id="title_bar">	
	         <span> 벼룩시장 </span> 
	         <img src = "./resources/images/market_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="market_rewrite.ams" id="" method="post" enctype="multipart/form-data">
	        <input type="hidden" name="cp" value="" /> 
			<input type="hidden" name="ps" value="" /> 
			<input type="hidden" name="ref" value="${reply.ref}" /> <!-- 참조 글번호  -->
			<input type="hidden" name="step" value="${reply.step}" /> <!-- step -->
			<input type="hidden" name="depth" value="${reply.depth}" /> <!-- depth -->
			<input type="hidden" name="kind" value="${reply.kind}" /> <!-- 카테고리 -->
	       	<table>
				<tr>
					<th>카테고리</th>
					<td colspan="2">
						<!-- <select id="" name="">
							<option selected="selected">선택</option>
							<option>공지</option>
							<option>대표</option>
							<option>부녀회</option>
							<option>노인회</option>						
						</select> -->	
						답글에는 카테고리 분류 선택을 하지 않을 예정  ${reply.kind}				
					</td>
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="writer" id="" value="${memeber.userid}" >
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
						<input type="text" name="title" id="" value="[Re]${reply.title}" >
					</td>
				</tr>
				<tr>
				 	<td colspan="6"><textarea id="" name="content" cols="100" rows="15" >
				 	원본글의 내용이 보여질 예정${reply.content}</textarea></td> 
				</tr>
				<tr>
					<th>첨부파일</th><td colspan="5"></td>
				</tr>
							
				<tr>
					<td class="center" colspan="6">					    
						<input type="submit" name="" value="등록"> <!--추후, 버튼으로 변경해서 유효성 검사  -->
						<button><a href="market_list.ams">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
	    