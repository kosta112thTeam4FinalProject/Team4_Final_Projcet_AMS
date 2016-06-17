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
			fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["content"].exec("PASTE_HTML",
						[ "기존 DB에 저장된 내용을 에디터에 적용할 문구" ]);
			},
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
	<span> 민원게시판 </span> <img src="./resources/images/complain_title.png">
</div>

<div id="board_content">
	<form action="" id="frm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<!-- 민원게시판의 카테고리를 민원으로만 하기위해 추후 수정 예정  -->
				<!-- <th>카테고리</th>
					<td colspan="1">
						<select id="" name="">
							<option selected="selected">민원</option>
							<option>공지</option>
							<option>대표</option>
							<option>부녀회</option>
							<option>노인회</option>						
						</select>					
					</td>
					 -->
				<td><input type="checkbox" value="Y" name="notice" id="">공지사항
				</td>
				<th>작성자</th>
				<td colspan="2">
					<input type="text" name="writer" id="writer">
				</td>

			</tr>
			<tr>
				<th>설문조사</th>
				<td colspan="2">
					<button>
						<a href="">설문조사 등록</a>
					</button>
				</td>

				<th>파일 첨부</th>
				<td colspan="2">
					<button>
						<a href="#this" class="btn" id="addFile">파일 첨부</a>
					</button>
				</td>

			</tr>

			<tr>
				<th>제목</th>
				<td colspan="5"><input type="text" name="title" id="title">
				</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="content" name="content" cols="100" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="5"></td>
			</tr>

			<tr>
				<td class="center" colspan="6">
				<!-- <input type="submit" name="" value="등록" onclick=""> --> <!--추후, 버튼으로 변경해서 유효성 검사  -->
				<button id="save">
					등록
				</button>
					<button>
						<a href="complain_list.ams">취소</a>
					</button></td>
			</tr>
		</table>
	</form>
</div>
