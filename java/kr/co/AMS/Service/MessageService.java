package kr.co.AMS.Service;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.tcp.SendMessageData;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.Message_Dao;
import kr.co.AMS.Model.vo.Receive_Message;
import kr.co.AMS.Model.vo.Send_Message;

//쪽지
@Service
public class MessageService {
	
	@Autowired
	private SqlSession sqlSession;
	
	//1.1 받은쪽지함 목록 전체
	public HashMap getReceiveMsg(String pg, Principal principal, Receive_Message receive_message) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_받은 쪽지함 목록 전체");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 10;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		receive_message.setUserid(principal.getName());
		String userid = receive_message.getUserid();
		System.out.println("쪽지를 받는 사람 :  " + userid);
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		
		int total = message_dao.getReceiveTotal(userid);
		int read = message_dao.getUnReadCount(userid);
		System.out.println(userid + "님이 읽지 않은 쪽지 개수 : " + read );
				
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);		
		
	   //... 목록
	   int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
	   // int totalPage = total/rowSize + (total%rowSize==0?0:1);
	   System.out.println("페이지수 : " + allPage);

	   int block = 10; 
	   // 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
	   int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
	   // ((1-1)/10*10)
	   int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
	   if (toPage > allPage) // 예) 20>17
	   { 
		   toPage = allPage;
	   }		
		
		//start와 end 값을 map에 담음
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("userid", userid);
		
		List<Receive_Message> list = message_dao.getReceiveMsg(map);
		
		//int result = anonDao.getAnonyCommentCount(board_idx);
		 
		HashMap maps = new HashMap();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("allPage", allPage);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		maps.put("read", read);
		
		return maps;			
	}
	
	
	//2.1 보낸쪽지함 목록 전체
	public HashMap getSendMsg(String pg, Principal principal, Send_Message send_message) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_보낸 쪽지함 목록 전체");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 10;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		/*send_message.setUserid(principal.getName());
		String userid = send_message.getUserid();*/
		
		send_message.setSender(principal.getName());	
		String sender = send_message.getSender();
		
		System.out.println("쪽지를 보낸사람 :  " + sender);
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		
		int total = message_dao.getSendTotal(sender);
				
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);		
		
	   //... 목록
	   int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
	   // int totalPage = total/rowSize + (total%rowSize==0?0:1);
	   System.out.println("페이지수 : " + allPage);

	   int block = 10; 
	   // 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
	   int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
	   // ((1-1)/10*10)
	   int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
	   if (toPage > allPage) // 예) 20>17
	   { 
		   toPage = allPage;
	   }		
		
		//start와 end 값을 map에 담음
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("sender", sender);
		
		List<Send_Message> list = message_dao.getSendMsg(map);
		
	 
		HashMap maps = new HashMap();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("allPage", allPage);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
			
		return maps;	
		
	}
	
	
	
	//3.1 받은 쪽지 상세보기
	public HashMap messageRecDetail(int receive_idx, Principal principal ) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_받은 쪽지 글 상세보기");
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		//쪽지 받은 사람
		Receive_Message receive_message = message_dao.detailReceiveMessage(receive_idx);
	
		receive_message.setUserid(principal.getName());
		String userid = receive_message.getUserid();

		//쪽지 읽음 여부 및 알림을 위한 조회수 증가
		message_dao.updateHit(receive_idx);
		
		//쪽지 읽음 여부 표시
		message_dao.updateRead();
		
		//쪽지 알림 여부 표시
		int read = message_dao.getUnReadCount(userid);
		System.out.println(userid + "님이 읽지 않은 쪽지 개수 : " + read );	

		
		HashMap maps = new HashMap();
		maps.put("receive_message", receive_message);
		maps.put("read", read);
		
		return maps;
	}
	
	//3.2 보낸 쪽지 상세보기
	public Send_Message messageSendDetail(int send_idx, Principal principal) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_보낸 쪽지 글 상세보기");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);

		// 쪽지보낸 사람
		Send_Message send_message = message_dao.detailSendMessage(send_idx);

		send_message.setUserid(principal.getName());

		return send_message;
	}
	
	
	//4.1 쪽지쓰기_받은 쪽지함
	public int insertReceiveMessageOk(Receive_Message receive_message, Principal principal)throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_받은 쪽지함 쪽지 쓰기 완료하기");
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		
		receive_message.setSender(principal.getName());
		System.out.println("ddddd :" + receive_message.getSender());
		
		
		int result = message_dao.insertReceiveMessage(receive_message);
		System.out.println("쪽지쓰기_받은 쪽지함 : " + receive_message.getReceive_idx());
		System.out.println("쪽지쓰기_받은 쪽지함 : " + result);
		
		return result;
	}
	
	//4.2 쪽지쓰기_보낸 쪽지함
	public int insertSendMessageOk(Send_Message send_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_보낸 쪽지함 쪽지쓰기 완료하기");
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		send_message.setSender(principal.getName());
		
		int result = message_dao.insertSendMessage(send_message);
		
		return result;
	}

	
	//5.1 받은 쪽지 삭제
	public int receiveMessageDelete(int receive_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_받은 쪽지 삭제하기");
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		int result = message_dao.deleteReceiveMessage(receive_idx);
		
		return result;
	}
	
	//5.2 받은 쪽지 삭제
	public int sendMessageDelete(int send_idx) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_보낸 쪽지 삭제하기");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);

		int result = message_dao.deleteSendMessage(send_idx);
		
		return result;
	}
	
	//5.3 받은 쪽지삭제_checkbox
	public int receiveMessageCheckDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_받은 쪽지 삭제하기_checkbox");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		String[] recevie_idx = request.getParameterValues("check_num");
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("seq 길이 :  " + recevie_idx .length);

		for (int i = 0; i < recevie_idx .length; i++) {
			list.add(recevie_idx [i]);
		}

		int result = message_dao.checkDeleteRecMsg(list);

		return result;
	}
	
	//5.4 보낸 쪽지삭제_checkbox
	public int sendMessageCheckDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_보낸 쪽지 삭제하기_checkbox");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		String[] send_idx = request.getParameterValues("check_num");
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("send_idx 길이 :  " + send_idx.length);

		for (int i = 0; i < send_idx.length; i++) {
			list.add(send_idx[i]);
		}

		int result = message_dao.checkDeleteSendMsg(list);

		return result;
	}
	
	//6.1 쪽지 답장쓰기
	public Receive_Message messageRewriteView(int receive_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_쪽지 답장쓰기");
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		Receive_Message receive_message = message_dao.detailReceiveMessage(receive_idx);
		
		return receive_message;
		
	}
	
	
	//6.2 쪽지 답장 쓰기 완료하기_받은 쪽지함
	public int receiveMessageRewriteOk(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_쪽지 답장쓰기 완료_받은쪽지함");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		receive_message.setSender(principal.getName());

		int result = message_dao.reWriteRecMessage(receive_message);
		
		return result;

	}
	
	//6.2 쪽지 답장 쓰기 완료하기_받은 쪽지함
	public int sendMessageRewriteOk(Send_Message send_message, Principal principal) throws ClassNotFoundException, SQLException {

		System.out.println("Service_쪽지 답장쓰기 완료_보낸쪽지함");

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);

		send_message.setSender(principal.getName());
		
		int result = message_dao.reWriteSendMessage(send_message);

		return result;

	}
	
	
	//7.1 받은 쪽지함 검색
	public HashMap receiveMessageSearch(Receive_Message receive_message, Principal principal, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		System.out.println("Service_받은 쪽지함 검색");
		
		
		receive_message.setUserid(principal.getName());
		
		String userid = receive_message.getUserid(); //받은 사람 
		String column = request.getParameter("column"); //
		String search = request.getParameter("search"); 
		
		System.out.println("받은쪽지함 검색 : " + column + " = ' " + search + " ' ");

		HashMap<String, String> map = new HashMap<String, String>(); // collection
		map.put("column", column); // column : name or email or home
		map.put("search", search); // search : 홍길동
		map.put("userid", userid);

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		List<Receive_Message> list = message_dao.searchbyReceiveMsg(map);
		
		HashMap maps = new HashMap();
		maps.put("list", list);
		
		
		return maps;
		
	}
	
	
	//7.2 보낸 쪽지함 검색
	public HashMap sendMessageSearch(Send_Message send_message, Principal principal, HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException {

		System.out.println("Service_보낸 쪽지함 검색");

		send_message.setSender(principal.getName());

		String sender = send_message.getSender();
		String column = request.getParameter("column"); // name, home,email
		String search = request.getParameter("search"); // 홍길동
		System.out.println("보낸쪽지함 검색 : " + column + " = ' " + search + " ' ");

		HashMap<String, String> map = new HashMap<String, String>(); // collection
		map.put("column", column); // column : name or email or home
		map.put("search", search); // keyvalue : 홍길동
		map.put("sender", sender);

		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);

		List<Send_Message> list = message_dao.searchbySendMsg(map);

		HashMap maps = new HashMap();
		maps.put("list", list);

		return maps;

	}
	
	
	//**읽지 않은 쪽지 개수 > 모든 페이지에서 표시될 수 있도록하기
	public int unReadMessageCount(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		
	    System.out.println("Service_읽지않은 쪽지 개수 표시");
	    
		receive_message.setUserid(principal.getName());
		
		String userid = receive_message.getUserid();
	
	
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		int read = message_dao.getUnReadCount(userid);
		
		return read;		
	}
	
	//**쪽지 알람(Notification)
	public List<Receive_Message> msgNotificationCheck(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_받은쪽지 알람");
		
		receive_message.setUserid(principal.getName());
		String userid = receive_message.getUserid();
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		
		List<Receive_Message> list = message_dao.notificationCheck(map);
		
		return list;	
	}
	
	
	
	
	//**쪽지 알람 상태 변경
	public int changeMsgAlarmChange(Receive_Message receive_message, Principal principal) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_쪽지 알람 상태 변경");
		
		receive_message.setUserid(principal.getName());
		
		Message_Dao message_dao = sqlSession.getMapper(Message_Dao.class);
		
		int result = message_dao.msgAlarmChange(receive_message);
		
		return result;		
	}
	
	
	

}
