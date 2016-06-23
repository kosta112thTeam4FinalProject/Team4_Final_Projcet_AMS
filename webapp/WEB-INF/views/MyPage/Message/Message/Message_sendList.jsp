<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
   function CheckAll(){            
       var gChk = document.getElementsByName("check_group");       //체크박스의 name값
       var nChk = document.getElementsByName("check_num");                   
       if(gChk[0].checked){ 
        for(i=0; i<nChk.length;i++){                                                                    
         nChk[i].checked = true;              //체크되어 있을경우 설정변경
        }
       }else{
        for(i=0; i<nChk.length;i++){                                                                    
         nChk[i].checked = false;                                              
        }  
       }
      }

   function CheckGroup(form){ 
       var i; 
       var nChk = document.getElementsByName("check_num");     //체크되어있는 박스 value값
       form['gid'].value ='';
       if(nChk){
        for(i=0;i<nChk.length;i++) { 
         if(nChk[i].checked){                                                            //체크되어 있을경우 
          if(form['gid'].value ==''){
           form['gid'].value = nChk[i].value; 
          }else{
           form['gid'].value =  form['gid'].value+ ',' +nChk[i].value;   //구분자로 +=
          }
         } 
        }
        if(form['gid'].value ==''){                                                 //선택이 하나도 안되어있을 경우
         alert("삭제할 게시물을 선택해 주세요.");       
         return false; 
        }
        return true;
       } 
      }   
   </script>
	      <div id="title_bar">	
	         <span> MyPage </span> 
	         <img src = "./resources/images/title_bar/mypage_title.png">   	
	      </div>
	      
	      <div id="mypage_menu" style="float: left;">
	      	<ul style="text-decoration: none">
	      		<li>
	      			<a href="member_modify">회원정보수정</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_write.ams">쪽지쓰기</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_received.ams">받은 쪽지함</a>
	      		</li>
	      		
	      		<li>
	      		<a href="message_send.ams">보낸 쪽지함</a>
	      		</li>	      		
	      	
	      	</ul>	       
	      </div>      
	         
	      
	      <div id="board">
	      보낸쪽지함
	      <form name="qa_list" method="post" action="message_send_checkDel.ams" onsubmit="return CheckGroup(this)">
	      	<table>
	      		<thead>
	      			<tr>
	      				<th><input type="checkbox" name="check_group" onclick="javascript:CheckAll()"></th>	      				
	      				<th>제목</th>
	      				<th>받는사람</th>
	      				<th>날짜</th>      			
	      			</tr>      		
	      		</thead>
	      		
	      		<c:forEach var="send_message" items="${list}">
	      		
	      		<tbody>
	      		   <input type="hidden" name="send_idx" value="${send_message.send_idx}">  
	      			<tr>
	      			 <td>	      			
	      			    <input type="checkbox" name="check_num" value="${send_message.send_idx}">
	      			  </td>
	      			  
	      			  <td>
	      			    <a href="message_send_detail.ams?send_idx=${send_message.send_idx}">
	      			    ${send_message.title}</a>
	      			   </td>
	      			  
	      			   <td>
	      			    ${send_message.userid}
	      			   </td>
	      			   
	      			   <td>
	      			   ${send_message.send_date}
	      			   </td>
	      			   
	      			  </tr>	     						      			    	      		
	      		</tbody> 
	      		</c:forEach> 
	      	    	     	
	      	</table>
	      	<!--  <button class="del_message"><a href="message_delete.ams">삭제</a></button> -->
	      	 <input type="hidden" name="gid"> <!-- 체크박스 선택해서 삭제시 사용 -->
	      	 <input type="submit" value="삭제">
	      	 </form>
	      	 <button class="write_message"><a href="message_write.ams">쪽지쓰기</a></button>
	      	</div>
	      	
	      	
	      	<div id="board_page">
	      	  
	      	  <!-- 이전  -->
	      	  <c:if test="${pg>1}"> <!-- 이전 페이지가 있는 경우  -->
	      	  <a href="message_received.ams?pg=${pg-1}">[이전]</a>
	      	  </c:if>
	      	 
	      			      	  
	      	  <!-- 1,2,3.....  -->
	      	  <ul>
	      	    <c:forEach begin="${fromPage}" end="${toPage}" var="i">
					<c:if test="${i==pg}"> <li style="color:red">${i}</li> </c:if>
					<c:if test="${i!=pg}"> <li><a href="message_send.ams?pg=${i}">${i}</a></li>
					</c:if>					
				</c:forEach>
			 </ul>
			 
			 <!-- 다음  -->
			 <c:if test="${pg < allPage}">
	      	  	<a href="message_send.ams?pg=${pg+1}">[다음]</a>
	      	 </c:if>	

	      	
	      	</div> 
	      	
	      	<div id="board_search" >
	      		<form action="message_send_search.ams" method="post">
	      		   <select name="column">
	      		   	<option value="userid">받는사람</option>
	      		    <option value="title">제목</option>
	      		    <option value="content">내용</option>	      		          		   
	      		   </select>        		    		  
	      		        		   
	      		   <input type="text"  name="search">
	      		   <input type="submit"	 value="검색">
	      		
	      		</form>   	
	      	
	      	</div>   
	    