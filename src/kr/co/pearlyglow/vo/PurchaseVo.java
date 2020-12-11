package kr.co.pearlyglow.vo;

import java.sql.Date;

public class PurchaseVo {
	private int pNum;
	private String id;
	private String pAddress;
	private String pWay;
	private Date pDate;
	private String pStatus;
	private int pTotal;
	public PurchaseVo() {
		super();
	}
	public PurchaseVo(int pNum, String id, String pAddress, String pWay, Date pDate, String pStatus, int pTotal) {
		super();
		this.pNum = pNum;
		this.id = id;
		this.pAddress = pAddress;
		this.pWay = pWay;
		this.pDate = pDate;
		this.pStatus = pStatus;
		this.pTotal = pTotal;
		
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
	public String getpWay() {
		return pWay;
	}
	public void setpWay(String pWay) {
		this.pWay = pWay;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	public int getpTotal() {
		return pTotal;
	}
	public void setpTotal(int pTotal) {
		this.pTotal = pTotal;
	}
	
	
}
