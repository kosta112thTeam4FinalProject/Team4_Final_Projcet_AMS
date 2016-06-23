package kr.co.AMS.Model.vo;

import java.sql.Date;

//회원 및 관리사무소 직원 인증번호 테이블_VO
public class Member_Certification {

	private String userid; // 아이디
	private String name; // 세대주명
	private String email; // 이메일
	private int checknum; // 인증번호
	private Date regdate; // 인증번호 생성일

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getChecknum() {
		return checknum;
	}

	public void setChecknum(int checknum) {
		this.checknum = checknum;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
