package kr.co.AMS.Controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.AMS.Model.vo.Complaint_board;
import kr.co.AMS.Service.ComplaintService;

//민원게시판
@Controller
public class ComplaintController {

	@Autowired
	ComplaintService Complaintervice;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 1.민원게시판 목록보기
	@RequestMapping("complain_list.ams")
		public String complain_list_View(String pg, String rowSize, String order, Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 목록보기 실행");

		String search = req.getParameter("search");
		String period = req.getParameter("period");
		String scope = req.getParameter("scope");

		HashMap<String, Object> maps = Complaintervice.getAllComplaintsList(pg, rowSize, order, search, period, scope);

		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("pageCount", maps.get("pageCount"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("rowSize", maps.get("rowSize"));
		model.addAttribute("order", maps.get("order"));
		model.addAttribute("search", maps.get("search"));
		model.addAttribute("period", maps.get("period"));
		model.addAttribute("scope", maps.get("scope"));

		return "AdminOffice.Complaint_board.Complain_List";
	}

	// 2.민원게시판 상세보기
	@RequestMapping("complain_detail.ams")
	public String complain_Detail_View(int board_idx, int pg, int rowSize, String order, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 상세보기 실행");

		int result = Complaintervice.updateHit(board_idx);
		Complaint_board complaint_board = Complaintervice.getComplaintDetail(board_idx);

		model.addAttribute("complaint", complaint_board);
		model.addAttribute("pg", pg);
		model.addAttribute("rowSize", rowSize);
		model.addAttribute("order", order);

		return "AdminOffice.Complaint_board.Complain_Detail";
	}

	// 3.1 민원게시판 글 작성하기
	@RequestMapping(value = "complain_write.ams", method = RequestMethod.GET)
	public String complain_Write_View() {

		System.out.println("민원게시판 글 작성 실행");

		return "AdminOffice.Complaint_board.Complain_Write";
	}

	// 3.2 민원게시판 글 작성 완료하기
	@RequestMapping(value = "complain_write.ams", method = RequestMethod.POST)
	public String complain_Write_Ok(Complaint_board Complaint_board) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 작성 완료 실행");

		int result = Complaintervice.writeComplaint(Complaint_board);

		String view = null;

		if (result > 0) {
			System.out.println("글 작성 성공");
			view = "redirect:complain_list.ams";
		} else {
			System.out.println("글 작성 실패");
			view = "redirect:complaint_write.ams";
		}

		return view;
	}

	// 4.1 민원게시판 답변 작성하기
	@RequestMapping(value = "complain_rewrite.ams", method = RequestMethod.GET)
	public String complain_Rewrite_View(int board_idx, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 답 글 작성 실행");

		Complaint_board Complaint_board = Complaintervice.getComplaintDetail(board_idx);

		model.addAttribute("complaint", Complaint_board);

		return "AdminOffice.Complaint_board.Complain_ReWrite";
	}

	// 4.2 민원게시판 답변 작성 완료하기
	@RequestMapping(value = "complain_rewrite.ams", method = RequestMethod.POST)
	public String complain_Rewrite_Ok() {
		System.out.println("민원게시판 답 글 작성 완료 실행");

		return "AdminOffice.Complaint_board.Complain_List";
	}

	// 5.1 민원게시판 글 수정하기
	@RequestMapping(value = "complain_modify.ams", method = RequestMethod.GET)
	public String complain_Modify_View(int board_idx, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 수정 실행");

		Complaint_board complaint_board = Complaintervice.getComplaintDetail(board_idx);

		model.addAttribute("complaint", complaint_board);

		return "AdminOffice.Complaint_board.Complain_Modify";
	}

	// 5.2 민원게시판 글 수정 완료 하기
	@RequestMapping(value = "complain_modify.ams", method = RequestMethod.POST)
	public String complain_Modify_Ok(Complaint_board complaint_board) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 수정 완료 실행");

		int result = Complaintervice.updateComplaint(complaint_board);

		String view = null;

		if (result > 0) {
			System.out.println("글 작성 성공");
			view = "complain_detail.ams?board_idx=" + complaint_board.getBoard_idx();
		} else {
			System.out.println("글 작성 실패");
			view = "redirect:complain_modify.ams";
		}

		return "AdminOffice.Complaint_board.Complain_List";
	}

	// 6. 민원게시판 글 삭제하기
	@RequestMapping("complain_delete.ams")
	public String complain_Delete(int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 삭제 실행");

		int result = Complaintervice.deleteComplaint(board_idx);

		String view = null;

		if (result > 0) {
			System.out.println("글 작성 성공");
			view = "redirect:complain_list.ams";
		} else {
			System.out.println("글 작성 실패");
			view = "redirect:complaint_list.ams";
		}

		return view;
	}

	// 7. 민원게시판 글 검색하기
	@RequestMapping("complain_search.ams")
	public String complain_Search() {

		System.out.println("민원게시판 글 검색 실행");

		return "AdminOffice.Complaint_board.Complain_List";
	}

}
