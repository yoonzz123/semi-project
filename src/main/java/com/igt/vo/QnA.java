package com.igt.vo;

import java.sql.Timestamp;

public class QnA {
	int qNo;
	String mId;
	String qTitle;
	String qContent;
	Timestamp qRDate;
	String qrTitle;
	
	public QnA() {}
	public QnA(int qNo, String mId, String qTitle, String qContent, Timestamp qRDate, String qrTitle) {
		this.qNo = qNo;
		this.mId = mId;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qRDate = qRDate;		
		this.qrTitle = qrTitle;
	}
	
	
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public Timestamp getqRDate() {
		return qRDate;
	}
	public void setqRDate(Timestamp qRDate) {
		this.qRDate = qRDate;
	}
	public String getQrTitle() {
		return qrTitle;
	}
	public void setQrTitle(String qrTitle) {
		this.qrTitle = qrTitle;
	};
	
	
	
}
