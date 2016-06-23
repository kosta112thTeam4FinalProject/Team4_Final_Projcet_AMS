<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<div id="title_bar">
		<span> 회원관리 </span> <img
			src="./resources/images/title_bar/membermange_title.png">
	</div>

	<div id="management_memu">

		<a href="member_list.ams"><img id="btnmemberlist_1"
			src="./resources/images/member/Be_member_list.png"></a> <a
			href="member_list.ams"><img id="btnmemberlist_2"
			src="./resources/images/member/Af_member_list.png"></a> &nbsp;
		&nbsp;&nbsp;&nbsp;
		<!-- 회원등록 -->
		<a href="member_Register.ams"><img
			src="./resources/images/member/Be_member_reg.png"></a>
		<!-- <a href =""><img src="./resources/images/member/Af_member_reg.png"></a> -->


	</div>

	<div id="members">
		<table id="member_list">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>세대주명</th>
					<th>이메일</th>
					<th>연락처</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${member}">
					<tr>
						<td>${member.addr_1 }</td>
						<td>${member.userid }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.phone }</td>
						<td>${member.birthday }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<div id="member_list_page">

		<!-- 이전  -->
		<c:if test="${pg>1}">
			<!-- 이전 페이지가 있는 경우  -->
			<a href="member_list`.ams?pg=${pg-1}">[이전]</a>
		</c:if>


		<!-- 1,2,3.....  -->
		<ul>
			<c:forEach begin="${fromPage}" end="${toPage}" var="i">
				<c:if test="${i==pg}">
					<li style="color: red">${i}</li>
				</c:if>
				<c:if test="${i!=pg}">
					<li><a href="member_list.ams?pg=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
		</ul>

		<!-- 다음  -->
		<c:if test="${pg < pageCount}">
			<a href="member_list.ams?pg=${pg+1}">[다음]</a>
		</c:if>

	</div>

	<div id="member_search">
		<form id="" action="" method="post">

			<select name="info">
				<option value="userid" selected>아이디</option>
				<option value="name">세대주명</option>
				<option value="email">이메일</option>
			</select> 
			
			<input type="text" name="search"> 
			<input type="submit" value="검색">

		</form>

	</div>

</body>
</html>

