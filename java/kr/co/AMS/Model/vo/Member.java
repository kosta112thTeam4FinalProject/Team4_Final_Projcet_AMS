package kr.co.AMS.Model.vo;

import java.sql.Date;

//입주민 회원_VO
public class Member {

	private String userid; // 아이디
	private String password; // 비밀번호
	private String name; // 세대주명
	private String addr_1; // 동
	private String addr_2;// 호
	private String email; // 이메일
	private int phone; // 핸드폰
	private int emerphone; // 비상 연락처
	private Date birthday; // 생년월일
	private int checknum; // 인증번호
	private Date regdate; // 회원가입 일

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr_1() {
		return addr_1;
	}

	public void setAddr_1(String addr_1) {
		this.addr_1 = addr_1;
	}

	public String getAddr_2() {
		return addr_2;
	}

	public void setAddr_2(String addr_2) {
		this.addr_2 = addr_2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getEmerphone() {
		return emerphone;
	}

	public void setEmerphone(int emerphone) {
		this.emerphone = emerphone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
