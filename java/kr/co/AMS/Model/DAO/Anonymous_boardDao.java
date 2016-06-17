package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.AMS.Model.vo.Anonymous_board;
import kr.co.AMS.Model.vo.Anonymous_comment;

//익명게시판 DAO
public interface Anonymous_boardDao {
	
	
	//1. 익명게시판 글 목록 전체(select multi row)
	List<Anonymous_board> getAllAnonyList(HashMap map)throws SQLException, ClassNotFoundException;
	
	
	//2. 익명게시판 글 상세보기(select single row)
	Anonymous_board getAnonymousDetail(int board_idx)throws SQLException, ClassNotFoundException;
	
	
	//3. 익명게시판 글 등록하기(insert)
	int insertAnonymous(Anonymous_board anony_board)throws SQLException, ClassNotFoundException;
	
	
	//4. 익명게시판 파일 등록하기(insert)
	int insertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
	
	
	//5. 익명게시판 파일 읽어오기(목록보기)(select)
	List<Map<String, Object>> selectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
	
	
	//6. 익명게시판 파일 삭제하기(delete)
	void deleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
	
	
	//7. 익명게시판 파일 수정하기(update)
	void updateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
	
	
	//8. 익명게시판 글 수정하기(update)
	int updateAnonymous(Anonymous_board anony_board) throws SQLException, ClassNotFoundException;
	
	
	//9. 익명게시판 글 삭제하기(delete)	
	//--> 삭제 규칙) 답글이 있을 경우, 답글을 제외한 원본 글만 삭제
	//             원본글 삭제 후 > 삭제된 원본글입니다.
	//             댓글이 있을 경우, 댓글을 포함한 해당 원본 글 삭제
	int deleteAnonymous(int board_idx) throws SQLException, ClassNotFoundException;
	
	
	//10. 익명게시판 글 전체 건수(select count)
	int anonymousTotalCount() throws SQLException, ClassNotFoundException;
	
	
	//11. 익명게시판 페이징 처리
	//추후 필요하면 수정(우선, 게시물 전체 건수를 사용해 start와 end페이지를 정해서 사용가능
	
	
	//12.익명게시판 조회수 증가(update hit)
	int getAnonymousReadnum(int board_idx) throws SQLException, ClassNotFoundException;
	
	
	//13.익명게시판 조회순 정렬(select hit)
	List<Anonymous_board> sortListHit(HashMap map) throws SQLException, ClassNotFoundException;
	
	//---------답글 관련----------------
	//13. 익명게시판 답글 등록하기(insert)
	int insertReAnonymous(Anonymous_board anony_board)throws SQLException, ClassNotFoundException;
	
	
	//14.익명게시판 답글 파일 등록하기(insert)
	int reInsertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
	
	
	//15.익명게시판 답글 파일 읽어오기(목록보기)(select)
	List<Map<String, Object>> reSelectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
	
	
	//16.익명게시판 답글 파일 삭제하기(delete)
	void reDeleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
	
	
	//17.익명게시판 답글 파일 수정하기(update)
	void reUpdateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
	
	
		
	//19.익명게시판 답글 삭제하기(delete)
	//--> 삭제 규칙) 원본 글이 있을 경우, 원본 글을 제외한 해당 답글만 삭제
	//             답글의 댓글이 있을 경우, 댓글을 포함한 해당 답글 삭제
	int deleteReAnonymous(int board_idx) throws SQLException, ClassNotFoundException;
	
	
		
	//21.익명게시판 답글에 대한 순번처리하기
	void updateAnonymousStep(Anonymous_board anony_board) throws ClassNotFoundException, SQLException;
		
	//---------댓글 관련----------------
	//22.익명게시판 댓글 등록하기(insert)
	int insertAnonymousComment(Anonymous_comment anony_comment)throws SQLException, ClassNotFoundException;
	
	
	//23.익명게시판 댓글 수정하기(update)
	int updateAnonymousComment(Anonymous_comment anony_comment) throws SQLException, ClassNotFoundException;
   
	
	//24.익명게시판 댓글 삭제하기(delete)
	int deleteAnonymousComment(int comment_idx) throws SQLException, ClassNotFoundException;
	
	
	//25.익명게시판 댓글 목록전체(select multi row)
	List<Anonymous_comment> getAllCommentList(HashMap map)throws SQLException, ClassNotFoundException;
	
	
	//26.익명게시판 댓글 전체 건수(select count)
	int anonymousCommentTotalCount() throws SQLException, ClassNotFoundException;
	
	
	//27.익명게시판 댓글의 댓글 등록하기(insert)
	//**확인할 사항 : 댓글의 댓글의 경우, 최대 depth를 2로 한정할 것인가?, 아니면 더 증가시킬 것인가?
	int insertReAnonymousComment(Anonymous_comment anony_comment) throws ClassNotFoundException, SQLException;
	
	
	//28.익명게시판 댓글 상세보기(수정 시 필요)
	Anonymous_comment getAnonymousCommentDetail(int comment_idx)throws SQLException, ClassNotFoundException;
	
	//28.익명게시판 댓글 목록 보기 처리(depth, step)
	//추후 필요하면 수정
	
	//29.익명게시판 댓글 페이징 처리 
	//추후 필요하면 수정
	           


}
