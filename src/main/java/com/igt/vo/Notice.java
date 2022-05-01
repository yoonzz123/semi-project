package com.igt.vo;

import java.sql.Timestamp;

public class Notice {
	
	private int nNo;
	private String nTitle;
	private String nContent;
	private Timestamp nRdate;
	
	public Notice() {}
	public Notice(int nNo, String nTitle, String nContent,Timestamp nRdate) {
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nRdate = nRdate;
		
	}
	public int getnNo() {
		return nNo;
	}
	public void setnNo(int nNo) {
		this.nNo = nNo;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Timestamp getnRdate() {
		return nRdate;
	}
	public void setnRdate(Timestamp nRdate) {
		this.nRdate = nRdate;
	}
	
}
