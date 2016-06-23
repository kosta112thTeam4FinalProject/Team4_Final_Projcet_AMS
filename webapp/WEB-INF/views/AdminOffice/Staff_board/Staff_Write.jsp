<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>	
	      <div id="title_bar">	
	         <span> 직원 전용 게시판 </span> 
	         <img src = "./resources/images/staff_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="staff_write.ams" id="" method="post" enctype="multipart/form-data">
	       	<table>
				<tr>
					<th>카테고리</th>
					<td colspan="2">
						<input type="checkbox"	name="" value="">공지사항	
					</td>
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="writer" id="writer" value="${member.writer}">
					</td>				
					
				</tr>
				<tr>
					<th> 설문조사 </th>
					<td colspan="2">
						<button><a href="">설문조사 등록</a></button>					
					</td>
					
					<th> 파일 첨부 </th>
					<td colspan="2">
 					 <input type="file" id="file" name="file_0"> 
					<a href="#this" class="btn" id="delete" name="delete">삭제</a> 
					</td>
							
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5">
						<input type="text" name="title" id="title" >
					</td>
				</tr>
				<tr>
				 	<td colspan="6"><textarea id="content" name="content" cols="100" rows="15">
				 	 공지사항을 등록해주세요</textarea></td> 
				</tr>
				<tr>
				 	<th><a href="#this" class="btn" id="addFile">파일 추가</a></th> 
					<td colspan="5"></td>
				</tr>
				
											
				<tr>
					<td class="center" colspan="6">					    
						<input type="submit" name="" value="등록" onclick=""> <!--추후, 버튼으로 변경해서 유효성 검사  -->
						<button><a href="staff_list.ams">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js">
	var gfv_count = 1;

	$(document).ready(function() {
		$("#list").on("click", function(e) { //목록으로 버튼
			e.preventDefault();
			fn_openBoardList();
		});

		$("#write").on("click", function(e) { //작성하기 버튼
			e.preventDefault();
			fn_insertBoard();
		});

		$("#addFile").on("click", function(e){ //파일 추가 버튼
            e.preventDefault();
            fn_addFile();
        });
         
		$("a[name='delete']").on("click", function(e) { //삭제 버튼
			e.preventDefault();
			fn_deleteFile($(this));
		});
	});

	function fn_openBoardList() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardList.do' />");
		comSubmit.submit();
	}

	function fn_insertBoard() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/sample/insertBoard.do' />");
		comSubmit.submit();
	}

	function fn_addFile() {
		var str = "<p><input type='file' name='file_" + (gfv_count++)
				+ "'><a href='#this' class='btn' name='delete'>삭제</a></p>";
		$("#fileDiv").append(str);
		$("a[name='delete']").on("click", function(e) { //삭제 버튼
			e.preventDefault();
			fn_deleteFile($(this));
		});
	}

	function fn_deleteFile(obj) {
		obj.parent().remove();
	}
</script> 

	      
	      
	    
	     