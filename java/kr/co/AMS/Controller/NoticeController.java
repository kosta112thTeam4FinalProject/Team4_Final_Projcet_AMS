package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//공지사항 게시판
@Controller
/*@RequestMapping("/AdminOffice")*/
public class NoticeController {
	
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	
	//1.공지사항 목록보기
	@RequestMapping("notice_list.ams")
	public String notice_list_View()
	{
		System.out.println("공지사항 목록보기 실행");		
		
		return "AdminOffice.Notice_board.Notice_List";
	}
	
	
	//2. 공지사항 상세보기	
	@RequestMapping("notice_detail.ams")
	public String notice_Detail_View()
	{
		System.out.println("공지사항 상세보기 실행");
		
		return "AdminOffice.Notice_board.Notice_Detail";
	}
	
	
	//3.1 공지사항 글 작성하기
	//@RequestMapping("notice_write.ams")
	@RequestMapping(value="notice_write.ams", method=RequestMethod.GET)
	public String notice_Write_View() {
		System.out.println("공지사항 글 작성 실행");

	
		return "AdminOffice.Notice_board.Notice_Write";
	}
	
	
	//3.2 공지사항 글 작성 완료하기
	@RequestMapping(value="notice_write.ams", method=RequestMethod.POST)
	public String notice_Write_Ok() {
		System.out.println("공지사항 글 작성 완료 실행");

		
		return "AdminOffice.Notice_board.Notice_List";
	}
	

	//4.1 공지사항 답변 작성하기
	//@RequestMapping("notice_rewrite.ams")
	@RequestMapping(value="notice_rewrite.ams", method=RequestMethod.GET)
	public String notice_Rewrite_View() {
		System.out.println("공지사항 답 글 작성 실행");

		
		return "AdminOffice.Notice_board.Notice_ReWrite";
	}
	
	
	//4.2 공지사항 답변 작성 완료하기
	@RequestMapping(value="notice_rewrite.ams", method=RequestMethod.POST)
	public String notice_Rewrite_Ok() {
		System.out.println("공지사항 답 글 작성 완료 실행");

		
		return "AdminOffice.Notice_board.Notice_List";
	}
	
	
	//5.1 공지사항 글 수정하기
	//@RequestMapping("notice_modify.ams")
	@RequestMapping(value="notice_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String notice_Modify_View() {
		System.out.println("공지사항 글 수정 실행");

		
		return "AdminOffice.Notice_board.Notice_Modify";
	}
	
	
	//5.2 공지사항 글 수정 완료 하기	
	@RequestMapping(value="notice_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String notice_Modify_Ok() {
		System.out.println("공지사항 글 수정 완료 실행");

		
		return "AdminOffice.Notice_board.Notice_List";
	}
	
	
	//6. 공지사항 글 삭제하기
	@RequestMapping("notice_delete.ams")
	public String notice_Delete() {
		System.out.println("공지사항 글 삭제 실행");

		
		return "AdminOffice.Notice_board.Notice_List";
	}
	
	//7. 공지사항 글 검색하기
	@RequestMapping("notice_search.ams")
	public String notice_Search() {
		System.out.println("공지사항 글 검색 실행");

		return "AdminOffice.Notice_board.Notice_List";
	}
	
	
	

}
