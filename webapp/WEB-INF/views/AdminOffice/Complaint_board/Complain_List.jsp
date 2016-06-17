<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
<%
	SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
	Date d = new Date();
	
	Date d2 = df.parse(df.format(d));

%>
 --%>
 
<!-- <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"uploadAjax.ams",
			data:formData,
			dataType:"text",
			processData:false,
			contentType:false,
			type:"POST",
			
			success: function(data){
				
				console.log(data);
				console.log(checkImageType(data));
				
				var str = "";
				if(checkImageType(data)){
					
					str ="<div>"
						+"<a href=displayFile?fileName="+getImageLink(data)+">"
						+"<img src='displayFile.ams?fileName="+data+"'/>"
						+ "</a><small data-src="+data+">X</small></div>";
				} else{
					str = "<div><a href='displayFile.ams?fileName="+data+"'>"
						+ getOriginalName(data) +"</a>"
						+ "<small data-src=" + data + ">X</small></div>"
				}
				
				$(".uploadedList").append(str);
			},
			error:function(xhr){
				alert(xhr.status + "Error");
			}
		})
	});
</script> -->

<div id="title_bar">
	<span> 민원게시판 </span> <img src="./resources/images/complain_title.png">
</div>


<div id="board_top">
	<form name="board_list" action="">
		<!-- form tag에 action이 없으면 현재 URL 주소로 submit -->
		<select name="rowSize" onchange="submit()">
			<c:forEach var="i" begin="10" end="50" step="10">
				<c:choose>
					<c:when test="${rowSize == i}">
						<option value='${i}' selected>${i}건</option>
					</c:when>
					<c:otherwise>
						<option value='${i}'>${i}건</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> 
		<input type="hidden" name="pg" value="${pg}">
		<input type="hidden" name="order" value="${order}">
		<input type="hidden" name="search" value="${search}">
		<input type="hidden" name="period" value="${period}">
		<input type="hidden" name="scope" value="${scope}">
	</form>
</div>
<div>
	<a href="complain_list.ams?pg=${pg}&rowSize=${rowSize}&order=regdate&search=${search}&period=${period}&scope=${scope}">최신순</a> | 
	<a href="complain_list.ams?pg=${pg}&rowSize=${rowSize}&order=hit&search=${search}&period=${period}&scope=${scope}">조회순</a>
</div>


<div id="board">
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="complaint">
				<tr>
					<td>
						<c:if test="${complaint.notice == 'Y' }">
							<img src="./resources/images/notice_tag.png">
						</c:if> 
						<c:if test="${complaint.notice == 'N' }">
							${complaint.board_idx}
						</c:if>
						<a href="complain_detail.ams?board_idx=${complaint.board_idx}&pg=${pg}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">
							${complaint.title} </a> 
							
							<!-- 새글 new 사진 띄우기 --> <%-- 
					<%
						Date d3 = df.parse ( %> ${complaint.regdate} <% );
					
						if(d2.getDay() - d3.getDay() == 0 )
						{ %>
						
							<img src ="./resources/images/new.gif" alt="새글"/>
							
					<% 	}  %>
					 --%>
					</td>
					<td>${complaint.writer}</td>
					<td>${complaint.regdate}</td>
					<td>${complaint.hit}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<button class="reg_button">
		<a href="complain_write.ams">등록</a>
	</button>
</div>


<div id="board_page">
	<c:if test="${pg > 1 }">
		<a href="complain_list.ams?pg=${pg - 1}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">[이전]</a>
	</c:if>
	<ul>
		<c:forEach begin="${fromPage }" end="${toPage }" var="i">
			<c:if test="${pg == i }">
				<li><a class=strong href="">${i}</a></li>
			</c:if>
			<c:if test="${pg != i}">
				<li><a href="complain_list.ams?pg=${i}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">${i}</a></li>
			</c:if>
		</c:forEach>
	</ul>
	<c:if test="${pg < pageCount}">
		<a href="complain_list.ams?pg=${pg + 1}&rowSize=${rowSize}&order=${order}&search=${search}&period=${period}&scope=${scope}">[다음]</a>
	</c:if>
</div>


<div id="board_search">
	<form class="search_form" id="complain_search" action="" method="GET">
		
		<input type="hidden" name="pg" value="1">
		<input type="hidden" name="rowSize" value="10">
		<input type="hidden" name="order" value="${order}">
		
		<select id="" name="period">
			<option value="all" selected>전체기간</option>
			<option value="day">1일</option>
			<option value="week">1주일</option>
			<option value="month">1개월</option>
			<!-- <option value="type">기간입력</option> -->
		</select>
		<select id="" name="scope">
			<option value="titleNContent" selected>제목 + 내용</option>
			<option value="title">제목만</option>
			<option value="writer">글작성자</option>
			<option value="commContent">댓글내용</option>
			<option value="commWriter">댓글작성자</option>
		</select> 
		
		<input type="text" id="" name="search"> 
		<input type="submit" id="" name="" value="검색">
	</form>
</div>


