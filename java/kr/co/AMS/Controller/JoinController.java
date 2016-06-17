package kr.co.AMS.Controller;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.AMS.Model.vo.Anonymous_board;
import kr.co.AMS.Model.vo.Anonymous_comment;
import kr.co.AMS.Service.AnonymousService;
import kr.co.AMS.Service.JoinService;

//회원가입
@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	//1.회원가입 페이지 
	@RequestMapping("member_join.ams")
	public String mebmer_Join_View() throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_회원가입 페이지 보기");	
		
		return "Member.Join.Member_Join";
	}
	
	
	/*//2. 익명게시판 상세보기	
	@RequestMapping("anonymous_detail.ams")
	public String anonymous_Detail_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_익명게시판 상세보기 실행");
		
		Anonymous_board anony_board = anonymousService.anonyDetail(board_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("anony_board", anony_board);
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	//3.1 익명게시판 글 작성하기
	//@RequestMapping("anonymous_write.ams")
	@RequestMapping(value="anonymous_write.ams", method=RequestMethod.GET)
	public String anonymous_Write_View() {
		
		System.out.println("Con_익명게시판 글 작성 실행");

	
		return "Residents.Anonymous_board.Anonymous_Write";
	}
	
	
	//3.2 익명게시판 글 작성 완료하기
	@RequestMapping(value="anonymous_write.ams", method=RequestMethod.POST)
	public String anonymous_Write_Ok(Anonymous_board anony_board) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 글 작성 완료 실행");
		
		int result = anonymousService.anonyInserOk(anony_board);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_list.ams";
		}
		else
		{
			view = "redirect:index.asm";
		}	
		
		return view;
	
	}
	
	//4.1 익명게시판 답변 작성하기
	//@RequestMapping("anonymous_rewrite.ams")
	@RequestMapping(value="anonymous_rewrite.ams", method=RequestMethod.GET)
	public String anonymous_Rewrite_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 답 글 작성 실행");
		
		Anonymous_board anony_board = anonymousService.anonyRewriteView(board_idx);

		model.addAttribute("pg", pg);
		model.addAttribute("anony_board", anony_board);
		
		return "Residents.Anonymous_board.Anonymous_ReWrite";
	}
	
	
	//4.2 익명게시판 답변 작성 완료하기
	@RequestMapping(value="anonymous_rewrite.ams", method=RequestMethod.POST)
	public String anonymous_Rewrite_Ok(Anonymous_board anony_board, String pg) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 답 글 작성 완료 실행");
		
		int result = anonymousService.anonyRewriteOk(anony_board);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_list.ams?pg="+pg;
		}
		else
		{
			view = "redirect:index.asm";
		}

		
		return view;
	}
	
	
	//5.1 익명게시판 글 수정하기
	//@RequestMapping("anonymous_modify.ams")
	@RequestMapping(value="anonymous_modify.ams", method=RequestMethod.GET) <--실제 구현시 사용
	public String anonymous_Modify_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException 
	{
		System.out.println("Con_익명게시판 글 수정 실행");

		Anonymous_board anony_board = anonymousService.anonyModifyView(board_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("anony_board", anony_board);
		
		return "Residents.Anonymous_board.Anonymous_Modify";
	}
	
	
	//5.2 익명게시판 글 수정 완료 하기	
	@RequestMapping(value="anonymous_modify.ams", method=RequestMethod.POST)<--실제 구현시 사용
	public String anonymous_Modify_Ok(Anonymous_board anony_board, String pg) throws ClassNotFoundException, SQLException
	{
		
		System.out.println("Con_익명게시판 글 수정 완료 실행");
		
		int result = anonymousService.anonyModifyViewOk(anony_board);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_list.ams?pg="+pg;
		}
		else
		{
			view = "redirect:index.asm";
		}
			
		return  view;
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
	
	
	//8. 익명게시판 댓글 목록보기
	@RequestMapping("anonymous_comment_list.ams")
	public String anonymous_comment_list_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_익명게시판 댓글 목록보기 실행");	
		
		HashMap maps = anonymousService.getAllAnonyCommentList(board_idx, pg);
	      
		model.addAttribute("clist", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("board_idx", maps.get("board_idx"));
		
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	
	//2. 익명게시판 댓글 상세보기	
	@RequestMapping("anonymous_detail.ams")
	public String anonymous_Detail_View(int board_idx, String pg, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_익명게시판 상세보기 실행");
		
		Anonymous_board anony_board = anonymousService.anonyDetail(board_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("anony_board", anony_board);
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	//3. 익명게시판 댓글 작성 완료하기
	@RequestMapping(value = "anonymous_comment_write.ams", method=RequestMethod.POST)
	public String anonymous_Comment_Write_Ok(Anonymous_comment anony_comment, int board_idx) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 댓글 작성 완료 실행");
		int result = anonymousService.anonyCommentInserOk(anony_comment);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_detail.ams?board_idx="+board_idx;
		}
		else
		{
			view = "redirect:index.asm";
		}	
		
		return view;
	
	}
	
	//4.1 익명게시판 댓글의 댓글 작성하기
	@RequestMapping(value="anonymous_comment_rewrite.ams", method=RequestMethod.GET)
	public String anonymous_Comment_Rewrite_View(int comment_idx, String pg, Model model) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 댓글의 댓글 작성 실행");
		
		Anonymous_comment anony_comment = anonymousService.anonyCommentRewriteView(comment_idx);

		model.addAttribute("pg", pg);
		model.addAttribute("anony_comment", anony_comment);
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	//4.2 익명게시판 댓글의 댓글 작성 완료하기
	@RequestMapping(value="anonymous_comment_rewrite.ams", method=RequestMethod.POST)
	public String anonymous_Comment_Rewrite_Ok(Anonymous_comment anony_comment, int board_idx) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("Con_익명게시판 댓글의 댓글 작성 완료 실행");
		
		int result = anonymousService.anonyCommentRewriteOk(anony_comment);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_detail.ams?board_idx="+board_idx;
		}
		else
		{
			view = "redirect:index.asm";
		}

		
		return view;
	}
	
	
	//5.1 익명게시판 댓글 수정하기
	@RequestMapping(value="anonymous_comment_modify.ams", method=RequestMethod.GET) <--실제 구현시 사용
	public String anonymous_Comment_Modify_View(int comment_idx, String pg, Model model) throws ClassNotFoundException, SQLException 
	{
		System.out.println("Con_익명게시판 댓글 수정 실행");

		Anonymous_comment anony_comment = anonymousService.anonyCommentModifyView(comment_idx);
		
		model.addAttribute("pg", pg);
		model.addAttribute("anony_comment", anony_comment);
		
		return "Residents.Anonymous_board.Anonymous_Detail";
	}
	
	
	//5.2 익명게시판 글 수정 완료 하기	
	@RequestMapping(value="anonymous_comment_modify.ams", method=RequestMethod.POST)<--실제 구현시 사용
	public String anonymous_Comment_Modify_Ok(Anonymous_comment anony_comment, int board_idx) throws ClassNotFoundException, SQLException
	{
		
		System.out.println("Con_익명게시판 댓글 수정 완료 실행");
		
		int result = anonymousService.anonyCommentModifyViewOk(anony_comment);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_detail.ams?board_idx="+board_idx;
		}
		else
		{
			view = "redirect:index.asm";
		}
			
		return  view;
	}
		
	
	//6. 익명게시판 댓글 삭제하기
	@RequestMapping("anonymous_comment_delete.ams")
	public String anonymous_Comment_Delete(int comment_idx, int board_idx) throws ClassNotFoundException, SQLException 
	{
		System.out.println("Con_익명게시판 댓글 수정 완료 실행");
		
		int result = anonymousService.anonyCommentDelete(comment_idx);
		
		String view = null;
		
		if(result > 0)
		{
			view = "redirect:anonymous_detail.ams?board_idx="+board_idx;
		}
		else
		{
			view = "redirect:index.asm";
		}
			
		return  view;
	}
	
	*/
	
}
