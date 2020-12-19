package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class Reviewboard_Purchase_pDetail_ItemsVo {
	private String id;
	private int rbnum;
	private String savename;
	private String iname;
	private int pdnum;
	private int score;
	private String rbcontent;
	private Date rdate;
	public Reviewboard_Purchase_pDetail_ItemsVo() {}
	public Reviewboard_Purchase_pDetail_ItemsVo(String id, int rbnum, String savename, String iname, int pdnum, int score,
			String rbcontent, Date rdate) {
		super();
		this.id = id;
		this.rbnum = rbnum;
		this.savename = savename;
		this.iname = iname;
		this.pdnum = pdnum;
		this.score = score;
		this.rbcontent = rbcontent;
		this.rdate = rdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getRbnum() {
		return rbnum;
	}
	public void setRbnum(int rbnum) {
		this.rbnum = rbnum;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getPdnum() {
		return pdnum;
	}
	public void setPdnum(int pdnum) {
		this.pdnum = pdnum;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRbcontent() {
		return rbcontent;
	}
	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
}
