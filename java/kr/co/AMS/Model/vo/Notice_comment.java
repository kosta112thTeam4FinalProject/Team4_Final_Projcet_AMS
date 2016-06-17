package kr.co.AMS.Model.vo;

import java.util.Date;

public class Notice_comment {
	private int Comment_Idx;
	private int Board_Idx;
	private String Writer;
	private String Content;
	private Date Date;
	private int Ref;
	private int Depth;
	private int Step;
	
	public int getComment_Idx() {
		return Comment_Idx;
	}
	public void setComment_Idx(int comment_Idx) {
		Comment_Idx = comment_Idx;
	}
	public int getBoard_Idx() {
		return Board_Idx;
	}
	public void setBoard_Idx(int board_Idx) {
		Board_Idx = board_Idx;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getRef() {
		return Ref;
	}
	public void setRef(int ref) {
		Ref = ref;
	}
	public int getDepth() {
		return Depth;
	}
	public void setDepth(int depth) {
		Depth = depth;
	}
	public int getStep() {
		return Step;
	}
	public void setStep(int step) {
		Step = step;
	}
}
