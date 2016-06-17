package kr.co.AMS.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.AMS.Model.DAO.Market_boardDao;
import kr.co.AMS.Model.vo.Market_board;
import kr.co.AMS.Model.vo.Market_boardComment;


@Service
public class MarketService {
	
	@Autowired
	private SqlSession sqlSession;
	
	//market 글 등록 service
	public String market_Write_Ok_Service(Market_board m)
			throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 작성 완료 실행 service");
		
		System.out.println(" notice : " + m.getNotice());
		System.out.println(" writer : " + m.getWriter());
		System.out.println(" title : " + m.getTitle());
		System.out.println(" content : " + m.getContent());
		System.out.println(" kind : " + m.getKind());
		
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		
		market_boardDao.market_Insert(m);
		
		//return "Residents.Market_board.Market_List";
		return "redirect:market_list.ams";
	}
	
	//게시물 개수
	public int market_Count_Service() throws ClassNotFoundException, SQLException{
		System.out.println("게시물 개수 service");
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		int marketNum = market_boardDao.market_getCount();
		System.out.println("개수는 : " + marketNum);
		
		return marketNum;
	}
	
	//글 답변
	public String market_Rewrite_Ok_Service(Market_board m) throws ClassNotFoundException, SQLException{
		System.out.println("답변 service");
		System.out.println(m.getRef());
		System.out.println(m.getBoard_idx());
		System.out.println(m.getContent());
		System.out.println(m.getDepth());
		System.out.println(m.getStep());
		System.out.println(m.getTitle());
		System.out.println(m.getKind());
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_Depth(m); // depth 증가
		System.out.println("답변 service 2");
		market_boardDao.market_Re_Insert(m);
		System.out.println("답변 service 3");
		
		return "redirect:market_list.ams";
	}
	
	//글 상세보기
	public Market_board market_Detail_View_Service(int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("글 상세보기 service");
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		Market_board market_board = market_boardDao.market_Detail(board_idx);
		market_boardDao.market_Hit_Update(board_idx);
		
		return market_board;
	}
	
	//market 글 목록 service
	public List<Market_board> market_list_View_Service(HashMap map) throws ClassNotFoundException, SQLException{
		//NoticeDao noticeDao = SqlSession.getMapper(NoticeDao.class);
		//List<Notice> list= noticeDao.getNotices(page, field, query);
		
		System.out.println("글목록 service");
		
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		List<Market_board> list = market_boardDao.market_List(map);
		
		return list;
		
	}
	//글 수정
	public Market_board market_Modify_Ok_Service(int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 수정 완료 실행1 service");
		System.out.println("idx : " + board_idx);
		
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		Market_board market_board = market_boardDao.market_Detail(board_idx);
		
		return market_board;
	}
	//글 수정
	public String market_Modify_Ok_Service(Market_board m) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 수정 완료 실행2 service");
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_Update(m);
		System.out.println("idx : " + m.getBoard_idx());
		
		return "redirect:market_detail.ams?board_idx=" + m.getBoard_idx();
	}
	//글 삭제
	public String market_Delete_Service(int board_idx) throws ClassNotFoundException, SQLException{
		
		System.out.println("글삭제 service");
		System.out.println("idx : " + board_idx);
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_CommentAllDel(board_idx); //덧글 삭제
		System.out.println("해당게시판 덧글삭제");
		market_boardDao.market_Delete(board_idx);
		
		return "redirect:market_list.ams";
		
	}
	
	//덧글 등록
	public String Market_Comment(Market_boardComment m) throws ClassNotFoundException, SQLException{
		System.out.println("덧글 service");
		System.out.println(m.getBoard_idx());
		
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_Comment(m);
		
		return "redirect:market_detail.ams?board_idx=" + m.getBoard_idx();
	}
	
	public List<Market_boardComment> Market_CommentList(int board_idx) 
			throws ClassNotFoundException, SQLException{
		System.out.println("덧글 리스트 service");
		System.out.println("board_idx");
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		List<Market_boardComment> list = market_boardDao.market_CommentList(board_idx);
		
		return list;
	}
	
	public String market_CommentDel_Service(int comment_idx, int board_idx) throws ClassNotFoundException, SQLException {
		System.out.println("벼룩시장 글 삭제 실행 service");
		System.out.println("idx : " + comment_idx);
		System.out.println("boardidx" + board_idx);
		
		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_CommentDel(comment_idx);

		return "redirect:market_detail.ams?board_idx=" + board_idx;
	}
	//덧글 수정
	public String Market_Comment_Modify_Service(Market_boardComment m) throws IOException, ClassNotFoundException, SQLException {

		System.out.println("덧글 수정 등록 처리 service");
		System.out.println("n : " + m.getContent());
		System.out.println("n : " + m.getBoard_idx());
		System.out.println("m : " + m.getComment_idx());

		Market_boardDao market_boardDao = sqlSession.getMapper(Market_boardDao.class);
		market_boardDao.market_Comment_Update(m);
		
		
		return "redirect:market_detail.ams?board_idx=" + m.getBoard_idx();
	}
	
	
}
