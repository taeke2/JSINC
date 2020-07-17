package com.jsinc.jsincDTO;

// 작성자 : 서해준

// 커뮤니티 DTO
public class CommunityDTO {
	private int cNo; // 커뮤니티 번호
	private int empNo; // 사원 번호
	private String name; // 사원 이름
	private String title;// 커뮤니티 이름
	private String content; // 커뮤니티 소개
	private String com_date; // 커뮤니티 등록 날짜
	private String autho; // 접근 권한
	private String rank; // 작성자 계급
	private int members; // 가입자 수
	private String join; // 가입 상태

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCom_date() {
		return com_date;
	}

	public void setCom_date(String com_date) {
		this.com_date = com_date;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
	}

}
