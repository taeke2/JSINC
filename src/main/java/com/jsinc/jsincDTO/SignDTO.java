package com.jsinc.jsincDTO;

import java.util.Date;

public class SignDTO {

	private int bno;
	private int empno;
	private String title;
	private String content;
	private String writer;
	private String target;
	private String checksign;
	private String department;
	private String worklocation;
	private String signs;
	private Date regdate;
	private String outwork;
	private String startDT;
	private String endDT;
	
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
