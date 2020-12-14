package kr.co.pearlyglow.vo.join;

import java.util.Date;

public class Stock_Items_ItemsImageVO {
	private int iNum;
	private String iName;
	private int price;
	private int iSale;
	private String iGender;
	private String iCategory;
	private String color;
	private String iSize;
	private int whight;
	private String material;
	private String kDetail;
	private String eDetail;
	private String iThumbnail;
	
	private int rs;
	private int cnt;
	private int total;
	private Date sDate;
	public Stock_Items_ItemsImageVO(int iNum, String iName, int price, int iSale, String iGender, String iCategory,
			String color, String iSize, int whight, String material, String kDetail, String eDetail, String iThumbnail,
			int rs, int cnt, int total, Date sDate) {
		super();
		this.iNum = iNum;
		this.iName = iName;
		this.price = price;
		this.iSale = iSale;
		this.iGender = iGender;
		this.iCategory = iCategory;
		this.color = color;
		this.iSize = iSize;
		this.whight = whight;
		this.material = material;
		this.kDetail = kDetail;
		this.eDetail = eDetail;
		this.iThumbnail = iThumbnail;
		this.rs = rs;
		this.cnt = cnt;
		this.total = total;
		this.sDate = sDate;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getiSale() {
		return iSale;
	}
	public void setiSale(int iSale) {
		this.iSale = iSale;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getiSize() {
		return iSize;
	}
	public void setiSize(String iSize) {
		this.iSize = iSize;
	}
	public int getWhight() {
		return whight;
	}
	public void setWhight(int whight) {
		this.whight = whight;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getkDetail() {
		return kDetail;
	}
	public void setkDetail(String kDetail) {
		this.kDetail = kDetail;
	}
	public String geteDetail() {
		return eDetail;
	}
	public void seteDetail(String eDetail) {
		this.eDetail = eDetail;
	}
	public String getiThumbnail() {
		return iThumbnail;
	}
	public void setiThumbnail(String iThumbnail) {
		this.iThumbnail = iThumbnail;
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
