package kr.co.pearlyglow.vo;

public class SalesDataVo {
	private String sDate;
	private int earring;
	private int bracelet;
	private int necklace;
	private int ring;
	private int man;
	private int woman;
	private int total;
	public SalesDataVo() {
		super();
	}
	public SalesDataVo(String sDate, int earring, int bracelet, int necklace, int ring, int man, int woman, int total) {
		super();
		this.sDate = sDate;
		this.earring = earring;
		this.bracelet = bracelet;
		this.necklace = necklace;
		this.ring = ring;
		this.man = man;
		this.woman = woman;
		this.total = total;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public int getEarring() {
		return earring;
	}
	public void setEarring(int earring) {
		this.earring = earring;
	}
	public int getBracelet() {
		return bracelet;
	}
	public void setBracelet(int bracelet) {
		this.bracelet = bracelet;
	}
	public int getNecklace() {
		return necklace;
	}
	public void setNecklace(int necklace) {
		this.necklace = necklace;
	}
	public int getRing() {
		return ring;
	}
	public void setRing(int ring) {
		this.ring = ring;
	}
	public int getMan() {
		return man;
	}
	public void setMan(int man) {
		this.man = man;
	}
	public int getWoman() {
		return woman;
	}
	public void setWoman(int woman) {
		this.woman = woman;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
