package com.jsinc.jsincDTO;

// 작성자 : 허성택

// 설문 결과 DTO
public class SurveyResultDTO {
	private int empNo; // 사원번호
	private String title; // 설문 제목
	private String result; // 설문 선택지

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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
