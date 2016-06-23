package kr.co.AMS.Controller;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.fasterxml.jackson.annotation.JsonView;

import kr.co.AMS.Model.vo.Member_Certification;
import kr.co.AMS.Service.MemberService;

//회원관리
@Controller
public class ManagermentController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private View jsonView;

	// 1.회원관리 페이지
	@RequestMapping(value = "member_list.ams", method = RequestMethod.GET)
	public String mebmer_Management_View(String pg, String info, String search, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Con_회원관리페이지 보기");
		
		HashMap maps = memberService.getAllMemberList(pg, info, search);

		model.addAttribute("member", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("pageCount", maps.get("pageCount"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("info", info);
		model.addAttribute("search", search);

		return "AdminOffice.Member_Management.Member_Management";
	}

	// 2.회원관리 목록보기
	@RequestMapping(value = "member_list.ams", method = RequestMethod.POST)
	public String member_List_View(String pg, String info, String search, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Con_회원목록 보기");

		System.out.println("controller info : " + info);
		System.out.println("contorller search : " + search);
		
		HashMap<String, Object> maps = memberService.getAllMemberList(pg, info, search);

		model.addAttribute("member", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("pageCount", maps.get("pageCount"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));
		model.addAttribute("info", info);
		model.addAttribute("search", search);
		
		
		return "AdminOffice.Member_Management.Member_Management";
	}

	// 2.회원관리 목록보기
	/*@RequestMapping(value = "member_list.ams", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody Model mebmer_List(String pg, Model model) throws ClassNotFoundException, SQLException {

		System.out.println("Con_회원목록 보기_완료");

		HashMap maps = memberService.getAllMemberList(pg);

		model.addAttribute("list", maps.get("list"));
		model.addAttribute("pg", maps.get("pg"));
		model.addAttribute("allPage", maps.get("allPage"));
		model.addAttribute("block", maps.get("block"));
		model.addAttribute("fromPage", maps.get("fromPage"));
		model.addAttribute("toPage", maps.get("toPage"));

		return model;
	}*/

	// 1.회원 인증번호 등록 페이지
	@RequestMapping("member_Register.ams")
	public String mebmer_Register_View() throws ClassNotFoundException, SQLException {
		System.out.println("Con_회원관리페이지 보기");

		return "AdminOffice.Member_Management.Member_Register";
	}

	// 인증 번호 생성하기
	@RequestMapping(value = "member_Create_checkNum.ams")
	public @ResponseBody int registerNumber() throws ClassNotFoundException, SQLException {

		int checknum = memberService.createRegisterNum();
		
		return checknum;
	}
	
	// 인증 번호 DB에 저장 후 사용자에게 이메일 보내기
	@RequestMapping(value="member_Register_Num_Ok.ams", method=RequestMethod.POST)
	public  String registerOk(Member_Certification member_certification, Model model) throws ClassNotFoundException, SQLException {
		
		int result = memberService.registerCheckNum(member_certification);
		
		if(result > 0){
			model.addAttribute("member_certification", member_certification);
		}
		
		return "AdminOffice.Member_Management.Member_Register_Ok";
	}
}
