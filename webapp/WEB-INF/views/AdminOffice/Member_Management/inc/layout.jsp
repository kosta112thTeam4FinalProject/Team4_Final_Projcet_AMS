<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- CSS3_반응형_가로폭 조정  -->
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<title><tiles:getAsString name="title"/></title>
		<%-- <link href='<tiles:getAsString name="css"/>' type="text/css" rel="stylesheet"/> --%> 
		
	    <link href="./css/base.css" type="text/css" rel="stylesheet" />
		<link href="./css/management.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	<!-- Header  영역  -->
	<tiles:insertAttribute name="header"/>
	
	<!-- Main 영역 -->
	<div id="ams-container">
	<tiles:insertAttribute name="content"/>
	</div>
	
	<!-- Footer  영역  -->
	<tiles:insertAttribute name="footer"/>
	</body>
</html>