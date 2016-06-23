package kr.co.AMS.Model.vo;

import java.sql.Date;

//받은 쪽지함_VO
public class Receive_Message {

	private int receive_idx; // 받은 쪽지 번호
	private int hit; // 조회수(읽음/읽지 않음 관련)
	private String userid; // 받는사람
	private String sender; // 보낸사람
	private String title; // 제목
	private String content; // 쪽지 내용
	private String read; // 쪽지 읽음 여부 표시
	private int msgAlram; //쪽지 알람
	private Date receive_date; // 보낸날짜

	public int getReceive_idx() {
		return receive_idx;
	}

	public void setReceive_idx(int receive_idx) {
		this.receive_idx = receive_idx;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	
	public int getMsgAlram() {
		return msgAlram;
	}

	public void setMsgAlram(int msgAlram) {
		this.msgAlram = msgAlram;
	}

	public Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}

}
