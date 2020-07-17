package com.jsinc.jsincDTO;

// 작성자 : 서해준

// 쪽지 DTO
public class MessageDTO {
	private String sender; // 보내는 사람
	private String receiver; // 받는 사람
	private String senderRank; // 보내는 사람 계급
	private String recRank; // 받는 사람 계급
	private int senderEmpNo; // 보내는 사람 사원 번호
	private int recEmpNo; // 받는 사람 사원 번호
	private String senderDep; // 보내는 사람 부서
	private String recDep; // 받는 사람 부서
	private String mesChk; // 읽음 여부
	private String subject; // 메세지 제목
	private String content; // 메세지 내용
	private String sentTime; // 보낸 시각

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSenderRank() {
		return senderRank;
	}

	public void setSenderRank(String senderRank) {
		this.senderRank = senderRank;
	}

	public String getRecRank() {
		return recRank;
	}

	public void setRecRank(String recRank) {
		this.recRank = recRank;
	}

	public int getSenderEmpNo() {
		return senderEmpNo;
	}

	public void setSenderEmpNo(int senderEmpNo) {
		this.senderEmpNo = senderEmpNo;
	}

	public int getRecEmpNo() {
		return recEmpNo;
	}

	public void setRecEmpNo(int recEmpNo) {
		this.recEmpNo = recEmpNo;
	}

	public String getSenderDep() {
		return senderDep;
	}

	public void setSenderDep(String senderDep) {
		this.senderDep = senderDep;
	}

	public String getRecDep() {
		return recDep;
	}

	public void setRecDep(String recDep) {
		this.recDep = recDep;
	}

	public String getMesChk() {
		return mesChk;
	}

	public void setMesChk(String mesChk) {
		this.mesChk = mesChk;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSentTime() {
		return sentTime;
	}

	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}

}
