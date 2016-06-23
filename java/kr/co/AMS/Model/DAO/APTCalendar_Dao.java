package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.List;

import kr.co.AMS.Model.vo.APTCalendar_Dto;

public interface APTCalendar_Dao {
	//일정 불러오기
	public List<APTCalendar_Dto> getCalendar() throws ClassNotFoundException, SQLException;
	//일정 추가
	public void insertCalendar(APTCalendar_Dto a) throws ClassNotFoundException, SQLException;
	//일정 삭제
	public void deleteCalendar(APTCalendar_Dto a) throws ClassNotFoundException, SQLException;
	//일정 resize
	public void resizeCalendar(APTCalendar_Dto a) throws ClassNotFoundException, SQLException;
}
