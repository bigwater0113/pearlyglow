package kr.co.pearlyglow.vo;

import java.sql.Date;

public class StockVo {
	private int sNum;
	private int iNum;
	private int rs;
	private int cnt;
	private int total;
	private Date sDate;
	public StockVo() {
		super();
	}
	public StockVo(int sNum, int iNum, int rs, int cnt, int total, Date sDate) {
		super();
		this.sNum = sNum;
		this.iNum = iNum;
		this.rs = rs;
		this.cnt = cnt;
		this.total = total;
		this.sDate = sDate;
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
}
