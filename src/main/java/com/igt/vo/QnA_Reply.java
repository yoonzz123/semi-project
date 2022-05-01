package com.igt.vo;

import java.sql.Timestamp;

public class QnA_Reply {
	int qrNo;
	int qNo;
	String qrTitle;
	String qrContent;
	Timestamp qrRDate;
	
	
	public QnA_Reply() {}
	public QnA_Reply(int qrNo, int qNo, String qrTitle, String qrContent, Timestamp qrRDate) {
		this.qrNo = qrNo;
		this.qNo = qNo;
		this.qrTitle = qrTitle;
		this.qrContent = qrContent;
		this.qrRDate = qrRDate;
	}
	
	public int getQrNo() {
		return qrNo;
	}
	public void setQrNo(int qrNo) {
		this.qrNo = qrNo;
	}
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getQrTitle() {
		return qrTitle;
	}
	public void setQrTitle(String qrTitle) {
		this.qrTitle = qrTitle;
	}
	public String getQrContent() {
		return qrContent;
	}
	public void setQrContent(String qrContent) {
		this.qrContent = qrContent;
	}
	public Timestamp getQrRDate() {
		return qrRDate;
	}
	public void setQrRDate(Timestamp qrRDate) {
		this.qrRDate = qrRDate;
	}	
}
