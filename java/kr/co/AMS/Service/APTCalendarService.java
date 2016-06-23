package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.APTCalendar_Dao;
import kr.co.AMS.Model.vo.APTCalendar_Dto;

@Service
public class APTCalendarService {

	@Autowired
	private SqlSession sqlSession;
	
	public List<APTCalendar_Dto> apt_Calendar_Get_Service() 
			throws ClassNotFoundException, SQLException{
		
		System.out.println("캘린더 ajax get service");
		APTCalendar_Dao calendarDao = sqlSession.getMapper(APTCalendar_Dao.class);
		
		List<APTCalendar_Dto> data = calendarDao.getCalendar();
		System.out.println("service test");
		
		return data;
	}
	
	public String apt_Calendar_Insert_Service(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
		System.out.println("일정 추가 service");
		APTCalendar_Dao calendarDao = sqlSession.getMapper(APTCalendar_Dao.class);
		
		calendarDao.insertCalendar(a);
		System.out.println("일정 추가 service2");
		
		return "redirect:apt_calendar_get.ams";
	}
	
	public String apt_Calendar_Delete_Service(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
		System.out.println("일정 삭제 service");
		APTCalendar_Dao calendarDao = sqlSession.getMapper(APTCalendar_Dao.class);
		calendarDao.deleteCalendar(a);
		System.out.println("일정 삭제 service2");
		
		return "redirect:apt_calendar_get.ams";
	}
	
	public String apt_Calendar_Resize_Service(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
		System.out.println("일정 resize service");
		APTCalendar_Dao calendarDao = sqlSession.getMapper(APTCalendar_Dao.class);
		calendarDao.resizeCalendar(a);
		System.out.println("일정 resize service2");
		
		return "redirect:apt_calendar_get.ams";
	}
	
}
