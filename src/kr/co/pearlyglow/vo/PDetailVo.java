package kr.co.pearlyglow.vo;

public class PDetailVo {
	private int pdNum;
	private int iNum;
	private int pNum;
	private int pCnt;
	private int pPay;
	public PDetailVo() {
		super();
	}
	public PDetailVo(int pdNum, int iNum, int pNum, int pCnt, int pPay) {
		super();
		this.pdNum = pdNum;
		this.iNum = iNum;
		this.pNum = pNum;
		this.pCnt = pCnt;
		this.pPay = pPay;
	}
	public int getPdNum() {
		return pdNum;
	}
	public void setPdNum(int pdNum) {
		this.pdNum = pdNum;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getpCnt() {
		return pCnt;
	}
	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}
	public int getpPay() {
		return pPay;
	}
	public void setpPay(int pPay) {
		this.pPay = pPay;
	}
	
}
