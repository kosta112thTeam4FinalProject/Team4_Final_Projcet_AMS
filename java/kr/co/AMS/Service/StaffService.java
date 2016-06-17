package kr.co.AMS.Service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.AMS.Model.DAO.DownloadDao;
import kr.co.AMS.Model.DAO.Staff_boardDao;
import kr.co.AMS.Model.vo.Staff_board;
import util.FileUtils;


@Service
public class StaffService {
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	@Autowired
	private SqlSession sqlSession;
	
	//1.Staff게시판 글 목록 전체
	public HashMap getAllStaffList(String pg) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 전체 목록");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 10;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int total = staffDao.StaffTotalCount();
		
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
		
		List<Staff_board> list = staffDao.getAllList(map);
		 
		HashMap maps = new HashMap();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("allPage", allPage);
		maps.put("block", block);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		
		return maps;	
		
	}
	
	
	//2.Staff게시판 글 상세보기
	public Staff_board staffDetail(Model model,int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 글 상세보기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		List<Map<String, Object>> list = staffDao.selectFileList(board_idx);
		
		model.addAttribute("list", list);
		//조회수 증가
		staffDao.getStaffReadnum(board_idx);
		
		Staff_board staff_board = staffDao.getStaff(board_idx);
		
		return staff_board;
	}
	
	//3.Staff게시판 글 등록 완료하기
	public int staffInserOk(HttpServletRequest request,Staff_board staff_board) throws Exception
	{
		System.out.println("Service_Staff게시판 글 등록 완료하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.insertStaff(staff_board);
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(staff_board, request);
		for(int i = 0, size = list.size(); i < size; i++){
			staffDao.insertFile(list.get(i));
		}
		
		return result;
	}

	
	//4.1Staff게시판 글 수정하기
	public Staff_board staffModifyView(int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 글 수정하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		Staff_board staff_board = staffDao.getStaff(board_idx);
		
		return staff_board;
	}
	
	
	//4.2 Staff게시판 글 수정하기 완료
	public int staffModifyViewOk(Staff_board staff_board) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 글 수정하기 완료");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.updateStaff(staff_board);
		
		return result;
	}
	
	//5.Staff게시판 글 삭제하기
	public int staffDelete(int board_idx) throws ClassNotFoundException, SQLException
	{
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.deleteStaff(board_idx);
		
		return result;
	}
	
	
	//6.1 Staff게시판 답글 작성하기
	public Staff_board staffRewriteView(int board_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 답글 등록하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		Staff_board staff_board = staffDao.getStaff(board_idx);
		
		return staff_board;
		
	}
	
	
	//6.2 Staff게시판 답글 완료하기
	public int staffRewriteOk(Staff_board staff_board) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판  답글 등록 완료");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		//답글쓰기 step처리
		System.out.println("현재 step : " + staff_board.getStep());
		
		staffDao.updateStaffStep(staff_board);	
		
		System.out.println("update step : " + staff_board.getStep());
		
		
		//step, depth처리
		//staff_board.setStep(staff_board.getStep()+1);
		//staff_board.setDepth(staff_board.getDepth()+1);
		
		System.out.println("답글에 대한 ref :  " + staff_board.getRef());
		System.out.println("답글에 대한 step :  " + staff_board.getStep());
		System.out.println("답글에 대한 depth :  " + staff_board.getDepth());
		
		int result = staffDao.insertReStaff(staff_board);
		
		return result;
	}
	
	public String searchBoard(HttpServletRequest request, HttpServletResponse response, Model model) throws ClassNotFoundException, SQLException{

// 컬럼명

		String column = request.getParameter("column"); // name, home,email
		String keyvalue = request.getParameter("keyvalue"); // 홍길동
		System.out.println("select  from guest where " + column + " = ' " + keyvalue + " ' ");

		HashMap<String, String> map = new HashMap<String, String>(); // collection
		map.put("column", column); // column : name or email or home
		map.put("search", keyvalue); // keyvalue : 홍길동

		
		Staff_boardDao boardDao = sqlSession.getMapper(Staff_boardDao.class);
		List<Staff_board> list = boardDao.getSearchList(map);
		
		model.addAttribute("list", list);

		return "";
}
	
	/*
	
	//7.Staff게시판 댓글 등록 완료하기
	public int staffCommentInserOk(Staff_boardComment Staff_boardComment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판  댓글 등록 완료");
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.insertStaffComment(Staff_boardComment);
		
		return result;
	}
	
	
	//8.Staff게시판 댓글 목록 전체(상세보기)
	public HashMap getAllstaffCommentList(String pg) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판  댓글 목록 전체 보기");
		
		int page=1;
		String Strpg = pg;
		
		if(Strpg != null)
		{
			page = Integer.parseInt(Strpg);
		}
		
		int rowSize = 5;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int total = staffDao.StaffCommentTotalCount();
		
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
		
		List<Staff_boardComment> list = staffDao.getAllCommentList(map);
		
		//댓글을 작성할 해당 게시물의 board_idx를 가져옴
		Staff_board staff_board = new Staff_board();
		int board_idx = staff_board.getBoard_idx();
		 
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
	
	
	
	//9.1 Staff게시판 댓글 수정하기
	public Staff_boardComment staffCommentModifyView(int comment_idx) throws ClassNotFoundException, SQLException
	{
		
		System.out.println("Service_Staff게시판 글 수정하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		Staff_boardComment Staff_boardComment = staffDao.getStaffCommentDetail(comment_idx);
		
		return Staff_boardComment;
		
	}
	
	
	//9.2 Staff게시판 댓글 수정 완료하기
	public int staffCommentModifyViewOk(Staff_boardComment Staff_boardComment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 댓글 수정하기 완료");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.updateStaffComment(Staff_boardComment);
		
		return result;
	}
	
	
	//10.1 Staff게시판 댓글에 댓글 등록하기
	public Staff_boardComment staffCommentRewriteView(int comment_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판 댓글에 댓글 등록하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		Staff_boardComment Staff_boardComment = staffDao.getStaffCommentDetail(comment_idx);
		
		return Staff_boardComment;
		
	}
	
	
	//10.2 Staff게시판 댓글에 댓글 작성 완료하기
	public int staffCommentRewriteOk(Staff_boardComment Staff_boardComment) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판  댓글에 댓글 등록 완료");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		//답글쓰기 step처리
		System.out.println("현재 step : " + Staff_boardComment.getStep());
		
		staffDao.updateStaffComment(Staff_boardComment);	
		
		System.out.println("update step : " + Staff_boardComment.getStep());
		
		
		//step, depth처리
		//staff_board.setStep(staff_board.getStep()+1);
		//staff_board.setDepth(staff_board.getDepth()+1);
		
		System.out.println("답글에 대한 ref :  " + Staff_boardComment.getRef());
		System.out.println("답글에 대한 step :  " + Staff_boardComment.getStep());
		System.out.println("답글에 대한 depth :  " + Staff_boardComment.getDepth());
		
		int result = staffDao.insertReStaffComment(Staff_boardComment);
		
		return result;
	}
	
	
	//11. Staff게시판 댓글 삭제하기
	public int staffCommentDelete(int comment_idx) throws ClassNotFoundException, SQLException
	{
		System.out.println("Service_Staff게시판  댓글 삭제하기");
		
		Staff_boardDao staffDao = sqlSession.getMapper(Staff_boardDao.class);
		
		int result = staffDao.deleteStaffComment(comment_idx);
		
		return result;		
	}*/

	public void downloadFile(String idx, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		DownloadDao downloadDao = sqlSession.getMapper(DownloadDao.class);
		
		Map<String, Object> map = downloadDao.selectFileInfo(idx);
		
		String storedFileName = (String)map.get("STORED_FILE_NAME");
	    String originalFileName = (String)map.get("ORIGINAL_FILE_NAME");
	    
	    byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
	    
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();

		
	}

}
