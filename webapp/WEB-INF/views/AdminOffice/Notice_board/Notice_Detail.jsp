<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id="title_bar">
	<span> 공지사항 </span> <img src="./resources/images/notice_title.png">
</div>

<div id="board_content">
	<table>
		<tr>
			<th>제목</th>
			<td colspan="3">${detail.title }</td>
			<td colspan="2" class="right">
				<button>
				<!-- 페이징 처리를 해줄때, board_idx 값을 맞춰서 그 해당 내용이 전달되게 해야한다. -->
					<a href="notice_modify.ams?board_idx=${detail.board_idx }">수정</a>
				</button>
				<button>
					<a href="notice_delete.ams?board_idx=${detail.board_idx }">삭제</a>
				</button>
			</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${detail.regdate }</td>
			<th>작성자</th>
			<td>${detail.writer}</td>
			<th>조회수</th>
			<td>${detail.hit+1 }</td><!-- 해당 글을 클릭했을때 조회수가 증가된 상태로 봐야하기 때문에 +1을 해준다 -->
		</tr>
		<tr>
			<th>첨부파일</th>
			<td class="left" colspan="5">text.txt</td>
		</tr>


		<tr>
		<!-- 본문내용 -->
			<td colspan="6">
			<textarea  id="" name="" cols="100" rows="15" readonly="readonly">
				${detail.content }
			</textarea>
			</td>
		</tr>

		<tr>
			<td class="right" colspan="6">
				<button>
					<a href="notice_rewrite.ams?board_idx=${detail.board_idx }">답글</a>
				</button>
				<button>
					<a href="notice_list.ams">목록</a>
				</button>
			</td>

		</tr>

		<tr>
			<td>이전글</td>
			<td colspan="5">이전글 제목</td>
		</tr>

		<tr>
			<td>다음글</td>
			<td colspan="5">다음글 제목</td>
		</tr>
	</table>
</div>

<div id="board_reply">

	<table>
		<tr>
			<td colspan="4">106-105 <sup>2016.03.29</sup></td>
			<td colspan="2" class="right"><button>수정</button>
				<button>삭제</button></td>
		</tr>
		<tr>
			<td colspan="6">댓글 내용</td>
		</tr>
	</table>
</div>

<div id="reply_write">
	<sub>통신예절에 어긋나는 글이나 상업적인 글, 우리 아파트와 무관한 글은 관리자에 의해 사전 통보 없이 삭제 될
		수 있습니다. </sub>
	<form action="" id="" method="post">
		<input type="hidden" name="idx" value="${notice.reply_write }">
		<!-- 내가 현재 reply을 다려는 글 번호를 알아야 함!  -->
		<table>
			<tr>
				<td colspan="2"><input type="text" name="" id=""
					value="로그인한 아이디"></td>
				<td colspan="4"></td>

			</tr>

			<tr>
				<td colspan="5"><textarea rows="5" cols="100">댓글은 10자(20byte) 이상 입력해주세요</textarea></td>
				<td class="right"><input type="submit" value="등록"></td>
			</tr>

		</table>
	</form>

</div>

