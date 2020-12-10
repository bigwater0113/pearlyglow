package kr.co.pearlyglow.vo;

public class DeliveryVo {
	private int dNum;
	private int pNum;
	private String dCompany;
	private int trackingNum;
	private String dStatus;
	public DeliveryVo() {
		super();
	}
	public DeliveryVo(int dNum, int pNum, String dCompany, int trackingNum, String dStatus) {
		super();
		this.dNum = dNum;
		this.pNum = pNum;
		this.dCompany = dCompany;
		this.trackingNum = trackingNum;
		this.dStatus = dStatus;
	}
	public int getdNum() {
		return dNum;
	}
	public void setdNum(int dNum) {
		this.dNum = dNum;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getdCompany() {
		return dCompany;
	}
	public void setdCompany(String dCompany) {
		this.dCompany = dCompany;
	}
	public int getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(int trackingNum) {
		this.trackingNum = trackingNum;
	}
	public String getdStatus() {
		return dStatus;
	}
	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}
	
	
}
