<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">

//채팅 사이트 연결
	$(function(){
		console.log("test");
		
		$('#chat').click(function(){
			var url = "http://192.168.0.131:8090/Team4_Final_Project_AMS/resources/websocket/page.html";
			console.log("확인 : " + url);
			window.open(url, "reqreg", "width=400, height=400, scrollbars=no, resizeable=no");
		});
	});
	
	
</script>
</head>
<body>
<button type="button" id="chat">채팅</button>
</body>
</html>