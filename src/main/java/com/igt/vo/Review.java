package com.igt.vo;

import java.sql.Timestamp;

public class Review {
	private int rNo;
	private String mId;
	private int pNo;
	private String rTitle;
	private String rContent;
	private Timestamp rRDate;
	private String rImg;
	
	public Review() {}
	public Review(int rNo, String mId, int pNo, String rTitle, 
			String rContent, Timestamp rRDate, String rImg) {
		this.rNo = rNo;
		this.mId = mId;
		this.pNo = pNo;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rRDate = rRDate;
		this.rImg = rImg;
	}
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Timestamp getrRDate() {
		return rRDate;
	}
	public void setrRDate(Timestamp rRDate) {
		this.rRDate = rRDate;
	}
	public String getrImg() {
		return rImg;
	}
	public void setrImg(String rImg) {
		this.rImg = rImg;
	}
	
}
