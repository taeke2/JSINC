package com.jsinc.jsincDTO;

// 작성자 : 허성택

// 출&퇴근 DTO
public class AttendanceDTO {
	private int empNo; // 사원번호
	private String goWork; // 출근시간
	private String leaveWork; // 퇴근시간
	private double workTime; // 일한 시간

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getGoWork() {
		return goWork;
	}

	public void setGoWork(String goWork) {
		this.goWork = goWork;
	}

	public String getLeaveWork() {
		return leaveWork;
	}

	public void setLeaveWork(String leaveWork) {
		this.leaveWork = leaveWork;
	}

	public double getWorkTime() {
		return workTime;
	}

	public void setWorkTime(double workTime) {
		this.workTime = workTime;
	}

}
