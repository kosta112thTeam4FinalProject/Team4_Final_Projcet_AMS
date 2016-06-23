package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.ComplainCal_Dao;
import kr.co.AMS.Model.vo.ComplainCal_Dto;
import kr.co.AMS.Model.vo.ComplainCal_User_Dto;

@Service
public class ComplainCalService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ComplainCal_Dto> complainCal_Get_Service() 
			throws ClassNotFoundException, SQLException{
		System.out.println("예약일정 가져오기 service");
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		
		List<ComplainCal_Dto> data = complainCalDao.getComplainCal();
		System.out.println("예약일정 가져오기 service2");
		
		return data;
	}
	
	public String complainCal_Insert_Service(ComplainCal_Dto c) 
			throws ClassNotFoundException, SQLException{
		System.out.println("예약일정 추가 service");
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		complainCalDao.insertComplainCal(c);
		System.out.println("예약일정 추가 service2");
		
		return "redirect:complain_calendar_get.ams";
	}
	
	public String complainCal_Delete_Service(ComplainCal_Dto c) 
			throws ClassNotFoundException, SQLException{
		System.out.println("예약일정 삭제 service");
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		complainCalDao.deleteComplainCal(c);
		System.out.println("예약일정 삭제 service2");
		
		return "redirect:complain_calendar_get.ams";
	}
	
	public String complainCal_User_Insert_Service(ComplainCal_User_Dto u) 
			throws ClassNotFoundException, SQLException{
		System.out.println("사용자 예약 등록 service");
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		complainCalDao.complainCal_Insert(u);
		complainCalDao.complainCal_Update(u);
		System.out.println("사용자 예약 등록 service2");
		
		return "AdminOffice.Complain_Calendar.ComplainCal_User";
	}
	
	public ComplainCal_User_Dto complainCal_User_Content_Service(ComplainCal_User_Dto u) 
			throws ClassNotFoundException, SQLException{
		System.out.println("보수 내용 보기 service");
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		ComplainCal_User_Dto data = complainCalDao.getComplainCalContent(u);
		System.out.println("보수 내용 보기 service2");
		
		return data;
	}
	
	/*public int complainCal_able_Get_Service(ComplainCal_User_Dto u) 
			throws ClassNotFoundException, SQLException {
		System.out.println("예약 현황 가져오기 ajax get service");
		
		ComplainCal_Dao complainCalDao = sqlSession.getMapper(ComplainCal_Dao.class);
		int num = complainCalDao.complainCal_userGet(u);
		System.out.println("service num : " + num);
		System.out.println("예약 현황 가져오기 ajax get service2");
		
		return num;
	}*/
	
	
}
