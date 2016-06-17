package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.AMS.Model.vo.Notice_board;
import kr.co.AMS.Model.vo.Notice_comment;

//공지게시판 DAO
public interface Notice_boardDao {
   
   
   //1. 공지게시판 글 목록 전체(select multi row)
   List<Notice_board> getAllList(HashMap map)throws SQLException, ClassNotFoundException;
   
   
   //2. 공지게시판 글 상세보기(select single row)
   Notice_board getNotice(int board_idx)throws SQLException, ClassNotFoundException;
   
   
   //3. 공지게시판 글 등록하기(insert)
   int insertNotice(Notice_board noti_board)throws SQLException, ClassNotFoundException;
   
   
   //4. 공지게시판 파일 등록하기(insert)
   int insertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
   
   
   //5. 공지게시판 파일 읽어오기(목록보기)(select)
   List<Map<String, Object>> selectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
   
   
   //6. 공지게시판 파일 삭제하기(delete)
   void deleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //7. 공지게시판 파일 수정하기(update)
   void updateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //8. 공지게시판 글 수정하기(update)
   int updateNotice(Notice_board noti_board) throws SQLException, ClassNotFoundException;
   
   
   //9. 공지게시판 글 삭제하기(delete)   
   //--> 삭제 규칙) 답글이 있을 경우, 답글을 제외한 원본 글만 삭제
   //             원본글 삭제 후 > 삭제된 원본글입니다.
   //             댓글이 있을 경우, 댓글을 포함한 해당 원본 글 삭제
   int deleteNotice(int board_idx) throws SQLException, ClassNotFoundException;
   
   
   //10. 공지게시판 글 전체 건수(select count)
   int NoticeTotalCount() throws SQLException, ClassNotFoundException;
   
   
   //11. 공지게시판 페이징 처리
   //추후 필요하면 수정(우선, 게시물 전체 건수를 사용해 start와 end페이지를 정해서 사용가능
   
   //12.공지게시판 조회수 증가(update hit)
   void getNoticeReadnum(int board_idx) throws SQLException, ClassNotFoundException;
   
   
   //---------답글 관련----------------
   //13. 공지게시판 답글 등록하기(insert)
   int insertReNotice(Notice_board noti_board)throws SQLException, ClassNotFoundException;
   
   
   //14.공지게시판 답글 파일 등록하기(insert)
   int reInsertFile(Map<String, Object> map) throws SQLException, ClassNotFoundException;
   
   
   //15.공지게시판 답글 파일 읽어오기(목록보기)(select)
   List<Map<String, Object>> reSelectFileList(int board_idx) throws SQLException, ClassNotFoundException; 
   
   
   //16.공지게시판 답글 파일 삭제하기(delete)
   void reDeleteFileList(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //17.공지게시판 답글 파일 수정하기(update)
   void reUpdateFile(Map<String, Object> map) throws SQLException, ClassNotFoundException; 
   
   
   //18.공지게시판 답글 수정하기(update)
   int updateReNotice(Notice_board noti_board) throws SQLException, ClassNotFoundException;
   
   
   //19.공지게시판 답글 삭제하기(delete)
   //--> 삭제 규칙) 원본 글이 있을 경우, 원본 글을 제외한 해당 답글만 삭제
   //             답글의 댓글이 있을 경우, 댓글을 포함한 해당 답글 삭제
   int deleteReNotice(int board_idx) throws SQLException, ClassNotFoundException;
   
   
   //20.공지게시판 답글에 답글 등록하기(update depth)
   int updateNoticeDepth(Notice_board noti_board) throws ClassNotFoundException, SQLException;
   
      
   //---------댓글 관련----------------
   //21.공지게시판 댓글 등록하기(insert)
   int insertNoticeComment(Notice_comment noti_comment)throws SQLException, ClassNotFoundException;
   
   
   //22.공지게시판 댓글 수정하기(update)
   int updateNoticeComment(Notice_comment noti_comment) throws SQLException, ClassNotFoundException;
   
   
   //23.공지게시판 댓글 삭제하기(delete)
   int deleteNoticeComment(int comment_idx) throws SQLException, ClassNotFoundException;
   
   
   //24.공지게시판 댓글 목록전체(select multi row)
   List<Notice_comment> getAllCommentList(int board_idx)throws SQLException, ClassNotFoundException;
   
   
   //25.공지게시판 댓글 전체 건수(select count)
   int NoticeCommentTotalCount() throws SQLException, ClassNotFoundException;
   
   
   //26.공지게시판 댓글의 댓글 등록하기(insert)
   //**확인할 사항 : 댓글의 댓글의 경우, 최대 depth를 2로 한정할 것인가?, 아니면 더 증가시킬 것인가?
   int updateNoticeDepth(Notice_comment noti_comment) throws ClassNotFoundException, SQLException;
   
   
   //27.공지게시판 댓글 목록 보기 처리(depth, step)
   //추후 필요하면 수정
   
   //28.공지게시판 댓글 페이징 처리 
   //추후 필요하면 수정
              


}