package kr.co.AMS.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.AMS.Model.vo.ComplainCal_Dto;
import kr.co.AMS.Model.vo.ComplainCal_User_Dto;
import kr.co.AMS.Service.ComplainCalService;

@Controller
public class ComplainCalController {

	@Autowired
	private ComplainCalService service;

	// 1.보수처리 일정 상세보기
	@RequestMapping("Complain_Calendar.ams")
	public String complainCal_View() {

		System.out.println("보수처리 예약 상세보기 실행");

		return "AdminOffice.Complain_Calendar.Complain_Calendar";
	}

	// 1.예약 일정 가져오기
	@RequestMapping(value = "complain_calendar_get.ams", method = RequestMethod.GET)
	public @ResponseBody List<ComplainCal_Dto> complainCal_Get() throws ClassNotFoundException, SQLException {

		System.out.println("예약일정 ajax get");
		List<ComplainCal_Dto> data = service.complainCal_Get_Service();
		System.out.println("test");

		return data;
	}

	// 1-2.예약 일정 추가
	@RequestMapping(value = "complain_calendar_insert.ams", method = RequestMethod.POST)
	public @ResponseBody String complainCal_Insert(ComplainCal_Dto c) throws ClassNotFoundException, SQLException {
		System.out.println("일정 추가 controller");
		System.out.println(c.getReserve_o());
		System.out.println(c.getStart_cal());
		System.out.println(c.getEnd_cal());
		String url = service.complainCal_Insert_Service(c);
		System.out.println("일정 추가 controller2");
		return url;
	}

	// 1-3일정 삭제
	@RequestMapping(value = "complain_calendar_delete.ams", method = RequestMethod.POST)
	public @ResponseBody String complainCal_Delete(ComplainCal_Dto c) throws ClassNotFoundException, SQLException {
		System.out.println("일정 삭제 controller");
		System.out.println(c.getComplain_idx());
		String url = service.complainCal_Delete_Service(c);
		System.out.println("일정 삭제 controller2");

		return url;
	}
	
	// 1-4 예약 내용 보기
	@RequestMapping(value = "complain_calendar_getContent.ams", method = RequestMethod.POST)
	public @ResponseBody ComplainCal_User_Dto complainCal_User_Content(ComplainCal_User_Dto u) 
			throws ClassNotFoundException, SQLException {
		System.out.println("보수 처리 예약 내용 보기 controller");
		System.out.println("idx : " + u.getComplain_idx());
		ComplainCal_User_Dto data = service.complainCal_User_Content_Service(u);
		System.out.println("data : " + data.getContent());
		
		return data;
	}
	

	// 2-1.보수처리 예약(사용자) 상세보기
	@RequestMapping("complainCal_get.ams")
	public String complainCal_User_View() {

		System.out.println("보수처리 예약 사용자 상세보기 실행");

		return "AdminOffice.Complain_Calendar.ComplainCal_User";
	}

	// 2-2.예약 일정 추가
	@RequestMapping(value = "complainCal_user_insert.ams", method = RequestMethod.POST)
	public String complainCal_User_Insert(ComplainCal_User_Dto u) throws ClassNotFoundException, SQLException {
		System.out.println("사용자 예약 하기 controller");
		System.out.println(u.getComplain_idx());
		System.out.println(u.getContent());
		String url = service.complainCal_User_Insert_Service(u);
		System.out.println("사용자 예약하기 controller2");

		return url;
	}
	

}
