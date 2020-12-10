package kr.co.pearlyglow.vo;

public class ShoppingBasketVo {
	private int sbNum;
	private String id;
	private int iNum;
	private int sbCnt;
	public ShoppingBasketVo() {
		super();
	}
	public ShoppingBasketVo(int sbNum, String id, int iNum, int sbCnt) {
		super();
		this.sbNum = sbNum;
		this.id = id;
		this.iNum = iNum;
		this.sbCnt = sbCnt;
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
	
}
