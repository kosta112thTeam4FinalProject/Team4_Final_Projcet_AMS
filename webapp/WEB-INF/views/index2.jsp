<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		
		<!-- CSS3_반응형_가로폭 조정  -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Main_UI_테스트</title>
		
	<!-- 	<style type="text/css">
			#ams-container {
				width: 80%;
				height:100%;
				margin: 0px auto;
				padding: 20px;
				border-: 1px solid #bcbcbc;
				
			}
			
			#ams-side_1 {
			
				 width:20%;
				 height:100%;
				 float:left;
				 background-color:gray;	
				 border:1px groove black;		
			}
			
			#ams-side_2 {
			
				 width:20%;
				 height:100%;
				 float:right;
				 background-color:gray;	
				  border:1px groove black;			
			}
						
			#ams-header {
			    /* width:80%; */
				padding: 20px;
				margin-bottom: 20px;				
				border-bottom: 1px solid #bcbcbc;
				/* position: relative; */
				
			}
		
			#ams-logo
			{
				float:inherit;
				/* margin:0 150px 0 0;  */
				font-family: 맑은고딕;
				font-size: 18px;
				font-weight: bold;
				color:darkglay;			
			}
			#ams-logo img{
			    
			 	width: 30px;
   				height: 30px;
			}
			
			#ams-logo img a{
				display: block;
				text-decoration: none;		
			}
			
			#ams-log img a:hover{			
				opacity: 0.4;			
			}
			
		
		    #ams-login{
				float:right;
				margin : 0 0 150 20 
				border:1px solide gray;
				/* box-sizing: border-box; */
			
			}
			
			#ams-header-menu{
				float:inherit;
	            font-family: 맑은고딕;
	            font-size: 13px;        
			
			}
			
			#ams-header-menu a{			
			 	text-decoration: none;	
			
			} 
			
			#ams-header-menu a:hover{			
			 	font-color:gray;
			
			}			
						
			#ams-menu{	
			    width:80%;					 
				padding: 20px;
				padding-top:0px;
				margin-bottom: 20px;
				/* border: 1px solid #bcbcbc; */			
			}
			
			ul {
				list-style-type: none;
			    margin: 0;
			    padding: 0;
			    overflow: hidden;
			    /* border: 1px solid #e7e7e7; */
			    background-color: none;
			    font-family: Verdana,Geneva, sans-serif;
			    font-size:13px	
			
			}
			
			ul ul {
				display:none;
				position:absolute;
				background-color:#EFFBEF;
				
			}
			
			ul ul li {
			   float:none;
			   position: relative;
			   color: gray;
			}
			
			 ul li:hover ul {
			 	display:list-item;
			 	
			 }
			 
			 ul li li a:hover{
			 
			 	border-bottom: 1px groove red;
			 }
			
			li {
    			float: left;
    			margin:0 5 px;
			}

			li a {
			    display: block;
			    color: #666;
			    text-align: center;
			    /* padding: 14px 16px; */
			    padding:10px;
			    text-decoration: none;
			}

			li a:hover/* :not(.active) */ {
			    /* background-color: #ddd; */
			    background-image: url(./resources/images/blue.gif);
			    background-repeat: repeat-x;
			    background-position: bottom;			    
			}

			/* li a.active {
			    color: white;
			    background-color: #4CAF50;
			} */
					
			
			#main_img{			
			   /*  width: 100%;  */
				padding: 20px;
				padding-bottom : 0px;
				/* margin-bottom: 20px; */
				/* border: 1px solid #bcbcbc; */
				
				/*  width:971px;  */
				/* width:100%;  */
				/* height:400px; */
				max-width:1024px; max-height:400px; /* width:100%; height:100%;  */
			    /* background-image: url(./resources/images/img_back.png);
			    background-repeat: no-repeat;
			    background-position: center top; */       
			    		    
			}
			
			#main_img img{
				margin:10px 0 60px 50px;
				/* float:none; */
				/* width:95%; */
				width:971px;
				height: 350px;
			    position: center; 
				/* position: relative; */
				border-radius:10px;
			/* 	border-bottom-right-radius:10px;
				border-bottom-left-radius:10px; */
			}
			
			#menu_box {
				/* width: 80%; */
				/* height:100px; */
				padding: 20px;
				padding-top : 0px;
				margin-bottom: 20px;
				border-bottom: 1px solid #bcbcbc;
						
			}			
			
			#ams-box_2 {
				/* width: 80%; */
				height:210px;
				padding: 20px;
				padding-bottom:0px;
				margin-bottom: 0px;
				/* border: 1px solid #bcbcbc; */
			}
			
			#main-preview_1 {
			
				-webkit-column-count: 3; /* Chrome, Safari, Opera */
   				-moz-column-count: 3; /* Firefox */
   				-webkit-column-gap:20px;
   				column-count:3;
   				column-gap:20px;
   				column-rule-color:gray;			
			}
			
			#main-div_1 {
			
				height:200px;
				padding:5px;
				padding-right:5px;
				width:30%;
				float:left;
				/* border:1px groove black; */	
				margin-left:15px;		
			} 
			
			#main-div_2 {
			
				height:200px;
				padding:5px;
				padding-right:5px;
				width:30%;
				float:left;
				/* border:1px groove black;	 */		
			} 
			
			#main-div_3 {
			
				height:200px;
				padding:5px;
				padding-right:5px;
				width:30%;
				float:left;
				/* border:1px groove black;	 */		
			} 
			
			#ams-box_3 {
				/* width: 80%; */
				height:210px;
				padding: 20px;
				padding-top:0px;
				margin-bottom: 20px;
				/* border: 1px solid #bcbcbc; */
			}
			
			#main-div_4 {
			
				height:200px;
				padding:2px;
				padding-right:5px;
				margin-left:10px;
				width:23%;
				float:left;
				/* border:1px groove black;		 */	
			} 
			
			#main-div_5 {
			
				height:200px;
				padding:2px;
				padding-right:5px;
				width:23%;
				float:left;
				/* border:1px groove black;		 */	
			} 
			
			#main-div_6 {
			
				height:200px;
				padding:2px;
				padding-right:5px;
				width:23%;
				float:left;
				/* border:1px groove black;		 */	
			} 
			
			#main-div_7 {
			
				height:200px;
				padding:2px;
				padding-right:5px;
				width:23%;
				float:left;
				/* border:1px groove black;	 */		
			} 
			
			/* #main_table {
				
				/* border-collapse:collpase; */ /* border사이의 간격 없앰 
				border: 3px solid black;	
				width:;
			
			}
			
			#main_table td {
			    border: 1px solid black;
			}	 */	
							
			#ams-footer {
				clear: both;
				padding: 20px;
				height :100px;
				border-top: 1px solid #bcbcbc;
				
			}
			
			#ams-logo_2 img{
			    
			 	width: 50px;
   				height: 50px;
   				float:left;
			}
			
			#footer_div {
				float :right;
				margin: 0 0 30px 100px;
				font-family: 맑은고딕;
				color: lightgray;
			
			}
			
			/* Drop Down Menu  */
			.dropbtn {
			    background-color: #4CAF50;
			    color: white;
			    padding: 16px;
			    font-size: 16px;
			    border: none;
			    cursor: pointer;
			}
			
			.dropdown {
			    position: relative;
			    display: inline-block;
			}
			
			.dropdown-content {
			    display: none;
			    position: absolute;
			    background-color: #f9f9f9;
			    min-width: 160px;
			    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			}
			
			.dropdown-content a {
			    color: black;
			    padding: 12px 16px;
			    text-decoration: none;
			    display: block;
			}
			
			.dropdown-content a:hover {background-color: #f1f1f1}
			
			.dropdown:hover .dropdown-content {
			    display: block;
			}
			
			.dropdown:hover .dropbtn {
			    background-color: #3e8e41;
			}
		
			@media all screen and (max-width:300px) {
				#ams-container {
					width: auto;
				}
				#menu_box {
					float: none;
					width: auto;
					height: auto;
				} 
			    #main-img{
			  		float: none;
					width: auto;
					height: auto;			    
			    }
				#ams-box_2 {
					float: none;
					width: auto;
					height: auto;
				}
				
				#ams-box_3 {
					float: none;
					width: auto;
					height: auto;
				}
				#ams-side_1{
					float: none;
					width: auto;
					height: auto;			
				}
				#ams-side_2{
					float: none;
					width: auto;
					height: auto;			
				}
				
				.dropdown {
				
					float: none;
					width: auto;
					height: auto;				
				}					
			}
		</style> -->
		
	</head>
	<body>
		<div id="ams-container">
	      <div id="ams-header">
	       
	        <div id="ams-logo">
	         <a href ="index.ams"><img alt="home" src="./resources/images/home.png"></a>Kosta 아파트
	        </div>
	        
	        <div id="ams-login">
		        <form action="" >
		        	<input type="text" id="" name="" placeholder="아이디"/>
		        	<input type="password" id="" name="" placeholder="비밀번호"/>
		        	
		        	<input type="submit" id="" name="" value="로그인"/>		        
		        </form>
	        </div>
	        
	        <div id="ams-header-menu">
	        	<a href ="">회원가입</a> |
	        	<a href ="">비밀번호찾기</a>
	        
	        </div>
	      </div>
	      
	      <div id="ams-menu">
	      	<ul>
	      	 
			  <li><a href="">아파트 소개</a>
			   	<ul>
			   <li><a href="">단지 소개</a></li>
			   <li><a href="">단지 위치</a></li>
			   <li><a href="">단지 배치도</a></li>
			   <li><a href="">단지 평형도</a></li>
			   <li><a href="">편의 시설</a></li>
			    </ul>
			   </li>
		
			  <li><a href="#news">관리사무소</a>
			  	<ul>
			  	  <li><a href="${pageContext.request.contextPath}/complain_list.ams">민원 접수처리</a></li>
				   <li><a href="${pageContext.request.contextPath}/notice_list.ams">공지사항</a></li>
				   <li><a href="">아파트 일정</a></li>
				   <li><a href="">운영정보공개</a></li>
				   <li><a href="">관리소 소개</a></li>
				   <li><a href="">회원관리</a></li>
			  	   <li><a href="">배너관리</a></li>
 			       <li><a href="${pageContext.request.contextPath}/staff_list.ams">직원전용 게시판</a></li> 			  	
			  	</ul>		  
			  </li>
			  
			  <li><a href="#contact">자치기구</a>
			  	<ul>
			  	  <li><a href="">대표회의</a></li>
				   <li><a href="">부녀회</a></li>
				   <li><a href="">노인회</a></li>				 	  	
			  	</ul>			  
			  </li>
			  
			  <li><a href="#about">입주민 공간</a>
			  	<ul>
			  	  <li><a href="">온라인 반상회</a></li>
				   <li><a href="${pageContext.request.contextPath}/market_list.ams">벼룩시장</a></li>
				   <li><a href="${pageContext.request.contextPath}/anonymous_list.ams">익명게시판</a></li>				 	  	
			  	</ul>		  
			  </li>
			  <li><a href="#about">아파트 관리비</a>
			  	<ul>
			  	  <li><a href="">관리비조회</a></li>
				   <li><a href="">에너지사용량조회</a></li>
				   <li><a href="">관리비등록</a></li>				 	  	
			  	</ul>	
			  
			  </li>
			</ul> 					      
	      </div>
	      
	     <!--  <div id="ams-side_1"></div>
	      <div id="ams-side_2"></div>	  -->	    
	  
	      <div id="main_img">
	      	<img src="./resources/images/apt_img.jpeg"> 
	    
	      </div>
	      
	      <div id="menu_box">
	       <ul>
	        
	      	<li><a href=""><img src="./resources/images/search.png"></a></li>
	      	<li><a href=""><img src="./resources/images/minwon.png"></a></li>
	      	<li><a href=""><img src="./resources/images/AMS.png"></a></li>
	      	<li><a href=""><img src="./resources/images/energy.png"></a></li>
	      	<li><a href=""><img src="./resources/images/notice.png"></a></li>
	       </ul> 
	      </div> 
	      
	       <div id="ams-box_2">
	      		<div id="main-div_1">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp;공지사항
	      		 <hr>
	      		 test
	      		</div>
	      		
	      		<div id="main-div_2">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp; 최근 게시글
	      		 <hr>
	      		 test
	      		</div>
	      		
	      		<div id="main-div_3"> 
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp;관리비 사용 내역
	      		 <hr>
	      		 test
	      		</div>
	       </div>
	       
	        <div id="ams-box_3">
	      		<div id="main-div_4">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp; 아파트 일정
	      		 <hr>
	      		 test
	      		</div>
	      		
	      		<div id="main-div_5">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp;설문조사
	      		 <hr>	      		 
	      		 test
	      		</div>
	      		
	      		<div id="main-div_6">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp;아파트 근린시설
	      		 <hr>
	      		 <img src="./resources/images/banner_lib.png" width="100%" >
	      		  <img src="./resources/images/banner_health.png" width="100%" >
	      		</div>
	      		
	      		<div id="main-div_7">
	      		 <img src="./resources/images/main_btn.png" width="15" height="15" align="center">&nbsp;지역뉴스
	      		 <hr>
	      		<iframe src="http://www.seoul.co.kr/" width="100%"	height="80%"  scrolling="no"></iframe>
	      		</div>
	       </div>
	      
	      <div id="ams-footer">
	        <div id="ams-logo_2">
	         <a href ="index.ams"><img alt="home" src="./resources/images/home.png"></a>Kosta 아파트
	        </div>
	        
	        <div id="footer_div">
	         경기도 성남시 분당구 삼평동 대왕판교로670길 Kosta아파트<br>
			TEL) 031-123-4567~8  Fax)031-1234-6578  www.kostaapt.com<br>
			Copyright ⓒKosta아파트. All Rights Reserved.	         
	        </div>
	      </div>
	    </div>
	
	</body>
</html>