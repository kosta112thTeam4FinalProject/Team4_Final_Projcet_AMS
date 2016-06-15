<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	      
	      <div id="title_bar">	
	         <span> 벼룩시장 </span> 
	         <img src = "./resources/images/market_title.png">   	
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
	      			<tr>
	      			  <td>1 &nbsp; <img src="./resources/images/market_tag.png"> <a href="market_detail.ams">공지사항 테스트 </a></td>
	      			  <td> 104-201</td>
	      			  <td> 2016.03.10</td>
	      			  <td>5</td>
	      			</tr>
	      			<tr>
	      			  <td>${market.noti_idx} <img src="./resources/images/market_tag.png"> <a href="market_detail.ams?seq=${market.noti_idx}"> ${market.noti_title} </a> </td>
	      			  <td> ${market.noti_writer} </td>
	      			  <td> ${market.noti_regdate} </td>
	      			  <td>${market.noti_hit}</td>
	      			</tr>
	      			
	      			      			    	      		
	      		</tbody>      	     	
	      	</table>
	      	 <button class="reg_button"><a href="market_write.ams">등록</a></button>
	      	</div>
	      	
	      	
	      	<div id="board_page">
	      	  
	      	  <a href="">[이전]</a>
	      	  <ul>
				<li><a class=strong href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
			 </ul>
	      	  <a href="">[다음]</a>
	      	
	      	</div> 
	      	
	      	<div id="board_search" >
	      		<form class="search_form" id="" action="market_search.ams" method="post">
	      		   <select id="" >
	      		   	<option selected="selected">선택하세요</option>
	      		    <option>1일</option>
	      		    <option>1주일</option>
	      		    <option>1개월</option>
	      		    <option>기간입력	      		    
	      		      <input type="text" id="" name=""> ~ <input type="text" id="" name="">	
	      		      <button>설정</button>     		    
	      		    </option>       		   
	      		   </select> 
	      		   
	      		       		   
	      		   <select id="">
	      		    <option selected="selected">선택하세요</option>
	      		    <option>전체</option>
	      		    <option>제목 + 내용</option>
	      		    <option>제목만</option>
	      		    <option>글작성자</option>
	      		    <option>댓글내용</option>
	      		    <option>댓글작성자</option>      		   
	      		   </select> 
	      		   
	      		   <input type="text" id="" name="">
	      		   <input type="submit"	 id=""  name="" value="검색">
	      		
	      		</form>   	
	      	
	      	</div>   
	      
	  