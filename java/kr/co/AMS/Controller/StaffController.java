package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//직원전용게시판 게시판
@Controller
public class StaffController {
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	//1.직원전용게시판 목록보기
	@RequestMapping("staff_list.ams")
	public String staff_list_View()
	{
		System.out.println("직원전용게시판 목록보기 실행");		
		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	//2. 직원전용게시판 상세보기	
	@RequestMapping("staff_detail.ams")
	public String staff_Detail_View()
	{
		System.out.println("직원전용게시판 상세보기 실행");
		
		return "AdminOffice.Staff_board.Staff_Detail";
	}
	
	
	//3.1 직원전용게시판 글 작성하기
	//@RequestMapping("staff_write.ams")
	@RequestMapping(value="staff_write.ams", method=RequestMethod.GET)
	public String staff_Write_View() {
		System.out.println("직원전용게시판 글 작성 실행");

	
		return "AdminOffice.Staff_board.Staff_Write";
	}
	
	
	//3.2 직원전용게시판 글 작성 완료하기
	@RequestMapping(value="staff_write.ams", method=RequestMethod.POST)
	public String staff_Write_Ok() {
		System.out.println("직원전용게시판 글 작성 완료 실행");

		
		return "AdminOffice.Staff_board.Staff_List";
	}
	

	//4.1 직원전용게시판 답변 작성하기
	//@RequestMapping("staff_rewrite.ams")
	@RequestMapping(value="staff_rewrite.ams", method=RequestMethod.GET)
	public String staff_Rewrite_View() {
		System.out.println("직원전용게시판 답 글 작성 실행");

		
		return "AdminOffice.Staff_board.Staff_ReWrite";
	}
	
	
	//4.2 직원전용게시판 답변 작성 완료하기
	@RequestMapping(value="staff_rewrite.ams", method=RequestMethod.POST)
	public String staff_Rewrite_Ok() {
		System.out.println("직원전용게시판 답 글 작성 완료 실행");

		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	//5.1 직원전용게시판 글 수정하기
	//@RequestMapping("staff_modify.ams")
	@RequestMapping(value="staff_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String staff_Modify_View() {
		System.out.println("직원전용게시판 글 수정 실행");

		
		return "AdminOffice.Staff_board.Staff_Modify";
	}
	
	
	//5.2 직원전용게시판 글 수정 완료 하기	
	@RequestMapping(value="staff_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String staff_Modify_Ok() {
		System.out.println("직원전용게시판 글 수정 완료 실행");

		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	//6. 직원전용게시판 글 삭제하기
	@RequestMapping("staff_delete.ams")
	public String staff_Delete() {
		System.out.println("직원전용게시판 글 삭제 실행");

		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	//7. 직원전용게시판 글 검색하기
	@RequestMapping("staff_search.ams")
	public String staff_Search() {
		System.out.println("직원전용게시판 글 검색 실행");

		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	

}
