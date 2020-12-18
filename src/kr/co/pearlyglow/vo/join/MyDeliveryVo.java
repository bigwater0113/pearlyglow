package kr.co.pearlyglow.vo.join;

public class MyDeliveryVo {
	private String id;
	private	String receiver;
	private String pAddress;
	private int pNum;
	private String dCompany;
	private long trackingNum;
	private String dStatus;
	public MyDeliveryVo() {
		super();
	}
	public MyDeliveryVo(String id, String receiver, String pAddress, int pNum, String dCompany, long trackingNum,
			String dStatus) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.pAddress = pAddress;
		this.pNum = pNum;
		this.dCompany = dCompany;
		this.trackingNum = trackingNum;
		this.dStatus = dStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
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
	public long getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(long trackingNum) {
		this.trackingNum = trackingNum;
	}
	public String getdStatus() {
		return dStatus;
	}
	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}
	
}
