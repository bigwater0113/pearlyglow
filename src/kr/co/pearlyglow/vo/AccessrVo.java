package kr.co.pearlyglow.vo;

import java.sql.Date;

public class AccessrVo {
	private Date aDate;
	private int aCnt;
	public AccessrVo() {
		super();
	}
	public AccessrVo(Date aDate, int aCnt) {
		super();
		this.aDate = aDate;
		this.aCnt = aCnt;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public int getaCnt() {
		return aCnt;
	}
	public void setaCnt(int aCnt) {
		this.aCnt = aCnt;
	}
	
}
