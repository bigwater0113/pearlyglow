package kr.co.pearlyglow.vo.join;

import java.sql.Date;

public class MyReviewVo {
	private String id;			//구매내역T 아이디
	private int pNum;			//구매내역T 구매번호
	private String pStatus;		//구매내역T 출고상태
	private Date pDate;			//구매내역T 구매날짜
	private int pdNum;			//상세 T 상세번호
	private int iNum;			//  상품 T 품번
	private String iName;		//  상품 T 품명
	private String iThumbnail;	//  상품 T 썸네일이미지명
	private int pCnt;			//상세 T 구매갯수
	private int pPay;			//상세 T 상품별금액
	private int score;			// 리뷰 T 평가
	private String rbContent;	// 리뷰 T 내용
	private String saveName;	// 리뷰 T 이미지명
	private Date rDate;			// 리뷰 T 리뷰날짜
	public MyReviewVo() {
		super();
	}
	public MyReviewVo(String id, int pNum, String pStatus, Date pDate, int pdNum, int iNum, String iName,
			String iThumbnail, int pCnt, int pPay, int score, String rbContent, String saveName, Date rDate) {
		super();
		this.id = id;
		this.pNum = pNum;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.pdNum = pdNum;
		this.iNum = iNum;
		this.iName = iName;
		this.iThumbnail = iThumbnail;
		this.pCnt = pCnt;
		this.pPay = pPay;
		this.score = score;
		this.rbContent = rbContent;
		this.saveName = saveName;
		this.rDate = rDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
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
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiThumbnail() {
		return iThumbnail;
	}
	public void setiThumbnail(String iThumbnail) {
		this.iThumbnail = iThumbnail;
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
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	
}
