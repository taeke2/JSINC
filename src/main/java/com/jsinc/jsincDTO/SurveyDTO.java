package com.jsinc.jsincDTO;

// 작성자 : 허성택

// 설문 DTO
public class SurveyDTO {
	private int empNo; // 사원 번호
	private String title; // 설문 제목
	private String text; // 설문 내용
	private String sDate; // 등록 날짜
	private String eDate; // 마감 날짜
	private String writer; // 작성자
	private String state; // 설문 상태 (진행중, 마감됨)
	private int opt; // 옵션 ( 2개, 5개)
	private String autho; // 권한

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
	}

}
