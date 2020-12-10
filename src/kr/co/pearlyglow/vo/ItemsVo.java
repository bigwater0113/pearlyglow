package kr.co.pearlyglow.vo;

public class ItemsVo {
	private int iNum;
	private String iName;
	private int price;
	private String iGender;
	private String iCategory;
	private String color;
	private String iSize;
	private int weight;
	private String material;
	private String kDetail;
	private String eDetail;
	public ItemsVo() {
		super();
	}
	public ItemsVo(int iNum, String iName, int price, String iGender, String iCategory, String color, String iSize,
			int weight, String material, String kDetail, String eDetail) {
		super();
		this.iNum = iNum;
		this.iName = iName;
		this.price = price;
		this.iGender = iGender;
		this.iCategory = iCategory;
		this.color = color;
		this.iSize = iSize;
		this.weight = weight;
		this.material = material;
		this.kDetail = kDetail;
		this.eDetail = eDetail;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	
}
