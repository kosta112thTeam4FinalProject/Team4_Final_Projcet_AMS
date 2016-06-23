<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="./resources/SmartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
	var oEditors = [];
	$(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "content", //textarea에서 지정한 id와 일치해야 합니다. 
			//SmartEditor2Skin.html 파일이 존재하는 경로
			sSkinURI : "./resources/SmartEditor/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				fOnBeforeUnload : function() {

				}
			},
			/* fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["content"].exec("PASTE_HTML",
						[ "기존 DB에 저장된 내용을 에디터에 적용할 문구" ]);
			}, */
			fCreator : "createSEditor2"
		});

		//저장버튼 클릭시 form 전송
		$("#save").click(function() {
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		});
	});
</script>

	      
	      <div id="title_bar">	
	         <span> 민원게시판 </span> 
	         <img src = "./resources/images/complain_title.png">   	
	      </div>
	      
	      <div id="board_content">
	      <form action="complain_rewrite.ams" id="" method="post" enctype="multipart/form-data">
	      	<input type="hidden" name="board_idx" value="${complaint.board_idx}">
	        <input type="hidden" name="ref" value="${complaint.ref}" /> 
			<input type="hidden" name="depth" value="${complaint.depth}" /> 
			<input type="hidden" name="step" value="${complaint.step}" /> 
			<input type="hidden" name="pg" value="${pg}" />
			<input type="hidden" name="rowSize" value="${rowSize}" />
			<input type="hidden" name="order" value="${order}" />
			<input type="hidden" name="search" value="${search}" />
			<input type="hidden" name="period" value="${period}" />
			<input type="hidden" name="scope" value="${scope}" />
			
	       	<table>
				<tr>
					<th>카테고리</th>
					<td colspan="2">
						답글에는 카테고리 분류 선택을 하지 않을 예정				
					</td>
					<th> 작성자 </th>
					<td colspan="2">
						<input type="text" name="writer" id="" value="" >
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
						<input type="text" name="title" id="" value="[Re]${complaint.title}" >
					</td>
				</tr>
				<tr>
				 	<td colspan="6"><textarea id="content" name="content" cols="100" rows="15" >${complaint.content}
				 	</textarea></td> 
				</tr>
				<tr>
					<th>첨부파일</th><td colspan="5"></td>
				</tr>
							
				<tr>
					<td class="center" colspan="6">					    
						<input type="submit" name="" value="등록" onclick="">
						<button><a href="complain_list.ams?pg=${pg}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">취소</a></button>
					</td>				
				</tr>
				
			</table>	
	       	
	       	</form>       	
	      </div>
	      
	    
	  