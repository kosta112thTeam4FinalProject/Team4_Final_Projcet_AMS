package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//익명게시판 게시판
@Controller
public class AnonymousController {
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	//1.익명게시판 목록보기
	@RequestMapping("anonymous_list.ams")
	public String anonymous_list_View()
	{
		System.out.println("익명게시판 목록보기 실행");		
		
		return "Residents.Anonymous_board.Anonymous_List";
	}
	
	
	//2. 익명게시판 상세보기	
	@RequestMapping("anonymous_detail.ams")
	public String anonymous_Detail_View()
	{
		System.out.println("익명게시판 상세보기 실행");
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	//3.1 익명게시판 글 작성하기
	//@RequestMapping("anonymous_write.ams")
	@RequestMapping(value="anonymous_write.ams", method=RequestMethod.GET)
	public String anonymous_Write_View() {
		System.out.println("익명게시판 글 작성 실행");

	
		return "Residents.Anonymous_board.Anonymous_Write";
	}
	
	
	//3.2 익명게시판 글 작성 완료하기
	@RequestMapping(value="anonymous_write.ams", method=RequestMethod.POST)
	public String anonymous_Write_Ok() {
		System.out.println("익명게시판 글 작성 완료 실행");

		
		return "Residents.Anonymous_board.Anonymous_List";
	}
	

	//4.1 익명게시판 답변 작성하기
	//@RequestMapping("anonymous_rewrite.ams")
	@RequestMapping(value="anonymous_rewrite.ams", method=RequestMethod.GET)
	public String anonymous_Rewrite_View() {
		System.out.println("익명게시판 답 글 작성 실행");

		
		return "Residents.Anonymous_board.Anonymous_ReWrite";
	}
	
	
	//4.2 익명게시판 답변 작성 완료하기
	@RequestMapping(value="anonymous_rewrite.ams", method=RequestMethod.POST)
	public String anonymous_Rewrite_Ok() {
		System.out.println("익명게시판 답 글 작성 완료 실행");

		
		return "Residents.Anonymous_board.Anonymous_List";
	}
	
	
	//5.1 익명게시판 글 수정하기
	//@RequestMapping("anonymous_modify.ams")
	@RequestMapping(value="anonymous_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String anonymous_Modify_View() {
		System.out.println("익명게시판 글 수정 실행");

		
		return "Residents.Anonymous_board.Anonymous_Modify";
	}
	
	
	//5.2 익명게시판 글 수정 완료 하기	
	@RequestMapping(value="anonymous_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String anonymous_Modify_Ok() {
		System.out.println("익명게시판 글 수정 완료 실행");

		
		return "Residents.Anonymous_board.Anonymous_List";
	}
	
	
	//6. 익명게시판 글 삭제하기
	@RequestMapping("anonymous_delete.ams")
	public String anonymous_Delete() {
		System.out.println("익명게시판 글 삭제 실행");

		
		return "Residents.Anonymous_board.Anonymous_List";
	}
	
	//7. 익명게시판 글 검색하기
	@RequestMapping("anonymous_search.ams")
	public String anonymous_Search() {
		System.out.println("익명게시판 글 검색 실행");

		return "Residents.Anonymous_board.Anonymous_List";
	}
	
	
	
}
