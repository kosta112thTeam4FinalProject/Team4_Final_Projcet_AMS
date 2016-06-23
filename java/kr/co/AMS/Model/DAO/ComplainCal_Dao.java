package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.List;

import kr.co.AMS.Model.vo.ComplainCal_Dto;
import kr.co.AMS.Model.vo.ComplainCal_User_Dto;

public interface ComplainCal_Dao {
	//예약일정 가져오기
	public List<ComplainCal_Dto> getComplainCal() throws ClassNotFoundException, SQLException;
	//예약일정 추가
	public void insertComplainCal(ComplainCal_Dto c) throws ClassNotFoundException, SQLException;
	//예약일정 삭제
	public void deleteComplainCal(ComplainCal_Dto c) throws ClassNotFoundException, SQLException;
	//예약 내용 보기
	public ComplainCal_User_Dto getComplainCalContent(ComplainCal_User_Dto u) throws ClassNotFoundException, SQLException;
	
	
	//사용자 예약 등록
	public void complainCal_Insert(ComplainCal_User_Dto u) throws ClassNotFoundException, SQLException;
	//사용자 예약 현황 가져오기
	//public int complainCal_userGet(ComplainCal_User_Dto u) throws ClassNotFoundException, SQLException;
	//예약 현황 업데이트
	public void complainCal_Update(ComplainCal_User_Dto u) throws ClassNotFoundException, SQLException;
}
