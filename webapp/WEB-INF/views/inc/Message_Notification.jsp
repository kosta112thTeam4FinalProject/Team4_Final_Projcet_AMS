<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){			
		timer = setInterval(function(){
			
			console.log('12314141414');
			console.log('${userid}');
			
		   if('${userid}' != '') {
			
				$.ajax({
					
					 type:"post",
					 datatype:"json",
					 url : "message_notification.ams",
					/*  data: {"userid" : '${userid}'}, */					
					 success : function(data) {
						 
						 
						 if(data != null) {
			                  for(var i=0; i<data.length; i++){			                	  
			              
			                    console.log("실행합니다");
			                    console.log("userid : " + data[i].userid);
			                    
			                     /* var options = {
			                          
			                     } */
			                     var notification = new Notification('Kosta_APT', {
								      icon: 'http://cdn2.macworld.co.uk/cmsdata/features/3618063/cancel_messages_iphone_thumb800.jpg',
								      body : data[i].sender + "님이 쪽지를 보냈습니다."
								 });
			                     notification.onclick = function(event) {
			                    	  event.preventDefault(); // prevent the browser from focusing the Notification's tab
			                    	  window.open('http://www.mozilla.org', '_blank');
			                     }
			                     
			                     $.ajax({
			                         type : "post",
			                         url : "message_change_notification.ams",
			                         data : {"userid" : '${userid}', "receive_idx" : data[i].receive_idx},
			                         success : function() {			                        	 
			                      
			                         } //
			                      }); //ajax_2						 
					  
			                  } //for
					 } //if data
					 
					}, //success
					/* error:function(xhr)
					 {
						  alert(xhr.status + "ERROR");
					 }		 */	
					
				});	//ajax
		       }  
		   }, 3000 ); //timer 3초에 한번씩
			
	}); //end 
</script>