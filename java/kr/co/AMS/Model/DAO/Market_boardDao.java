package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.co.AMS.Model.vo.Market_board;
import kr.co.AMS.Model.vo.Market_boardComment;


public interface Market_boardDao {

	//전체 게시물 개수
	public int market_getCount() throws ClassNotFoundException, SQLException;
	//게시물 리스트
	public List<Market_board> market_List(HashMap map) throws ClassNotFoundException, SQLException; 
	//게시물 상세보기
	public Market_board market_Detail(int board_idx) throws ClassNotFoundException, SQLException;
	//market게시판 글 등록
	public int market_Insert(Market_board m) throws ClassNotFoundException, SQLException;
	//게시판 글 삭제
	public void market_Delete(int board_idx) throws ClassNotFoundException, SQLException;
	//게시판 수정
	public int market_Update(Market_board m) throws ClassNotFoundException, SQLException;
	//게시판 hit
	public void market_Hit_Update(int board_idx) throws ClassNotFoundException, SQLException;
	//depth 증가
	public void market_Depth(Market_board m) throws ClassNotFoundException, SQLException;
	//답글 등록
	public int market_Re_Insert(Market_board m) throws ClassNotFoundException, SQLException;
	//덧글 등록
	public int market_Comment(Market_boardComment m) throws ClassNotFoundException, SQLException;
	//덧글 리스트
	public List<Market_boardComment> market_CommentList(int board_idx) throws ClassNotFoundException, SQLException;
	//해당 게시판 덧글 전체삭제
	public void market_CommentAllDel(int board_idx) throws ClassNotFoundException, SQLException;
	//해당 덧글 삭제
	public int market_CommentDel(int comment_idx) throws ClassNotFoundException, SQLException;
	//덧글 수정
	public int market_Comment_Update(Market_boardComment m) throws ClassNotFoundException, SQLException;
	//해당 게시글 보기
	public Market_boardComment market_Comment_Detail(int comment_idx) throws ClassNotFoundException, SQLException;
}
