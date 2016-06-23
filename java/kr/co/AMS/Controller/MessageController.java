package kr.co.AMS.Controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.AMS.Model.vo.Receive_Message;
import kr.co.AMS.Model.vo.Send_Message;
import kr.co.AMS.Service.MessageService;

//쪽지
@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	//1.1 받은쪽지함 목록 전체
	@RequestMapping("message_received.ams")
	public String message_Receive_List_View(String pg, Principal principal, Receive_Message receive_message, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_받은 쪽지함 목록 전체 실행");	
		
		HashMap maps = messageService.getReceiveMsg(pg, principal, receive_message);
	      
		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("userid", maps.get("userid"));
		model.addAttribute("read", maps.get("read"));
		
		return "MyPage.Message.Message_ReceiveList";
	}
	
	//2.1 보낸쪽지함 목록 전체
	@RequestMapping("message_send.ams")
	public String message_Send_List_View(String pg, Principal principal, Send_Message send_message, Model model)
			throws ClassNotFoundException, SQLException {
		
		System.out.println("Con_보낸 쪽지함 목록 전체 실행");

		HashMap maps = messageService.getSendMsg(pg, principal, send_message);

		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("sender", maps.get("sender"));
		

		return "MyPage.Message.Message_sendList";
	}
	
	
	//3.1 받은 쪽지 상세보기
	@RequestMapping("message_receive_detail.ams")
	public String message_Rec_Detail_View(int receive_idx, Principal principal, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_받은 쪽지 상세보기 실행");
		
		HashMap maps = messageService.messageRecDetail(receive_idx, principal);
		
		//model.addAttribute("pg", pg);
		model.addAttribute("receive_message", maps.get("receive_message"));
		model.addAttribute("read", maps.get("read"));
		
		return "MyPage.Message.Message_ReciveDetail";		
		
	}
	
	//3.2 보낸 쪽지 상세보기
	@RequestMapping("message_send_detail.ams")
	public String message_Send_Detail_View(int send_idx, Principal principal, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Con_보낸 쪽지 상세보기 실행");

		Send_Message send_message = messageService.messageSendDetail(send_idx, principal);
		
		//model.addAttribute("pg", pg);
		model.addAttribute("send_message", send_message);
		
		return "MyPage.Message.Message_SendDetail";

	}
	
	//4.1 쪽지쓰기
	@RequestMapping(value="message_write.ams", method=RequestMethod.GET)
	public String message_Write_View()  {
		
		System.out.println("Con_쪽지 쓰기 실행");

		
		return "MyPage.Message.Message_Write";
	}
	
	//4.2 쪽지쓰기 완료하기
	@RequestMapping(value="message_write.ams", method=RequestMethod.POST)
	public String message_Write_Ok(Receive_Message receive_message, Send_Message send_message,Principal principal) throws ClassNotFoundException, SQLException {
		
		System.out.println("Con_쪽지 쓰기 완료 실행");

	    int result = messageService.insertReceiveMessageOk(receive_message, principal);
	    int result2 = messageService.insertSendMessageOk(send_message, principal);
		
       String view = null;
		
		if(result > 0 && result2 > 0)
		{
			view = "redirect:message_send.ams";
		}
		else
		{
			view = "redirect:index.asm";
		}	
		
		return view;
	}
	
	//5.1 받은 쪽지함 삭제하기
	@RequestMapping("message_receive_delete.ams")
    public String message_Receive_Delete_Ok(int receive_idx) throws ClassNotFoundException, SQLException {
		
		System.out.println("Con_받은 쪽지 삭제 완료 실행");

	    int result = messageService.receiveMessageDelete(receive_idx);
		
        String view = null;
		
		if(result > 0)
		{
			view = "redirect:message_received.ams";
		}
		else
		{
			view = "redirect:index.asm";
		}	
		
		return view;
	 }
	
	 //5.2 보낸 쪽지함 삭제하기
     @RequestMapping("messgae_send_delete.ams")
	 public String message_Send_Delete_Ok(int send_idx) throws ClassNotFoundException, SQLException {
			
			System.out.println("Con_ 보낸 쪽지 삭제 완료 실행");

		    int result = messageService.sendMessageDelete(send_idx);
		    
	        String view = null;
			
			if(result > 0)
			{
				view = "redirect:message_send.ams";
			}
			else
			{
				view = "redirect:index.asm";
			}	
			
			return view;
		 }
	
      
      //5.3 받은 쪽지 삭제하기_checkbox
      @RequestMapping("message_receive_checkDel.ams")
      public String message_Receive_Check_Delete_Ok(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
			
			System.out.println("Con_ Checkbox 받은 쪽지 삭제 실행");

		    int result = messageService.receiveMessageCheckDelete(request, response);
		    
	        String view = null;
			
			if(result > 0)
			{
				view = "redirect:message_received.ams";
			}
			else
			{
				view = "redirect:index.asm";
			}	
			
			return view;
		 }
      
      
      //5.3 보낸 쪽지 삭제하기_checkbox
      @RequestMapping("message_send_checkDel.ams")
      public String message_Send_Check_Delete_Ok(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
			
			System.out.println("Con_ Checkbox 보낸 쪽지 삭제 실행");

		    int result = messageService.sendMessageCheckDelete(request, response);
			
	        String view = null;
			
			if(result > 0)
			{
				view = "redirect:message_send.ams";
			}
			else
			{
				view = "redirect:index.asm";
			}	
			
			return view;
	 }
      
      
    //6.1 쪽지 답장 쓰기
    @RequestMapping(value="message_rewrite.ams", method=RequestMethod.GET)
  	public String message_Rewrite_View(int receive_idx, Model model) throws ClassNotFoundException, SQLException 
  	{
  		
  		System.out.println("Con_쪽지 답장 쓰기 실행");
  		
  		Receive_Message receive_message = messageService.messageRewriteView(receive_idx);

  		
  		model.addAttribute("receive_message", receive_message);
  		
  		return "MyPage.Message.Message_Rewrite";
  	} 
    
    
    //6.1 쪽지 답장 완료하기
    @RequestMapping(value="message_rewrite.ams", method=RequestMethod.POST)
  	public String message_Rewrite_Ok(Receive_Message receive_message, Send_Message send_message, Principal principal) throws ClassNotFoundException, SQLException 
  	{
  		
  		System.out.println("Con_쪽지 답장 쓰기 완료 실행");
  		
  		int result = messageService.receiveMessageRewriteOk(receive_message, principal);
  		int result2 = messageService.sendMessageRewriteOk(send_message, principal);
  		String view = null;
		
		if(result > 0 && result2 > 0)
		{
			view = "redirect:message_send.ams";
		}
		else
		{
			view = "redirect:index.asm";
		}	
		
		return view;
  		
  	}
    
    
    
    //7.1 받은 쪽지함 검색하기
    @RequestMapping("message_receive_search.ams")
    public String message_Receive_Search(Model model, Receive_Message receive_message, Principal principal, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
    	
    	System.out.println("Con_받은 쪽지함 검색 실행");
    	
    	HashMap maps = messageService.receiveMessageSearch(receive_message, principal, request, response);
	      
    	System.out.println("*************");
    	
    	model.addAttribute("list", maps.get("list"));
    	
    	return "MyPage.Message.Message_ReceiveList";
    	
    	
    }
    
    //7.2 보낸 쪽지함 검색하기
	@RequestMapping("message_send_search.ams")
    public String message_Send_Search(Model model, Send_Message send_message, Principal principal,HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException { 
		
		System.out.println("Con_보낸 쪽지함 검색 실행");
		
		HashMap maps = messageService.sendMessageSearch(send_message, principal, request, response);
	      
		model.addAttribute("list", maps.get("list"));
		
		return "MyPage.Message.Message_sendList";
	}
	
	//**읽지 않은 쪽지 개수 > 모든 페이지에서 표시될 수 있도록하기
	@RequestMapping(value="message_readcount.ams"/*, method=RequestMethod.POST*/)
	public @ResponseBody int messageUnreadCount(Receive_Message receive_message, Principal principal)
			throws ClassNotFoundException, SQLException {
		
		System.out.println("읽지 않은 쪽지 개수 표시");

		/*
		 * receive_message.setUserid(principal.getName()); String userid =
		 * receive_message.getUserid();
		 */

		int read = messageService.unReadMessageCount(receive_message, principal);

		System.out.println(principal.getName() + "님이 읽지 않은 쪽지 개수 : " + read);

		//model.addAttribute("read", read);

		return read;
	}
	
	
	
	//**쪽지 알람(Notification)
	@RequestMapping("message_notification.ams")
	public @ResponseBody List<Receive_Message> msgAlarmCheck(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_Notification 실행");
		
		List<Receive_Message> list = messageService.msgNotificationCheck(receive_message, principal);
						
		return list;		
		
	}
	
	//**쪽지 알람 상태 변경
	@RequestMapping("message_change_notification.ams")
	public @ResponseBody void msgAlarmChange(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_Notification 상태 변경 실행");
		
		int result = messageService.changeMsgAlarmChange(receive_message, principal);		
		
	}
    
	
}
