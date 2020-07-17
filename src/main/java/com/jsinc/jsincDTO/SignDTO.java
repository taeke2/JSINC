package com.jsinc.jsincDTO;

import java.util.Date;

// 작성자 : 임재만

// 전자 결재 DTO
public class SignDTO {
	private int bno; // 결재 번호
	private int empno; // 사원 번호
	private String title; // 결재 제목
	private String content; // 결재 내용
	private String writer; // 작성자
	private String target; // 결재 대상
	private String checksign; // 결재 상태(대기, 승인, 반려 등)
	private String department; // 부서
	private String worklocation; // 주소
	private String signs; // 결재 종류 ( 외근, 휴가, 연장근무 등)
	private Date regdate; // 등록 날짜
	private String outwork; // 마감 날짜
	private String startDT; // 등록 시각
	private String endDT; // 마감 시각

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getChecksign() {
		return checksign;
	}

	public void setChecksign(String checksign) {
		this.checksign = checksign;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWorklocation() {
		return worklocation;
	}

	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}

	public String getOutwork() {
		return outwork;
	}

	public void setOutwork(String outwork) {
		this.outwork = outwork;
	}

	public String getStartDT() {
		return startDT;
	}

	public void setStartDT(String startDT) {
		this.startDT = startDT;
	}

	public String getEndDT() {
		return endDT;
	}

	public void setEndDT(String endDT) {
		this.endDT = endDT;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getSigns() {
		return signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

}
