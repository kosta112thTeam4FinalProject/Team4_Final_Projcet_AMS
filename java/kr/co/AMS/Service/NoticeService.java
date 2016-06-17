package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.Notice_boardDao;
import kr.co.AMS.Model.vo.Notice_board;

//공지사항 게시판
@Service
public class NoticeService {

	@Autowired
	private SqlSession sqlSession;

	// notice 글 등록 service
	public String Notice_Write_Ok_Service(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("공지사항 글 작성 완료 실행 service");

		// 글 등록한 값들을 확인하기 위한 처리
		System.out.println(" writer : " + m.getWriter());
		System.out.println(" title : " + m.getTitle());
		System.out.println(" content : " + m.getContent());
		System.out.println(" kind : " + m.getKind());

		// mapper의 xml을 통해서 함수 처리
		Notice_boardDao Notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);

		// 함수의 실제 구현은 Notice_boardDao.xml 에 되어 있다.
		Notice_boardDao.insertNotice(m);

		return "redirect:notice_list.ams";
	}

	// 게시물 개수
	public int notice_Count_Service() throws ClassNotFoundException, SQLException {
		System.out.println("게시물 개수 service");
		Notice_boardDao Notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		int marketNum = Notice_boardDao.NoticeTotalCount();
		System.out.println("개수는 : " + marketNum);

		return marketNum;
	}

	// 공지사항 목록 list service
	public List<Notice_board> notice_list_View_Service(HashMap map) throws ClassNotFoundException, SQLException {
		// NoticeDao noticeDao = SqlSession.getMapper(NoticeDao.class);
		// List<Notice> list= noticeDao.getNotices(page, field, query);

		System.out.println("글목록 service");

		Notice_boardDao notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		List<Notice_board> list = notice_boardDao.getAllList(map);

		return list;

	}

	//공지사항 상세보기 service
	public Notice_board notice_detail_View_Service(int board_idx) throws ClassNotFoundException, SQLException {

		System.out.println("글 상세 service");
		Notice_boardDao notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		Notice_board notice_board = notice_boardDao.getNotice(board_idx);
		notice_boardDao.getNoticeReadnum(board_idx);//조회수 증가 함수
		return notice_board;
	}

	//공지사항 글 수정
	public Notice_board notice_detail_Modify_Service(int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("글 수정 notice_board service");

		Notice_boardDao notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		Notice_board notice_board = notice_boardDao.getNotice(board_idx);

		return notice_board;
	}
	//공지사항 글 수정
	public String notice_detail_Modify_Service(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("글 수정 STRING service");

		Notice_boardDao notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		notice_boardDao.updateNotice(m);
		return "redirect:notice_detail.ams?board_idx=" + m.getBoard_idx();
	}

	// 공지사항 답변등록 service
	public String notice_Rewrite_Ok_Service(Notice_board m) throws ClassNotFoundException, SQLException {
		System.out.println("답변 service");

		Notice_boardDao notice_boardDao = sqlSession.getMapper(Notice_boardDao.class);
		notice_boardDao.updateNoticeDepth(m); // depth 증가
		
		//값을 제대로 읽어 오는지 확인하는 처리문 :: 추후 삭제 가능
		System.out.println("1 : " + m.getDepth());
		System.out.println("2 : " + m.getRef());
		System.out.println(m.getWriter());
		System.out.println(m.getContent());
		System.out.println("답변 service 2");
		
		//xml 통해 실제 함수 처리, 구현
		notice_boardDao.insertReNotice(m);
		
		return "redirect:notice_list.ams";
	}

}
