package kr.co.AMS.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.AMS.Model.DAO.APTCalendar_Dao;
import kr.co.AMS.Model.vo.APTCalendar_Dto;
import kr.co.AMS.Service.APTCalendarService;


//아파트 일정
@Controller
public class APTCalendarController {
	
	@Autowired
	private APTCalendarService service;
	
	//1.아파트 일정 상세보기
	@RequestMapping("apt_calendar.ams")
	public String apt_Calendar_View() {
		
		System.out.println("아파트 일정 상세보기 실행");
	
		return "AdminOffice.APTCalendar.Calendar_Detail";
	}
	
	//1.아파트 일정 상세보기(user)
		@RequestMapping("apt_calendar_user.ams")
		public String apt_Calendar_User_View() {
			
			System.out.println("아파트 일정 상세보기 실행(user)");
		
			return "AdminOffice.APTCalendar.Calendar_Detail_User";
		}
	
	//1.일정 가져오기
	@RequestMapping(value="apt_calendar_get.ams", method=RequestMethod.GET)
	public @ResponseBody List<APTCalendar_Dto> apt_Calendar_Get() 
			throws ClassNotFoundException, SQLException{
		
		System.out.println("캘린더 ajax get ");
		List<APTCalendar_Dto> data = service.apt_Calendar_Get_Service();
		System.out.println("test");
		
		return data;
	}
	
	//2. 일정 추가
	@RequestMapping(value="apt_calendar_Insert.ams", method=RequestMethod.POST)
	public @ResponseBody String apt_Calendar_Insert(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
			System.out.println("일정 추가 controller");
			System.out.println(a.getTitle());
			System.out.println(a.getStart_cal());
			System.out.println(a.getEnd_cal());
			String url = service.apt_Calendar_Insert_Service(a);
			System.out.println("일정 추가 controller2");
		return url;
	}
	
	//일정 삭제
	@RequestMapping(value="apt_calendar_Delete.ams", method=RequestMethod.POST)
	public @ResponseBody String apt_Calendar_Delete(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
		System.out.println("일정 삭제 controller");
		System.out.println(a.getCal_idx());
		String url = service.apt_Calendar_Delete_Service(a);
		System.out.println("일정 삭제 controller2");
		
		return url;
	}
	
	//일정 resize
	@RequestMapping(value="apt_calendar_Resize.ams", method=RequestMethod.POST)
	public @ResponseBody String apt_Calendar_Resize(APTCalendar_Dto a) 
			throws ClassNotFoundException, SQLException{
		System.out.println("일정 resize controller");
		System.out.println(a.getTitle());
		System.out.println(a.getEnd_cal());
		String url = service.apt_Calendar_Resize_Service(a);
		System.out.println("일정 resize controller2");
		
		return url;
	}
	
	//3.1 아파트 일정 수정하기
	@RequestMapping(value="apt_calendar_Modify.ams", method=RequestMethod.POST)
	public String apt_Calendar_Modify_View() {

		System.out.println("아파트 일정 수정하기 실행");

		return "AdminOffice.APTCalendar.Calendar_Detail";
	}
	
	/////////////////////////////////////////////
	//3.1 아파트 일정 수정하기
	/*@RequestMapping(value="apt_calendar_Modify.ams", method=RequestMethod.POST)
	public String apt_Calendar_Modify_View() {

		System.out.println("아파트 일정 수정하기 실행");

		return "AdminOffice.APTCalendar.Calendar_Detail";
	}*/
	
	
	///////////////////////////////////////////////

}
