package kr.co.AMS.Controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kr.co.AMS.Model.vo.Complaint_board;
import kr.co.AMS.Model.vo.Complaint_comment;
import kr.co.AMS.Service.ComplaintService;

//민원게시판
@Controller
public class ComplaintController {

	@Autowired
	ComplaintService ComplaintService;
	
	@Autowired
	private View jsonview;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 1.민원게시판 목록보기
	@RequestMapping("complain_list.ams")
	public String complain_list_View(String pg, String rowSize, String order, Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, ParseException {
		System.out.println("민원게시판 목록보기 실행");

		String search = req.getParameter("search");
		String period = req.getParameter("period");
		String scope = req.getParameter("scope");

		HashMap<String, Object> maps = ComplaintService.getAllComplaintsList(pg, rowSize, order, search, period, scope);

		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd"); Date
		 * d = new Date(); Date date = dateFormat.parse(dateFormat.format(d));
		 * 
		 * List<Complaint_board> list = (ArrayList<Complaint_board>)
		 * maps.get("list");
		 * 
		 * for(Complaint_board complaint_board : list){
		 * complaint_board.setRegdate(dateFormat.parse(dateFormat.format(
		 * complaint_board.getRegdate())));
		 * System.out.println(complaint_board.getRegdate()); }
		 */
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
		/* model.addAttribute("date", date); */

		return "AdminOffice.Complaint_board.Complain_List";
	}

	// 댓글 목록
	/*@RequestMapping(value="complain_comment.ams", method=RequestMethod.POST)
	public View complain_comment_list(String pg, String order, Model model)
			throws ClassNotFoundException, SQLException{
		
		HashMap<String, Object> maps = ComplaintService.getCommentList(pg, order);
		
		model.addAttribute("comment", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("pageCount", maps.get("pageCount"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("rowSize", maps.get("rowSize"));
		model.addAttribute("order", maps.get("order"));
		
		return jsonview;
	}*/
	
	// 댓글 입력
	@RequestMapping(value="complain_write_comment.ams", method=RequestMethod.POST)
	public View complain_comment_list(Complaint_comment complaint_comment, Model model)
			throws ClassNotFoundException, SQLException{
		
		int result = ComplaintService.writeComment(complaint_comment);
		Complaint_comment comment = ComplaintService.readComment(complaint_comment.getComment_idx());
		
		model.addAttribute("complaint_comment", comment);
		
		return jsonview;
	}
	
	
	// 댓글의 댓글 쓰기 창
	@RequestMapping(value="complain_rewrite_comment.ams", method=RequestMethod.GET)
	public View reWriteComment(int comment_idx , Model model) throws ClassNotFoundException, SQLException{
		
		Complaint_comment comment = ComplaintService.readComment(comment_idx);
		
		model.addAttribute("complaint_comment", comment);
		
		return jsonview;
	}
	
	
	// 댓글의 댓글 쓰기 완료
	@RequestMapping(value="complain_rewrite_comment.ams", method=RequestMethod.POST)
	public View reWriteCommentComplete(Complaint_comment complaint_comment, Model model) throws ClassNotFoundException, SQLException{

		return jsonview;
	}
	
	// 2.민원게시판 상세보기
	@RequestMapping("complain_detail.ams")
	public String complain_Detail_View(int board_idx, int pg, int rowSize, String order, 
			String search, String period, String scope, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 상세보기 실행");

		int result = ComplaintService.updateHit(board_idx);
		Complaint_board complaint_board = ComplaintService.getComplaintDetail(board_idx);

		List<Complaint_comment> list = ComplaintService.getCommentList(board_idx);
		
		model.addAttribute("complaint", complaint_board);
		model.addAttribute("comment", list);
		model.addAttribute("pg", pg);
		model.addAttribute("rowSize", rowSize);
		model.addAttribute("order", order);
		model.addAttribute("search", search);
		model.addAttribute("period", period);
		model.addAttribute("scope", scope);
		
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

		int result = ComplaintService.writeComplaint(Complaint_board);

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
	public String complain_Rewrite_View(int board_idx, String pg, String rowSize, String order, String search,
			String period, String scope, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 답 글 작성 실행");

		Complaint_board Complaint_board = ComplaintService.getComplaintDetail(board_idx);

		model.addAttribute("complaint", Complaint_board);
		model.addAttribute("pg", pg);
		model.addAttribute("rowSize", rowSize);
		model.addAttribute("order", order);
		model.addAttribute("search", search);
		model.addAttribute("period", period);
		model.addAttribute("scope", scope);

		return "AdminOffice.Complaint_board.Complain_ReWrite";
	}

	// 4.2 민원게시판 답변 작성 완료하기
	@RequestMapping(value = "complain_rewrite.ams", method = RequestMethod.POST)
	public String complain_Rewrite_Ok(Complaint_board complaint_board, String pg, String rowSize, String order,
			String search, String period, String scope, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 답 글 작성 완료 실행");

		int result = ComplaintService.reWriteComplaint(complaint_board);

		String view = null;

		if (result > 0) {
			view = "AdminOffice.Complaint_board.Complain_List";
		} else {
			view = "AdminOffice.Complaint_board.Complain_List";
		}

		HashMap<String, Object> maps = ComplaintService.getAllComplaintsList(pg, rowSize, order, search, period, scope);

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

		return view;
	}

	// 5.1 민원게시판 글 수정하기
	@RequestMapping(value = "complain_modify.ams", method = RequestMethod.GET)
	public String complain_Modify_View(int board_idx, String pg, String rowSize, String order, String search,
			String period, String scope, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 수정 실행");

		Complaint_board complaint_board = ComplaintService.getComplaintDetail(board_idx);

		model.addAttribute("complaint", complaint_board);
		model.addAttribute("pg", pg);
		model.addAttribute("rowSize", rowSize);
		model.addAttribute("order", order);
		model.addAttribute("search", search);
		model.addAttribute("period", period);
		model.addAttribute("scope", scope);

		return "AdminOffice.Complaint_board.Complain_Modify";
	}

	// 5.2 민원게시판 글 수정 완료 하기
	@RequestMapping(value = "complain_modify.ams", method = RequestMethod.POST)
	public String complain_Modify_Ok(Complaint_board complaint_board) throws ClassNotFoundException, SQLException {
		System.out.println("민원게시판 글 수정 완료 실행");

		int result = ComplaintService.updateComplaint(complaint_board);

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

		int result = ComplaintService.deleteComplaint(board_idx);

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

}
