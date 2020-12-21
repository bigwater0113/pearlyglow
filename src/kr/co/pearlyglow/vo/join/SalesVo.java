package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class SalesVo {
	private int iNum;
	private String iGender;
	private String iCategory;
	private int pPay;
	private Date pDate;
	public SalesVo() {
		super();
	}
	public SalesVo(int iNum, String iGender, String iCategory, int pPay, Date pDate) {
		super();
		this.iNum = iNum;
		this.iGender = iGender;
		this.iCategory = iCategory;
		this.pPay = pPay;
		this.pDate = pDate;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public String getiGender() {
		return iGender;
	}
	public void setiGender(String iGender) {
		this.iGender = iGender;
	}
	public String getiCategory() {
		return iCategory;
	}
	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}
	public int getpPay() {
		return pPay;
	}
	public void setpPay(int pPay) {
		this.pPay = pPay;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
}
