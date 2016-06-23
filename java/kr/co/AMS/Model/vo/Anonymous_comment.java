package kr.co.AMS.Model.vo;

import java.sql.Date;

//익명게시판 댓글_VO
public class Anonymous_comment {
	
	private int comment_idx; //댓글 번호
	private int board_idx; //참조하는 글의 번호
	private int writer; //댓글 작성자
	private int nickname; //댓글 작성시 닉네임
	private int content; //댓글 내용
	private Date regdate; //댓글 작성일
	
	//계층형
	private int ref; //참조번호
	private int depth; //들여쓰기
	private int step; //댓글 순서
	
	
	//Default생성자
	public Anonymous_comment() {}
	

	//Overloading 생성자
	public Anonymous_comment(int commnet_idx, int board_idx, int writer, int nickname, int content, Date regdate,
			int ref, int depth, int step) {
		super();
		this.comment_idx = commnet_idx;
		this.board_idx = board_idx;
		this.writer = writer;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.ref = ref;
		this.depth = depth;
		this.step = step;
	}


	//getter, setter
	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int commnet_idx) {
		this.comment_idx = commnet_idx;
	}


	public int getBoard_idx() {
		return board_idx;
	}


	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}


	public int getWriter() {
		return writer;
	}


	public void setWriter(int writer) {
		this.writer = writer;
	}


	public int getNickname() {
		return nickname;
	}


	public void setNickname(int nickname) {
		this.nickname = nickname;
	}


	public int getContent() {
		return content;
	}


	public void setContent(int content) {
		this.content = content;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
		return "Anonymous_comment [commnet_idx=" + comment_idx + ", board_idx=" + board_idx + ", writer=" + writer
				+ ", nickname=" + nickname + ", content=" + content + ", regdate=" + regdate + ", ref=" + ref
				+ ", depth=" + depth + ", step=" + step + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

