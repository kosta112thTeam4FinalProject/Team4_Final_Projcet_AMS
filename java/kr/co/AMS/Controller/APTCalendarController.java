package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//아파트 일정
@Controller
public class APTCalendarController {
	
	//1.아파트 일정 상세보기
	@RequestMapping("apt_calendar.ams")
	public String apt_Calendar_View() {
		
		System.out.println("아파트 일정 상세보기 실행");
	
		return "AdminOffice.APTCalendar.Calendar_Detail";
	}
	
	
	//3.1 아파트 일정 수정하기
	@RequestMapping(value="apt_calendar_Modify.ams", method=RequestMethod.GET)
	public String apt_Calendar_Modify_View() {

		System.out.println("아파트 일정 수정하기 실행");

		return "AdminOffice.APTCalendar.Calendar_Detail";
	}

}
