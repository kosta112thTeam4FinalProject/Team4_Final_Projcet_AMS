package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.Member_Dao;
import kr.co.AMS.Model.vo.Member;
import kr.co.AMS.Model.vo.Member_Certification;

//회원관리
@Service
public class MemberService {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private JavaMailSender mailSender;

	// 1.회원 전체 목록 보기
	public HashMap<String, Object> getAllMemberList(String pg, String info, String search) throws ClassNotFoundException, SQLException {
		System.out.println("Service_회원 전체 목록 보기");

		System.out.println("service info : " + info);
		System.out.println("service search : " + search);
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);

		int page = 1;
		String StrPg = pg;

		if (StrPg != null) {
			page = Integer.parseInt(StrPg);
		}


		// 항목 20개씩 보여주기
		int rowSize = 20;
		

		// 회원 전체 수
		int total = member_dao.memberTotalCount();


		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("info", info);
		
		if(search != null){
			
			total = member_dao.getSearchCount(map);
		}
		
		// 출력 건수보다  글 수가 적을 경우
		// 현재 출력 페이지를 1로 변경
		if(rowSize > total){
			page = 1;
		}
		
		
		// ... 목록
		int pageCount = (int) Math.ceil(total / (double) rowSize); // 페이지수
		
		int block = 5;
		// 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
		int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
		// ((1-1)/10*10)
		int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
		if (toPage > pageCount) // 예) 20>17
		{
			toPage = pageCount;
		}
		
		int start = (page * rowSize) - (rowSize - 1);
		int end = page * rowSize;

		// start와 end 값을 map에 담음
		map.put("start", start);
		map.put("end", end);

		List<Member> list = member_dao.getAllMemberList(map);
		
		System.out.println("list : " + list);
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("pageCount", pageCount);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		maps.put("search", search);
		maps.put("info", info);

		return maps;

	}

	public int createRegisterNum() throws ClassNotFoundException, SQLException {

		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);

		int checknum = 1;

		do {
			checknum = (int) Math.floor(Math.random() * 1000000) + 100000;

		} while (member_dao.doubleCheck(checknum) != 0);

		System.out.println("생성한 인증 번호 : " + checknum);

		return checknum;
	}

	public int registerCheckNum(Member_Certification member_certification) throws ClassNotFoundException, SQLException {

		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);

		int result = member_dao.insertRegiNum(member_certification);

		if (result > 0) {

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom("betakosta1@gmail.com");
				messageHelper.setTo(member_certification.getEmail());
				messageHelper.setSubject("Kosta아파트 회원가입을 위한 인증번호입니다");
				messageHelper.setText("안녕하세요", member_certification.getUserid() + " <html> 님의 인증번호는 "
						+ member_certification.getChecknum() + "입니다."
						+ "회원가입 페이지로 이동<a href='http://localhost:8090/Team4_Final_Project_AMS_board_Test/index.asm'>Kosta아파트 회원가입</a></html>");

				mailSender.send(message);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}