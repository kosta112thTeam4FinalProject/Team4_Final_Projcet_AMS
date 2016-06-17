package kr.co.AMS.Controller;

// import 추가 
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.AMS.Model.vo.Notice_board;
import kr.co.AMS.Service.NoticeService;

//공지사항 게시판
@Controller
/*@RequestMapping("/AdminOffice")*/
public class NoticeController {
	
	
	// NoticeService 타입의 noticeService @Autowired 통해서 주입
	@Autowired
	private NoticeService noticeService;
	
	
	//1.공지사항 목록보기 
	@RequestMapping("notice_list.ams") //@RequestMapping을 통해 "notice_list.ams" 이것을 찾으면 여기 함수 실행
	public String notice_list_View(String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("공지사항 목록보기 실행");		
		
		// 페이지 목록 보기를 위한 처리 
		int page = 1;
		String Strpg = pg;
		if (Strpg != null) {
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 10;  //한 페이지에 보이기 하는 목록의 수
		int start = (page * rowSize) - (rowSize - 1);  
		int end = page * rowSize;
		int total = noticeService.notice_Count_Service(); //개시물의 총 갯수 구함
		// ... 목록
	   int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
	   int totalPage = total / rowSize + (total % rowSize == 0 ? 0 : 1);
	   System.out.println("페이지수 : " + allPage);
				
	   int block = 5;   // 한페이지에 보여줄 범위  (예)<< [1] [2] [3] [4] [5] >>
	   int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작 // ((1-1)/10*10)
	   int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
	   if (toPage > allPage) // 예) 20>17
	   {
		   toPage = allPage;
	   }
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//map에 시작, 끝 값을 넣는다.
		map.put("start", start);
		map.put("end", end);
		
		List<Notice_board> list = noticeService.notice_list_View_Service(map); //모든 목록을 받아온 값을 list에 대입
		
		System.out.println("list" + list.size());  
		
		//model 을 이용해서 파라메터 값을 넣는다. 
		model.addAttribute("pg", page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		model.addAttribute("list", list); 
		//view 단에 사용할 객체 생성 가능( ModelAndView의 addObject() 와 같은기능)
		//자동 forward
  		//단 notices(Model model) 함수의 parameter
	
		return "AdminOffice.Notice_board.Notice_List";
	}
	
	
	//2. 공지사항 상세보기	
	@RequestMapping("notice_detail.ams")
	public String notice_Detail_View(int board_idx, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("공지사항 상세보기 실행");
		Notice_board detail = noticeService.notice_detail_View_Service(board_idx);
		
		//model 을 이용해서 파라메터 값을 넣는다. 
		//view 단에 사용할 객체 생성 가능( ModelAndView의 addObject() 와 같은기능)
		//자동 forward
  		//단 notices(Model model) 함수의 parameter
		model.addAttribute("detail", detail);
		return "AdminOffice.Notice_board.Notice_Detail";
	}
	
	
	//3.1 공지사항 글 작성하기 :: Notice_List.jsp 에서 등록으로 인해서 작동함
	@RequestMapping(value="notice_write.ams", method=RequestMethod.GET)
	public String notice_Write_View() {
		System.out.println("공지사항 글 작성 실행");

		return "AdminOffice.Notice_board.Notice_Write";
	}
	
	
	//3.2 공지사항 글 작성 완료하기 : Notice_Write.jsp 에서 post 방식의 submit 으로 인해서 작동
	@RequestMapping(value="notice_write.ams", method=RequestMethod.POST)
	public String notice_Write_Ok(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 글 작성 완료 실행");

		String url = noticeService.Notice_Write_Ok_Service(m);
		//서비스에서 리턴하는 주소로 값을 받고 그 값을 리턴함 //notice_list.ams 로 이동
		return url ;
	}
	

	//4.1 공지사항 답변 작성하기
	@RequestMapping(value="notice_rewrite.ams", method=RequestMethod.GET)
	public String notice_Rewrite_View(Notice_board m,Model model) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 답 글 작성 실행");
		// 정보를 읽어 오는지 확인하기 위한 처리문 : 추후 삭제 해야함
		System.out.println("ref : " + m.getRef());
		System.out.println("idx : " + m.getBoard_idx());
		System.out.println("depth : " + m.getDepth());
		//reply 변수에 해당 board_idx 값의 내용들을 대입
		Notice_board reply = noticeService.notice_detail_View_Service(m.getBoard_idx());
		// 정보를 읽어 오는지 확인하기 위한 처리문 : 추후 삭제 해야함
		System.out.println("reply" + reply.getContent());
		System.out.println(reply.getTitle());
		//이 reply를 model에 추가함
		//view 단에 사용할 객체 생성 가능( ModelAndView의 addObject() 와 같은기능)
		//자동 forward
  		//단 notices(Model model) 함수의 parameter
		model.addAttribute("reply", reply);
		return "AdminOffice.Notice_board.Notice_ReWrite";
	}
	
	
	//4.2 공지사항 답변 작성 완료하기
	@RequestMapping(value="notice_rewrite.ams", method=RequestMethod.POST)
	public String notice_Rewrite_Ok(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 답 글 작성 완료 실행");

		String url = noticeService.notice_Rewrite_Ok_Service(m);
		return url;
	}
	
	
	//5.1 공지사항 글 수정하기
	@RequestMapping(value="notice_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String notice_Modify_View(int board_idx, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 글 수정 실행");
		System.out.println("board_idx"+board_idx);

		Notice_board modify = noticeService.notice_detail_Modify_Service(board_idx);
		
		System.out.println("board_idx"+board_idx);
		
		//modify 를 model에 추가
		//view 단에 사용할 객체 생성 가능( ModelAndView의 addObject() 와 같은기능)
		//자동 forward
  		//단 notices(Model model) 함수의 parameter
		model.addAttribute("modify", modify);
		
		return "AdminOffice.Notice_board.Notice_Modify";
	}
	
	
	//5.2 공지사항 글 수정 완료 하기	
	@RequestMapping(value="notice_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String notice_Modify_Ok(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 글 수정 완료 실행");
		String url = noticeService.notice_detail_Modify_Service(m);
		return url;
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
