package kr.co.AMS.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//민원게시판
@Service
public class ComplaintsService {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//실제 구현시 참고할 샘플_추후 작업시 삭제 후 작업진행
	/*public Notice_board getAllList(int noti_seq) throws ClassNotFoundException, SQLException
	{
		Notice_boardDao notice_boardDao = sqlSession.getMappe(Notice_boardDao.class);
		Notice_board Notice_board = Notice_boardDao.getAllList(noti_seq);
		
		return Notice_board;
	}*/

}
