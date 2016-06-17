<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="ams-container">
	<div id="ams-header">

		<div id="ams-logo">
			<a href="index.ams"><img alt="home"
				src="./resources/images/home.png"></a>Kosta 아파트
		</div>

		<div id="ams-login">
			<form action="">
				<input type="text" id="" name="" placeholder="아이디" /> <input
					type="password" id="" name="" placeholder="비밀번호" /> <input
					type="submit" id="" name="" value="로그인" />
			</form>
		</div>

		<div id="ams-header-menu">
			<a href="">회원가입</a> | <a href="">비밀번호찾기</a>

		</div>
	</div>

	<div id="ams-menu">
		<ul>

			<li><a href="${pageContext.request.contextPath}/apt_intro.ams">아파트 소개</a>
				<ul>
					<li><a href="">단지 소개</a></li>
					<li><a href="">단지 위치</a></li>
					<li><a href="">단지 배치도</a></li>
					<li><a href="">단지 평형도</a></li>
					<li><a href="">편의 시설</a></li>
				</ul></li>

			<li><a href="#news">관리사무소</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/complain_list.ams">민원
							접수처리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/notice_list.ams">공지사항</a></li>
					<li><a href="${pageContext.request.contextPath}/apt_calendar.ams">아파트 일정</a></li>
					<li><a href="">운영정보공개</a></li>
					<li><a href="">관리소 소개</a></li>
					<li><a href="">회원관리</a></li>
					<li><a href="">배너관리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/staff_list.ams">직원전용
							게시판</a></li>
				</ul></li>

			<li><a href="#contact">자치기구</a>
				<ul>
					<li><a href="">대표회의</a></li>
					<li><a href="">부녀회</a></li>
					<li><a href="">노인회</a></li>
				</ul></li>

			<li><a href="#about">입주민 공간</a>
				<ul>
					<li><a href="">온라인 반상회</a></li>
					<li><a
						href="${pageContext.request.contextPath}/market_list.ams">벼룩시장</a></li>
					<li><a
						href="${pageContext.request.contextPath}/anonymous_list.ams">익명게시판</a></li>
				</ul></li>
			<li><a href="#about">아파트 관리비</a>
				<ul>
					<li><a href="">관리비조회</a></li>
					<li><a href="">에너지사용량조회</a></li>
					<li><a href="">관리비등록</a></li>
				</ul></li>
				

		</ul>
		
	</div>
</div>

	<!--  <div id="ams-side_1"></div>
	      <div id="ams-side_2"></div>	  -->