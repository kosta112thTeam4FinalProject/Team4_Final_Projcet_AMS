<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function(){
				$('#save').click(function(){
					var info = {
									content : $('#commContent').val(), 
									writer : $('#commWriter').val(), 
									board_idx : $('#board_idx').val()
								};
					$.ajax({
						type : "POST",
						url : "complain_write_comment.ams",
						data : info,
						success : function(data){
							var comment = data.complaint_comment;
							var output="";
							output += "<tr>"
								output += "<td colspan='4'>"
									output += comment.writer
									output += "<sub>" + comment.regdate + "</sub>"
									output += "<button id='replyBtn_" + comment.comment_idx + "' value="+ comment.comment_idx +"><img src='./resources/images/replyComm.png' alt='답글'></button>"
								output += "</td>"
								output += "<td colspan='2' class='right'>"
									output += "<button id='replyModBtn' value=" + comment.comment_idx +">수정</button>"
									output += "<button id='replyDelBtn' value=" + comment.comment_idx + ">삭제</button>"
								output += "</td>"
							output += "</tr>"
							output += "<tr>"
								output += "<td colspan='6'>" + comment.content + "</td>"	
							output += "</tr>"
							output += "<div id= 'reply_" + comment.comment_idx + "'></div>";
							
							console.log(output);
							
							$('#reply_table').append(output);
						},
						
						error:function(xhr){
							alert(xhr.status + "Error");
						}
					});
				});
				
				
				$('button[id^="replyBtn_"]').on("click", function(){
					
					var reply = $(this);
					
					console.log("reply : " + reply);
					
					var info = {comment_idx : reply.val()}
					
					console.log("info : " + reply.val());
					
					$.ajax({
						type : "GET",
						url : "complain_rewrite_comment.ams",
						data : info,
						success : function(data){
							var comment = data.complaint_comment;
							console.log("comment : " + comment);
							var output = "";
							 output += "<input type='hidden' id='board_idx' value="+ comment.board_idx +">";
								 output += "<table>";
									output += "<tr>";
										output += "<td colspan='2'>";
											output += "<input type='text' name='writer' id='replyWriter'>";
										output += "</td>";
										output += "<td colspan='4'></td>";
									output += "</tr>";
									output += "<tr>";
										output += "<td colspan='5'>";
											output += "<textarea name='content' id='replyContent' rows='5' cols='100'></textarea>";
										output += "</td>";
										output += "<td class='right'>";
											output += "<button id = 'replySave'>등록</button>";
										output += "</td>";
									output += "</tr>";
								output +="</table>";
							
								console.log("replyBtn : " + output);
								console.log("댓글 번호 : " +  comment.comment_idx);
								
							console.log("reply _ comment_idx : " + "div[id='reply_" + comment.comment_idx + "']");
								
							$("div[id='reply_" + comment.comment_idx + "']").html(output);
							
						},						
	
						error:function(xhr){
							alert(xhr.status + "Error");
						}
					});
				});
				
				$('#replyModBtn').on("click", function(){
					var reply = $(this);
					
					var rno = reply.val();
					
					alert("rno : " + rno);
				})
			}			
	);
	
	$('#replyModBtn').on("click", function(){
		var rno = reply.attr("name");
		
		alert("rno : " + rno);
	})
</script>

<div id="title_bar">
	<span> 민원게시판 </span> <img src="./resources/images/complain_title.png">
</div>

<div id="board_content">
	<table>
		<tr>
			<th>제목</th>
			<td colspan="3">${complaint.title }</td>
			<td colspan="2" class="right">
				<button>
					<a href="complain_modify.ams?board_idx=${complaint.board_idx}&pg=${pg}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">수정</a>
				</button>
				<button>
					<a href="complain_delete.ams?board_idx=${complaint.board_idx}">삭제</a>
				</button>
			</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${complaint.regdate }</td>
			<th>작성자</th>
			<td>${complaint.writer }</td>
			<th>조회수</th>
			<td>${complaint.hit }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td class="left" colspan="5">test.txt</td>
		</tr>


		<tr>
			<td colspan="6">
				<textarea id="content" name="content" cols="100" rows="15">
					${complaint.content}
				</textarea>
			</td>
			<!-- <td colspan="6">내용</td> -->
		</tr>

		<tr>
			<td class="right" colspan="6">
				<button>
					<a href="complain_rewrite.ams?board_idx=${complaint.board_idx}&pg=${pg}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">답글</a>
				</button>
				<button>
					<a href="complain_list.ams?pg=${pg}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">목록</a>
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
	<table id="reply_table">
		<c:forEach var="comm" items="${comment}">
			<tr>
				<td colspan="4">
					${comm.writer } <sub>${comm.regdate }</sub>
					<button id="replyBtn_${comm.comment_idx}" value="${comm.comment_idx}"><img src="./resources/images/replyComm.png" alt="답글"></button>
				</td>
				<td colspan="2" class="right">
					<button id="replyModBtn" value="${comm.comment_idx}">수정</button>
					<button id="replyDelBtn" value="${comm.comment_idx}">삭제</button>
				</td>
			</tr>
			<tr>
				<td colspan="6">${comm.content}</td>
			</tr>
			
			 <div id="reply_${comm.comment_idx}">
			 
			 </div>
		</c:forEach>
	</table>
</div>

<div id="reply_write">
	<sub>통신예절에 어긋나는 글이나 상업적인 글, 우리 아파트와 무관한 글은 관리자에 의해 사전 통보 없이 삭제 될 수 있습니다. </sub>
		<input type="hidden" id="board_idx" value="${complaint.board_idx}">
		<table>
			<tr>
				<td colspan="2">
					<input type="text" name="writer" id="commWriter" placeholder="로그인한 아이디">
				</td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td colspan="5">
					<textarea name="content" id="commContent" rows="5" cols="100" placeholder="댓글은 10자(20byte) 이상 입력해주세요"></textarea>
				</td>
				<td class="right">
					<button id = "save">등록</button>
				</td>
			</tr>
		</table>
</div>
