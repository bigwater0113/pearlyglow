package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class Items_purchase_pdetailVo {

	private int pnum;
	private int pdnum;
	private int inum;
	private String iname;
	private int pcnt;
	private int ppay;
	private int ptotal;
	private String ithumbnail;
	private Date pdate;
	private String id;
	public Items_purchase_pdetailVo() {}
	public Items_purchase_pdetailVo(int pnum, int pdnum, String iname, int pcnt, int ppay, int ptotal,
			String ithumbnail, Date pdate, String id, int inum) {
		super();
		this.pnum = pnum;
		this.pdnum = pdnum;
		this.iname = iname;
		this.pcnt = pcnt;
		this.ppay = ppay;
		this.ptotal = ptotal;
		this.ithumbnail = ithumbnail;
		this.pdate = pdate;
		this.id = id;
		this.inum = inum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getPdnum() {
		return pdnum;
	}
	public void setPdnum(int pdnum) {
		this.pdnum = pdnum;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public int getPpay() {
		return ppay;
	}
	public void setPpay(int ppay) {
		this.ppay = ppay;
	}
	public int getPtotal() {
		return ptotal;
	}
	public void setPtotal(int ptotal) {
		this.ptotal = ptotal;
	}
	public String getIthumbnail() {
		return ithumbnail;
	}
	public void setIthumbnail(String ithumbnail) {
		this.ithumbnail = ithumbnail;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	
	
}

