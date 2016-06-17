package kr.co.AMS.Controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.AMS.Model.vo.Staff_board;
import kr.co.AMS.Service.StaffService;

//직원전용게시판 게시판

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	//1.직원전용게시판 목록보기
	@RequestMapping("staff_list.ams")
	public String staff_list_View(String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("직원전용게시판 목록보기 실행");		
		
		HashMap maps = staffService.getAllStaffList(pg);
	      
		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	//2. 직원전용게시판 상세보기	
	@RequestMapping("staff_detail.ams")
	public String staff_Detail_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("직원전용게시판 상세보기 실행");
		Staff_board staff_board = staffService.staffDetail(model,board_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("staff_board", staff_board);
		 
		 
		 
		return "AdminOffice.Staff_board.Staff_Detail";
	}
	
	
	//3.1 직원전용게시판 글 작성하기
	//@RequestMapping("staff_write.ams")
	@RequestMapping(value="staff_write.ams", method=RequestMethod.GET)
	public String staff_Write_View(Staff_board staff_board, Model model, Principal principal) {
		System.out.println("직원전용게시판 글 작성 실행");
		
	/*	staff_board.setWriter(principal.getName());;
		 model.addAttribute("staff_board", staff_board);*/
	
		return "AdminOffice.Staff_board.Staff_Write";
	}
	
	
	//3.2 직원전용게시판 글 작성 완료하기
	@RequestMapping(value="staff_write.ams", method=RequestMethod.POST)
	public String staff_Write_Ok(String pg, HttpServletRequest request,Staff_board staff_board, Model model) throws Exception {
		System.out.println("직원전용게시판 글 작성 완료 실행");
		
		staffService.staffInserOk(request,staff_board);
		
		HashMap maps = staffService.getAllStaffList(pg);
	      
		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		
		return "AdminOffice.Staff_board.Staff_List";
	}
	

	//4.1 직원전용게시판 답변 작성하기
	//@RequestMapping("staff_rewrite.ams")
	@RequestMapping(value="staff_rewrite.ams", method=RequestMethod.GET)
	public String staff_Rewrite_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("직원전용게시판 답 글 작성 실행");
		Staff_board staff_board = staffService.staffRewriteView(board_idx);

		model.addAttribute("pg", pg);
		model.addAttribute("staff_board", staff_board);
		return "AdminOffice.Staff_board.Staff_ReWrite";
	}
	
	
	//4.2 직원전용게시판 답변 작성 완료하기
	@RequestMapping(value="staff_rewrite.ams", method=RequestMethod.POST)
	public String staff_Rewrite_Ok(Staff_board staff_board, String pg) throws ClassNotFoundException, SQLException {

	int result = staffService.staffRewriteOk(staff_board);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:Staff_List.ams?pg="+pg;
		}
		else
		{
			view = "redirect:index.asm";
		}

		
		return view;
		
	}
	
	
	//5.1 직원전용게시판 글 수정하기
	//@RequestMapping("staff_modify.ams")
	@RequestMapping(value="staff_modify.ams", method=RequestMethod.GET) /*<--실제 구현시 사용*/
	public String staff_Modify_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("직원전용게시판 글 수정 실행");
		Staff_board staff_board = staffService.staffModifyView(board_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("staff_board", staff_board);
		
		return "AdminOffice.Staff_board.Staff_Modify";
	}
	
	
	//5.2 직원전용게시판 글 수정 완료 하기	
	@RequestMapping(value="staff_modify.ams", method=RequestMethod.POST)/*<--실제 구현시 사용*/
	public String staff_Modify_Ok(Staff_board anony_board, String pg) throws ClassNotFoundException, SQLException {
		System.out.println("직원전용게시판 글 수정 완료 실행");
		int result = staffService.staffModifyViewOk(anony_board);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:Staff_List.ams?pg="+pg;
		}
		else
		{
			view = "redirect:index.asm";
		}
			
		return  view;
	}
	
	
	//6. 직원전용게시판 글 삭제하기
	@RequestMapping("staff_delete.ams")
	public String staff_Delete(Model model, String pg, int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("직원전용게시판 글 삭제 실행");
		
		HashMap maps = staffService.getAllStaffList(pg);
	      
		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		
		int result = staffService.staffDelete(board_idx);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:Staff_List.ams?pg="+pg;
		}
		else
		{
			view = "redirect:index.asm";
		}
		 return view;
	}
	
	@RequestMapping("/downloadFile.htm")
	public void downloadFile(String idx, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		staffService.downloadFile(idx, response);
		
	}
	
	//7. 직원전용게시판 글 검색하기
	@RequestMapping("staff_search.ams")
	public String staff_Search(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("직원전용게시판 글 검색 실행");
		
		staffService.searchBoard(request, response, model);
		
		
		return "AdminOffice.Staff_board.Staff_List";
	}
	
	
	

}
