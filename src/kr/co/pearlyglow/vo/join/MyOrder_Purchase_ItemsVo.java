package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class MyOrder_Purchase_ItemsVo {
	private String id;
	private int pNum;
	private int iNum;
	private String iThumbnail;
	private String iName;
	private int pPay;
	private String pStatus;
	private Date pDate;
	private String dCompany;
	private long trackingNum;
	public MyOrder_Purchase_ItemsVo() {
		super();
	}
	public MyOrder_Purchase_ItemsVo(String id, int pNum, int iNum, String iThumbnail, String iName, int pPay,
			String pStatus, Date pDate, String dCompany, long trackingNum) {
		super();
		this.id = id;
		this.pNum = pNum;
		this.iNum = iNum;
		this.iThumbnail = iThumbnail;
		this.iName = iName;
		this.pPay = pPay;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.dCompany = dCompany;
		this.trackingNum = trackingNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public String getiThumbnail() {
		return iThumbnail;
	}
	public void setiThumbnail(String iThumbnail) {
		this.iThumbnail = iThumbnail;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getpPay() {
		return pPay;
	}
	public void setpPay(int pPay) {
		this.pPay = pPay;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public String getdCompany() {
		return dCompany;
	}
	public void setdCompany(String dCompany) {
		this.dCompany = dCompany;
	}
	public long getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(long trackingNum) {
		this.trackingNum = trackingNum;
	}
	
}
