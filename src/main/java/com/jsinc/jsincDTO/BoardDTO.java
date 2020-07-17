package com.jsinc.jsincDTO;

import java.util.Date;

// 작성자 : 임재만

// 게시판 DTO
public class BoardDTO {
	private int bno; // 게시판 번호
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String department; // 부서
	private Date regdate; // 작성 날짜
	private String savefile; // 저장된 파일명
	private String realfile; // 실제 저장 파일
	private int filesize; // 파일 크기

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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getSavefile() {
		return savefile;
	}

	public void setSavefile(String savefile) {
		this.savefile = savefile;
	}

	public String getRealfile() {
		return realfile;
	}

	public void setRealfile(String realfile) {
		this.realfile = realfile;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
