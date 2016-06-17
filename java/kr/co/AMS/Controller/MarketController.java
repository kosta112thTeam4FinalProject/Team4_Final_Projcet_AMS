package kr.co.AMS.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.AMS.Model.DAO.Market_boardDao;
import kr.co.AMS.Model.vo.Market_board;
import kr.co.AMS.Model.vo.Market_boardComment;
import kr.co.AMS.Service.MarketService;

//벼룩시장 게시판
@Controller
public class MarketController {

	@Autowired
	private MarketService service;

	/*
	 * @Autowired private SqlSession SqlSession;
	 */

	// 1.벼룩시장 목록보기
	@RequestMapping("market_list.ams")
	public String market_list_View(String pg, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 목록보기 controller");

		int page = 1;
		String Strpg = pg;
		if (Strpg != null) {
			page = Integer.parseInt(Strpg);
		}

		int rowSize = 10;
		int start = (page * rowSize) - (rowSize - 1);
		int end = page * rowSize;

		//List<Market_board> list = service.market_list_View_Service();
		// NoticeDao noticeDao = SqlSession.getMapper(NoticeDao.class);
		// int total = noticeDao.getCount();
		int total = service.market_Count_Service();

		System.out.println("start_page : " + start);
		System.out.println("end_page :  " + end);
		System.out.println("총 게시물 건수 : " + total);

		// ... 목록
		int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
		int totalPage = total / rowSize + (total % rowSize == 0 ? 0 : 1);
		System.out.println("페이지수 : " + allPage);

		int block = 5;
		// 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] >>
		int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
		// ((1-1)/10*10)
		int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
		if (toPage > allPage) // 예) 20>17
		{
			toPage = allPage;
		}

		// start와 end 값을 map에 담음
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		// List<Notice> list = noticeDao.getNotices(map);
		List<Market_board> list = service.market_list_View_Service(map);
		
		model.addAttribute("pg", page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		model.addAttribute("list", list);

		return "Residents.Market_board.Market_List";
	}

	// 2. 벼룩시장 상세보기
	@RequestMapping("market_detail.ams")
	public String market_Detail_View(int board_idx, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 상세보기 실행 controller");

		Market_board detail = service.market_Detail_View_Service(board_idx);
		List<Market_boardComment> list = service.Market_CommentList(board_idx);
		model.addAttribute("detail", detail);
		model.addAttribute("list", list);

		return "Residents.Market_board.Market_Detail";
	}

	// 3.1 벼룩시장 글 작성하기
	// @RequestMapping("market_write.ams")
	@RequestMapping(value = "market_write.ams", method = RequestMethod.GET)
	public String market_Write_View() {
		System.out.println("벼룩시장 글 작성 실행 get");

		return "Residents.Market_board.Market_Write";
	}

	// 3.2 벼룩시장 글 작성 완료하기
	@RequestMapping(value = "market_write.ams", method = RequestMethod.POST)
	public String market_Write_Ok(Market_board m) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 작성 완료 실행 post");

		String url = service.market_Write_Ok_Service(m);

		return url;
	}

	// 4.1 벼룩시장 답변 작성하기
	// @RequestMapping("market_rewrite.ams")
	@RequestMapping(value = "market_rewrite.ams", method = RequestMethod.GET)
	public String market_Rewrite_View(Market_board m, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 답 글 작성 실행 controller 1");
		System.out.println("ref : " + m.getRef());
		System.out.println("idx : " + m.getBoard_idx());
		System.out.println("depth : " + m.getDepth());
		Market_board reply = service.market_Detail_View_Service(m.getBoard_idx());
		model.addAttribute("reply", reply);

		return "Residents.Market_board.Market_ReWrite";
	}

	// 4.2 벼룩시장 답변 작성 완료하기
	@RequestMapping(value = "market_rewrite.ams", method = RequestMethod.POST)
	public String market_Rewrite_Ok(Market_board m) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 답 글 작성 완료 실행");
		String url = service.market_Rewrite_Ok_Service(m);
		System.out.println("벼룩시장 답 글 작성 완료 실행2 ");

		return url;
	}

	// 5.1 벼룩시장 글 수정하기
	// @RequestMapping("market_modify.ams")
	@RequestMapping(value = "market_modify.ams", method = RequestMethod.GET)
	public String market_Modify_View(int board_idx, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 수정 실행");
		System.out.println("idx : " + board_idx);
		Market_board modify = service.market_Modify_Ok_Service(board_idx);
		model.addAttribute("modify", modify);

		return "Residents.Market_board.Market_Modify";
	}

	// 5.2 벼룩시장 글 수정 완료 하기
	@RequestMapping(value = "market_modify.ams", method = RequestMethod.POST)
	public String market_Modify_Ok(Market_board m) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 수정 완료 실행");
		System.out.println("idx : " + m.getBoard_idx());
		String url = service.market_Modify_Ok_Service(m);

		System.out.println(m.getNotice());
		System.out.println(m.getContent());
		System.out.println(m.getTitle());
		System.out.println(m.getKind());

		return url;
	}

	// 6. 벼룩시장 글 삭제하기
	@RequestMapping("market_delete.ams")
	public String market_Delete(int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 삭제 실행");
		System.out.println("idx : " + board_idx);
		String url = service.market_Delete_Service(board_idx);

		return url;
	}

	// 7. 벼룩시장 글 검색하기
	@RequestMapping("market_search.ams")
	public String market_Search() {
		System.out.println("벼룩시장 글 검색 실행");

		return "Residents.Market_board.Market_List";
	}

	// 덧글 등록
	// 덧글등록 처리(실제 덧글등록 처리)
	@RequestMapping(value = "market_comment.ams", method = RequestMethod.POST)
	public String Market_Comment(Market_boardComment m) throws IOException, ClassNotFoundException, SQLException {

		System.out.println("실제 덧글 등록 처리");
		System.out.println("n : " + m.getContent());
		System.out.println("n : " + m.getBoard_idx());

		String url = service.Market_Comment(m);

		return url;
	}

	// 덧글 삭제
	// 6. 벼룩시장 글 삭제하기
	@RequestMapping("market_commentDel.ams")
	public String market_CommentDel(int comment_idx, int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 삭제 실행");
		System.out.println("idx : " + comment_idx);
		System.out.println("boardidx : " + board_idx);

		String url = service.market_CommentDel_Service(comment_idx, board_idx);

		return url;
	}

	
	@RequestMapping(value = "market_comment_Modify.ams", method = RequestMethod.POST)
	public String Market_Comment_Modify(Market_boardComment m) throws IOException, ClassNotFoundException, SQLException {

		System.out.println("덧글 수정 등록 처리");
		System.out.println("n : " + m.getContent());
		System.out.println("n : " + m.getBoard_idx());
		System.out.println("m : " + m.getComment_idx());

		String url = service.Market_Comment_Modify_Service(m);

		return url;
	}

}
