<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- CSS3_반응형_가로폭 조정  -->
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<title><tiles:getAsString name="title"/></title>
		<link href='<tiles:getAsString name="css"/>' type="text/css" rel="stylesheet"/> 
		
	    <link href="./css/base.css" type="text/css" rel="stylesheet" />
	 <link href="./css/board.css" type="text/css" rel="stylesheet" />
		<!-- <link href="./css/fullcalendar.css" type="text/css" rel="stylesheet" />
		<link href="./css/fullcalendar.print.css" type="text/css" rel="stylesheet" /> -->
		<link rel='stylesheet' type='text/css' href='http://arshaw.com/css/main.css?6' />
		<link rel='stylesheet' type='text/css' href='http://arshaw.com/css/fullcalendar.css?3' />
		<link rel='stylesheet' type='text/css' href='http://arshaw.com/js/fullcalendar-1.6.3/fullcalendar/fullcalendar.css' /> 
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
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS3_반응형_가로폭 조정  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:getAsString name="title" /></title>
<%-- <link href='<tiles:getAsString name="css"/>' type="text/css" rel="stylesheet"/> --%>
<!-- <script src="//code.jquery.com/jquery-1.12.0.min.js"></script> -->
<link href="./css/base.css" type="text/css" rel="stylesheet" />
<link href="./css/board.css" type="text/css" rel="stylesheet" />
<!-- <link href="./css/fullcalendar.css" type="text/css" rel="stylesheet" />
		<link href="./css/fullcalendar.print.css" type="text/css" rel="stylesheet" /> -->
<!-- <link rel='stylesheet' type='text/css' href='http://arshaw.com/css/main.css?6' />
		<link rel='stylesheet' type='text/css' href='http://arshaw.com/css/fullcalendar.css?3' />
		<link rel='stylesheet' type='text/css' href='http://arshaw.com/js/fullcalendar-1.6.3/fullcalendar/fullcalendar.css' />  -->


</head>
<body>

	<!-- Header  영역  -->
	<tiles:insertAttribute name="header" />

	<!-- Main 영역 -->
	<div id="ams-container">
		<tiles:insertAttribute name="content" />
	</div>

	<!-- Footer  영역  -->
	<tiles:insertAttribute name="footer" />
</body>
</html>