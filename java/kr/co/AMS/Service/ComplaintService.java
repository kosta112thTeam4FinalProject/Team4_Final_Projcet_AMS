package kr.co.AMS.Service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.AMS.Controller.ComplaintController;
import kr.co.AMS.Model.DAO.Complaint_boardDao;
import kr.co.AMS.Model.vo.Complaint_board;
import kr.co.AMS.Model.vo.Complaint_comment;

//민원게시판
@Service
public class ComplaintService {
	
	private static final Logger logger = LoggerFactory.getLogger(ComplaintController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	// 게시글 리스트 가져오기
	public HashMap<String, Object> getAllComplaintsList(String pg, String rowSize, String order, 
			String search, String period, String scope) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int page = 1;
		String strPg = pg;
		String ord = "regdate";
		
		int row = 10;
		String rowNum = rowSize;
		
		if(strPg != null){
			page  = Integer.parseInt(strPg.trim());
		}
		
		if(rowSize != null){
			row = Integer.parseInt(rowNum.trim());
		}
		
		if(order != null){
			ord = order;
		}
		
		// 날짜 계산
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		
		// 검색 부분 설정
		String scp1 = null;
		String scp2 = null;
		
		Date from = null;
		Date to = null;
		
		if(search != null){
			// scope
			if(scope.equals("titleNContent")){
				scp1 = "title";
				scp2 = "content";
			} else if(scope.equals("title") || scope.equals("writer")){
				scp1 = scope;
			} else if(scope.equals("commContent")){
				
			} else if(scope.equals("commWriter")){
				
			}
				
			// period
			// from & to 가 null 이면 mapper의 query에서 if문 사용해서 기간 상관 없이 출력
			/*
			if(period.equals("all")){
				from = null;
				to = null;
			}
			*/
			// period
			if(period.equals("day")){
				to = date;
				cal.add(Calendar.DATE, -1);
				from = cal.getTime();
			} else if(period.equals("week")){
				to = date;
				cal.add(Calendar.DATE, -7);
				from = cal.getTime();
			} else if(period.equals("month")){
				/*to = dateFormat.format(date);
				cal.add(Calendar.DATE, -30);
				from = dateFormat.format(cal.getTime());*/
				to = date;
				cal.add(Calendar.DATE, -30);
				from = cal.getTime();
			}
		}
		
		
		// 글 전체 수
		int total = complaints_boardDao.getComplaintsCount();
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("scp1", scp1);
		map.put("scp2", scp2);
		map.put("from", from);
		map.put("to", to);
		
		// 검색 범위의 글 전체 수
		if(search != null){
			total = complaints_boardDao.getSearchCount(map);
		}
		
		// 출력 건수보다  글 수가 적을 경우
		// 현재 출력 페이지를 1로 변경
		if(row > total){
			page = 1;
		}
		
		// 페이지 수
		int pageCount = (int)Math.ceil(total / (double)row);
		
		// 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] >>
		int block = 5;
		
		// 보여줄 페이지의 시작
		int fromPage = ((page - 1) / block * block) + 1;
		// 보여줄 페이지의 끝
		int toPage = ((page - 1) / block * block) + block;
		
		if(toPage > pageCount){
			toPage = pageCount;
		}
		
		int start = (page * row) - (row - 1);
		int end = page * row;
		
		// 리스트를 불러오기 위한 값들
		map.put("start", start);
		map.put("end", end);
		map.put("order", ord);
		
		
		List<Complaint_board> list = complaints_boardDao.getAllList(map);
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("pageCount", pageCount);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		maps.put("rowSize", row);
		maps.put("order", ord);
		maps.put("search", search);
		maps.put("period", period);
		maps.put("scope", scope);
		
		return maps;
	}
	
	// 게시글 작성하기
	public int writeComplaint(Complaint_board complaints_board) throws ClassNotFoundException, SQLException{
			
		if(complaints_board.getNotice() == null){
			complaints_board.setNotice("N");
		}
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int result = complaints_boardDao.insertComplaint(complaints_board);
		
		return result;
	}
	
	
	// 게시글 상세보기
	public Complaint_board getComplaintDetail(int board_idx) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		Complaint_board complaints_board = complaints_boardDao.getComplaintDetail(board_idx);
		
		return complaints_board;
	}
	
	// 댓글 등록
	public int writeComment(Complaint_comment complaint_comment) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int result = complaints_boardDao.insertComment(complaint_comment);
		
		System.out.println("댓글 등록 comment_idx: " + complaints_boardDao.getComment(complaint_comment.getComment_idx()).getComment_idx());
		return result;
	}
	
	// comment_idx에 따른 해당 댓글 가져오기
	public Complaint_comment readComment(int comment_idx) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		System.out.println(comment_idx);
		Complaint_comment comment = complaints_boardDao.getComment(comment_idx);
		
		System.out.println("해당 댓글 가져오기 : " + comment.getComment_idx());
		
		return comment;
	}
	 
	
	// 댓글 목록 가져오기
	public List<Complaint_comment> getCommentList(int board_idx) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		List<Complaint_comment> list = complaints_boardDao.getAllComment(board_idx);
		
		return list;
	}
	/*public HashMap<String, Object> getCommentList(String pg, String order) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int page = 1;
		String strPg = pg;
		String ord = "asc";
		
		int row = 10;
		
		if(strPg != null){
			page  = Integer.parseInt(strPg.trim());
		}
		
		if(order != null){
			ord = order;
		}

		// 글 전체 수
		int total = complaints_boardDao.getCommentCount();
		
		
		// 출력 건수보다  글 수가 적을 경우
		// 현재 출력 페이지를 1로 변경
		if(row > total){
			page = 1;
		}
		
		// 페이지 수
		int pageCount = (int)Math.ceil(total / (double)row);
		
		// 한페이지에 보여줄 범위 << [1] [2] [3] [4] [5] >>
		int block = 5;
		
		// 보여줄 페이지의 시작
		int fromPage = ((page - 1) / block * block) + 1;
		// 보여줄 페이지의 끝
		int toPage = ((page - 1) / block * block) + block;
		
		if(toPage > pageCount){
			toPage = pageCount;
		}
		
		int start = (page * row) - (row - 1);
		int end = page * row;
		
		// 리스트를 불러오기 위한 값들
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("order", ord);
		
		
		List<Complaint_comment> list = complaints_boardDao.getAllComment(map);
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("pg", page);
		maps.put("pageCount", pageCount);
		maps.put("fromPage", fromPage);
		maps.put("toPage", toPage);
		maps.put("rowSize", row);
		maps.put("order", ord);		
		
		return maps;
	}*/
	
	// delete
	public int deleteComplaint(int board_idx) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int result = complaints_boardDao.deleteComplaint(board_idx);
		
		return result;
	}
	
	// update
	public int updateComplaint(Complaint_board complaint_board) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int result = complaints_boardDao.updateComplaint(complaint_board);
		
		return result;
	}
	
	// hit
	public int updateHit(int board_idx) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		int result = complaints_boardDao.increaseHit(board_idx);
		
		return result;
	}
	
	// rewrite
	public int reWriteComplaint(Complaint_board complaint_board) throws ClassNotFoundException, SQLException{
		
		Complaint_boardDao complaints_boardDao = sqlSession.getMapper(Complaint_boardDao.class);
		
		if(complaint_board.getNotice() == null){
			complaint_board.setNotice("N");
		}
		
		complaint_board.setDepth(complaint_board.getDepth() + 1);
		complaint_board.setStep(complaint_board.getStep() + 1);
		
		int result = complaints_boardDao.insertReWrite(complaint_board);
		
		return result;
	}
}
