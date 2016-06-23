package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.Member_Dao;
import kr.co.AMS.Model.vo.Family;
import kr.co.AMS.Model.vo.Member;
import kr.co.AMS.Model.vo.Member_Car;
import kr.co.AMS.Model.vo.Member_Certification;


//회원관련
@Service
public class JoinService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private JavaMailSender mailSender;
	
	/*//1.회원 가입 전 인증번호 생성 및 기본 사항 저장
	public int insertMemberCertifi(Member_Certification member_certi) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_회원 인증번호 저장");
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		int result = member_dao.insertMemberCertifi(member_certi);
		
		if (result > 0) {

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom("betakosta1@gmail.com");
				messageHelper.setTo(member_certi.getEmail());
				messageHelper.setSubject("Kosta아파트 회원가입을 위한 인증번호입니다");
				messageHelper.setText("안녕하세요", member_certi.getUserid()
						+ " <html> 님의 인증번호는 " + member_certi.getChecknum() + "입니다."
								+ "회원가입 페이지로 이동<a href='http://localhost:8090/Team4_Final_Project_AMS_board_Test/index.asm'>Kosta아파트 회원가입</a></html>");

				mailSender.send(message);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end if
		
		return result;			
	}*/
	
	
	// select * from member_certification
	// 인증번호 테이블의 정보를 멤버 vo에 입력 후 return > 회원가입 화면에 출력
	public Member getMemberInfo(String userid) throws ClassNotFoundException, SQLException{

		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		Member_Certification member_certification = member_dao.getCertiInfo(userid);
		
		String addr[] = member_certification.getUserid().split("-");
		
		Member member = new Member();
		
		member.setUserid(member_certification.getUserid());
		member.setName(member_certification.getName());
		member.setEmail(member_certification.getEmail());
		member.setAddr_1(addr[0]);
		member.setAddr_2(addr[1]);
		
		return member;
	}
	
	// 회원 가입 완료
	public void joinCompleted(Member member, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		int result = member_dao.insertMember(member);
		
		if(result > 0 ){
			member_dao.assignRole(member.getUserid());
		}
		
		Enumeration param = request.getParameterNames();
	
		int fNum = 0;
		int carNum = 0;
		
		HashMap<String, Object> members = new HashMap<String, Object>();
		HashMap<String, Object> cars = new HashMap<String, Object>();
		
		while(param.hasMoreElements()){
		
			String name = (String)param.nextElement();
			String value = request.getParameter(name);
			
			String[] str = name.split("_");
			System.out.println("str0 : " + str[0]);						
			
			if(str[0].equals("name")){
				members.put("name_"+fNum, value);
			}
			
			if(str[0].equals("age")){
				members.put("age_"+fNum, value);
			}
			
			if(str[0].equals("gender")){
				members.put("gender_"+fNum++, value);
			}
			
			if(str[0].equals("carname")){
				cars.put("carname_"+carNum, value);
			}
			
			if(str[0].equals("carnumber")){
				cars.put("carnumber_"+carNum++, value);
			}	
		}
		
		for(int i = 0; i < fNum; i++){
			Family family = new Family();
			family.setUserid(member.getUserid());
			family.setF_name((String)members.get("name_"+i));
			family.setAge((Integer.valueOf((String)members.get("age_"+i))));
			family.setGender((String)members.get("gender_"+i));
			
			System.out.println("family : " + family.getUserid());
			System.out.println("family : " + family.getF_name());
			System.out.println("family : " + family.getAge());
			System.out.println("family : " + family.getGender());
			
			member_dao.addFamilyMember(family);
		}
		
		for(int i = 0; i < carNum; i++){
			Member_Car member_car = new Member_Car();
			member_car.setUserid(member.getUserid());
			member_car.setCarname((String)cars.get("carname_"+i));
			member_car.setCarnumber((String)cars.get("carnumber_"+i));
			
			System.out.println("car : " + member_car.getUserid());
			System.out.println("car : " + member_car.getCarname());
			System.out.println("car : " + member_car.getCarnumber());
			
			member_dao.addMemberCars(member_car);
		}
		
		if (result > 0) {

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom("betakosta1@gmail.com");
				messageHelper.setTo(member.getEmail());
				messageHelper.setSubject("Kosta아파트 회원가입을 환영합니다");
				messageHelper.setText("안녕하세요", member.getUserid()
						+ " <html> 님, 가입을 환영합니다 "
						+ " 홈페이지로 이동<a href='http://localhost:8090/Team4_Final_Project_AMS_board_Test/index.asm'>Kosta아파트</a></html>");

				mailSender.send(message);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end if
	}
	
    //2.회원 인증번호 일치 여부 확인
	public int memberCheck(Member_Certification member_certification) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_회원 인증번호 일치 여부 확인");
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		System.out.println("service : " + member_certification);
		int result = member_dao.selectMemberCheck(member_certification);
		System.out.println("service : " + result);
		return result;
		
	}
	
	/*//3.1 회원가입_member
	public int joinMemberOk(Member member) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_회원가입하기_Member");
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		int result = member_dao.insertMember(member);
		
		return result;
		
	}*/
	
	//3.2 회원가입_family
	public int joinMemberFamily(Family family) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_회원가입하기_Family");
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		int result = member_dao.insertFamily(family);
		
		return result;
	}
	
	//3.3 회원가입_car
	public int joinMembmerCar(Member_Car car) throws ClassNotFoundException, SQLException 
	{
		System.out.println("Service_회원가입하기_Car");
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);
		
		int result = member_dao.insertMemberCar(car);
		
		return result;
		
	}
	
	//3.회원가입
/*	@Transactional(rollbackFor=Exception.class)
	public String joinMemberOk(Member member, Family family, Member_Car car) throws Exception 
	{
		System.out.println("Service_회원가입하기");
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);		
		
		int result;
		int result2;
		int result3;
		
		try {
			result = member_dao.insertMember(member);
			result2 = member_dao.insertFamily(family);
			result3 = member_dao.insertMemberCar(car);	
			
		}catch(Exception e){
        	e.printStackTrace();
        	throw new Exception();
        }		 
		
        String view = null;
		
		if(result > 0 && result2 > 0 && result3 > 0)
		{
			view = "Member.Join.Member_Join_Ok";
		}
		else
		{
			view="redirect:index.asm";
		}
			
		return "Member.Join.Member_Join_Ok";
		
	}*/
	
	
	//4. 회원 로그인
	public int member_Login(String userid, String password) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_회원 로그인");
		
		Member_Dao member_dao = sqlSession.getMapper(Member_Dao.class);	
		
		
		int result = member_dao.memberLogin(userid, password);
		
		
		
		return result;
	}
}
