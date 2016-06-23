package kr.co.AMS.Model.vo;

import java.sql.Date;

public class ComplainCal_Dto {
	private int complain_idx;
	private String reserve_o;
	private String reserve_n;
	private Date start_cal;
	private Date end_cal;
	
	
	public int getComplain_idx() {
		return complain_idx;
	}
	public void setComplain_idx(int complain_idx) {
		this.complain_idx = complain_idx;
	}
	public String getReserve_o() {
		return reserve_o;
	}
	public void setReserve_o(String reserve_o) {
		this.reserve_o = reserve_o;
	}
	public String getReserve_n() {
		return reserve_n;
	}
	public void setReserve_n(String reserve_n) {
		this.reserve_n = reserve_n;
	}
	public Date getStart_cal() {
		return start_cal;
	}
	public void setStart_cal(Date start_cal) {
		this.start_cal = start_cal;
	}
	public Date getEnd_cal() {
		return end_cal;
	}
	public void setEnd_cal(Date end_cal) {
		this.end_cal = end_cal;
	}
	
	
}
