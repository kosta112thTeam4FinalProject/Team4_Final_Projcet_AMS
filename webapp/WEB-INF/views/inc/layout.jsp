<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- CSS3_반응형_가로폭 조정  -->
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<title>index</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	
	<!-- Notification -->
	<tiles:insertAttribute name="Message_Notification"/>
	
	<!-- Header  영역  -->
	<tiles:insertAttribute name="header"/>
	
	<!-- Main 영역 -->
	<%-- <div id="main">
		<div class="top-wrapper clear">
		<tiles:insertAttribute name="content"/>
		</div>	
	</div> --%>
	<div id="ams-container">
	<tiles:insertAttribute name="content"/>
	</div>
	
	<!-- Footer  영역  -->
	<tiles:insertAttribute name="footer"/>
	</body>
</html>