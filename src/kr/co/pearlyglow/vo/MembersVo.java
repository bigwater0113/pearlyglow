package kr.co.pearlyglow.vo;

import java.sql.Date;

public class MembersVo {
	private String id;
	private String pwd;
	private String name;
	private Date birth;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String isSleep;
	private Date recentAcc;
	public MembersVo() {
		super();
	}
	public MembersVo(String id, String pwd, String name, Date birth, String gender, String email, String phone,
			String address, String isSleep, Date recentAcc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isSleep = isSleep;
		this.recentAcc = recentAcc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIssleep() {
		return isSleep;
	}
	public void setIssleep(String isSleep) {
		this.isSleep = isSleep;
	}
	public Date getRecentAcc() {
		return recentAcc;
	}
	public void setRecentAcc(Date recentAcc) {
		this.recentAcc = recentAcc;
	}
}
