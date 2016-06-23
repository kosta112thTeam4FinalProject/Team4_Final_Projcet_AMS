package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.co.AMS.Model.vo.Family;
import kr.co.AMS.Model.vo.Member;
import kr.co.AMS.Model.vo.Member_Car;
import kr.co.AMS.Model.vo.Member_Certification;

//회원_DAO
public interface Member_Dao {
	
	
	//1.회원 가입 전 인증번호 생성 및 기본 사항 저장(insert)
	int insertMemberCertifi(Member_Certification member_certi)throws SQLException, ClassNotFoundException;
	
	//2.회원 인증번호 일치 여부 확인(select)
	int selectMemberCheck(Member_Certification member_certification)throws SQLException, ClassNotFoundException;
	
	//3.1 회원 가입(insert)
	int insertMember(Member member)throws SQLException, ClassNotFoundException;
	
	//3.2 회원 가입 시 세대구성원 입력(insert)
	int insertFamily(Family family)throws SQLException, ClassNotFoundException;
	
	//3.3 회원 가입 시 차량 정보 입력(insert)
	int insertMemberCar(Member_Car car)throws SQLException, ClassNotFoundException;
	
	//4.회원 로그인 시 아이디 존재 및 비밀번호 일치 여부 확인(select)
	int memberLogin(String userid, String password)throws SQLException, ClassNotFoundException;
	
	//5.1 회원 정보 수정 시 상세 정보 가저오기_Member(select)
	Member memberDetail(String userid)throws SQLException, ClassNotFoundException;
	
	//5.2 회원 정보 수정 시 상세 정보 가저오기_Family(select)
	Family memberFamilyDetail(String userid)throws SQLException, ClassNotFoundException;
	
	//5.3 회원 정보 수정시 상세 정보 가져오기_Car(select)
	Member_Car memberCarDetail(String userid)throws SQLException, ClassNotFoundException;
	
	//6.1 회원 정보 수정 사항 반영_Member(update)
	int memberModify(Member member) throws SQLException, ClassNotFoundException;
	
	//6.2 회원 정보 수정 사항 반영_Family(update)
	int memberFamilyModify(Family family) throws SQLException, ClassNotFoundException;
		
	//6.3 회원 정보 수정 사항 반영_Member_Car(update)
	int memberCarModify(Member_Car car) throws SQLException, ClassNotFoundException;
	
	//7. 비밀번호 찾기 시 회원 이메일 여부확인
    Member isMemberEmail(String userid) throws SQLException, ClassNotFoundException;
    
    //8.회원전체목록 보기
    List<Member> getAllMemberList(HashMap map) throws SQLException, ClassNotFoundException; 
    
    //9.회원 전체 수
    int memberTotalCount() throws SQLException, ClassNotFoundException;
    
    // 검색 회원 전체 수
    int getSearchCount(HashMap<String, Object> map) throws ClassNotFoundException, SQLException;
  
	// 인증 번호 생성(insertRegiNum)
    int insertRegiNum(Member_Certification member_certification) throws ClassNotFoundException, SQLException;
    
    // 인증 번호 중복 체크
    int doubleCheck(int checknum) throws ClassNotFoundException, SQLException;

    // 해당 아이디의 인증번호 불러오기
    int getRegiNum(String userid) throws ClassNotFoundException, SQLException;
    
    // select * from member_certi where userid = '';
    Member_Certification getCertiInfo(String userid) throws ClassNotFoundException, SQLException;
    
    // family member 저장
    int addFamilyMember(Family family) throws ClassNotFoundException, SQLException;
    
    // member 차명/차번호 저장
    int addMemberCars(Member_Car member_car) throws ClassNotFoundException, SQLException;
    
    // 회원가입 시 해당 아이디 role부여
    int assignRole(String userid) throws ClassNotFoundException, SQLException;
}
