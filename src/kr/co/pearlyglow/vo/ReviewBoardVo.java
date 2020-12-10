package kr.co.pearlyglow.vo;

public class ReviewBoardVo {
	private int rbNum;
	private int pdNum;
	private int score;
	private String rbContent;
	private String orgName;
	private String saveName;
	public ReviewBoardVo() {
		super();
	}
	public ReviewBoardVo(int rbNum, int pdNum, int score, String rbContent, String orgName, String saveName) {
		super();
		this.rbNum = rbNum;
		this.pdNum = pdNum;
		this.score = score;
		this.rbContent = rbContent;
		this.orgName = orgName;
		this.saveName = saveName;
	}
	public int getRbNum() {
		return rbNum;
	}
	public void setRbNum(int rbNum) {
		this.rbNum = rbNum;
	}
	public int getPdNum() {
		return pdNum;
	}
	public void setPdNum(int pdNum) {
		this.pdNum = pdNum;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRbContent() {
		return rbContent;
	}
	public void setRbContent(String rbContent) {
		this.rbContent = rbContent;
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
	
}
