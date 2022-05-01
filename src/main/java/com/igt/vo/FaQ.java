package com.igt.vo;

import java.sql.Timestamp;

public class FaQ {
	private int fNo;
	private String fTitle;
	private String fContent;
	private Timestamp fRDate;
	
	public int getfNo() {
		return fNo;
	}
	public void setfNo(int fNo) {
		this.fNo = fNo;
	}
	public String getfTitle() {
		return fTitle;
	}
	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}
	public String getfContent() {
		return fContent;
	}
	public void setfContent(String fContent) {
		this.fContent = fContent;
	}
	public Timestamp getfRDate() {
		return fRDate;
	}
	public void setfRDate(Timestamp fRDate) {
		this.fRDate = fRDate;
	}
	
}
