package kr.co.pearlyglow.vo;

public class Items_imageVo {
	private int imgNum;
	private int iNum;
	private String imgName;
	public Items_imageVo() {
		super();
	}
	public Items_imageVo(int imgNum, int iNum, String imgName) {
		super();
		this.imgNum = imgNum;
		this.iNum = iNum;
		this.imgName = imgName;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
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
	
}
