package kr.co.pearlyglow.vo;

public class Items_imageVo {
	private int imgNum;
	private int iNum;
	private String file1;
	private String file2;
	private String file3;
	public Items_imageVo(int imgNum, int iNum, String file1, String file2, String file3) {
		super();
		this.imgNum = imgNum;
		this.iNum = iNum;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	public String getFile3() {
		return file3;
	}
	public void setFile3(String file3) {
		this.file3 = file3;
	}
	
	
}
