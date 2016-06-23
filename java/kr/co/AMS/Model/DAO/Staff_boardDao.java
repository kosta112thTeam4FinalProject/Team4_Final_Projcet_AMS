package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.AMS.Model.vo.Staff_board;

//직원게시판 DAO
public interface Staff_boardDao {
   
   
   //1. 직원게시판 글 목록 전체(select multi row)
   List<Staff_board> getAllList(HashMap map)throws SQLException, ClassNotFoundException;
   
   
   //2. 직원게시판 글 상세보기(select single row)
   Staff_board getStaff(int board_idx)throws SQLException, ClassNotFoundException;
   
   
   //3. 직원게시판 글 등록하기(insert)
   int insertStaff(Staff_board staff_board)throws SQLException, ClassNotFoundException;
   
   
   //4. 직원게시판 파일 등록하기(insert)
   int insertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
   
   
   //5. 직원게시판 파일 읽어오기(목록보기)(select)
   List<Map<String, Object>> selectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
   
   
   //6. 직원게시판 파일 삭제하기(delete)
   void deleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //7. 직원게시판 파일 수정하기(update)
   void updateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //8. 직원게시판 글 수정하기(update)
   int updateStaff(Staff_board staff_board) throws SQLException, ClassNotFoundException;
   
   
   //9. 직원게시판 글 삭제하기(delete)   
   //--> 삭제 규칙) 답글이 있을 경우, 답글을 제외한 원본 글만 삭제
   //             원본글 삭제 후 > 삭제된 원본글입니다.
   //             댓글이 있을 경우, 댓글을 포함한 해당 원본 글 삭제
   int deleteStaff(int board_idx) throws SQLException, ClassNotFoundException;
   
   
   //10. 직원게시판 글 전체 건수(select count)
   int StaffTotalCount() throws SQLException, ClassNotFoundException;
   
   
   //11. 직원게시판 페이징 처리
   //추후 필요하면 수정(우선, 게시물 전체 건수를 사용해 start와 end페이지를 정해서 사용가능
   
   //12.직원게시판 조회수 증가(update hit)
   public int getStaffReadnum(int board_idx) throws SQLException, ClassNotFoundException;
  
   

   //---------답글 관련----------------
   //13. 직원게시판 답글 등록하기(insert)
   int insertReStaff(Staff_board staff_board)throws SQLException, ClassNotFoundException;
   
   
   //14.직원게시판 답글 파일 등록하기(insert)
   int reInsertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
   
   
   //15.직원게시판 답글 파일 읽어오기(목록보기)(select)
   List<Map<String, Object>> reSelectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
   
   
   //16.직원게시판 답글 파일 삭제하기(delete)
   void reDeleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //17.직원게시판 답글 파일 수정하기(update)
   void reUpdateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //18.직원게시판 답글 수정하기(update)
   int updateReStaff(Staff_board staff_board) throws SQLException, ClassNotFoundException;
   
   
   //19.직원게시판 답글 삭제하기(delete)
   //--> 삭제 규칙) 원본 글이 있을 경우, 원본 글을 제외한 해당 답글만 삭제
   //             답글의 댓글이 있을 경우, 댓글을 포함한 해당 답글 삭제
   int deleteReStaff(int board_idx) throws SQLException, ClassNotFoundException;
   
   
   //20.직원게시판 답글에 답글 등록하기(update depth)
   int updateStaffDepth(Staff_board staff_board) throws ClassNotFoundException, SQLException;
   
   //검색
   
	//21.직원게시판 답글에 대한 순번처리하기
	void updateStaffStep(Staff_board anony_board) throws ClassNotFoundException, SQLException;
		
   public List<Staff_board> getSearchList(Map<String, String> map) throws ClassNotFoundException, SQLException;
   
  /*
   //---------댓글 관련----------------
   //21.직원게시판 댓글 등록하기(insert)
   int insertStaffComment(Staff_boardComment Staff_boardComment)throws SQLException, ClassNotFoundException;
   
   
   //22.직원게시판 댓글 수정하기(update)
   int updateStaffComment(Staff_boardComment Staff_boardComment) throws SQLException, ClassNotFoundException;
   
   
   //23.직원게시판 댓글 삭제하기(delete)
   int deleteStaffComment(int comment_idx) throws SQLException, ClassNotFoundException;
   
   
   //24.직원게시판 댓글 목록전체(select multi row)
   List<Staff_boardComment> getAllCommentList(HashMap<String, Integer> map)throws SQLException, ClassNotFoundException;
   
   
   //25.직원게시판 댓글 전체 건수(select count)
   int StaffCommentTotalCount() throws SQLException, ClassNotFoundException;
   
   
   //26.직원게시판 댓글의 댓글 등록하기(insert)
   //**확인할 사항 : 댓글의 댓글의 경우, 최대 depth를 2로 한정할 것인가?, 아니면 더 증가시킬 것인가?
   int updateStaffDepth(Staff_boardComment Staff_boardComment) throws ClassNotFoundException, SQLException;
   
   
	//27.익명게시판 댓글의 댓글 등록하기(insert)
	//**확인할 사항 : 댓글의 댓글의 경우, 최대 depth를 2로 한정할 것인가?, 아니면 더 증가시킬 것인가?
	int insertReStaffComment(Staff_boardComment Staff_boardComment) throws ClassNotFoundException, SQLException;
	
   
	//28.직원게시판 댓글 상세보기(수정 시 필요)
	Staff_boardComment getStaffCommentDetail(int comment_idx)throws SQLException, ClassNotFoundException;
	
              
*/

}