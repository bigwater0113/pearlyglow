package kr.co.pearlyglow.vo;

import java.sql.Date;

public class QnABoardVo {
	private int ibNum;
	private String id;
	private int iNum;
	private String ibPwd;
	private String ibContent;
	private Date ibDate;
	private String ans;
	private Date ansDate;
	public QnABoardVo() {
		super();
	}
	public QnABoardVo(int ibNum, String id, int iNum, String ibPwd, String ibContent, Date ibDate, String ans,
			Date ansDate) {
		super();
		this.ibNum = ibNum;
		this.id = id;
		this.iNum = iNum;
		this.ibPwd = ibPwd;
		this.ibContent = ibContent;
		this.ibDate = ibDate;
		this.ans = ans;
		this.ansDate = ansDate;
	}
	public int getIbNum() {
		return ibNum;
	}
	public void setIbNum(int ibNum) {
		this.ibNum = ibNum;
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
	public String getIbPwd() {
		return ibPwd;
	}
	public void setIbPwd(String ibPwd) {
		this.ibPwd = ibPwd;
	}
	public String getIbContent() {
		return ibContent;
	}
	public void setIbContent(String ibContent) {
		this.ibContent = ibContent;
	}
	public Date getIbDate() {
		return ibDate;
	}
	public void setIbDate(Date ibDate) {
		this.ibDate = ibDate;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public Date getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}
	
	
}
