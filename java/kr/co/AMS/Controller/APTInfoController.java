package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//아파트 소개
@Controller
public class APTInfoController {
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	//1.1단지소개 상세보기
	@RequestMapping("apt_intro.ams")
	public String apt_Intro_View() {
		System.out.println("단지소개 상세보기 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	
	
	//1.2 단지소개 수정하기
	@RequestMapping(value="apt_intro_modify.ams", method=RequestMethod.GET)
	public String apt_Intro_Modify() {
		System.out.println("단지소개 수정하기 실행");

		return "AdminOffice.APTInfo.APTInfo_Modify";
	}

	
	//1.3 단지소개 수정 완료하기
	@RequestMapping(value = "apt_intro_modify.ams", method = RequestMethod.POST)
	public String apt_Intro_Modify_Ok() {
		System.out.println("단지소개 수정하기 완료 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	
	
	//2.1 단지소개 상세보기
	@RequestMapping("apt_location.ams")
	public String apt_Location_View() {
		System.out.println("단지위치 상세보기 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	

	//2.2 단지위치 수정하기
	@RequestMapping(value = "apt_location_modify.ams", method = RequestMethod.GET)
	public String apt_Location_Modify() {
		System.out.println("단지위치 수정하기 실행");

		return "AdminOffice.APTInfo.APTInfo_Modify";
	}
	

	//2.3 단지위치 수정 완료하기
	@RequestMapping(value = "apt_location_modify.ams", method = RequestMethod.POST)
	public String apt_Location_Modify_Ok() {
		System.out.println("단지위치 수정하기 완료 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	
	
	//3.1 단지배치도 상세보기
	@RequestMapping("apt_layout.ams")
	public String apt_Layout_View() {
		System.out.println("단지배치도 상세보기 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	

	//3.2 단지배치도 수정하기
	@RequestMapping(value = "apt_layout_modify.ams", method = RequestMethod.GET)
	public String apt_Layout_Modify() {
		System.out.println("단지배치도 수정하기 실행");

		return "AdminOffice.APTInfo.APTInfo_Modify";
	}
	

	//3.3 단지배치도 수정 완료하기
	@RequestMapping(value = "apt_layout_modify.ams", method = RequestMethod.POST)
	public String apt_Layout_Modify_Ok() {
		System.out.println("단지배치도 수정하기 완료 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	

	//4.1 단지평형도 상세보기
	@RequestMapping("apt_size.ams")
	public String apt_Size_View() {
		System.out.println("단지평형도 상세보기 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	

	//4.2 단지평형도 수정하기
	@RequestMapping(value = "apt_size_modify.ams", method = RequestMethod.GET)
	public String apt_Size_Modify() {
		System.out.println("단지평형도 수정하기 실행");

		return "AdminOffice.APTInfo.APTInfo_Modify";
	}

	
	//4.3 단지평형도 수정 완료하기
	@RequestMapping(value = "apt_size_modify.ams", method = RequestMethod.POST)
	public String apt_Size_Modify_Ok() {
		System.out.println("단지평형도 수정하기 완료 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
	
	
	//5.1 편의시설 상세보기
	@RequestMapping("apt_facility.ams")
	public String apt_Facility_View() {
		System.out.println("편의시설 상세보기 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}

	//5.2 편의시설 수정하기
	@RequestMapping(value = "apt_facility_modify.ams", method = RequestMethod.GET)
	public String apt_Facility_Modify() {
		System.out.println("편의시설 수정하기 실행");

		return "AdminOffice.APTInfo.APTInfo_Modify";
	}

	//5.3 단지소개 수정 완료하기
	@RequestMapping(value = "apt_facility_modify.ams", method = RequestMethod.POST)
	public String apt_Facility_Modify_Ok() {
		System.out.println("편의시설 수정하기 완료 실행");

		return "AdminOffice.APTInfo.APTInfo_Detail";
	}
}
