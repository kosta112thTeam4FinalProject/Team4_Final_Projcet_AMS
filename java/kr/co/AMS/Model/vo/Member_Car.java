package kr.co.AMS.Model.vo;

//회원 차량 정보_VO
public class Member_Car {

	private String userid; // 아이디
	private String carname; // 차명
	private String carnumber; // 차량 번호

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

}
