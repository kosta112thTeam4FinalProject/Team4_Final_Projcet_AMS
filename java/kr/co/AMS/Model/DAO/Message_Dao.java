package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.AMS.Model.vo.Receive_Message;
import kr.co.AMS.Model.vo.Send_Message;

//쪽지_DAO
public interface Message_Dao {

	
	//1.1 받은쪽지함 목록(select)
    List<Receive_Message> getReceiveMsg(HashMap map) throws ClassNotFoundException, SQLException;
	
	//1.2 받은쪽지 전체 건수(select count)
	 int getReceiveTotal(String userid) throws ClassNotFoundException, SQLException;
		
	//2.1 보낸쪽지함 목록(select)
	 List<Send_Message> getSendMsg(HashMap map) throws ClassNotFoundException, SQLException;
	
	//2.2 보낸쪽지함 전체 건수(select count)
	 int getSendTotal(String sender) throws ClassNotFoundException, SQLException;
	
	//3.1 받은 쪽지함 상세보기(select)
	 Receive_Message detailReceiveMessage(int receive_idx) throws ClassNotFoundException, SQLException;
	
	//3.2 보낸 쪽지함 상세보기(select)
    Send_Message detailSendMessage(int send_idx) throws ClassNotFoundException, SQLException;
	
	//4.1 쪽지쓰기_받은 쪽지함(insert)
	int insertReceiveMessage(Receive_Message receive_message) throws ClassNotFoundException, SQLException;
	
	//4.2 쪽지쓰기_보낸 쪽지함(insert)
	 int insertSendMessage(Send_Message send_message) throws ClassNotFoundException, SQLException;
	
	//5.1 받은 쪽지 삭제(delete)
	 int deleteReceiveMessage(int receive_idx) throws ClassNotFoundException, SQLException;
	
	//5.2 보낸 쪽지 삭제(delete)
     int deleteSendMessage(int send_idx) throws ClassNotFoundException, SQLException;
	
	//5.3 받은 쪽지삭제_checkbox(delete)
	 int checkDeleteRecMsg(ArrayList list) throws ClassNotFoundException, SQLException;	
	
	//5.4 보낸 쪽지삭제_checkbox(delete)
	 int checkDeleteSendMsg(ArrayList list) throws ClassNotFoundException, SQLException;
	
	//6.1 쪽지 답장하기(받은 쪽지함)(insert)
	 int reWriteRecMessage(Receive_Message receive_message) throws ClassNotFoundException, SQLException;
	
	//6.2 쪽지 답장하기(보낸 쪽지함)(insert)
	 int reWriteSendMessage(Send_Message send_message) throws ClassNotFoundException, SQLException;
	
	//7.1 받은 쪽지함 검색(select)
	 List<Receive_Message> searchbyReceiveMsg(HashMap map) throws ClassNotFoundException, SQLException;
		
	//7.2 보낸 쪽지함 검색(select)
     List<Send_Message> searchbySendMsg(HashMap map) throws ClassNotFoundException, SQLException;
	
	//8.쪽지 읽음 여부 표시(update)
	 int updateHit(int receive_idx) throws ClassNotFoundException, SQLException; 
	
	//9.읽지 않은 쪽지 표시(select)
	 int getUnReadCount(String userid) throws ClassNotFoundException, SQLException;
	
	//10.쪽지 읽음/읽지 않음 여부 표시(update)
	int updateRead() throws ClassNotFoundException, SQLException;
	 
	 //11.쪽지 알람확인 _Notification
	 List<Receive_Message> notificationCheck(HashMap map); 
	 
	 //12.쪽지 알람상태 변경
	 int msgAlarmChange(Receive_Message receive_message);
	 
	
	
	
	
	
	
	
}
