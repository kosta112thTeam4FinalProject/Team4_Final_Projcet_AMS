package kr.co.AMS.Model.vo;

import java.sql.Date;

//익명게시판_VO
public class Anonymous_board {
	
	private int board_idx; //글 번호
	private String writer; //작성자
    private String nickname; //닉네임
    private String title; //글 제목
    private String content; //글 내용
    private String notice; //공지사항
    private Date regdate; //글 등록일
    private int hit; //글 조회수
    
    //계층형
    private int ref; //참조 번호
    private int depth; //들여쓰기
    private int step; //글의 순서
    
    
    //Default 생성자
    public Anonymous_board(){}
    

    //Overloading 생성자
    public Anonymous_board(int board_idx, String writer, String nickname, String title, String content, String notice,
			Date regdate, int hit, int ref, int depth, int step) {
		super();
		this.board_idx = board_idx;
		this.writer = writer;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.notice = notice;
		this.regdate = regdate;
		this.hit = hit;
		this.ref = ref;
		this.depth = depth;
		this.step = step;
	}
	
	//getter, setter
	public int getBoard_idx() {
		return board_idx;
	}

	

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "Anonymous_board [board_idx=" + board_idx + ", writer=" + writer + ", nickname=" + nickname + ", title="
				+ title + ", content=" + content + ", notice=" + notice + ", regdate=" + regdate + ", hit=" + hit
				+ ", ref=" + ref + ", depth=" + depth + ", step=" + step + "]";
	}

	
	
	
	
	
	
    
   
    
    
    
}

