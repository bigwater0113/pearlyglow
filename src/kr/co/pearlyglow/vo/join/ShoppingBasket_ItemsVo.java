package kr.co.pearlyglow.vo.join;

public class ShoppingBasket_ItemsVo {
	private int sbNum;
	private String id;
	private int iNum;
	private int sbCnt;
	private int iSale;
	
	private String iName;
	private int price;
	private String iGender;
	private String iCategory;
	private String color;
	private String iSize;
	private String iThumbnail;
	public ShoppingBasket_ItemsVo(int sbNum, String id, int iNum, int sbCnt, int iSale, String iName, int price,
			String iGender, String iCategory, String color, String iSize, String iThumbnail) {
		super();
		this.sbNum = sbNum;
		this.id = id;
		this.iNum = iNum;
		this.sbCnt = sbCnt;
		this.iSale = iSale;
		this.iName = iName;
		this.price = price;
		this.iGender = iGender;
		this.iCategory = iCategory;
		this.color = color;
		this.iSize = iSize;
		this.iThumbnail = iThumbnail;
	}
	public int getSbNum() {
		return sbNum;
	}
	public void setSbNum(int sbNum) {
		this.sbNum = sbNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public int getSbCnt() {
		return sbCnt;
	}
	public void setSbCnt(int sbCnt) {
		this.sbCnt = sbCnt;
	}
	public int getiSale() {
		return iSale;
	}
	public void setiSale(int iSale) {
		this.iSale = iSale;
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
	public String getiThumbnail() {
		return iThumbnail;
	}
	public void setiThumbnail(String iThumbnail) {
		this.iThumbnail = iThumbnail;
	}

	
}