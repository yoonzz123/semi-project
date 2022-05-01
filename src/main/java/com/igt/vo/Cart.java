package com.igt.vo;

public class Cart {
	int cNo;
	int cQTY;
	String mId;
	int pNo;
	
	public Cart() {}
	public Cart(int cNo, int cQTY, String mId, int pNo) {
		this.cNo = cNo;
		this.cQTY = cQTY;
		this.mId = mId;
		this.pNo = pNo;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public int getcQTY() {
		return cQTY;
	}
	public void setcQTY(int cQTY) {
		this.cQTY = cQTY;
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
}
