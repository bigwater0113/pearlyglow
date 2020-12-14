package kr.co.pearlyglow.vo.join;

public class Purchase_pDetailVO {
	private int pnum;
	private String id;
	private int pdnum;
	private int inum;
	
	public Purchase_pDetailVO() {}
	public Purchase_pDetailVO(int pnum, String id, int pdnum, int inum) {
		super();
		this.pnum = pnum;
		this.pdnum = pdnum;
		this.id = id;
		this.inum = inum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPdnum() {
		return pdnum;
	}
	public void setPdnum(int pdnum) {
		this.pdnum = pdnum;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	
	
}
