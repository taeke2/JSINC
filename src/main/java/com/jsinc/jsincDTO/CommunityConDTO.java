package com.jsinc.jsincDTO;

// 작성자 : 서해준

// 커뮤니티 댓글 DTO
public class CommunityConDTO {
	private int cNo; // 커뮤니티 번호
	private int empNo; // 사원 번호
	private String name; // 사원 이름
	private String content; // 댓글 내용
	private String com_date; // 작성 날짜
	private String rank; // 작성자 계급
	private int idgroup, step, indent; // 댓글 순서 변수 idgroup : 댓글, step : 대댓글, indent : 댓글 순서

	public int getIdgroup() {
		return idgroup;
	}

	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}
}
