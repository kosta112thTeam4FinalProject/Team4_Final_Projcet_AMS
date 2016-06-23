package kr.co.AMS.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Model.DAO.Anonymous_boardDao;
import kr.co.AMS.Model.vo.Anonymous_board;
import kr.co.AMS.Model.vo.Anonymous_comment;

//익명게시판
@Service
public class AnonymousService {
	
	@Autowired
	private SqlSession sqlSession;
	
	//1.익명게시판 글 목록 전체
	public HashMap getAllAnonymousList(String pg) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 전체 목록");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 10;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int total = anonDao.anonymousTotalCount();
		
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);
		
	   //... 목록
	   int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
	   // int totalPage = total/rowSize + (total%rowSize==0?0:1);
	   System.out.println("페이지수 : " + allPage);

	   int block = 10; 
	   // 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
	   int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
	   // ((1-1)/10*10)
	   int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
	   if (toPage > allPage) // 예) 20>17
	   { 
		   toPage = allPage;
	   }		
		
		//start와 end 값을 map에 담음
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<Anonymous_board> list = anonDao.getAllAnonyList(map);
		 
		HashMap maps = new HashMap();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("allPage", allPage);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		
		return maps;	
		
	}
	
	
	//2.익명게시판 글 상세보기
	public Anonymous_board anonyDetail(int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 글 상세보기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		//조회수 증가
		anonDao.getAnonymousReadnum(board_idx);
		
		Anonymous_board anony_board = anonDao.getAnonymousDetail(board_idx);
		
		return anony_board;
	}
	
	//3.익명게시판 글 등록 완료하기
	public int anonyInserOk(Anonymous_board anony_board) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 글 등록 완료하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int result = anonDao.insertAnonymous(anony_board);
		
		return result;
	}

	
	//4.1익명게시판 글 수정하기
	public Anonymous_board anonyModifyView(int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 글 수정하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		Anonymous_board anony_board = anonDao.getAnonymousDetail(board_idx);
		
		return anony_board;
	}
	
	
	//4.2 익명게시판 글 수정하기 완료
	public int anonyModifyViewOk(Anonymous_board anony_board) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 글 수정하기 완료");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int result = anonDao.updateAnonymous(anony_board);
		
		return result;
	}
	
	//5.익명게시판 글 삭제하기
	public int anonyDelete()
	{
		
		return 0;
	}
	
	
	//6.1 익명게시판 답글 작성하기
	public Anonymous_board anonyRewriteView(int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 답글 등록하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		Anonymous_board anony_board = anonDao.getAnonymousDetail(board_idx);
		
		return anony_board;
		
	}
	
	
	//6.2 익명게시판 답글 완료하기
	public int anonyRewriteOk(Anonymous_board anony_board) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판  답글 등록 완료");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		//답글쓰기 step처리
		System.out.println("현재 step : " + anony_board.getStep());
		
		anonDao.updateAnonymousStep(anony_board);	
		
		System.out.println("update step : " + anony_board.getStep());
		
		
		//step, depth처리
		//anony_board.setStep(anony_board.getStep()+1);
		//anony_board.setDepth(anony_board.getDepth()+1);
		
		System.out.println("답글에 대한 ref :  " + anony_board.getRef());
		System.out.println("답글에 대한 step :  " + anony_board.getStep());
		System.out.println("답글에 대한 depth :  " + anony_board.getDepth());
		
		int result = anonDao.insertReAnonymous(anony_board);
		
		return result;
	}
	
	
	//7.익명게시판 댓글 등록 완료하기
	public int anonyCommentInserOk(Anonymous_comment anony_comment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판  댓글 등록 완료");
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int result = anonDao.insertAnonymousComment(anony_comment);
		
		return result;
	}
	
	
	//8.익명게시판 댓글 목록 전체(상세보기)
	public HashMap getAllAnonyCommentList(String pg) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판  댓글 목록 전체 보기");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 5;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int total = anonDao.anonymousCommentTotalCount();
		
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);
		
	   //... 목록
	   int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
	   // int totalPage = total/rowSize + (total%rowSize==0?0:1);
	   System.out.println("페이지수 : " + allPage);

	   int block = 10; 
	   // 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
	   int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
	   // ((1-1)/10*10)
	   int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
	   if (toPage > allPage) // 예) 20>17
	   { 
		   toPage = allPage;
	   }		
		
		//start와 end 값을 map에 담음
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<Anonymous_comment> list = anonDao.getAllCommentList(map);
		
		//댓글을 작성할 해당 게시물의 board_idx를 가져옴
		Anonymous_board anony_board = new Anonymous_board();
		int board_idx = anony_board.getBoard_idx();
		 
		HashMap maps = new HashMap();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("allPage", allPage);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		maps.put("board_idx",board_idx);		
		return maps;	
		
	}
	
	
	
	//9.1 익명게시판 댓글 수정하기
	public Anonymous_comment anonyCommentModifyView(int comment_idx) throws ClassNotFoundException, SQLException
	{
		
		System.out.println("Service_익명게시판 글 수정하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		Anonymous_comment anony_comment = anonDao.getAnonymousCommentDetail(comment_idx);
		
		return anony_comment;
		
	}
	
	
	//9.2 익명게시판 댓글 수정 완료하기
	public int anonyCommentModifyViewOk(Anonymous_comment anony_comment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 댓글 수정하기 완료");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int result = anonDao.updateAnonymousComment(anony_comment);
		
		return result;
	}
	
	
	//10.1 익명게시판 댓글에 댓글 등록하기
	public Anonymous_comment anonyCommentRewriteView(int comment_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판 댓글에 댓글 등록하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		Anonymous_comment anony_comment = anonDao.getAnonymousCommentDetail(comment_idx);
		
		return anony_comment;
		
	}
	
	
	//10.2 익명게시판 댓글에 댓글 작성 완료하기
	public int anonyCommentRewriteOk(Anonymous_comment anony_comment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판  댓글에 댓글 등록 완료");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		//답글쓰기 step처리
		System.out.println("현재 step : " + anony_comment.getStep());
		
		anonDao.updateAnonymousComment(anony_comment);	
		
		System.out.println("update step : " + anony_comment.getStep());
		
		
		//step, depth처리
		//anony_board.setStep(anony_board.getStep()+1);
		//anony_board.setDepth(anony_board.getDepth()+1);
		
		System.out.println("답글에 대한 ref :  " + anony_comment.getRef());
		System.out.println("답글에 대한 step :  " + anony_comment.getStep());
		System.out.println("답글에 대한 depth :  " + anony_comment.getDepth());
		
		int result = anonDao.insertReAnonymousComment(anony_comment);
		
		return result;
	}
	
	
	//11. 익명게시판 댓글 삭제하기
	public int anonyCommentDelete(int comment_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_익명게시판  댓글 삭제하기");
		
		Anonymous_boardDao anonDao = sqlSession.getMapper(Anonymous_boardDao.class);
		
		int result = anonDao.deleteAnonymousComment(comment_idx);
		
		return result;		
	}

	

}
