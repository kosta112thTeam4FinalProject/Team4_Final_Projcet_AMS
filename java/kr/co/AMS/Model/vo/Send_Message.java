package kr.co.AMS.Model.vo;

import java.sql.Date;

//보낸 쪽지함_VO
public class Send_Message {
	
	private int send_idx; //받은 쪽지 번호
	private String userid; //받는 사람
	private String sender; //보낸 사람
	private String title; //제목
	private String Content; //쪽지 내용
	private Date send_date; //보낸 시간
	
	//Default 생성자
	public Send_Message() {}

	
	//Overloading 생성자
	public Send_Message(int send_idx, String userid, String sender, String title, String content, Date send_date) {
		super();
		this.send_idx = send_idx;
		this.userid = userid;
		this.sender = sender;
		this.title = title;
		Content = content;
		this.send_date = send_date;
	}


	//getter, setter
	public int getSend_idx() {
		return send_idx;
	}


	public void setSend_idx(int send_idx) {
		this.send_idx = send_idx;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	public Date getSend_date() {
		return send_date;
	}


	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}


	@Override
	public String toString() {
		return "Send_Message [send_idx=" + send_idx + ", userid=" + userid + ", sender=" + sender + ", title=" + title
				+ ", Content=" + Content + ", send_date=" + send_date + "]";
	}
	
	
	
	
	
	
	

}
