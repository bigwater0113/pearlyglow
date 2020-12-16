package kr.co.pearlyglow.vo;

import java.sql.Date;

public class QnABoardVo {
	private int ibNum;
	private String id;
	private int iNum;
	private String qCategory;
	private String qTitle;
	private String ibPwd;
	private String ibContent;
	private String orgName;
	private String saveName;
	private Date ibDate;
	private String ans;
	private Date ansDate;
	private int ref;
	private int lev;
	private int step;
	public QnABoardVo() {
		super();
	}
	public QnABoardVo(int ibNum, String id, int iNum, String qCategory, String qTitle, String ibPwd, String ibContent, String orgName, String saveName, Date ibDate, String ans,
			Date ansDate, int ref, int lev, int step) {
		super();
		this.ibNum = ibNum;
		this.id = id;
		this.iNum = iNum;
		this.qCategory = qCategory;
		this.qTitle = qTitle;
		this.ibPwd = ibPwd;
		this.ibContent = ibContent;
		this.orgName  =orgName;
		this.saveName = saveName;
		this.ibDate = ibDate;
		this.ans = ans;
		this.ansDate = ansDate;
		this.ref=ref;
		this.lev=lev;
		this.step=step;
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
	public String getqCategory() {
		return qCategory;
	}
	public void setqCategory(String qCategory) {
		this.qCategory = qCategory;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
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
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
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
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
}
