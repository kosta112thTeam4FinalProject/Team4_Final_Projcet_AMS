package kr.co.AMS.Controller;

import java.sql.SQLException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.AMS.Model.vo.Family;
import kr.co.AMS.Model.vo.Member;
import kr.co.AMS.Model.vo.Member_Car;
import kr.co.AMS.Model.vo.Member_Certification;
import kr.co.AMS.Service.JoinService;

//회원가입
@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private JavaMailSender mailSender;
		
	//1. 회원가입 페이지_약관동의
	@RequestMapping("member_join.ams")
	public String mebmer_Join_Step_1_View() 
	{
		System.out.println("Con_회원가입 페이지 보기_약관동의");	
		
		return "Member.Join.Member_Join_Step_1";
	}
	
	//2.1 회원가입 페이지_인증번호확인 
	@RequestMapping(value="member_ceriti_check.ams", method=RequestMethod.GET)
	public String mebmer_Join2_View()  
	{
		
		System.out.println("Con_회원가입 페이지 보기_인증번호확인");

		return "Member.Join.Member_Join_Step_2";
	}	
	
	//2.2 회원가입 페이지_인증번호확인 완료
	@RequestMapping(value="member_ceriti_check.ams",  method=RequestMethod.POST)
	public @ResponseBody int mebmer_Ceriti_Check(Member_Certification member_certification) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_회원 인증번호 일치 여부 확인");	
		
		int result = joinService.memberCheck(member_certification);
	
		return result;
	}
	
	//3.1 회원가입 페이지_회원정보 입력
	@RequestMapping(value="member_join_info.ams", method=RequestMethod.GET)
	public String member_Join3_View(String userid, Model model) throws ClassNotFoundException, SQLException
	{
		System.out.println("Con_회원가입 페이지 보기_회원정보 입력");
		
		Member member = joinService.getMemberInfo(userid);
		
		model.addAttribute("member", member);
		
		return "Member.Join.Member_Join_Step_3";
	}
	
	
	// 회원가입 완료
	@RequestMapping(value="member_join_info.ams", method=RequestMethod.POST)
	public String memberJoinCompleted(Member member, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		joinService.joinCompleted(member, request);
		
		return "Member.Join.Member_Join_Ok";
	}
	
	//4.회원가입 페이지_회원가입완료
	@RequestMapping("member_join_ok.ams")
	public String member_Join_Ok()
	{
		System.out.println("Con_회원가입 페이지 보기_회원가입 완료");
		
		return "Member.Join.Member_Join_Ok";
	}
	

	@RequestMapping(value="member_login.ams")
	public String member_Login()
	{
		System.out.println("Con_회원 로그인_Security");
		return "Member.Join.Member_Login";
	}
	
	//6.회원 로그아웃
	@RequestMapping("member_logout.ams")
	public String member_Logout(HttpSession session)
	{
		//로그아웃 : session 소멸
		session.invalidate();
		
		return "home.index";		
		
	}
}
