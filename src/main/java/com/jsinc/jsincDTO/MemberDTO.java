package com.jsinc.jsincDTO;

// 작성자 : 허성택

// 사원 DTO
public class MemberDTO {
	private int empNo; // 사원 번호
	private String password; // 비밀번호
	private String name; // 이름
	private String birth; // 생년월일
	private String userEmail; // 이메일
	private String phoneNumber; // 전화번호
	private String gender; // 성별
	private String mailChk; // 메일 수신 여부
	private String smsChk; // SMS 수신 여부
	private String dep; // 부서
	private String rank; // 계급
	private String img; // 사진
	private int authority; // 권한

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailChk() {
		return mailChk;
	}

	public void setMailChk(String mailChk) {
		this.mailChk = mailChk;
	}

	public String getSmsChk() {
		return smsChk;
	}

	public void setSmsChk(String smsChk) {
		this.smsChk = smsChk;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

}
