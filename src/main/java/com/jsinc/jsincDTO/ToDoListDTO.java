package com.jsinc.jsincDTO;

// 작성자 : 허성택

// 스케줄 DTO
public class ToDoListDTO {
	private int empNo; // 사원 번호
	private String eDate; // 마감 날짜
	private String sDate; // 등록 날짜
	private String todo; // 할일
	private String checked; // 체크 상태 (완료 여부)

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}
