package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//민원게시판
@Controller
public class ComplaintsController {
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	//1.민원게시판 목록보기
	@RequestMapping("complain_list.ams")
	public String complain_list_View()
	{
		System.out.println("민원게시판 목록보기 실행");
		
		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	
	
	//2.민원게시판 상세보기	
	@RequestMapping("complain_detail.ams")
	public String complain_Detail_View()
	{
		System.out.println("민원게시판 상세보기 실행");
		
		
		return "AdminOffice.Complaints_board.Complain_Detail";
	}
	
	
	//3.1 민원게시판 글 작성하기	
	@RequestMapping(value="complain_write.ams", method=RequestMethod.GET)
	public String complain_Write_View() {
		System.out.println("민원게시판 글 작성 실행");

		
		return "AdminOffice.Complaints_board.Complain_Write";
	}
	
	
	//3.2 민원게시판 글 작성 완료하기
	@RequestMapping(value="complain_write.ams", method=RequestMethod.POST)
	public String complain_Write_Ok() {
		System.out.println("민원게시판 글 작성 완료 실행");

		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	

	//4.1 민원게시판 답변 작성하기	
	@RequestMapping(value="complain_rewrite.ams", method=RequestMethod.GET)
	public String complain_Rewrite_View() {
		System.out.println("민원게시판 답 글 작성 실행");

	
		return "AdminOffice.Complaints_board.Complain_ReWrite";
	}
	
	
	//4.2 민원게시판 답변 작성 완료하기
	@RequestMapping(value="complain_rewrite.ams", method=RequestMethod.POST)
	public String complain_Rewrite_Ok() {
		System.out.println("민원게시판 답 글 작성 완료 실행");

		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	
	
	//5.1 민원게시판 글 수정하기
	@RequestMapping(value="complain_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String complain_Modify_View() {
		System.out.println("민원게시판 글 수정 실행");

		
		return "AdminOffice.Complaints_board.Complain_Modify";
	}
	
	
	//5.2 민원게시판 글 수정 완료 하기	
	@RequestMapping(value="complain_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String complain_Modify_Ok() {
		System.out.println("민원게시판 글 수정 완료 실행");

		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	
	
	//6. 민원게시판 글 삭제하기
	@RequestMapping("complain_delete.ams")
	public String complain_Delete() {
		System.out.println("민원게시판 글 삭제 실행");

		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	
	//7. 민원게시판 글 검색하기
	@RequestMapping("complain_search.ams")
	public String complain_Search() {
		
		System.out.println("민원게시판 글 검색 실행");

		
		return "AdminOffice.Complaints_board.Complain_List";
	}
	
	
	

}
