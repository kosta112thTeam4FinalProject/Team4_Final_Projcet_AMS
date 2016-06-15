package kr.co.AMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//벼룩시장 게시판
@Controller
public class MarketController {
	
	/*@Autowired
	private NoticeService noticeService;*/
	
	//1.벼룩시장 목록보기
	@RequestMapping("market_list.ams")
	public String market_list_View()
	{
		System.out.println("벼룩시장 목록보기 실행");		
		
		return "Residents.Market_board.Market_List";
	}
	
	
	//2. 벼룩시장 상세보기	
	@RequestMapping("market_detail.ams")
	public String market_Detail_View()
	{
		System.out.println("벼룩시장 상세보기 실행");
		
		return "Residents.Market_board.Market_Detail";
	}
	
	
	//3.1 벼룩시장 글 작성하기
	//@RequestMapping("market_write.ams")
	@RequestMapping(value="market_write.ams", method=RequestMethod.GET)
	public String market_Write_View() {
		System.out.println("벼룩시장 글 작성 실행");

	
		return "Residents.Market_board.Market_Write";
	}
	
	
	//3.2 벼룩시장 글 작성 완료하기
	@RequestMapping(value="market_write.ams", method=RequestMethod.POST)
	public String market_Write_Ok() {
		System.out.println("벼룩시장 글 작성 완료 실행");

		
		return "Residents.Market_board.Market_List";
	}
	

	//4.1 벼룩시장 답변 작성하기
	//@RequestMapping("market_rewrite.ams")
	@RequestMapping(value="market_rewrite.ams", method=RequestMethod.GET)
	public String market_Rewrite_View() {
		System.out.println("벼룩시장 답 글 작성 실행");

		
		return "Residents.Market_board.Market_ReWrite";
	}
	
	
	//4.2 벼룩시장 답변 작성 완료하기
	@RequestMapping(value="market_rewrite.ams", method=RequestMethod.POST)
	public String market_Rewrite_Ok() {
		System.out.println("벼룩시장 답 글 작성 완료 실행");

		
		return "Residents.Market_board.Market_List";
	}
	
	
	//5.1 벼룩시장 글 수정하기
	//@RequestMapping("market_modify.ams")
	@RequestMapping(value="market_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String market_Modify_View() {
		System.out.println("벼룩시장 글 수정 실행");

		
		return "Residents.Market_board.Market_Modify";
	}
	
	
	//5.2 벼룩시장 글 수정 완료 하기	
	@RequestMapping(value="market_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String market_Modify_Ok() {
		System.out.println("벼룩시장 글 수정 완료 실행");

		
		return "Residents.Market_board.Market_List";
	}
	
	
	//6. 벼룩시장 글 삭제하기
	@RequestMapping("market_delete.ams")
	public String market_Delete() {
		System.out.println("벼룩시장 글 삭제 실행");

		
		return "Residents.Market_board.Market_List";
	}
	
	//7. 벼룩시장 글 검색하기
	@RequestMapping("market_search.ams")
	public String market_Search() {
		System.out.println("벼룩시장 글 검색 실행");

		return "Residents.Market_board.Market_List";
	}
	
	
	

}
