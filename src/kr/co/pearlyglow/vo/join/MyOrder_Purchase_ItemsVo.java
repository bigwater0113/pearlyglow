package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class MyOrder_Purchase_ItemsVo {
	private String id;
	private int pNum;
	private int iNum;
	private String imgName;
	private String iName;
	private int pTotal;
	private String pStatus;
	private Date pDate;
	public MyOrder_Purchase_ItemsVo() {
		super();
	}
	public MyOrder_Purchase_ItemsVo(String id, int pNum, int iNum, String imgName, String iName, int pTotal,
			String pStatus, Date pDate) {
		super();
		this.id = id;
		this.pNum = pNum;
		this.iNum = iNum;
		this.imgName = imgName;
		this.iName = iName;
		this.pTotal = pTotal;
		this.pStatus = pStatus;
		this.pDate = pDate;
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
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getpTotal() {
		return pTotal;
	}
	public void setpTotal(int pTotal) {
		this.pTotal = pTotal;
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
}
